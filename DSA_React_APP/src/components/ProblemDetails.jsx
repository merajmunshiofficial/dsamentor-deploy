import React, { useState, useEffect } from "react";

import CodeBlock from "./CodeBlock";
import CodeEditor from "./CodeEditor";
import ReactMarkdown from "react-markdown";

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
    const apiKey = localStorage.getItem("openai_api_key");
    if (!apiKey) {
      setError("No OpenAI API key found. Please log in and provide your API key.");
      setLoading(false);
      return;
    }
    try {
      const prompt = `You are a DSA coding mentor. Compare the user's code to the reference solution.\n\nReference Solution:\n${problem.code}\n\nUser's Code:\n${userCode}\n\nIf the user's code is correct, reply with 'Correct' and a brief explanation. If incorrect, explain what is wrong, how to fix it, and actionable guidance.`;
      const response = await fetch("https://api.openai.com/v1/chat/completions", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Authorization": `Bearer ${apiKey}`,
        },
        body: JSON.stringify({
          model: "gpt-3.5-turbo",
          messages: [
            { role: "system", content: "You are a helpful DSA coding mentor." },
            { role: "user", content: prompt },
          ],
          max_tokens: 512,
        }),
      });
      if (!response.ok) {
        throw new Error(`OpenAI API error: ${response.status}`);
      }
      const data = await response.json();
      const aiMessage = data.choices?.[0]?.message?.content || "No feedback received.";
      setFeedback(aiMessage);
    } catch (err) {
      setError(err.message || "Unknown error");
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
          <div className="flex flex-col flex-1 h-[600px] max-h-[80vh]">
            <div className="flex-grow overflow-auto border border-base-300 rounded-lg">
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
            <div className="mt-2 flex justify-end">
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
              <div className="mt-2 alert alert-error">
                <span>{error}</span>
              </div>
            )}
            {feedback && (
              <div className="mt-2 card bg-base-100 border border-base-300 p-4 prose max-w-none">
                <h4 className="font-semibold mb-2">Feedback:</h4>
                <ReactMarkdown className="prose max-w-none">
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
