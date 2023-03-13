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
    path: '/subcomptest/parentcomp',
    name: 'ParentComp',
    redirect: '/subcomptest/parentcomp/childcomp1', // 서브컴포넌트 초기값 설정
    component: () => import(/* webpackChunkName: "about" */ '../views/SubCompTest/ParentComp'),
    children: [
      {
        path: 'childcomp1',
        component: () => import(/* webpackChunkName: "about" */ '../components/SubCompTest/ChildComp1')
      },
      {
        path: 'childcomp2',
        component: () => import(/* webpackChunkName: "about" */ '../components/SubCompTest/ChildComp2')
      },
      {
        path: 'childcomp3',
        component: () => import(/* webpackChunkName: "about" */ '../components/SubCompTest/ChildComp3')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
