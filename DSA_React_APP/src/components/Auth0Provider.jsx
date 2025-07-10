import React from 'react';
import { Auth0Provider } from '@auth0/auth0-react';
import { auth0Config } from '../config/auth0';

const Auth0ProviderWithHistory = ({ children }) => {
  const onRedirectCallback = (appState) => {
    // Handle the redirect after authentication
    window.history.replaceState(
      {},
      document.title,
      appState?.returnTo || window.location.pathname
    );
  };

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
