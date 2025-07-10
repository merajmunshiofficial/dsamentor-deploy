import React from 'react';
import { useAuth } from '../contexts/AuthContext';

const Header = () => {
  const { logout } = useAuth();

  const handleLogout = () => {
    if (window.confirm('Are you sure you want to logout?')) {
      logout();
    }
  };

  return (
    <header className="bg-gradient-to-r from-blue-600 to-purple-600 text-white shadow-lg">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex justify-between items-center h-16">
          <div className="flex items-center">
            <h1 className="text-xl font-bold">DSA Practice App</h1>
            <span className="ml-3 px-2 py-1 bg-white/20 rounded-full text-xs">Private</span>
          </div>
          
          <div className="flex items-center space-x-4">
            <span className="text-sm opacity-75">Welcome back!</span>
            <button
              onClick={handleLogout}
              className="bg-white/20 hover:bg-white/30 px-4 py-2 rounded-lg text-sm font-medium transition-colors"
            >
              Logout
            </button>
          </div>
        </div>
      </div>
    </header>
  );
};

export default Header;
