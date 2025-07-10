// Auth0 Configuration
// You'll need to create an Auth0 account and app to get these values

// Debug environment variables
console.log('🔍 Environment check:', {
  isDev: import.meta.env.DEV,
  mode: import.meta.env.MODE,
  auth0Domain: import.meta.env.VITE_AUTH0_DOMAIN,
  auth0ClientId: import.meta.env.VITE_AUTH0_CLIENT_ID,
  allEnv: import.meta.env
});

// For now, let's hardcode the production values to test if that works
// In production these should come from GitHub secrets via environment variables
const AUTH0_DOMAIN = import.meta.env.VITE_AUTH0_DOMAIN || 
  (import.meta.env.PROD ? 'merajmunshi.us.auth0.com' : 'merajmunshi.us.auth0.com');

const AUTH0_CLIENT_ID = import.meta.env.VITE_AUTH0_CLIENT_ID || 
  (import.meta.env.PROD ? 'wetVbccRWFxGMtiWEfAI9XGFZnWRj4Gd' : 'wetVbccRWFxGMtiWEfAI9XGFZnWRj4Gd');

const AUTH0_AUDIENCE = import.meta.env.VITE_AUTH0_AUDIENCE || '';

console.log('🔧 Final Auth0 config values:', {
  domain: AUTH0_DOMAIN,
  clientId: AUTH0_CLIENT_ID,
  audience: AUTH0_AUDIENCE
});

// Get the correct redirect URI based on environment
const getRedirectUri = () => {
  if (import.meta.env.DEV) {
    // Development - use current localhost without base path
    return window.location.origin + '/';
  } else {
    // Production - use the full GitHub Pages URL
    return window.location.origin + '/';
  }
};

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

// Check if Auth0 is properly configured
export const isAuth0Configured = () => {
  // Debug information
  console.log('Auth0 Debug Info:', {
    domain: AUTH0_DOMAIN,
    clientId: AUTH0_CLIENT_ID,
    env: import.meta.env.MODE,
    isDev: import.meta.env.DEV
  });
  
  const hasValidDomain = AUTH0_DOMAIN && 
                         AUTH0_DOMAIN !== 'undefined' &&
                         AUTH0_DOMAIN !== 'your-auth0-domain.auth0.com' && 
                         AUTH0_DOMAIN !== 'dev-example.auth0.com';
  
  const hasValidClientId = AUTH0_CLIENT_ID && 
                          AUTH0_CLIENT_ID !== 'undefined' &&
                          AUTH0_CLIENT_ID !== 'your-auth0-client-id' &&
                          AUTH0_CLIENT_ID !== 'test-client-id';
  
  const isConfigured = hasValidDomain && hasValidClientId;
  console.log('Auth0 Configuration Check:', { hasValidDomain, hasValidClientId, isConfigured });
  
  return isConfigured;
};

// Auth0 setup instructions:
// 1. Go to https://auth0.com and create a free account
// 2. Create a new application (Single Page Application)
// 3. Configure the application settings:
//    - Allowed Callback URLs: http://localhost:5173/, http://localhost:5174/, https://merajmunshiofficial.github.io/dsamentor-deploy/
//    - Allowed Logout URLs: http://localhost:5173/, http://localhost:5174/, https://merajmunshiofficial.github.io/dsamentor-deploy/
//    - Allowed Web Origins: http://localhost:5173, http://localhost:5174, https://merajmunshiofficial.github.io/dsamentor-deploy
// 4. Copy your Domain and Client ID to the .env file
// 5. Optionally create an API for additional security (recommended)

console.log('🔍 Full import.meta.env:', import.meta.env);
