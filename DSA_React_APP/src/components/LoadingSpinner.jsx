import React from 'react';

export default function LoadingSpinner() {
  return (
    <div className="min-h-screen flex items-center justify-center bg-base-200">
      <div className="text-center">
        <span className="loading loading-spinner loading-lg text-primary"></span>
        <h2 className="text-2xl font-bold text-base-content mt-4">DSA Mentor</h2>
        <p className="text-base-content/70">Setting up your learning environment...</p>
      </div>
    </div>
  );
}
