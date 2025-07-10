import React, { useEffect, useRef } from "react";

export default function ProblemList({ problems, selectedProblemIdx, onSelectProblem }) {
  const problemRefs = useRef([]);

  useEffect(() => {
    if (problemRefs.current[selectedProblemIdx]) {
      problemRefs.current[selectedProblemIdx].scrollIntoView({ behavior: "smooth", block: "center" });
    }
  }, [selectedProblemIdx]);

  return (
    <div className="flex flex-col bg-gray-50 w-[280px] overflow-hidden border-r border-gray-300">
      <div className="p-4 border-b border-gray-300 bg-gray-100">
        <h2 className="font-bold text-lg">Problems</h2>
      </div>
      <div className="flex-1 overflow-y-auto p-2">
        {problems.map((problem, idx) => (
          <button
            key={problem.name}
            ref={el => problemRefs.current[idx] = el}
            className={`w-full text-left px-3 py-2 mb-1 rounded hover:bg-blue-100 transition-colors text-sm ${selectedProblemIdx === idx ? "bg-blue-400 text-white ring-2 ring-blue-700" : "bg-white"}`}
            onClick={() => onSelectProblem(idx)}
          >
            {problem.name}
          </button>
        ))}
      </div>
    </div>
  );
}