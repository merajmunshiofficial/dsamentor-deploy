import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

// https://vite.dev/config/
export default defineConfig(({ mode }) => ({
  plugins: [react()],
  // Only use base path in production for GitHub Pages
  base: mode === 'production' ? '/dsamentor-deploy/' : '/',
  build: {
    // Disable minification temporarily for debugging
    minify: false,
  },
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
      },
    },
  },
}));
