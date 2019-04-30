//直播类型信息接口
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
        data: {
            id: params
        }
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
        data: {
            id: params
        }
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

//logo上传
export function uploadImage(params1,params2) {
    return request({
        method: 'post',
        url: '/api/casttype/upload',
        data: {
            castLogo: params1,
            logoBase: params2
        }
    })
}

//获取图片链接
export function getImageUrl(params) {
    return request({
        method: 'post',
        url: '/api/casttype/geturl',
        data: {
            castLogo: params
        }
    })
}




