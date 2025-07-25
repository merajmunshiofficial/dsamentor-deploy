import React, { useState, useEffect } from 'react';
import aiService from '../services/aiService';

export default function DaisyApiKeyModal({ isOpen, onClose, onSave }) {
  const [selectedProvider, setSelectedProvider] = useState('openai');
  const [apiKeys, setApiKeys] = useState({
    openai: '',
    perplexity: ''
  });
  const [error, setError] = useState('');
  const [testing, setTesting] = useState(false);
  const [testResults, setTestResults] = useState({});

  useEffect(() => {
    if (isOpen) {
      // Initialize with current provider and keys
      const currentProvider = aiService.getCurrentProvider();
      setSelectedProvider(currentProvider);
      
      // Load existing API keys
      setApiKeys({
        openai: aiService.getApiKey('openai') || '',
        perplexity: aiService.getApiKey('perplexity') || ''
      });
      
      setError('');
      setTestResults({});
    }
  }, [isOpen]);

  const handleProviderChange = (provider) => {
    setSelectedProvider(provider);
    setError('');
    setTestResults({});
  };

  const handleApiKeyChange = (provider, value) => {
    setApiKeys(prev => ({
      ...prev,
      [provider]: value
    }));
    setError('');
    // Clear test result for this provider
    setTestResults(prev => ({
      ...prev,
      [provider]: null
    }));
  };

  const handleTestConnection = async (provider) => {
    const apiKey = apiKeys[provider];
    if (!apiKey.trim()) {
      setError('Please enter an API key first');
      return;
    }

    if (!aiService.validateApiKey(provider, apiKey)) {
      setError(`Invalid ${provider === 'openai' ? 'OpenAI' : 'Perplexity'} API key format`);
      return;
    }

    setTesting(true);
    setError('');
    
    try {
      const result = await aiService.testConnection(provider, apiKey);
      setTestResults(prev => ({
        ...prev,
        [provider]: { success: true, message: `✅ Connected to ${result.provider}` }
      }));
    } catch (err) {
      setTestResults(prev => ({
        ...prev,
        [provider]: { success: false, message: `❌ ${err.message}` }
      }));
    } finally {
      setTesting(false);
    }
  };

  const handleSave = () => {
    const currentApiKey = apiKeys[selectedProvider];
    
    if (!currentApiKey.trim()) {
      setError('Please enter a valid API key');
      return;
    }

    if (!aiService.validateApiKey(selectedProvider, currentApiKey)) {
      setError(`Invalid ${selectedProvider === 'openai' ? 'OpenAI' : 'Perplexity'} API key format`);
      return;
    }

    // Save the API key and set as current provider
    aiService.setApiKey(selectedProvider, currentApiKey);
    aiService.setCurrentProvider(selectedProvider);
    
    // Also save the other provider's key if it exists
    const otherProvider = selectedProvider === 'openai' ? 'perplexity' : 'openai';
    if (apiKeys[otherProvider].trim()) {
      aiService.setApiKey(otherProvider, apiKeys[otherProvider]);
    }

    onSave(currentApiKey);
    onClose();
  };

  const handleClearKey = (provider) => {
    aiService.removeApiKey(provider);
    setApiKeys(prev => ({
      ...prev,
      [provider]: ''
    }));
    setTestResults(prev => ({
      ...prev,
      [provider]: null
    }));
  };

  if (!isOpen) return null;

  const providers = aiService.providers;
  const currentProviderConfig = providers[selectedProvider];

  return (
    <div className="modal modal-open">
      <div className="modal-box max-w-2xl">
        <h3 className="font-bold text-lg mb-4">AI API Configuration</h3>
        
        {/* Provider Selection */}
        <div className="form-control mb-4">
          <label className="label">
            <span className="label-text font-semibold">Select AI Provider</span>
          </label>
          <div className="tabs tabs-boxed">
            {Object.entries(providers).map(([key, config]) => (
              <button
                key={key}
                className={`tab ${selectedProvider === key ? 'tab-active' : ''}`}
                onClick={() => handleProviderChange(key)}
              >
                {config.name}
              </button>
            ))}
          </div>
        </div>

        {/* API Key Input for Selected Provider */}
        <div className="form-control mb-4">
          <label className="label">
            <span className="label-text">
              {currentProviderConfig.name} API Key
            </span>
            <span className="label-text-alt">
              {apiKeys[selectedProvider] ? '✅ Saved' : '❌ Not set'}
            </span>
          </label>
          <div className="join w-full">
            <input
              type="password"
              placeholder={`${currentProviderConfig.keyPrefix}...`}
              className="input input-bordered join-item flex-1"
              value={apiKeys[selectedProvider]}
              onChange={(e) => handleApiKeyChange(selectedProvider, e.target.value)}
            />
            <button
              className="btn btn-outline join-item"
              onClick={() => handleTestConnection(selectedProvider)}
              disabled={testing || !apiKeys[selectedProvider].trim()}
            >
              {testing ? (
                <span className="loading loading-spinner loading-sm"></span>
              ) : (
                'Test'
              )}
            </button>
            {apiKeys[selectedProvider] && (
              <button
                className="btn btn-ghost join-item"
                onClick={() => handleClearKey(selectedProvider)}
              >
                Clear
              </button>
            )}
          </div>
          
          {/* Test Results */}
          {testResults[selectedProvider] && (
            <label className="label">
              <span className={`label-text-alt ${testResults[selectedProvider].success ? 'text-success' : 'text-error'}`}>
                {testResults[selectedProvider].message}
              </span>
            </label>
          )}
        </div>

        {/* Other Provider Status */}
        <div className="form-control mb-4">
          <label className="label">
            <span className="label-text">
              {selectedProvider === 'openai' ? 'Perplexity' : 'OpenAI'} API Key (Optional)
            </span>
            <span className="label-text-alt">
              {apiKeys[selectedProvider === 'openai' ? 'perplexity' : 'openai'] ? '✅ Saved' : '❌ Not set'}
            </span>
          </label>
          <div className="join w-full">
            <input
              type="password"
              placeholder={`${providers[selectedProvider === 'openai' ? 'perplexity' : 'openai'].keyPrefix}...`}
              className="input input-bordered join-item flex-1"
              value={apiKeys[selectedProvider === 'openai' ? 'perplexity' : 'openai']}
              onChange={(e) => handleApiKeyChange(selectedProvider === 'openai' ? 'perplexity' : 'openai', e.target.value)}
            />
            <button
              className="btn btn-outline join-item"
              onClick={() => handleTestConnection(selectedProvider === 'openai' ? 'perplexity' : 'openai')}
              disabled={testing || !apiKeys[selectedProvider === 'openai' ? 'perplexity' : 'openai'].trim()}
            >
              {testing ? (
                <span className="loading loading-spinner loading-sm"></span>
              ) : (
                'Test'
              )}
            </button>
            {apiKeys[selectedProvider === 'openai' ? 'perplexity' : 'openai'] && (
              <button
                className="btn btn-ghost join-item"
                onClick={() => handleClearKey(selectedProvider === 'openai' ? 'perplexity' : 'openai')}
              >
                Clear
              </button>
            )}
          </div>
          
          {/* Test Results for other provider */}
          {testResults[selectedProvider === 'openai' ? 'perplexity' : 'openai'] && (
            <label className="label">
              <span className={`label-text-alt ${testResults[selectedProvider === 'openai' ? 'perplexity' : 'openai'].success ? 'text-success' : 'text-error'}`}>
                {testResults[selectedProvider === 'openai' ? 'perplexity' : 'openai'].message}
              </span>
            </label>
          )}
        </div>

        {/* Error Display */}
        {error && (
          <div className="alert alert-error mb-4">
            <span>{error}</span>
          </div>
        )}

        {/* Provider Information */}
        <div className="bg-base-200 p-4 rounded-lg mb-4">
          <h4 className="font-semibold mb-2">About {currentProviderConfig.name}</h4>
          <div className="text-sm space-y-1">
            <div><strong>Model:</strong> {currentProviderConfig.model}</div>
            <div><strong>Key Format:</strong> Starts with "{currentProviderConfig.keyPrefix}"</div>
            {selectedProvider === 'openai' && (
              <div><strong>Get API Key:</strong> <a href="https://platform.openai.com/api-keys" target="_blank" rel="noopener noreferrer" className="link link-primary">OpenAI Platform</a></div>
            )}
            {selectedProvider === 'perplexity' && (
              <div><strong>Get API Key:</strong> <a href="https://www.perplexity.ai/settings/api" target="_blank" rel="noopener noreferrer" className="link link-primary">Perplexity Settings</a></div>
            )}
          </div>
        </div>
        
        <div className="text-sm text-base-content/70 mb-4">
          🔒 Your API keys are stored locally in your browser and never sent to our servers.
          Having both keys allows automatic fallback if one provider is unavailable.
        </div>
        
        <div className="modal-action">
          <button className="btn btn-ghost" onClick={onClose}>Cancel</button>
          <button 
            className="btn btn-primary" 
            onClick={handleSave}
            disabled={!apiKeys[selectedProvider].trim()}
          >
            Save & Use {currentProviderConfig.name}
          </button>
        </div>
      </div>
      <div className="modal-backdrop" onClick={onClose}></div>
    </div>
  );
}
