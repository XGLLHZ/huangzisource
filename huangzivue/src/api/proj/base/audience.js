//用户详情接口
import request from '@/utils/request'

//列表
export function getListAudience(params) {
    return request({
        method: 'post',
        url: '/api/audience/list',
        data: params
    })
}

//单个
export function getByIdAudience(params) {
    return request({
        method: 'post',
        url: '/api/audience/get',
        data: {
            id: params
        }
    })
}

//增加
export function addAudience(params) {
    return request({
        method: 'post',
        url: '/api/audience/insert',
        data: params
    })
}

//删除
export function deleteAudience(params) {
    return request({
        method: 'post',
        url: '/api/audience/delete',
        data: {
            id: params
        }
    })
}

//修改
export function updateAudience(params) {
    return request({
        method: 'post',
        url: '/api/audience/update',
        data: params
    })
}




