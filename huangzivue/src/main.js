// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
//启动项目时先加载该文件
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import store from './store'
import { initMenu } from './utils/menu'
//import axios from 'axios'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/index.scss'

Vue.use(ElementUI);
//Vue.prototype.$axios = axios   //在vue中使用axios

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',   //项目加载第一步：官方解释为实例提供挂载的元素，可以理解为将vue文件转换成html文件
  router,
  store,
  components: { App },   //项目加载第二步：注册组件
  template: '<App/>'   //设置要挂载的元素，即vue文件中的template将被html的形式加入到html文件中
})

// vue项目启动时的文件加载顺序
// 1、确定将被挂载（替换）的元素，此处为index.html中的<div id="app"><div>
// 2、注册组件（此处只有组件App），选择其中用于替换挂载元素（第一步中的元素）的模板组件（<App/>），即用App.vue替换index.html中的<div id="app"><div>
// 3、注入路由器router：
//    1、模板组件（App.vue）中有<router-view/>，将在其中渲染路由匹配到的组件
//    2、注入（import）路由时指定的是router文件夹，即文件夹下所有routes
//    3、router文件夹下此时只有index.js文件，其中routes:[]规定了文件地址及其url地址映射
//    4、根据文件地址，载入组件（First.vue），组件被渲染在<router-view/>中，显示在index.html中

// 祝您生活愉快

//注册路由全局首位
router.beforeEach((to,from,next) => {
  var username = store.state.user.userName
  alert(username)
  if (to.meta.requireAuth) {
    if (username != null) {
      // initMenu(router,store)
      next()
    } else {
      next({ path: '/login',query: { redirect: to.path } })
    }
  } else {
    next();
  }
})

