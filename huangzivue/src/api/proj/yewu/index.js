//业务信息接口
import request from '@/utils/request'

//全部直播页面信息列表
export function getAllLiveInfo(params) {
    return request({
        method: 'post',
        url: '/api/navinfo/alllive/list',
        data: params
    })
}

//主播直播页面信息
export function getByIdHostInfo(params) {
    return request({
        method: 'post',
        url: '/api/navinfo/alllive/get',
        data: {
            id: params
        }
    })
}

//直播分类页面信息列表
export function getKindList(params) {
    return request({
        method: 'post',
        url: '/api/navinfo/kind/list',
        data: params
    })
}

//获取单个直播类别信息
export function getCastType(params) {
    return request({
        method: 'post',
        url: '/api/navinfo/kind/get',
        data: {
            id: params
        }
    })
}

//根据直播类别获取主播及直播信息列表
export function getLiveListByCastType(params) {
    return request({
        method: 'post',
        url: '/api/navinfo/castkind',
        data: params
    })
}
