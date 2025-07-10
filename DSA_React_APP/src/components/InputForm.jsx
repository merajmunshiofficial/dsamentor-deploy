import React, { useState, useEffect } from "react";

export default function InputForm({ input, setInput, onRun, loading }) {
  const [error, setError] = useState("");
  const [text, setText] = useState(JSON.stringify(input, null, 2));

  // Sync text area with input prop when problem changes
  useEffect(() => {
    setText(JSON.stringify(input, null, 2));
  }, [input]);

  const handleChange = (e) => {
    setText(e.target.value);
    try {
      const parsed = JSON.parse(e.target.value);
      setError("");
      setInput(parsed);
    } catch {
      setError("Invalid JSON");
    }
  };

  return (
    <div className="bg-white p-4 rounded shadow border">
      <label className="font-semibold">Input (JSON):</label>
      <textarea
        className="border rounded p-2 font-mono min-h-[120px] max-h-[200px] resize-y w-full mt-2"
        value={text}
        onChange={handleChange}
        disabled={loading}
      />
      {error && <div className="text-red-500 text-sm mt-1">{error}</div>}
      <button
        className="bg-blue-600 text-white px-4 py-2 rounded disabled:opacity-50 hover:bg-blue-700 transition-colors w-full mt-2"
        onClick={onRun}
        disabled={!!error || loading}
      >
        {loading ? "Running..." : "Run Solution"}
      </button>
    </div>
  );
}