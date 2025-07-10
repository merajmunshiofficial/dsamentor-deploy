import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import dotenv from 'dotenv'

// Load environment variables from .env.production explicitly in production
if (process.env.NODE_ENV === 'production') {
  dotenv.config({ path: '.env.production' })
}

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  // Only use base path in production for GitHub Pages
  base: process.env.NODE_ENV === 'production' ? '/dsamentor-deploy/' : '/',
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
})
