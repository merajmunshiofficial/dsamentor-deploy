import React from 'react';
import { Auth0Provider } from '@auth0/auth0-react';
import { auth0Config, isAuth0Configured } from '../config/auth0';

const Auth0ProviderWithHistory = ({ children }) => {
  const onRedirectCallback = (appState) => {
    // Handle the redirect after authentication
    window.history.replaceState(
      {},
      document.title,
      appState?.returnTo || window.location.pathname
    );
  };

  if (!isAuth0Configured()) {
    return (
      <div style={{
        minHeight: '100vh',
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center',
        background: 'linear-gradient(135deg, #1e293b, #7c3aed)',
        color: '#fff',
        padding: '2rem'
      }}>
        <h2 style={{ fontSize: '2rem', marginBottom: '1rem' }}>Auth0 Not Configured</h2>
        <p style={{ maxWidth: 500, textAlign: 'center', marginBottom: '1.5rem' }}>
          Your Auth0 credentials are missing or invalid.<br/>
          Please set <code>VITE_AUTH0_DOMAIN</code> and <code>VITE_AUTH0_CLIENT_ID</code> in your <code>.env</code> file.<br/>
          See <b>.env.example</b> for the required keys.
        </p>
        <pre style={{ background: '#22223b', color: '#fbbf24', padding: '1rem', borderRadius: 8 }}>
VITE_AUTH0_DOMAIN=your-tenant.auth0.com
VITE_AUTH0_CLIENT_ID=your-client-id
VITE_AUTH0_AUDIENCE=your-api-audience # (optional)
VITE_PROD_CALLBACK_URL=https://merajmunshiofficial.github.io/dsamentorai/callback
        </pre>
      </div>
    );
  }

  return (
    <Auth0Provider
      domain={auth0Config.domain}
      clientId={auth0Config.clientId}
      authorizationParams={auth0Config.authorizationParams}
      onRedirectCallback={onRedirectCallback}
      cacheLocation={auth0Config.cacheLocation}
      useRefreshTokens={auth0Config.useRefreshTokens}
    >
      {children}
    </Auth0Provider>
  );
};

export default Auth0ProviderWithHistory;
