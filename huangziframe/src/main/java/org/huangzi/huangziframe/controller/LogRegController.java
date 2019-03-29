package org.huangzi.huangziframe.controller;

import org.huangzi.huangziframe.dto.MenuInfoDto;
import org.huangzi.huangziframe.dto.UserInfoDto;
import org.huangzi.huangziframe.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/3/28 20:27
 * @description: 登录注册控制器
 */
@RestController
@RequestMapping("/api/userinfo")
public class LogRegController {

    @Autowired
    IUserInfoService userInfoService;

    /**
     * 登录
     * @param userInfoDto
     * @return
     */
    @RequestMapping("/login")
    public UserInfoDto login(@RequestBody UserInfoDto userInfoDto) {
        return userInfoService.login(userInfoDto);
    }

    /**
     * 注册
     * @param userInfoDto
     * @return
     */
    @RequestMapping("/register")
    public UserInfoDto register(@RequestBody UserInfoDto userInfoDto) {
        return  userInfoService.register(userInfoDto);
    }

    /**
     * 用户登录成功之后通过用户所具有的角色的id来获取资源，以便渲染菜单
     * @param id
     * @return
     */
    @RequestMapping("/menu")
    public List<MenuInfoDto> list(@RequestBody int id) {
        return userInfoService.list(id);
    }

}
