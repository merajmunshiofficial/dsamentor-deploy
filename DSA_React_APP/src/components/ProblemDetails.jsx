import React, { useState, useEffect } from "react";

import CodeBlock from "./CodeBlock";
import CodeEditor from "./CodeEditor";
import ReactMarkdown from "react-markdown";
import aiService from "../services/aiService";

const tabs = ["Description", "Approach", "Code", "Code Editor"];

export default function ProblemDetails({ problem }) {
  const [activeTab, setActiveTab] = useState("Description");
  const [userCodeMap, setUserCodeMap] = useState({});
  const [feedback, setFeedback] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [userCode, setUserCode] = useState("");
  const [input, setInput] = useState(problem?.defaultInput || {});
  const [output, setOutput] = useState(null);
  const [runLoading, setRunLoading] = useState(false);
  const [runError, setRunError] = useState("");
  const [aiProvider, setAiProvider] = useState(null);

  const getProblemKey = () => {
    if (!problem) return "";
    return `${problem.topic || ''}::${problem.name || ''}`;
  };

  useEffect(() => {
    const key = getProblemKey();
    setUserCode(userCodeMap[key] || "");
    setFeedback(null);
    setError(null);
    setInput(problem?.defaultInput || {});
    setOutput(null);
    setRunError("");
    setAiProvider(null);
    
    // Migrate existing keys on component mount
    aiService.migrateExistingKeys();
  }, [problem]);

  useEffect(() => {
    const key = getProblemKey();
    if (key) {
      setUserCodeMap((prev) => ({ ...prev, [key]: userCode }));
    }
  }, [userCode]);

  if (!problem) {
    return (
      <div className="flex items-center justify-center h-full">
        <div className="text-center">
          <h3 className="text-lg font-semibold text-base-content">Select a problem</h3>
          <p className="text-base-content/70">Choose a problem to view details</p>
        </div>
      </div>
    );
  }

  const editorLanguage = problem.language === 'java' ? 'java' : 'javascript';

  const handleCheck = async () => {
    setLoading(true);
    setError(null);
    setFeedback(null);
    setAiProvider(null);
    
    try {
      const result = await aiService.getCodeFeedback(userCode, problem.code);
      setFeedback(result.feedback);
      setAiProvider({
        name: result.provider,
        model: result.model
      });
    } catch (err) {
      setError(err.message || "Unknown error occurred");
    } finally {
      setLoading(false);
    }
  };

  const handleRun = async () => {
    setOutput(null);
    setRunError("");
    setRunLoading(true);
    if (!problem) return;
    try {
      const res = await fetch(problem.endpoint, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(input),
      });
      if (!res.ok) throw new Error(`HTTP ${res.status}`);
      const data = await res.json();
      setOutput(data);
    } catch (err) {
      setRunError(err.message || "Error running solution");
    } finally {
      setRunLoading(false);
    }
  };

  return (
    <div className="flex flex-col h-full bg-base-100">
      {/* Header with problem title and difficulty */}
      <div className="flex-shrink-0 p-4 border-b border-base-300 bg-base-200">
        <div className="flex items-center justify-between mb-3">
          <h1 className="text-xl font-bold text-base-content">{problem.name}</h1>
          <div className="badge badge-primary">{problem.difficulty || 'Medium'}</div>
        </div>
        
        {/* Tabs */}
        <div className="tabs tabs-bordered">
          {tabs.map((tab) => (
            <button
              key={tab}
              className={`tab ${activeTab === tab ? "tab-active" : ""}`}
              onClick={() => setActiveTab(tab)}
            >
              {tab}
            </button>
          ))}
        </div>
      </div>
      
      {/* Content Area */}
      <div className="flex-1 overflow-y-auto p-4">
        {activeTab === "Description" && (
          <div className="space-y-4">
            <div className="card bg-base-100 border border-base-300">
              <div className="card-body">
                <h3 className="card-title text-lg">Problem Statement</h3>
                <div className="prose prose-sm max-w-none">
                  <p className="whitespace-pre-wrap text-base-content leading-relaxed">
                    {problem.description || "No description available."}
                  </p>
                </div>
              </div>
            </div>
            
            {/* Examples */}
            {problem.examples && (
              <div className="card bg-base-100 border border-base-300">
                <div className="card-body">
                  <h3 className="card-title text-lg">Examples</h3>
                  <div className="space-y-3">
                    {problem.examples.map((example, idx) => (
                      <div key={idx} className="bg-base-200 p-3 rounded-lg">
                        <div className="font-semibold mb-2">Example {idx + 1}:</div>
                        <div className="font-mono text-sm">
                          <div><strong>Input:</strong> {JSON.stringify(example.input)}</div>
                          <div><strong>Output:</strong> {JSON.stringify(example.output)}</div>
                          {example.explanation && (
                            <div className="mt-2"><strong>Explanation:</strong> {example.explanation}</div>
                          )}
                        </div>
                      </div>
                    ))}
                  </div>
                </div>
              </div>
            )}
            
            {/* Constraints */}
            {problem.constraints && (
              <div className="card bg-base-100 border border-base-300">
                <div className="card-body">
                  <h3 className="card-title text-lg">Constraints</h3>
                  <div className="prose prose-sm max-w-none">
                    <p className="whitespace-pre-wrap text-base-content">
                      {problem.constraints}
                    </p>
                  </div>
                </div>
              </div>
            )}
          </div>
        )}
        
        {activeTab === "Approach" && (
          <div className="card bg-base-100 border border-base-300">
            <div className="card-body">
              <h3 className="card-title text-lg">Solution Approach</h3>
              <div className="prose prose-sm max-w-none">
                <p className="whitespace-pre-wrap text-base-content leading-relaxed">
                  {problem.approach || "No approach explanation available."}
                </p>
              </div>
              
              {/* Time and Space Complexity */}
              {(problem.timeComplexity || problem.spaceComplexity) && (
                <div className="mt-4 space-y-2">
                  {problem.timeComplexity && (
                    <div className="flex items-center gap-2">
                      <span className="badge badge-outline">Time Complexity:</span>
                      <code className="text-sm">{problem.timeComplexity}</code>
                    </div>
                  )}
                  {problem.spaceComplexity && (
                    <div className="flex items-center gap-2">
                      <span className="badge badge-outline">Space Complexity:</span>
                      <code className="text-sm">{problem.spaceComplexity}</code>
                    </div>
                  )}
                </div>
              )}
            </div>
          </div>
        )}
        
        {activeTab === "Code" && (
          <div className="card bg-base-100 border border-base-300">
            <div className="card-body">
              <h3 className="card-title text-lg">Reference Solution</h3>
              <div className="mt-4">
                <CodeBlock code={problem.code || "// No code available"} />
              </div>
            </div>
          </div>
        )}
        
        {activeTab === "Code Editor" && (
          <div className="flex flex-col flex-1 h-[80vh]">
            <div className="flex-grow border border-base-300 rounded-lg mb-2" style={{ minHeight: '600px' }}>
              <CodeEditor
                value={userCode}
                onChange={setUserCode}
                language={editorLanguage}
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
            <div className="flex justify-end mb-2">
              <button
                className="btn btn-primary"
                onClick={handleCheck}
                disabled={loading}
              >
                {loading ? (
                  <span className="loading loading-spinner loading-sm"></span>
                ) : (
                  "Run Code"
                )}
              </button>
            </div>
            {error && (
              <div className="mb-2 alert alert-error">
                <span>{error}</span>
              </div>
            )}
            {feedback && (
              <div className="flex-grow overflow-auto card bg-base-100 border border-base-300 p-4 prose max-w-none" style={{ minHeight: '400px' }}>
                <div className="flex items-center justify-between mb-2">
                  <h4 className="font-semibold">Feedback:</h4>
                  {aiProvider && (
                    <div className="badge badge-outline badge-sm">
                      {aiProvider.name} ({aiProvider.model})
                    </div>
                  )}
                </div>
                <ReactMarkdown className="prose max-w-none" components={{
                  code({node, inline, className, children, ...props}) {
                    return !inline ? (
                      <pre className="overflow-x-auto p-4 bg-gray-900 rounded-lg text-white text-sm" style={{ maxHeight: 'none' }} {...props}>
                        <code style={{ fontSize: '0.875rem', lineHeight: '1.25rem' }}>{children}</code>
                      </pre>
                    ) : (
                      <code className={className} {...props}>
                        {children}
                      </code>
                    )
                  }
                }}>
                  {feedback}
                </ReactMarkdown>
              </div>
            )}
          </div>
        )}
      </div>
    </div>
  );
}
