package org.huangzi.huangziframe.service;

import org.huangzi.huangziframe.dto.MenuInfoDto;
import org.huangzi.huangziframe.dto.RoleInfoDto;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/3/8 17:17
 * @description: 资源表事务层
 */
public interface IMenuInfoService {

    /**
     * 获取请求地址列表
     * @return
     */
    List<MenuInfoDto> getMenuList();

    /**
     * 根据menuid获取menu的角色
     * @param id
     * @return
     */
    List<RoleInfoDto> getMenuRoleList(int id);

}
