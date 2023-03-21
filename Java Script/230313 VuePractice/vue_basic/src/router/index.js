import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/comp1',
    name: 'Comp1',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Comp1View')
  },
  {
    path: '/comp2',
    name: 'Comp2',
    component: () => import(/* webpackChunkName: "about" */ '../views/Comp2View')
  },
  {
    path: '/subcomponent/parentcomp',
    name: 'ParentComp',
    redirect: '/subcomponent/parentcomp/childcomp1', // 서브컴포넌트 초기값 설정
    component: () => import(/* webpackChunkName: "about" */ '../views/SubComponent/ParentCompView'),
    children: [
      {
        path: 'childcomp1',
        component: () => import(/* webpackChunkName: "about" */ '../components/SubComponent/ChildComp1')
      },
      {
        path: 'childcomp2',
        component: () => import(/* webpackChunkName: "about" */ '../components/SubComponent/ChildComp2')
      },
      {
        path: 'childcomp3',
        component: () => import(/* webpackChunkName: "about" */ '../components/SubComponent/ChildComp3')
      }
    ]
  },
  {
    path: '/kakaomap/kakaomap',
    name: 'Kakaomap',
    redirect: '/kakaomap/kakaomap/exam1_simple', // 서브컴포넌트 초기값 설정
    component: () => import(/* webpackChunkName: "about" */ '../views/Kakaomap/KakaomapView'),
    children: [
      {
        path: 'exam1_simple',
        component: () => import(/* webpackChunkName: "about" */ '../components/Kakaomap/Exam1_Simple')
      },
      {
        path: 'exam2_simple',
        component: () => import(/* webpackChunkName: "about" */ '../components/Kakaomap/Exam2_Simple')
      },
      {
        path: 'exam3_marker',
        component: () => import(/* webpackChunkName: "about" */ '../components/Kakaomap/Exam3_Marker')
      },
      {
        path: 'exam4_searchlist',
        component: () => import(/* webpackChunkName: "about" */ '../components/Kakaomap/Exam4_SearchList')
      }
    ]
  },
  {
    path: '/serveraccess',
    name: 'ServerAccess',
    redirect: '/serveraccess/exam1_axios', // 서브컴포넌트 초기값 설정
    component: () => import(/* webpackChunkName: "about" */ '../views/ServerAccess/ServerAccessView'),
    children: [
      {
        path: 'exam1_axios',
        component: () => import(/* webpackChunkName: "about" */ '../components/ServerAccess/Exam1_Axios')
      }
    ]
  },
  {
    path: '/gymmanna',
    name: 'GymManna',
    redirect: '/gymmanna/signin', // 서브컴포넌트 초기값 설정
    component: () => import(/* webpackChunkName: "about" */ '../views/Proj-GymManna/GymMannaView'),
    children: [
      {
        path: 'signin',
        component: () => import(/* webpackChunkName: "about" */ '../components/Proj-GymManna/SignIn')
      },
      {
        path: 'articlegathering',
        component: () => import(/* webpackChunkName: "about" */ '../components/Proj-GymManna/ArticleGathering')
      }
    ]
  },
  {
    path: '/vuex',
    name: 'Vuex',
    redirect: '/Vuex/exam1_actions', // 서브컴포넌트 초기값 설정
    component: () => import(/* webpackChunkName: "about" */ '../views/Vuex/VuexView'),
    children: [
      {
        path: 'exam1_actions',
        component: () => import(/* webpackChunkName: "about" */ '../components/Vuex/Exam1_Actions')
      },
      {
        path: 'exam2_getters',
        component: () => import(/* webpackChunkName: "about" */ '../components/Vuex/Exam2_Getters')
      },
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
