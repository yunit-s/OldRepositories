// 초기 코드
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// createApp(App).use(store).use(router).mount('#app');
const app = createApp(App).use(store).use(router);

// axios 코드
import axios from 'axios'
app.config.globalProperties.$axios = axios; // 전역 객체로 설정

app.mount('#app');
