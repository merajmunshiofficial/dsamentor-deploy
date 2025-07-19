import React, { useState, useEffect } from "react";
import { HashRouter as Router, Routes, Route, useLocation } from "react-router-dom";
import { useAuth0 } from "@auth0/auth0-react";
import { isAuth0Configured } from "./config/auth0";
import Auth0ProviderWithHistory from "./components/Auth0Provider";
import Auth0Login from "./components/Auth0Login";
import Auth0Setup from "./components/Auth0Setup";
import LoadingSpinner from "./components/LoadingSpinner";
import CallbackPage from "./components/CallbackPage";
import TopicSelector from "./components/TopicSelector";
import ProblemList from "./components/ProblemList";
import ProblemDetails from "./components/ProblemDetails";
import InputForm from "./components/InputForm";
import OutputPanel from "./components/OutputPanel";
import CodeEditor from "./components/CodeEditor";
import ModernDaisyNavbar from "./components/ModernDaisyNavbar";
import DaisyApiKeyModal from "./components/DaisyApiKeyModal";


  // Main App Component (after authentication)
function MainApp() {
  const [topics, setTopics] = useState([]);
  const [problemsByTopic, setProblemsByTopic] = useState({});
  const [selectedTopic, setSelectedTopic] = useState(() => localStorage.getItem("lastSelectedTopic") || "");
  const [selectedProblemIdx, setSelectedProblemIdx] = useState(() => {
    const idx = localStorage.getItem("lastSelectedProblemIdx");
    return idx ? parseInt(idx, 10) : 0;
  });
  const [input, setInput] = useState({});
  const [output, setOutput] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");
  const [showApiKeyModal, setShowApiKeyModal] = useState(false);
  const [searchQuery, setSearchQuery] = useState("");
  const [userCode, setUserCode] = useState("");

  useEffect(() => {
    async function loadAllProblems() {
      setLoading(true);
      setError("");
      try {
        const topicList = [
          "arrays", "dynamicprogramming", "binarysearch", "binarysearchtree", "binarytree", "bitmanipulation", "graph", "greedyalgorithm", "hashing", "heaps", "linkedlist", "maths", "recursion", "slidingwindow", "sorting", "stackandqueue", "string", "tries"
        ];
        const problemsByTopicTemp = {};
        for (const topic of topicList) {
          try {
            const dataPath = import.meta.env.DEV 
              ? `/src/data/${topic}/problems.json`
              : `./data/${topic}/problems.json`;
            const res = await fetch(dataPath);
            if (!res.ok) continue;
            const problems = await res.json();
            problemsByTopicTemp[topic] = problems;
          } catch (err) {
            console.warn(`Error loading ${topic}:`, err);
          }
        }
        const loadedTopics = Object.keys(problemsByTopicTemp);
        setTopics(loadedTopics);
        setProblemsByTopic(problemsByTopicTemp);
        let topicToSelect = localStorage.getItem("lastSelectedTopic") || loadedTopics[0] || "";
        let idxToSelect = parseInt(localStorage.getItem("lastSelectedProblemIdx") || "0", 10);
        setSelectedTopic(topicToSelect);
        setSelectedProblemIdx(idxToSelect);
        setInput(problemsByTopicTemp[topicToSelect]?.[idxToSelect]?.defaultInput || {});
        setLoading(false);
      } catch (err) {
        setError("Failed to load problems data.");
        setLoading(false);
      }
    }
    loadAllProblems();
  }, []);

  useEffect(() => {
    if (!selectedTopic || !problemsByTopic[selectedTopic]) return;
    const selectedProblem = problemsByTopic[selectedTopic][selectedProblemIdx];
    setInput(selectedProblem?.defaultInput || {});
    setOutput(null);
    setError("");
    setUserCode(selectedProblem?.solutionTemplate || "// Write your solution here");
    localStorage.setItem("lastSelectedTopic", selectedTopic);
    localStorage.setItem("lastSelectedProblemIdx", selectedProblemIdx);
  }, [selectedTopic, selectedProblemIdx, problemsByTopic]);

  const problems = problemsByTopic[selectedTopic] || [];
  const selectedProblem = problems[selectedProblemIdx];

  const handleRun = async () => {
    setOutput(null);
    setError("");
    if (!selectedProblem) return;
    try {
      const res = await fetch(selectedProblem.endpoint, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(input),
      });
      if (!res.ok) throw new Error(`HTTP ${res.status}`);
      const data = await res.json();
      setOutput(data);
    } catch (err) {
      setError(err.message || "Error running solution");
    }
  };

  if (loading) {
    return <LoadingSpinner />;
  }
  if (error) {
    return (
      <div className="flex items-center justify-center h-screen">
        <div className="alert alert-error max-w-md">
          <span>{error}</span>
        </div>
      </div>
    );
  }

  return (
    <div className="flex flex-col min-h-screen bg-base-100">
      <ModernDaisyNavbar onApiKeyClick={() => setShowApiKeyModal(true)} />
      
      <div className="flex flex-1 overflow-hidden">
        <TopicSelector
          topics={topics}
          selectedTopic={selectedTopic}
          onSelectTopic={setSelectedTopic}
        />
        <ProblemList
          problems={problems.filter(p => p.name.toLowerCase().includes(searchQuery.toLowerCase()))}
          selectedProblemIdx={selectedProblemIdx}
          onSelectProblem={setSelectedProblemIdx}
        />
        <main className="flex-1 flex flex-col overflow-hidden">
          <ProblemDetails problem={selectedProblem} />
          {/* Code Editor */}
          <div className="flex-1 overflow-hidden">
            <div className="h-full flex flex-col">
              <div className="bg-base-200 px-4 py-2 border-b border-base-300">
                <h3 className="text-lg font-semibold">Code Editor</h3>
              </div>
              <div className="flex-1 overflow-hidden">
                {selectedProblem && (
                  <div className="h-full">
                    <CodeEditor
                      value={userCode}
                      onChange={setUserCode}
                      language={selectedProblem.language === 'java' ? 'java' : 'javascript'}
                      height="100%"
                      width="100%"
                      options={{
                        fontSize: 14,
                        minimap: { enabled: false },
                        scrollBeyondLastLine: false,
                        automaticLayout: true,
                        theme: "vs-dark",
                      }}
                    />
                  </div>
                )}
              </div>
            </div>
          </div>
          
          {/* Input/Output Panel */}
          <div className="h-80 border-t border-base-300 flex flex-col">
            <div className="tabs tabs-bordered bg-base-200">
              <a className="tab tab-active">Input</a>
              <a className="tab">Output</a>
            </div>
            
            <div className="flex-1 flex overflow-hidden">
              {/* Input Section */}
              <div className="w-1/2 border-r border-base-300 p-4">
                <InputForm 
                  input={input} 
                  onInputChange={setInput} 
                  problem={selectedProblem}
                  onRun={handleRun}
                />
              </div>
              
              {/* Output Section */}
              <div className="w-1/2 p-4">
                <OutputPanel output={output} error={error} />
              </div>
            </div>
          </div>
        </main>
      </div>
      
      <DaisyApiKeyModal 
        isOpen={showApiKeyModal} 
        onClose={() => setShowApiKeyModal(false)} 
        onSave={(key) => setShowApiKeyModal(false)} 
      />
    </div>
  );




}

// Authentication wrapper component with routing
function AuthenticatedApp() {
  const { isAuthenticated, isLoading, error } = useAuth0();
  const location = useLocation();

  if (isLoading) {
    return <LoadingSpinner />;
  }

  if (location.pathname === '/callback' || location.pathname === '/dsamentorai/callback') {
    return <CallbackPage />;
  }

  if (error) {
    return (
      <div className="min-h-screen bg-base-200 flex items-center justify-center p-4">
        <div className="card bg-base-100 shadow-xl">
          <div className="card-body">
            <h2 className="card-title text-error">Authentication Error</h2>
            <p>{error.message}</p>
            <div className="card-actions justify-end">
              <button className="btn btn-primary" onClick={() => window.location.reload()}>Retry</button>
            </div>
          </div>
        </div>
      </div>
    );
  }

  return isAuthenticated ? <MainApp /> : <Auth0Login />;
}

// Root App Component
export default function App() {
  if (!isAuth0Configured()) {
    return (
      <div className="min-h-screen bg-base-200 flex items-center justify-center">
        <Auth0Setup />
      </div>
    );
  }

  return (
    <Router>
      <Auth0ProviderWithHistory>
        <AuthenticatedApp />
      </Auth0ProviderWithHistory>
    </Router>
  );
}
