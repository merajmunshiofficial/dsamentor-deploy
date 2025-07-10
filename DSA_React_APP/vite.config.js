import { defineConfig, loadEnv } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default ({ mode }) => {
  // Load environment variables based on mode
  const env = loadEnv(mode, process.cwd(), '')
  // Merge into process.env so import.meta.env picks them up
  process.env = { ...process.env, ...env }

  return defineConfig({
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
  })
}
