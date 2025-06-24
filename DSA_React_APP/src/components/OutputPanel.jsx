import React from "react";

export default function OutputPanel({ output, loading, error }) {
  return (
    <div className="flex flex-col gap-2 mt-4">
      <label className="font-semibold">Output:</label>
      <div className="bg-gray-100 rounded p-3 min-h-[60px] font-mono">
        {loading && <span className="text-blue-500">Loading...</span>}
        {error && <span className="text-red-500">{error}</span>}
        {!loading && !error && (
          <pre>{output ? JSON.stringify(output, null, 2) : "No output yet."}</pre>
        )}
      </div>
    </div>
  );
} 