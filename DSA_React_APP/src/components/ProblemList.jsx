import React, { useEffect, useRef } from "react";

export default function ProblemList({ problems, selectedProblemIdx, onSelectProblem }) {
  const problemRefs = useRef([]);

  useEffect(() => {
    if (problemRefs.current[selectedProblemIdx]) {
      problemRefs.current[selectedProblemIdx].scrollIntoView({ behavior: "smooth", block: "center" });
    }
  }, [selectedProblemIdx]);

  return (
    <div className="flex flex-col gap-2 p-4 bg-gray-50 h-full min-w-[220px] border-l overflow-y-auto">
      <h2 className="font-bold text-lg mb-2">Problems</h2>
      {problems.map((problem, idx) => (
        <button
          key={problem.name}
          ref={el => problemRefs.current[idx] = el}
          className={`text-left px-3 py-2 rounded hover:bg-blue-100 transition-colors ${selectedProblemIdx === idx ? "bg-blue-400 text-white ring-2 ring-blue-700" : "bg-white"}`}
          onClick={() => onSelectProblem(idx)}
        >
          {problem.name}
        </button>
      ))}
    </div>
  );
}