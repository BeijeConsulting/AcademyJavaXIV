import { fileURLToPath, URL } from 'url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  build: {
    rollupOptions: {
      external: [
        /^node:.*/,
      ]
    }
  },
  server: {
    proxy: {
      "/ws": {
        target: "http://localhost:8080/",
        changeOrigin: true,
        secure: false,
        ws: true
      },
    },
  },
  plugins: [vue({
    reactivityTransform: true
  })],

  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },

  base: './',
})
