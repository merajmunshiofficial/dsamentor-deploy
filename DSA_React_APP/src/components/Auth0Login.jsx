import React from 'react';
import { useAuth0 } from '@auth0/auth0-react';

const Auth0Login = () => {
  const { loginWithRedirect, isLoading } = useAuth0();

  const handleLogin = () => {
    loginWithRedirect();
  };

  return (
    <div className="min-h-screen bg-gradient-to-br from-indigo-900 via-blue-900 to-purple-900 relative overflow-hidden">
      {/* Animated Background Elements */}
      <div className="absolute inset-0">
        <div className="absolute top-1/4 left-1/4 w-64 h-64 bg-blue-500/10 rounded-full blur-3xl animate-pulse"></div>
        <div className="absolute bottom-1/4 right-1/4 w-96 h-96 bg-purple-500/10 rounded-full blur-3xl animate-pulse delay-700"></div>
        <div className="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 w-80 h-80 bg-cyan-500/10 rounded-full blur-3xl animate-pulse delay-1000"></div>
      </div>

      <div className="relative z-10 min-h-screen flex items-center justify-center p-4">
        <div className="max-w-7xl w-full grid lg:grid-cols-2 gap-12 items-center">
          
          {/* Left Side - Hero Section */}
          <div className="text-white space-y-8 lg:pr-8">
            <div className="space-y-6">
              <div className="flex items-center space-x-4">
                <div className="relative">
                  <div className="w-16 h-16 bg-gradient-to-r from-cyan-400 to-blue-500 rounded-2xl flex items-center justify-center transform rotate-3 shadow-2xl">
                    <span className="text-3xl">💡</span>
                  </div>
                  <div className="absolute -top-1 -right-1 w-6 h-6 bg-gradient-to-r from-pink-400 to-red-500 rounded-full animate-bounce"></div>
                </div>
                <div>
                  <h1 className="text-5xl lg:text-6xl font-bold bg-gradient-to-r from-cyan-400 via-blue-500 to-purple-500 bg-clip-text text-transparent">
                    DSA Mentor
                  </h1>
                  <div className="flex items-center space-x-2 mt-2">
                    <div className="w-2 h-2 bg-green-400 rounded-full animate-pulse"></div>
                    <span className="text-green-400 text-sm font-medium">Interactive Learning Platform</span>
                  </div>
                </div>
              </div>
              
              <p className="text-2xl lg:text-3xl text-gray-300 font-light leading-relaxed">
                Transform your coding skills with 
                <span className="font-semibold bg-gradient-to-r from-yellow-400 to-orange-500 bg-clip-text text-transparent"> hands-on practice</span> and 
                <span className="font-semibold bg-gradient-to-r from-green-400 to-blue-500 bg-clip-text text-transparent"> real-time execution</span>
              </p>
            </div>

            {/* Features Grid */}
            <div className="grid md:grid-cols-2 gap-4">
              <div className="bg-white/5 backdrop-blur-xl rounded-2xl p-4 border border-white/10 hover:bg-white/10 transition-all duration-300 transform hover:scale-105">
                <div className="flex items-center space-x-3">
                  <div className="w-10 h-10 bg-gradient-to-r from-green-400 to-blue-500 rounded-xl flex items-center justify-center">
                    <span className="text-lg">📚</span>
                  </div>
                  <div>
                    <h3 className="font-semibold text-white">18+ Topics</h3>
                    <p className="text-gray-400 text-sm">Comprehensive coverage</p>
                  </div>
                </div>
              </div>

              <div className="bg-white/5 backdrop-blur-xl rounded-2xl p-4 border border-white/10 hover:bg-white/10 transition-all duration-300 transform hover:scale-105">
                <div className="flex items-center space-x-3">
                  <div className="w-10 h-10 bg-gradient-to-r from-purple-400 to-pink-500 rounded-xl flex items-center justify-center">
                    <span className="text-lg">⚡</span>
                  </div>
                  <div>
                    <h3 className="font-semibold text-white">Live Execution</h3>
                    <p className="text-gray-400 text-sm">Test instantly</p>
                  </div>
                </div>
              </div>

              <div className="bg-white/5 backdrop-blur-xl rounded-2xl p-4 border border-white/10 hover:bg-white/10 transition-all duration-300 transform hover:scale-105">
                <div className="flex items-center space-x-3">
                  <div className="w-10 h-10 bg-gradient-to-r from-orange-400 to-red-500 rounded-xl flex items-center justify-center">
                    <span className="text-lg">🎯</span>
                  </div>
                  <div>
                    <h3 className="font-semibold text-white">Smart Progress</h3>
                    <p className="text-gray-400 text-sm">Track your journey</p>
                  </div>
                </div>
              </div>

              <div className="bg-white/5 backdrop-blur-xl rounded-2xl p-4 border border-white/10 hover:bg-white/10 transition-all duration-300 transform hover:scale-105">
                <div className="flex items-center space-x-3">
                  <div className="w-10 h-10 bg-gradient-to-r from-cyan-400 to-blue-500 rounded-xl flex items-center justify-center">
                    <span className="text-lg">🔧</span>
                  </div>
                  <div>
                    <h3 className="font-semibold text-white">Interactive UI</h3>
                    <p className="text-gray-400 text-sm">Modern experience</p>
                  </div>
                </div>
              </div>
            </div>

            {/* Statistics */}
            <div className="flex flex-wrap gap-8 pt-4">
              <div className="text-center">
                <div className="text-3xl font-bold bg-gradient-to-r from-cyan-400 to-blue-500 bg-clip-text text-transparent">18+</div>
                <div className="text-gray-400 text-sm">DSA Topics</div>
              </div>
              <div className="text-center">
                <div className="text-3xl font-bold bg-gradient-to-r from-green-400 to-blue-500 bg-clip-text text-transparent">200+</div>
                <div className="text-gray-400 text-sm">Practice Problems</div>
              </div>
              <div className="text-center">
                <div className="text-3xl font-bold bg-gradient-to-r from-purple-400 to-pink-500 bg-clip-text text-transparent">100%</div>
                <div className="text-gray-400 text-sm">Interactive</div>
              </div>
            </div>
          </div>

          {/* Right Side - Login Card */}
          <div className="flex justify-center lg:justify-end">
            <div className="w-full max-w-md">
              <div className="bg-white/10 backdrop-blur-2xl rounded-3xl p-8 border border-white/20 shadow-2xl">
                <div className="text-center space-y-6">
                  <div className="space-y-2">
                    <h2 className="text-3xl font-bold text-white">Welcome Back!</h2>
                    <p className="text-gray-300">Ready to level up your coding skills?</p>
                  </div>

                  <div className="space-y-4">
                    <button
                      onClick={handleLogin}
                      disabled={isLoading}
                      className="w-full bg-gradient-to-r from-cyan-500 to-blue-600 hover:from-cyan-600 hover:to-blue-700 text-white font-semibold py-4 px-8 rounded-2xl transition-all duration-300 transform hover:scale-105 hover:shadow-xl disabled:opacity-50 disabled:cursor-not-allowed flex items-center justify-center space-x-3"
                    >
                      {isLoading ? (
                        <>
                          <div className="w-5 h-5 border-2 border-white/30 border-t-white rounded-full animate-spin"></div>
                          <span>Signing you in...</span>
                        </>
                      ) : (
                        <>
                          <span>🚀</span>
                          <span>Start Learning Now</span>
                        </>
                      )}
                    </button>

                    <div className="text-center">
                      <p className="text-gray-400 text-sm">
                        Join thousands of developers mastering DSA
                      </p>
                    </div>
                  </div>

                  {/* Features Preview */}
                  <div className="space-y-3 pt-4 border-t border-white/10">
                    <h3 className="text-white font-medium">What's Inside:</h3>
                    <div className="space-y-2 text-sm text-gray-300">
                      <div className="flex items-center space-x-2">
                        <span className="text-green-400">✓</span>
                        <span>Arrays, Strings, Linked Lists</span>
                      </div>
                      <div className="flex items-center space-x-2">
                        <span className="text-green-400">✓</span>
                        <span>Trees, Graphs, Dynamic Programming</span>
                      </div>
                      <div className="flex items-center space-x-2">
                        <span className="text-green-400">✓</span>
                        <span>Binary Search, Sorting, Recursion</span>
                      </div>
                      <div className="flex items-center space-x-2">
                        <span className="text-green-400">✓</span>
                        <span>Heaps, Hashing, Bit Manipulation</span>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Auth0Login;
