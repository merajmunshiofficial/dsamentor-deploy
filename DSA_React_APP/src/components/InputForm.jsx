import React, { useState, useEffect } from "react";

export default function InputForm({ input, onInputChange, problem, onRun, loading }) {
  const [error, setError] = useState("");
  const [text, setText] = useState(JSON.stringify(input, null, 2));

  useEffect(() => {
    setText(JSON.stringify(input, null, 2));
  }, [input]);

  const handleChange = (e) => {
    setText(e.target.value);
    try {
      const parsed = JSON.parse(e.target.value);
      setError("");
      onInputChange(parsed);
    } catch {
      setError("Invalid JSON");
    }
  };

  return (
    <div className="space-y-4">
      <div className="form-control">
        <label className="label">
          <span className="label-text font-semibold">Input (JSON)</span>
        </label>
        <textarea
          className="textarea textarea-bordered font-mono h-32"
          value={text}
          onChange={handleChange}
          disabled={loading}
          placeholder="Enter JSON input..."
        />
        {error && <label className="label"><span className="label-text-alt text-error">{error}</span></label>}
      </div>
      
      <button
        className="btn btn-primary w-full"
        onClick={onRun}
        disabled={!!error || loading}
      >
        {loading ? (
          <>
            <span className="loading loading-spinner loading-sm"></span>
            Running...
          </>
        ) : (
          "Run Solution"
        )}
      </button>
    </div>
  );
}
