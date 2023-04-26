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

  // 루모스 프로젝트
  {
    path: '/lumoshomeview',
    name: 'lumoshomeview',
    component: () => import(/**/ '../views/LumosHomeView.vue')
  },
  {
    path: '/maincontentslayout',
    name: 'maincontentslayout',
    component: () => import(/**/ '../components/frame/MainContentsLayout.vue')
  },
  {
    path: '/mainsidelayout',
    name: 'mainsidelayout',
    component: () => import(/**/ '../components/frame/MainSideLayout.vue'),
    children: [
      {
        path: '/searchcenterlist',
        name: 'searchcenterlist',
        component: () => import(/**/ '../components/body/SearchCenterList.vue')
      },
      {
        path: '/recommendcenterlist',
        name: 'recommendcenterlist',
        component: () => import(/**/ '../components/body/RecommendCenterList.vue')
      },
    ]
  },
  {
    path: '/centerdatalayout',
    name: 'centerdatalayout',
    component: () => import(/**/ '../components/frame/CenterDataLayout.vue'),
    children: [
      {
        path: 'centerbasicinfo',
        name: 'centerbasicinfo',
        component: () => import(/**/ '../components/body/CenterBasicInfo.vue')
      },
      {
        path: 'centerdetailinfo',
        name: 'centerdetailinfo',
        component: () => import(/**/ '../components/body/CenterDetailInfo.vue')
      },
      {
        path: 'centerevalgrade',
        name: 'centerevalgrade',
        component: () => import(/**/ '../components/body/CenterEvalGrade.vue')
      },
      {
        path: 'centercafereview',
        name: 'centercafereview',
        component: () => import(/**/ '../components/body/CenterCafeReview.vue')
      },
      {
        path: 'centerstatus',
        name: 'centerstatus',
        component: () => import(/**/ '../components/body/CenterStatus.vue')
      },
    ]
  },

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
