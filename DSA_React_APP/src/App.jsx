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
      <ModernDaisyNavbar />

      
      <div className="flex flex-1 overflow-hidden">
        {/* Sidebar with Topic Selector */}
        <div className="w-64 bg-base-200 border-r border-base-300">
          <div className="p-4">
            <h2 className="text-lg font-bold mb-4">Topics</h2>
            <TopicSelector
              topics={topics}
              selectedTopic={selectedTopic}
              onSelectTopic={setSelectedTopic}
            />
          </div>
        </div>
        
        {/* Problem List */}
        <div className="w-80 bg-base-100 border-r border-base-300">
          <div className="p-4 border-b border-base-300">
            <h2 className="text-lg font-bold">Problems</h2>
            <p className="text-sm text-base-content/70">
              {problems.filter(p => p.name.toLowerCase().includes(searchQuery.toLowerCase())).length} problems
            </p>
          </div>
          <div className="overflow-y-auto h-[calc(100vh-8rem)]">
            <ProblemList
              problems={problems.filter(p => p.name.toLowerCase().includes(searchQuery.toLowerCase()))}
              selectedProblemIdx={selectedProblemIdx}
              onSelectProblem={setSelectedProblemIdx}
            />
          </div>
        </div>
        
        {/* Main Content Area */}
        <main className="flex-1 flex flex-col overflow-hidden">
          {/* Problem Details Card */}
          <div className="bg-base-100 border-b border-base-300">
            <ProblemDetails problem={selectedProblem} />
          </div>
          
          {/* Code Editor Section */}
          <div className="flex-1 flex flex-col bg-base-100">
            <div className="navbar bg-base-200 border-b border-base-300 px-4 py-2">
              <div className="flex-1">
                <h3 className="text-lg font-semibold">Code Editor</h3>
              </div>
              <div className="flex-none">
                <button 
                  className="btn btn-primary btn-sm"
                  onClick={handleRun}
                  disabled={!selectedProblem}
                >
                  <svg xmlns="http://www.w3.org/2000/svg" className="h-4 w-4 mr-1" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M14.752 11.168l-3.197-2.132A1 1 0 0010 9.87v4.263a1 1 0 001.555.832l3.197-2.132a1 1 0 000-1.664z" />
                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
                  </svg>
                  Run Code
                </button>
              </div>
            </div>
            <div className="flex-1 overflow-hidden">
              {selectedProblem ? (
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
              ) : (
                <div className="flex items-center justify-center h-full">
                  <div className="text-center">
                    <svg xmlns="http://www.w3.org/2000/svg" className="h-16 w-16 mx-auto mb-4 text-base-content/30" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                      <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M10 20l4-16m4 4l4 4-4 4M6 16l-4-4 4-4" />
                    </svg>
                    <p className="text-base-content/50">Select a problem to start coding</p>
                  </div>
                </div>
              )}
            </div>
          </div>
          
          {/* Input/Output Panel */}
          <div className="h-80 bg-base-100 border-t border-base-300">
            <div className="tabs tabs-boxed bg-base-200">
              <a className="tab tab-active">Input</a>
              <a className="tab">Output</a>
            </div>
            <div className="flex h-[calc(100%-3rem)]">
              {/* Input Section */}
              <div className="w-1/2 border-r border-base-300">
                <div className="p-4 h-full overflow-y-auto">
                  <InputForm 
                    input={input} 
                    onInputChange={setInput} 
                    problem={selectedProblem}
                    onRun={handleRun}
                  />
                </div>
              </div>
              
              {/* Output Section */}
              <div className="w-1/2">
                <div className="p-4 h-full overflow-y-auto">
                  <OutputPanel output={output} error={error} />
                </div>
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
