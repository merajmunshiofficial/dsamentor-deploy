import React, { useState } from "react";
import CodeBlock from "./CodeBlock";

const tabs = ["Description", "Approach", "Code"];

export default function ProblemDetails({ problem }) {
  const [activeTab, setActiveTab] = useState("Description");
  if (!problem) return <div className="p-4">Select a problem to view details.</div>;
  return (
    <div className="flex flex-col h-full">
      <div className="flex-shrink-0 p-4 border-b border-gray-200">
        <h1 className="text-2xl font-bold mb-2">{problem.name}</h1>
        <div className="flex gap-2">
          {tabs.map((tab) => (
            <button
              key={tab}
              className={`px-4 py-2 rounded-t ${activeTab === tab ? "bg-blue-500 text-white" : "bg-gray-200"}`}
              onClick={() => setActiveTab(tab)}
            >
              {tab}
            </button>
          ))}
        </div>
      </div>
      <div className="flex-1 bg-white p-4 overflow-y-auto">
        {activeTab === "Description" && <div className="whitespace-pre-wrap">{problem.description}</div>}
        {activeTab === "Approach" && <div className="whitespace-pre-wrap">{problem.approach}</div>}
        {activeTab === "Code" && <CodeBlock code={problem.code} />}
      </div>
    </div>
  );
} 