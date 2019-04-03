//主播信息接口
import request from '@/utils/request'

//列表
export function getListHostInfo(params) {
    return request({
        method: 'post',
        url: '/api/hostinfo/list',
        data: params
    })
}

//单个
export function getByIdHostInfo(params) {
    return request({
        method: 'post',
        url: '/api/hostinfo/get',
        data: params
    })
}

//增加
export function addHostInfo(params) {
    return request({
        method: 'post',
        url: '/api/hostinfo/insert',
        data: params
    })
}

//删除
export function deleteHostInfo(params) {
    return request({
        method: 'post',
        url: '/api/hostinfo/delete',
        data: params
    })
}

//修改
export function updateHostInfo(params) {
    return request({
        method: 'post',
        url: '/api/hostinfo/update',
        data: params
    })
}


