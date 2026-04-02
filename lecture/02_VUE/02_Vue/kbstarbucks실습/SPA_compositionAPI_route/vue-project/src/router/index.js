//라우팅 테이블을 등록
//path에 component를 연결하는 역할
import Home from '@/pages/Home.vue';
import NotFound from '@/pages/NotFound.vue';
import Product from '@/pages/Product.vue';
import ProductInfo from '@/pages/ProductInfo.vue';
import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL), //히스토리 조작을 위한
  routes: [
    {
      path: '/',
      component: Home,
    },
    // {
    //   path: '/product',
    //   component: Product,
    // },

    //명명된 라우트
    // { name: 'Product', path: '/product', component: Product },

    //중첩 라우트
    {
      name: 'Product',
      path: '/product',
      component: Product,
      children: [
        {
          name: 'ProductInfo',
          path: '/product/:prodNo',
          component: ProductInfo,
        },
      ],
    },

    {
      /*
      동적 파라미터 /:파라미터이름
        /:paths
      정규표현식
        (.*) 모든 문자
          * 여러 단계의 경로를 허용한다
      ex) /aaa
          /a/b
          /a/b/c
      */
      path: '/:paths(.*)*',
      component: NotFound,
    },
  ],
});

export default router;
