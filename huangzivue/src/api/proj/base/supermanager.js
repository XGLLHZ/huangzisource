//超管信息接口
import request from '@/utils/request'

//列表
export function getListSuperManager(params) {
    return request({
        method: 'post',
        url: '/api/supermanager/list',
        data: params
    })
}

//单个
export function getByIdSuperManager(params) {
    return request({
        method: 'post',
        url: '/api/supermanager/get',
        data: {
            id: params
        }
    })
}

//增加
export function addSuperManager(params) {
    return request({
        method: 'post',
        url: '/api/supermanager/insert',
        data: params
    })
}

//删除
export function deleteSuperManager(params) {
    return request({
        method: 'post',
        url: '/api/supermanager/delete',
        data: {
            id: params
        }
    })
}

//修改
export function updateSuperManager(params) {
    return request({
        method: 'post',
        url: '/api/supermanager/update',
        data: params
    })
}




