import React from 'react';

const LoadingSpinner = () => {
  return (
    <div className="min-h-screen bg-gradient-to-br from-indigo-900 via-blue-900 to-purple-900 flex items-center justify-center relative overflow-hidden">
      {/* Animated Background */}
      <div className="absolute inset-0">
        <div className="absolute top-1/4 left-1/4 w-64 h-64 bg-cyan-500/10 rounded-full blur-3xl animate-pulse"></div>
        <div className="absolute bottom-1/4 right-1/4 w-96 h-96 bg-purple-500/10 rounded-full blur-3xl animate-pulse delay-700"></div>
      </div>
      
      <div className="relative z-10 text-white text-center">
        <div className="relative mb-8">
          <div className="w-24 h-24 bg-gradient-to-r from-cyan-400 to-blue-500 rounded-2xl flex items-center justify-center mx-auto shadow-2xl">
            <span className="text-3xl">💡</span>
          </div>
          <div className="absolute inset-0 w-24 h-24 border-4 border-cyan-400/30 rounded-2xl animate-spin mx-auto"></div>
          <div className="absolute inset-2 w-20 h-20 border-2 border-blue-500/50 rounded-xl animate-spin mx-auto" style={{animationDirection: 'reverse', animationDuration: '3s'}}></div>
        </div>
        
        <h2 className="text-3xl font-bold mb-2 bg-gradient-to-r from-cyan-400 to-blue-400 bg-clip-text text-transparent">
          DSA Mentor
        </h2>
        <p className="text-xl text-gray-300 mb-6">Setting up your learning environment...</p>
        
        <div className="flex items-center justify-center space-x-3 mb-6">
          <div className="w-3 h-3 bg-cyan-400 rounded-full animate-bounce"></div>
          <div className="w-3 h-3 bg-blue-500 rounded-full animate-bounce" style={{animationDelay: '0.1s'}}></div>
          <div className="w-3 h-3 bg-purple-500 rounded-full animate-bounce" style={{animationDelay: '0.2s'}}></div>
        </div>
        
        <div className="bg-white/10 backdrop-blur-xl rounded-2xl p-6 border border-white/20 max-w-md mx-auto">
          <p className="text-gray-300 text-sm">Preparing your interactive DSA learning experience</p>
        </div>
      </div>
    </div>
  );
};

export default LoadingSpinner;
