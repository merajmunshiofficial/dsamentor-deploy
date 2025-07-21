import React from 'react';
import { useAuth0 } from '@auth0/auth0-react';

export default function ModernDaisyNavbar({ onApiKeyClick, onSearch }) {
  const { user, isAuthenticated, loginWithRedirect, logout } = useAuth0();

  const handleLogout = () => {
    logout({ returnTo: window.location.origin });
  };

  const handleSearch = (e) => {
    if (e.key === 'Enter' && onSearch) {
      onSearch(e.target.value);
    }
  };

  if (!isAuthenticated) {
    return null;
  }

  return (
    <div className="navbar bg-base-100 shadow-lg w-full">
      <div className="navbar-start">
        <div className="dropdown">
          <label tabIndex={0} className="btn btn-ghost lg:hidden">
            <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 6h16M4 12h8m-8 6h16" />
            </svg>
          </label>
          <ul tabIndex={0} className="menu menu-sm dropdown-content mt-3 z-[1] p-2 shadow bg-base-100 rounded-box w-52">
            <li><a>Home</a></li>
            <li><a>Problems</a></li>
            <li><a>About</a></li>
          </ul>
        </div>
        <a className="btn btn-ghost normal-case text-xl">DSA Mentor</a>
      </div>
      <div className="navbar-center hidden lg:flex">
        <ul className="menu menu-horizontal px-1">
          <li><a>Home</a></li>
          <li><a>Problems</a></li>
          <li><a>About</a></li>
        </ul>
      </div>
      <div className="navbar-end flex items-center gap-2">
        <div className="form-control">
          <input
            type="text"
            placeholder="Search"
            className="input input-bordered input-sm w-24 md:w-auto"
            onKeyPress={handleSearch}
          />
        </div>
        <button
          className="btn btn-primary btn-sm"
          onClick={onApiKeyClick}
          aria-label="Open OpenAI API Key Modal"
        >
          API Key
        </button>
        <div className="dropdown dropdown-end">
          <label tabIndex={0} className="btn btn-ghost btn-circle avatar">
            <div className="w-10 rounded-full">
              <img src={user?.picture || "https://daisyui.com/images/stock/photo-1534528741775-53994a69daeb.jpg"} alt="Profile" />
            </div>
          </label>
          <ul tabIndex={0} className="mt-3 z-[1] p-2 shadow menu menu-sm dropdown-content bg-base-100 rounded-box w-52">
            <li>
              <a className="justify-between">
                {user?.name || 'Profile'}
                <span className="badge">New</span>
              </a>
            </li>
            <li><a>Settings</a></li>
            <li><a onClick={handleLogout}>Logout</a></li>
          </ul>
        </div>
      </div>
    </div>
  );
}
