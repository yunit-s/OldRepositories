import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  
  // 화면 분할 연습
  {
    path: '/dividelayoutview',
    name: 'dividelayoutview',
    component: () => import(/**/ '../views/DivideLayoutView.vue')
  },

  // Tab 화면전환
  {
    path: '/tabview',
    name: 'tabview',
    component: () => import(/**/ '../views/TabView.vue')
  },

  // Vuex 활용
  {
    path: '/vuexview',
    name: 'vuexview',
    component: () => import(/**/ '../views/VuexView.vue')
  },

  // Lifecycle에 따른 Vue 속성 동작
  {
    path: '/lifecycleview',
    name: 'lifecycleview',
    component: () => import(/**/ '../views/LifecycleView.vue')
  },

  // 루모스 프로젝트
  {
    path: '/lumosprojectview',
    redirect: '/lumosprojectview/lumoshomeview',
    component: () => import(/**/ '../views/LumosProjectView.vue'),
    children: [
      {
        path: 'lumoshomeview',
        component: () => import(/**/ '../views/LumosHomeView.vue')
      },
      {
        path: 'loginhomeview',
        component: () => import(/**/ '../views/LoginHomeView.vue')
      },
    ]
  },

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
