//房管信息接口
import request from '@/utils/request'

//列表
export function getListRoomManager(params) {
    return request({
        method: 'post',
        url: '/api/roommanager/list',
        data: params
    })
}

//单个
export function getByIdRoomManager(params) {
    return request({
        method: 'post',
        url: '/api/roommanager/get',
        data: {
            id: params
        }
    })
}

//增加
export function addRoomManager(params) {
    return request({
        method: 'post',
        url: '/api/roommanager/insert',
        data: params
    })
}

//删除
export function deleteRoomManager(params) {
    return request({
        method: 'post',
        url: '/api/roommanager/delete',
        data: {
            id: params
        }
    })
}

//修改
export function updateRoomManager(params) {
    return request({
        method: 'post',
        url: '/api/roommanager/update',
        data: params
    })
}





