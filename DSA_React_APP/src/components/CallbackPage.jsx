import React, { useEffect } from 'react';
import { useAuth0 } from '@auth0/auth0-react';

const CallbackPage = () => {
  const { handleRedirectCallback, isLoading, error } = useAuth0();

  useEffect(() => {
    const handleCallback = async () => {
      try {
        await handleRedirectCallback();
        // Redirect to main app after successful authentication
        const basePath = import.meta.env.PROD ? '/dsamentor-deploy' : '';
        window.location.href = basePath + '/';
      } catch (err) {
        console.error('Auth0 callback error:', err);
      }
    };

    // Only handle callback if we have the code parameter
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.get('code')) {
      handleCallback();
    }
  }, [handleRedirectCallback]);

  if (isLoading) {
    return (
      <div style={{ 
        display: 'flex', 
        justifyContent: 'center', 
        alignItems: 'center', 
        height: '100vh',
        flexDirection: 'column'
      }}>
        <h2>Processing authentication...</h2>
        <div>Please wait while we log you in.</div>
      </div>
    );
  }

  if (error) {
    return (
      <div style={{ 
        display: 'flex', 
        justifyContent: 'center', 
        alignItems: 'center', 
        height: '100vh',
        flexDirection: 'column'
      }}>
        <h2>Authentication Error</h2>
        <p>{error.message}</p>
        <button onClick={() => {
          const basePath = import.meta.env.PROD ? '/dsamentor-deploy' : '';
          window.location.href = basePath + '/';
        }}>
          Return to Home
        </button>
      </div>
    );
  }

  return (
    <div style={{ 
      display: 'flex', 
      justifyContent: 'center', 
      alignItems: 'center', 
      height: '100vh'
    }}>
      <h2>Redirecting...</h2>
    </div>
  );
};

export default CallbackPage;
