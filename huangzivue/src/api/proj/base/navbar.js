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

//获取资源
export function getMenuApi(params) {
    return request({
        method: 'post',
        url: '/api/userinfo/menu',
        data: params
    })
}


