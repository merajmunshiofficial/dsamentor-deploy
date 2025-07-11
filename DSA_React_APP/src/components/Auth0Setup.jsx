import React from 'react';

const Auth0Setup = () => {
  return (
    <div className="min-h-screen bg-gradient-to-br from-slate-900 via-red-900 to-slate-900 flex items-center justify-center p-4">
      <div className="max-w-4xl w-full bg-white/10 backdrop-blur-md rounded-3xl shadow-2xl p-8 lg:p-12 border border-white/20">
        <div className="text-center mb-10">
          <div className="w-20 h-20 bg-gradient-to-r from-red-500 to-orange-500 rounded-2xl flex items-center justify-center mx-auto mb-6">
            <span className="text-3xl">⚠️</span>
          </div>
          <h1 className="text-3xl lg:text-4xl font-bold text-white mb-3">
            Auth0 Setup Required
          </h1>
          <p className="text-xl text-gray-300">
            Configure your Auth0 credentials to secure your DSA Mentor app
          </p>
        </div>

        <div className="grid lg:grid-cols-2 gap-8">
          {/* Setup Steps */}
          <div className="space-y-6">
            <div className="bg-white/10 rounded-2xl p-6 border border-white/10">
              <h2 className="text-2xl font-semibold mb-4 text-blue-300 flex items-center">
                <span className="mr-2">🚀</span>
                Quick Setup Steps
              </h2>
              <ol className="list-decimal list-inside space-y-3 text-gray-300">
                <li>Create a free Auth0 account at <a href="https://auth0.com" className="text-blue-400 underline hover:text-blue-300">auth0.com</a></li>
                <li>Create a new <span className="text-purple-400 font-medium">Single Page Application</span></li>
                <li>Copy your <span className="text-green-400 font-medium">Domain</span> and <span className="text-green-400 font-medium">Client ID</span></li>
                <li>Update your <span className="text-yellow-400 font-medium">.env</span> file with the credentials</li>
                <li>Restart your development server</li>
              </ol>
            </div>

            <div className="bg-white/10 rounded-2xl p-6 border border-white/10">
              <h3 className="text-xl font-semibold mb-3 text-purple-300 flex items-center">
                <span className="mr-2">🔧</span>
                Auth0 Application Settings
              </h3>
              <div className="space-y-3 text-sm">
                <div>
                  <span className="text-blue-300 font-medium">Callback URLs:</span>
                  <div className="bg-black/40 rounded-lg p-2 mt-1 font-mono text-green-300">
                    http://localhost:5173/callback, https://yourdomain.github.io/callback
                  </div>
                </div>
                <div>
                  <span className="text-blue-300 font-medium">Logout URLs:</span>
                  <div className="bg-black/40 rounded-lg p-2 mt-1 font-mono text-green-300">
                    http://localhost:5173, https://yourdomain.github.io
                  </div>
                </div>
                <div>
                  <span className="text-blue-300 font-medium">Web Origins:</span>
                  <div className="bg-black/40 rounded-lg p-2 mt-1 font-mono text-green-300">
                    http://localhost:5173, https://yourdomain.github.io
                  </div>
                </div>
              </div>
            </div>
          </div>

          {/* Environment Variables */}
          <div className="space-y-6">
            <div className="bg-white/10 rounded-2xl p-6 border border-white/10">
              <h3 className="text-xl font-semibold mb-3 text-green-300 flex items-center">
                <span className="mr-2">📝</span>
                Environment Variables
              </h3>
              <p className="text-gray-400 text-sm mb-4">
                Create a <span className="text-yellow-400 font-medium">.env</span> file in your project root:
              </p>
              <div className="bg-black/50 rounded-xl p-4 font-mono text-sm border border-gray-600">
                <div className="text-gray-500"># .env</div>
                <div className="text-green-400">VITE_AUTH0_DOMAIN=your-domain.auth0.com</div>
                <div className="text-green-400">VITE_AUTH0_CLIENT_ID=your-client-id</div>
              </div>
            </div>

            <div className="bg-gradient-to-r from-blue-600/20 to-purple-600/20 rounded-2xl p-6 border border-blue-500/30">
              <h3 className="text-xl font-semibold mb-3 text-white flex items-center">
                <span className="mr-2">💡</span>
                Pro Tips
              </h3>
              <ul className="space-y-2 text-gray-300 text-sm">
                <li className="flex items-start">
                  <span className="text-green-400 mr-2">✓</span>
                  <span>Use Auth0's free tier (up to 7,500 MAUs)</span>
                </li>
                <li className="flex items-start">
                  <span className="text-green-400 mr-2">✓</span>
                  <span>Enable social logins (Google, GitHub, etc.)</span>
                </li>
                <li className="flex items-start">
                  <span className="text-green-400 mr-2">✓</span>
                  <span>Set up multi-factor authentication</span>
                </li>
                <li className="flex items-start">
                  <span className="text-green-400 mr-2">✓</span>
                  <span>Customize your login page branding</span>
                </li>
              </ul>
            </div>

            <div className="text-center">
              <a
                href="https://auth0.com/signup"
                target="_blank"
                rel="noopener noreferrer"
                className="bg-gradient-to-r from-blue-600 to-purple-600 hover:from-blue-700 hover:to-purple-700 text-white font-semibold py-4 px-8 rounded-xl transition-all duration-200 transform hover:scale-105 inline-flex items-center space-x-2 shadow-lg"
              >
                <span>🚀</span>
                <span>Get Started with Auth0</span>
              </a>
            </div>
          </div>
        </div>

        <div className="mt-10 text-center">
          <p className="text-gray-400 text-sm">
            Need help? Check out the <a href="https://auth0.com/docs" className="text-blue-400 underline hover:text-blue-300">Auth0 Documentation</a>
          </p>
        </div>
      </div>
    </div>
  );
};

export default Auth0Setup;
