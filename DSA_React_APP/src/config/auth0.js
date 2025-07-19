console.log('VITE ENV:', import.meta.env);
// Auth0 Configuration
// Hardcoded credentials for debugging
const AUTH0_DOMAIN = 'merajmunshi.us.auth0.com'; // <-- Replace with your real Auth0 domain
const AUTH0_CLIENT_ID = 'wetVbccRWFxGMtiWEfAI9XGFZnWRj4Gd';     // <-- Replace with your real Auth0 client ID
const AUTH0_AUDIENCE = '';

// Get the correct redirect URI based on environment
const getRedirectUri = () => {
  if (import.meta.env.DEV) {
    return window.location.origin + '/callback';
  } else {
    return 'https://merajmunshiofficial.github.io/dsamentorai/callback';
  }
};

console.log('AUTH0_DOMAIN (hardcoded):', AUTH0_DOMAIN);
console.log('AUTH0_CLIENT_ID (hardcoded):', AUTH0_CLIENT_ID);

export const auth0Config = {
  domain: AUTH0_DOMAIN,
  clientId: AUTH0_CLIENT_ID,
  authorizationParams: {
    redirect_uri: getRedirectUri(),
    audience: AUTH0_AUDIENCE,
  },
  cacheLocation: 'localstorage',
  useRefreshTokens: true,
};

export const isAuth0Configured = () => {
  const hasValidDomain = AUTH0_DOMAIN && AUTH0_DOMAIN.includes('auth0.com');
  const hasValidClientId = AUTH0_CLIENT_ID && AUTH0_CLIENT_ID.length > 10;
  const isConfigured = hasValidDomain && hasValidClientId;
  return isConfigured;
};

// Auth0 setup instructions:
// 1. Go to https://auth0.com and create a free account
// 2. Create a new application (Single Page Application)
// 3. Configure the application settings in your Auth0 dashboard:
//    - Set Allowed Callback URLs for your development and production environments
//    - Set Allowed Logout URLs for your development and production environments
//    - Set Allowed Web Origins for your development and production environments
// 4. Copy your Domain and Client ID to the .env file
// 5. Set VITE_PROD_CALLBACK_URL in your production environment
// 6. Create an API and set the audience for additional security (recommended)

// End of Auth0 configuration
