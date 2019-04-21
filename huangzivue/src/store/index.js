import Vue from 'vue'
import Vuex from 'Vuex'
import '../lib/sockjs'
import '../lib/stomp'

//store：用来处理用户登录信息，为防止F5刷新页面导致localStorage中的用户信息丢失，故以字符串的形式存入，以json的形式取出

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        user: {
            userid: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).id,
            username: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).userName,
            userpassword: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).userPassword,
            usertype: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).userType
        },
        routes: []
    },
    mutations: {
        login(state,user) {
            state.user = user
            window.localStorage.setItem('user',JSON.stringify(user))   //以字符串的形式存入
        },
        logout() {
            window.localStorage.clear()
        },
        initMenu(state,menus) {
            state.routes = menus
        }
    }
})

