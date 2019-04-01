import Vue from 'vue'
import Vuex from 'Vuex'
import '../lib/sockjs'
import '../lib/stomp'

//store：用来处理用户登录信息，为防止F5刷新页面导致localStorage中的用户信息丢失，故以字符串的形式存入，以json的形式取出

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        user: {
            username: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).userName,
            usertype: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).userType
            // userrole: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).roleInfoDto.roleNamey
        }
    },
    mutations: {
        login(state,user) {
            state.user = user
            window.localStorage.setItem('user',JSON.stringify(user))
        },
        logout(state) {
            window.localStorage.removeItem('user')
        }
    }
})

