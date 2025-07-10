import React from 'react';
import { useAuth0 } from '@auth0/auth0-react';

const Auth0Login = () => {
  const { loginWithRedirect, isLoading } = useAuth0();

  const handleLogin = () => {
    loginWithRedirect();
  };

  return (
    <div className="min-h-screen bg-gradient-to-br from-blue-900 via-purple-900 to-indigo-900 flex items-center justify-center p-4">
      <div className="max-w-md w-full bg-white/10 backdrop-blur-md rounded-2xl shadow-2xl p-8 border border-white/20">
        <div className="text-center mb-8">
          <h1 className="text-3xl font-bold text-white mb-2">DSA Practice App</h1>
          <p className="text-gray-300">Secure Authentication with Auth0</p>
        </div>

        <div className="space-y-6">
          <div className="text-center">
            <div className="bg-white/10 rounded-lg p-6 mb-6">
              <div className="text-4xl mb-4">🔐</div>
              <h2 className="text-xl font-semibold text-white mb-2">Enterprise Security</h2>
              <p className="text-gray-300 text-sm">
                Your app is protected with Auth0's enterprise-grade security
              </p>
            </div>

            <button
              onClick={handleLogin}
              disabled={isLoading}
              className="w-full bg-gradient-to-r from-blue-600 to-purple-600 hover:from-blue-700 hover:to-purple-700 disabled:opacity-50 disabled:cursor-not-allowed text-white font-semibold py-3 px-6 rounded-lg transition-all duration-200 transform hover:scale-105"
            >
              {isLoading ? (
                <div className="flex items-center justify-center">
                  <div className="animate-spin rounded-full h-5 w-5 border-b-2 border-white mr-2"></div>
                  Loading...
                </div>
              ) : (
                'Sign In with Auth0'
              )}
            </button>
          </div>

          <div className="text-center text-gray-400 text-sm space-y-2">
            <p>✅ Multi-factor authentication</p>
            <p>✅ Social login options</p>
            <p>✅ Enterprise-grade security</p>
            <p>✅ No passwords stored locally</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Auth0Login;
