package org.huangzi.huangziframe.service;

import org.huangzi.huangziframe.dto.MenuInfoDto;
import org.huangzi.huangziframe.dto.UserInfoDto;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/3/28 20:21
 * @description: 用户信息事务层
 */
public interface IUserInfoService {

    /**
     * 用户登录
     * @param userInfoDto
     * @return
     */
    UserInfoDto login(UserInfoDto userInfoDto);

    /**
     * 用户注册
     * @param userInfoDto
     * @return
     */
    UserInfoDto register(UserInfoDto userInfoDto);

    /**
     * 通过用户id获取用户权限
     * @param id
     * @return
     */
    List<MenuInfoDto> list(int id);

}
