import React from 'react';
import { useAuth0 } from '@auth0/auth0-react';

const Auth0Header = () => {
  const { logout, user } = useAuth0();

  const handleLogout = () => {
    logout({
      logoutParams: {
        returnTo: window.location.origin
      }
    });
  };

  return (
    <header className="bg-gradient-to-r from-blue-600 to-purple-600 text-white shadow-lg">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex justify-between items-center h-16">
          <div className="flex items-center">
            <h1 className="text-xl font-bold">DSA Practice App</h1>
            <span className="ml-3 px-2 py-1 bg-white/20 rounded-full text-xs">
              🔐 Auth0 Secured
            </span>
          </div>
          
          <div className="flex items-center space-x-4">
            <div className="flex items-center space-x-2">
              {user?.picture && (
                <img 
                  src={user.picture} 
                  alt={user.name || 'User'} 
                  className="w-8 h-8 rounded-full"
                />
              )}
              <span className="text-sm opacity-75">
                Welcome, {user?.name || user?.email || 'User'}!
              </span>
            </div>
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

export default Auth0Header;
