import './assets/main.css';

//npm install bootstrap으로 부트스트랩모듈을 설치하세요!

//전역으로 사용될 스타일과 JS는 main.js에 설정합니다
// 전역 CSS 설정 (ex : 부트스트랩 스타일)
import 'bootstrap/dist/css/bootstrap.min.css';

//전역 JS 설정 ( ex: 햄버거메뉴 버튼 클릭했을 때 메뉴들이 수직으로 보이는 기능)
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import { createApp } from 'vue';
import App from './App.vue';

createApp(App).mount('#app');
