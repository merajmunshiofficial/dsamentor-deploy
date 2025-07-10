// Auth0 Configuration
// You'll need to create an Auth0 account and app to get these values

const domain = import.meta.env.VITE_AUTH0_DOMAIN;
const clientId = import.meta.env.VITE_AUTH0_CLIENT_ID;

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
  domain: domain || 'your-auth0-domain.auth0.com',
  clientId: clientId || 'your-auth0-client-id',
  authorizationParams: {
    redirect_uri: getRedirectUri(),
    audience: import.meta.env.VITE_AUTH0_AUDIENCE,
  },
  cacheLocation: 'localstorage',
  useRefreshTokens: true,
};

// Check if Auth0 is properly configured
export const isAuth0Configured = () => {
  return domain && clientId && 
         domain !== 'your-auth0-domain.auth0.com' && 
         clientId !== 'your-auth0-client-id' &&
         domain !== 'dev-example.auth0.com' &&
         clientId !== 'test-client-id';
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
