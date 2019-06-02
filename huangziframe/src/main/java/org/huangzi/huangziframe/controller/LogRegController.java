package org.huangzi.huangziframe.controller;

import org.apache.ibatis.annotations.Param;
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
    public UserInfoDto login(@RequestBody @Param("userInfoDto") UserInfoDto userInfoDto) {
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
     * 通过用户id获取用户权限，以便渲染菜单
     * @param id
     * @return
     */
    @RequestMapping("/menu")
    public List<MenuInfoDto> list(@RequestBody int id) {
        return userInfoService.list(id);
    }

    /**
     * 根据用户类型和用户id查询用户信息（个人中心页面显示）
     * @param userInfoDto
     * @return
     */
    @RequestMapping("/getinfo")
    public UserInfoDto getInfo(@RequestBody UserInfoDto userInfoDto) {
        return userInfoService.getInfo(userInfoDto.getUserType(),userInfoDto.getUserName());
    }

    /**
     * 修改密码
     * @param userInfoDto
     * @return
     */
    @RequestMapping("/updatepassword")
    public Integer updatePassWord(@RequestBody UserInfoDto userInfoDto) {
        return userInfoService.updatePassWord(userInfoDto);
    }

}

/**
 * 这一路上走走停停顺着少年漂流的痕迹
 * 不去想着尽享情节reng
 */


