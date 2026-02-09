import { createRouter, createWebHistory } from 'vue-router'
import ElementPlusView from '@/views/ElementPlusView.vue'
import TestView from '@/views/TestView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // 当访问 /elementplus 时，显示 ElementPlusView 组件
    { path: '/elementplus', component: ElementPlusView },
    // 当访问 /test 时，显示 TestView 组件
    { path: '/test', component: TestView },
    // 当访问 / 时，显示 ElementPlusView 组件
    { path: '/', component: ElementPlusView },
  ],
})

export default router
