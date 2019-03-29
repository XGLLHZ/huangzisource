package org.huangzi.huangziframe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.huangzi.huangziframe.dto.UserInfoDto;
import org.huangzi.huangziframe.entity.UserInfoEntity;

/**
 * @author: XGLLHZ
 * @date: 2019/3/28 19:54
 * @description: 用户表mapper接口
 */
public interface IUserInfoMapper extends BaseMapper<UserInfoEntity> {

    /**
     * 根据用户名获取用户信息；注册时用
     * @param userName
     * @return
     */
    UserInfoDto getUserByUsername(String userName);

    /**
     * 根据用户名和密码获取用户信息；登录时用
     * @param userName
     * @param userPassword
     * @return
     */
    UserInfoDto getUserByNamePass(String userName,String userPassword);

}
