package org.huangzi.huangziframe.service.impl;

import org.huangzi.huangziframe.dto.MenuInfoDto;
import org.huangzi.huangziframe.dto.RoleInfoDto;
import org.huangzi.huangziframe.dto.UserInfoDto;
import org.huangzi.huangziframe.entity.AudienceInfoEntity;
import org.huangzi.huangziframe.entity.UserInfoEntity;
import org.huangzi.huangziframe.mapper.IAudienceInfoMapper;
import org.huangzi.huangziframe.mapper.IMenuInfoMapper;
import org.huangzi.huangziframe.mapper.IRoleInfoMapper;
import org.huangzi.huangziframe.mapper.IUserInfoMapper;
import org.huangzi.huangziframe.service.IUserInfoService;
import org.huangzi.huangziframe.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/3/28 20:22
 * @description:
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    IUserInfoMapper userInfoMapper;

    @Autowired
    IRoleInfoMapper roleInfoMapper;

    @Autowired
    IMenuInfoMapper menuInfoMapper;

    @Autowired
    IAudienceInfoMapper audienceInfoMapper;

    /**
     * 用户登录
     * @param userInfoDto
     * @return
     */
    @Override
    public UserInfoDto login(UserInfoDto userInfoDto) {
        UserInfoDto userInfoDtos = userInfoMapper.getUserByNamePass(userInfoDto.getUserName(),userInfoDto.getUserPassword());
        if (userInfoDtos != null) {
            RoleInfoDto roleInfoDto = roleInfoMapper.getRoleByUserId(userInfoDtos.getId());
            userInfoDtos.setRoleInfoDto(roleInfoDto);
            return userInfoDtos;
        } else {
            return new UserInfoDto();
        }
    }

    /**
     * 用户注册
     * @param userInfoDto
     * @return
     */
    @Override
    public UserInfoDto register(UserInfoDto userInfoDto) {
        UserInfoDto userInfoDtos = userInfoMapper.getUserByUsername(userInfoDto.getUserName());
        if (userInfoDtos != null) {
            return new UserInfoDto();
        } else {
            UserInfoEntity userInfoEntitys = new UserInfoEntity();
            UserInfoEntity userInfoEntity = BeanConverterUtil.beanConvert(userInfoEntitys,userInfoDto);
            userInfoMapper.insert(userInfoEntity);
            AudienceInfoEntity audienceInfoEntity = new AudienceInfoEntity();
            audienceInfoEntity.setAudienceAccount(userInfoDto.getUserName());
            audienceInfoEntity.setAudiencePassword(userInfoDto.getUserPassword());
            audienceInfoMapper.insert(audienceInfoEntity);
            return userInfoDto;
        }
    }

    /**
     * 通过用户id获取用户权限
     * @param id
     * @return
     */
    @Override
    public List<MenuInfoDto> list(int id) {
        return menuInfoMapper.list(id);
    }

}
