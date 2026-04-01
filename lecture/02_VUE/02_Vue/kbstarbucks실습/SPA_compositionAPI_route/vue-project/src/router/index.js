//라우팅 테이블을 등록
//path에 component를 연결하는 역할
import Product from '@/pages/Product.vue';
import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL), //히스토리 조작을 위한
  routes: [
    {
      path: '/product',
      component: Product,
    },
  ],
});

export default router;
