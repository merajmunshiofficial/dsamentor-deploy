import React from 'react';

const EnvDebugger = () => {
  return (
    <div style={{ padding: '20px', border: '1px solid red', margin: '20px' }}>
      <h3>Environment Variables Debug</h3>
      <pre>{JSON.stringify(import.meta.env, null, 2)}</pre>
      <p>VITE_AUTH0_DOMAIN: {import.meta.env.VITE_AUTH0_DOMAIN}</p>
      <p>VITE_AUTH0_CLIENT_ID: {import.meta.env.VITE_AUTH0_CLIENT_ID}</p>
      <p>MODE: {import.meta.env.MODE}</p>
      <p>DEV: {import.meta.env.DEV}</p>
      <p>PROD: {import.meta.env.PROD}</p>
    </div>
  );
};

export default EnvDebugger;
