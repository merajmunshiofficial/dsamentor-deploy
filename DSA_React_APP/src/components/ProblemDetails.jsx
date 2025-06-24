import React, { useState } from "react";
import CodeBlock from "./CodeBlock";

const tabs = ["Description", "Approach", "Code"];

export default function ProblemDetails({ problem }) {
  const [activeTab, setActiveTab] = useState("Description");
  if (!problem) return <div className="p-4">Select a problem to view details.</div>;
  return (
    <div className="flex flex-col flex-1 p-4">
      <h1 className="text-2xl font-bold mb-2">{problem.name}</h1>
      <div className="flex gap-2 mb-4">
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
      <div className="bg-white p-4 rounded shadow min-h-[120px]">
        {activeTab === "Description" && <div>{problem.description}</div>}
        {activeTab === "Approach" && <div>{problem.approach}</div>}
        {activeTab === "Code" && <CodeBlock code={problem.code} />}
      </div>
    </div>
  );
} 