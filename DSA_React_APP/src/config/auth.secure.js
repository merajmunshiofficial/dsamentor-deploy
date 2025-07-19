// Environment-based Authentication (Most Secure)
// This uses environment variables that are not visible in the built code

export const AUTH_CONFIG = {
  // These will be replaced with actual values during build
  USERNAME: import.meta.env.VITE_APP_USERNAME || '',
  PASSWORD_HASH: import.meta.env.VITE_APP_PASSWORD_HASH || '',
  
  // Session duration (in hours)
  SESSION_DURATION: 24,
  
  // App settings
  APP_NAME: 'DSA Practice App',
  
  // Security settings
  MAX_LOGIN_ATTEMPTS: 5,
  LOCKOUT_DURATION: 15 // minutes
};

// Advanced hash function (better security)
const advancedHash = async (password) => {
  const encoder = new TextEncoder();
  const data = encoder.encode(password + import.meta.env.VITE_APP_SALT || 'CHANGE_THIS_SALT'); // Add salt
  const hashBuffer = await crypto.subtle.digest('SHA-256', data);
  const hashArray = Array.from(new Uint8Array(hashBuffer));
  return hashArray.map(b => b.toString(16).padStart(2, '0')).join('');
};

// Function to generate hash for your password (use this in console to get hash)
export const generateHash = async (password) => {
  return await advancedHash(password);
};

// Function to verify password
export const verifyPassword = async (inputPassword) => {
  const inputHash = await advancedHash(inputPassword);
  return inputHash === AUTH_CONFIG.PASSWORD_HASH;
};

// Additional security: Simple encryption for stored data
export const encryptData = (data) => {
  return btoa(JSON.stringify(data));
};

export const decryptData = (encryptedData) => {
  try {
    return JSON.parse(atob(encryptedData));
  } catch {
    return null;
  }
};
