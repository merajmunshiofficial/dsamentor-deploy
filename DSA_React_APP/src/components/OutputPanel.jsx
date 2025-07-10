import React from "react";

export default function OutputPanel({ output, loading, error }) {
  return (
    <div className="bg-white p-4 rounded shadow border">
      <label className="font-semibold">Output:</label>
      <div className="bg-gray-100 rounded p-3 font-mono mt-2 max-h-[300px] overflow-y-auto">
        {loading && <span className="text-blue-500">Loading...</span>}
        {error && <span className="text-red-500">{error}</span>}
        {!loading && !error && (
          <pre className="whitespace-pre-wrap">{output ? JSON.stringify(output, null, 2) : "No output yet."}</pre>
        )}
      </div>
    </div>
  );
} 