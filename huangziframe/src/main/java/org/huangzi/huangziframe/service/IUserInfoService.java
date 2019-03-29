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
     * 登录成功之后根据用户所具有的角色的id获取资源
     * @param id
     * @return
     */
    List<MenuInfoDto> list(int id);

}
