import { createApp } from 'vue';
import App from './App.vue';
import CheckboxItem from './components/CheckboxItem.vue';
import App2 from './App2.vue';
import App4 from './App4.vue';

// 전역 컴포넌트
// createApp(App).component('CheckboxItem', CheckboxItem).mount('#app');

// 1. v-for 개별 props
// createApp(App).mount('#app');

// 2. v-for 객체 props
// createApp(App2).mount('#app');

// 3. 이벤트 처리
createApp(App4).mount('#app');
