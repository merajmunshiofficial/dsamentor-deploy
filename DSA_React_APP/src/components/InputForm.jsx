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
    <div className="flex flex-col gap-2">
      <label className="font-semibold">Input (JSON):</label>
      <textarea
        className="border rounded p-2 font-mono min-h-[100px]"
        value={text}
        onChange={handleChange}
        disabled={loading}
      />
      {error && <div className="text-red-500 text-sm">{error}</div>}
      <button
        className="bg-blue-600 text-white px-4 py-2 rounded disabled:opacity-50"
        onClick={onRun}
        disabled={!!error || loading}
      >
        {loading ? "Running..." : "Run Solution"}
      </button>
    </div>
  );
}