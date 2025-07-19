import React, { useState } from 'react';
import { useAuth0 } from '@auth0/auth0-react';

const Auth0Header = () => {
  const { logout, user } = useAuth0();
  const [showApiKeyModal, setShowApiKeyModal] = useState(false);
  const [apiKeyInput, setApiKeyInput] = useState(localStorage.getItem('openai_api_key') || '');
  const [apiKeyError, setApiKeyError] = useState('');

  const handleLogout = () => {
    localStorage.removeItem('openai_api_key');
    logout({ logoutParams: { returnTo: window.location.origin } });
  };

  const handleApiKeySave = (e) => {
    e.preventDefault();
    if (!apiKeyInput.trim().startsWith('sk-') && !apiKeyInput.trim().startsWith('sk-proj-')) {
      setApiKeyError('Please enter a valid OpenAI API key.');
      return;
    }
    localStorage.setItem('openai_api_key', apiKeyInput.trim());
    setShowApiKeyModal(false);
    setApiKeyError('');
  };

  const handleApiKeyChange = (e) => {
    setApiKeyInput(e.target.value);
    setApiKeyError('');
  };

  const handleApiKeyClear = () => {
    localStorage.removeItem('openai_api_key');
    setApiKeyInput('');
    setShowApiKeyModal(false);
    setApiKeyError('');
  };

  return (
    <header className="bg-gradient-to-r from-indigo-900 via-blue-900 to-purple-900 text-white shadow-2xl border-b border-cyan-500/20">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex justify-between items-center h-16">
          <div className="flex items-center space-x-3">
            <div className="w-10 h-10 bg-gradient-to-r from-cyan-400 to-blue-500 rounded-xl flex items-center justify-center shadow-lg">
              <span className="text-xl">💡</span>
            </div>
            <div>
              <h1 className="text-xl font-bold bg-gradient-to-r from-cyan-400 to-blue-400 bg-clip-text text-transparent">
                DSA Mentor
              </h1>
              <div className="flex items-center space-x-2">
                <div className="w-2 h-2 bg-green-400 rounded-full animate-pulse"></div>
                <span className="text-green-400 text-xs font-medium">Live Session</span>
              </div>
            </div>
          </div>
          <div className="flex items-center space-x-4">
            <button
              onClick={() => setShowApiKeyModal(true)}
              className="bg-gradient-to-r from-blue-500 to-cyan-500 hover:from-blue-600 hover:to-cyan-600 text-white px-4 py-2 rounded-xl transition-all duration-300 transform hover:scale-105 hover:shadow-lg text-sm font-medium"
            >
              API Key
            </button>
            <div className="flex items-center space-x-3 bg-white/10 rounded-2xl px-4 py-2 backdrop-blur-xl border border-white/20">
              {user?.picture && (
                <img 
                  src={user.picture} 
                  alt={user.name || 'User'} 
                  className="w-8 h-8 rounded-full ring-2 ring-cyan-400/50 shadow-lg"
                />
              )}
              <div className="text-right">
                <div className="text-sm font-medium text-white">
                  {user?.name || 'User'}
                </div>
                <div className="text-xs text-gray-300">
                  Learning Mode
                </div>
              </div>
            </div>
            <button
              onClick={handleLogout}
              className="bg-gradient-to-r from-red-500 to-pink-500 hover:from-red-600 hover:to-pink-600 text-white px-4 py-2 rounded-xl transition-all duration-300 transform hover:scale-105 hover:shadow-lg text-sm font-medium"
            >
              Sign Out
            </button>
          </div>
        </div>
      </div>
      {/* API Key Modal */}
      {showApiKeyModal && (
        <div className="fixed inset-0 z-50 flex items-center justify-center" style={{background: 'rgba(0,0,0,0.7)'}}>
          <div className="bg-white rounded-xl p-8 shadow-xl w-full max-w-sm relative">
            <h3 className="text-lg font-semibold mb-4">OpenAI API Key</h3>
            <form onSubmit={handleApiKeySave}>
              <input
                type="password"
                className="w-full border border-gray-300 rounded px-3 py-2 mb-2 focus:outline-none focus:ring-2 focus:ring-blue-400"
                placeholder="sk-... or sk-proj-..."
                value={apiKeyInput}
                onChange={handleApiKeyChange}
                autoFocus
              />
              {apiKeyError && <div className="text-red-600 text-sm mb-2">{apiKeyError}</div>}
              <div className="flex space-x-2 mt-2">
                <button
                  type="submit"
                  className="flex-1 bg-blue-600 text-white py-2 rounded hover:bg-blue-700"
                >
                  Save
                </button>
                <button
                  type="button"
                  className="flex-1 bg-gray-300 text-gray-800 py-2 rounded hover:bg-gray-400"
                  onClick={() => setShowApiKeyModal(false)}
                >
                  Cancel
                </button>
                <button
                  type="button"
                  className="flex-1 bg-red-500 text-white py-2 rounded hover:bg-red-600"
                  onClick={handleApiKeyClear}
                  disabled={!localStorage.getItem('openai_api_key')}
                >
                  Clear
                </button>
              </div>
            </form>
            <p className="text-xs text-gray-500 mt-2">Your API key is stored only in your browser for this session.</p>
          </div>
        </div>
      )}
    </header>
  );
};

export default Auth0Header;
