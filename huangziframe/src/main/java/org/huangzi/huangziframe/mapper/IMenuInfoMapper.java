package org.huangzi.huangziframe.mapper;

import org.huangzi.huangziframe.dto.MenuInfoDto;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/3/7 20:48
 * @description: 权限实体mapper接口
 */
public interface IMenuInfoMapper {

    /**
     * 通过用户id获取用户权限
     * @param id
     * @return
     */
    List<MenuInfoDto> list(int id);

}
