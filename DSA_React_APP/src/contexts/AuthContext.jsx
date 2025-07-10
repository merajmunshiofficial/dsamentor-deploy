import React, { createContext, useContext, useState, useEffect } from 'react';
import { decryptData } from '../config/auth';

const AuthContext = createContext();

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error('useAuth must be used within an AuthProvider');
  }
  return context;
};

export const AuthProvider = ({ children }) => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    checkAuthStatus();
  }, []);

  const checkAuthStatus = () => {
    try {
      const authData = localStorage.getItem('dsa_auth');
      if (authData) {
        const parsed = decryptData(authData);
        if (parsed) {
          const now = Date.now();
          
          // Check if authentication is still valid (not expired)
          if (parsed.authenticated && parsed.expiry > now) {
            setIsAuthenticated(true);
          } else {
            // Clear expired authentication
            localStorage.removeItem('dsa_auth');
            setIsAuthenticated(false);
          }
        } else {
          // Clear invalid authentication data
          localStorage.removeItem('dsa_auth');
          setIsAuthenticated(false);
        }
      }
    } catch (error) {
      console.error('Auth check failed:', error);
      localStorage.removeItem('dsa_auth');
      setIsAuthenticated(false);
    } finally {
      setLoading(false);
    }
  };

  const login = (success) => {
    setIsAuthenticated(success);
  };

  const logout = () => {
    localStorage.removeItem('dsa_auth');
    setIsAuthenticated(false);
  };

  const value = {
    isAuthenticated,
    login,
    logout,
    loading
  };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};
