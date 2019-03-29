package org.huangzi.huangziframe.mapper;

import org.huangzi.huangziframe.dto.RoleInfoDto;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/3/28 20:56
 * @description: 角色表mapper接口
 */
public interface IRoleInfoMapper {

    /**
     * 根据用户id获取用户角色
     * @param id
     * @return
     */
    RoleInfoDto getRoleByUserId(int id);

}
