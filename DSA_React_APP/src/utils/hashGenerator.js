// Password Hash Generator
// Run this in your browser console to generate a hash for your password

import { generateHash } from '../config/auth.js';

// Instructions:
// 1. Open your browser console (F12)
// 2. Import this function
// 3. Run: await generatePasswordHash('your-password-here')
// 4. Copy the generated hash to auth.js

export const generatePasswordHash = async (password) => {
  if (!password) {
    console.log('Please provide a password: generatePasswordHash("your-password")');
    return;
  }
  
  const hash = await generateHash(password);
  console.log('=================================');
  console.log('PASSWORD HASH GENERATOR');
  console.log('=================================');
  console.log('Your password:', password);
  console.log('Generated hash:', hash);
  console.log('=================================');
  console.log('Copy this hash to src/config/auth.js');
  console.log('Replace PASSWORD_HASH with:', hash);
  console.log('=================================');
  
  return hash;
};

// Quick test function
export const testPassword = async (password) => {
  const { verifyPassword } = await import('../config/auth.js');
  const isValid = await verifyPassword(password);
  console.log('Password valid:', isValid);
  return isValid;
};

// Make it available globally for console use
window.generatePasswordHash = generatePasswordHash;
window.testPassword = testPassword;
