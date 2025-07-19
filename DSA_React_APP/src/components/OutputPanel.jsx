import React from "react";
import ReactMarkdown from "react-markdown";

export default function OutputPanel({ output, loading, error }) {
  return (
    <div className="space-y-4">
      <div className="form-control">
        <label className="label">
          <span className="label-text font-semibold">Output</span>
        </label>
        <div className="prose max-w-none overflow-auto p-4 border border-base-300 rounded-lg bg-base-100 min-h-[150px]">
          {loading && (
            <pre data-prefix=">"><code>Loading...</code></pre>
          )}
          {error && (
            <pre data-prefix="✗" className="text-error"><code>{error}</code></pre>
          )}
          {!loading && !error && (
            output ? <ReactMarkdown>{output}</ReactMarkdown> : "No output yet."
          )}
        </div>
      </div>
    </div>
  );
}
