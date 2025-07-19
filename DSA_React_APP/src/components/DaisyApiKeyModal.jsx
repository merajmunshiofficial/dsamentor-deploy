import React, { useState, useEffect } from 'react';

export default function DaisyApiKeyModal({ isOpen, onClose, onSave }) {
  const [apiKey, setApiKey] = useState('');
  const [error, setError] = useState('');

  useEffect(() => {
    if (isOpen) {
      setApiKey(localStorage.getItem('openai_api_key') || '');
      setError('');
    }
  }, [isOpen]);

  const handleSave = () => {
    if (!apiKey.trim()) {
      setError('Please enter a valid API key');
      return;
    }
    localStorage.setItem('openai_api_key', apiKey);
    onSave(apiKey);
    onClose();
  };

  if (!isOpen) return null;

  return (
    <div className="modal modal-open">
      <div className="modal-box">
        <h3 className="font-bold text-lg mb-4">OpenAI API Key</h3>
        
        <div className="form-control">
          <label className="label">
            <span className="label-text">Enter your OpenAI API key</span>
          </label>
          <input
            type="password"
            placeholder="sk-..."
            className="input input-bordered w-full"
            value={apiKey}
            onChange={(e) => setApiKey(e.target.value)}
          />
          {error && (
            <label className="label">
              <span className="label-text-alt text-error">{error}</span>
            </label>
          )}
        </div>
        
        <div className="text-sm text-base-content/70 mt-2">
          Your API key is stored locally in your browser and never sent to our servers.
        </div>
        
        <div className="modal-action">
          <button className="btn btn-ghost" onClick={onClose}>Cancel</button>
          <button className="btn btn-primary" onClick={handleSave}>Save</button>
        </div>
      </div>
      <div className="modal-backdrop" onClick={onClose}></div>
    </div>
  );
}
