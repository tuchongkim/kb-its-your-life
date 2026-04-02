import { fileURLToPath, URL } from 'node:url';

import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import vueDevTools from 'vite-plugin-vue-devtools';

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue(), vueDevTools()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
  server: {
    //개발할 때만 적용
    proxy: {
      '/api': {
        target: 'http://localhost:3000', //실제서버
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, ''),
        //정규표현식 리터럴: / /
        //^: 시작을 나타냄
        //\: escape문자
        //결국 '/api'로 시작하는 문자열이 있다면, '/api'를 지우겠다
      },
    },
  },
});
