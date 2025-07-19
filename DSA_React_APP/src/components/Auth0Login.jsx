import React from 'react';
import { useAuth0 } from '@auth0/auth0-react';

const Auth0Login = () => {
  const { loginWithRedirect, isLoading, isAuthenticated, logout, user } = useAuth0();
  
  const handleLogout = () => {
    logout({ logoutParams: { returnTo: window.location.origin } });
  };

  if (isAuthenticated) {
    return (
      <div className="min-h-screen flex items-center justify-center bg-base-200">
        <div className="card w-96 bg-base-100 shadow-xl">
          <div className="card-body">
            <h2 className="card-title">Welcome!</h2>
            <p>You are logged in as {user?.name || user?.email}</p>
            <div className="card-actions justify-end">
              <button className="btn btn-primary" onClick={handleLogout}>Logout</button>
            </div>
          </div>
        </div>
      </div>
    );
  }

  return (
    <div className="min-h-screen flex items-center justify-center bg-gradient-to-br from-slate-900 via-purple-900 to-slate-900">
      <div className="card w-96 bg-base-100 shadow-2xl border border-base-300">
        <div className="card-body text-center">
          <div className="mb-6">
            <div className="w-20 h-20 mx-auto mb-4 bg-gradient-to-r from-purple-500 to-pink-500 rounded-full flex items-center justify-center">
              <svg className="w-10 h-10 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M9 19v-6a2 2 0 00-2-2H5a2 2 0 00-2 2v6a2 2 0 002 2h2a2 2 0 002-2zm0 0V9a2 2 0 012-2h2a2 2 0 012 2v10m-6 0a2 2 0 002 2h2a2 2 0 002-2m0 0V5a2 2 0 012-2h2a2 2 0 012 2v14a2 2 0 01-2 2h-2a2 2 0 01-2-2z" />
              </svg>
            </div>
            <h2 className="text-3xl font-bold bg-gradient-to-r from-purple-600 to-pink-600 bg-clip-text text-transparent">DSA Mentor</h2>
            <p className="text-base-content/60 mt-2">Master data structures & algorithms</p>
          </div>
          
          <div className="space-y-4">
            <div className="text-sm text-base-content/70">
              <p>Join thousands of developers sharpening their skills</p>
            </div>
            
            <button 
              onClick={loginWithRedirect}
              disabled={isLoading}
              className="btn btn-primary w-full bg-gradient-to-r from-purple-600 to-pink-600 hover:from-purple-700 hover:to-pink-700 border-none text-white font-semibold"
            >
              {isLoading ? (
                <>
                  <span className="loading loading-spinner loading-sm"></span>
                  Connecting...
                </>
              ) : (
                'Get Started'
              )}
            </button>
            
            <p className="text-xs text-base-content/50">
              No account? Sign up during login
            </p>
          </div>
        </div>
      </div>
    </div>
  );

};

export default Auth0Login;
