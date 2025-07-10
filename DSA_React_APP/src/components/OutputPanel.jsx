import React from "react";

export default function OutputPanel({ output, loading, error }) {
  return (
    <div className="flex flex-col gap-2 bg-white p-4 rounded shadow border flex-1 min-h-0">
      <label className="font-semibold">Output:</label>
      <div className="bg-gray-100 rounded p-3 font-mono flex-1 overflow-y-auto">
        {loading && <span className="text-blue-500">Loading...</span>}
        {error && <span className="text-red-500">{error}</span>}
        {!loading && !error && (
          <pre className="whitespace-pre-wrap">{output ? JSON.stringify(output, null, 2) : "No output yet."}</pre>
        )}
      </div>
    </div>
  );
} 