import Vue from 'vue'
import Router from 'vue-router'
import index from '@/views/index'   //引入主页面
import projRoutes from './proj'   //引入项目路由

//注册路由
Vue.use(Router)


// path：路由
// name：路由名字
export const constantRouterMap = [
  {
    path: '/',
    name: 'index',
    component: index,
    redirect: 'index',
    children: [{
      path: '/index',
      name: 'index',
      component: index,
      meta: {
        requireAuth: false
      }
    }]
  }
]

const router = new Router({
  routes: constantRouterMap.concat(projRoutes)
})

export default router


