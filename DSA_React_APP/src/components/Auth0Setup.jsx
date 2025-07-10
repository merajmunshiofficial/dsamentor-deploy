import React from 'react';

const Auth0Setup = () => {
  return (
    <div className="min-h-screen bg-gradient-to-br from-orange-900 via-red-900 to-pink-900 flex items-center justify-center p-4">
      <div className="max-w-2xl w-full bg-white/10 backdrop-blur-md rounded-2xl shadow-2xl p-8 border border-white/20">
        <div className="text-center mb-8">
          <h1 className="text-3xl font-bold text-white mb-2">⚠️ Auth0 Setup Required</h1>
          <p className="text-gray-300">Please configure your Auth0 credentials</p>
        </div>

        <div className="space-y-6 text-white">
          <div className="bg-white/10 rounded-lg p-6">
            <h2 className="text-xl font-semibold mb-4">🚀 Quick Setup Steps:</h2>
            <ol className="list-decimal list-inside space-y-2 text-gray-300">
              <li>Create a free Auth0 account at <a href="https://auth0.com" className="text-blue-300 underline">auth0.com</a></li>
              <li>Create a new Single Page Application</li>
              <li>Copy your Domain and Client ID</li>
              <li>Update your .env file with the credentials</li>
              <li>Restart your development server</li>
            </ol>
          </div>

          <div className="bg-white/10 rounded-lg p-6">
            <h3 className="text-lg font-semibold mb-3">📝 Environment Variables:</h3>
            <div className="bg-black/30 rounded p-4 font-mono text-sm">
              <div className="text-green-300">VITE_AUTH0_DOMAIN=your-domain.auth0.com</div>
              <div className="text-green-300">VITE_AUTH0_CLIENT_ID=your-client-id</div>
            </div>
          </div>

          <div className="bg-white/10 rounded-lg p-6">
            <h3 className="text-lg font-semibold mb-3">🔧 Auth0 Configuration:</h3>
            <div className="space-y-2 text-sm text-gray-300">
              <p><strong>Callback URLs:</strong> http://localhost:5173</p>
              <p><strong>Logout URLs:</strong> http://localhost:5173</p>
              <p><strong>Web Origins:</strong> http://localhost:5173</p>
            </div>
          </div>

          <div className="text-center">
            <a
              href="https://auth0.com/signup"
              target="_blank"
              rel="noopener noreferrer"
              className="bg-gradient-to-r from-blue-600 to-purple-600 hover:from-blue-700 hover:to-purple-700 text-white font-semibold py-3 px-6 rounded-lg transition-all duration-200 transform hover:scale-105 inline-block"
            >
              Get Started with Auth0
            </a>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Auth0Setup;
