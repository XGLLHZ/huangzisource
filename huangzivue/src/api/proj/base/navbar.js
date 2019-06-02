//导航栏api 
import request from '@/utils/request'

//登录
export function loginApi(params) {
    return request({
        method: 'post',
        url: '/api/userinfo/login',
        data: params
    })
}

//注册
export function registerApi(params) {
    return request({
        method: 'post',
        url: '/api/userinfo/register',
        data: params
    })
}

//个人中心
export function getInfo(params1,params2) {
    return request({
        method: 'post',
        url: '/api/userinfo/getinfo',
        data: {
            userName: params1,
            userType: params2
        }
    })
}

//修改密码
export function updatePassWord(params1,params2) {
    return request({
        method: 'post',
        url: 'api/userinfo/updatepassword',
        data: {
            id: params1,
            userPassword: params2
        }
    })
}

//获取资源（菜单权限）
export function getMenuApi(params) {
    return request({
        method: 'post',
        url: '/api/userinfo/menu',
        data: params
    })
}


