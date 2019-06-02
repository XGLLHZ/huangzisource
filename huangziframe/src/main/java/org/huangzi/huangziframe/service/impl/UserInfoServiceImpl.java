package org.huangzi.huangziframe.service.impl;

import org.huangzi.huangziframe.dto.HostInfoDto;
import org.huangzi.huangziframe.dto.MenuInfoDto;
import org.huangzi.huangziframe.dto.RoleInfoDto;
import org.huangzi.huangziframe.dto.UserInfoDto;
import org.huangzi.huangziframe.entity.AudienceInfoEntity;
import org.huangzi.huangziframe.entity.UserInfoEntity;
import org.huangzi.huangziframe.mapper.*;
import org.huangzi.huangziframe.service.IUserInfoService;
import org.huangzi.huangziframe.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/3/28 20:22
 * @description: 用户信息事务层实现类
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

    @Autowired
    ISuperManagerMapper superManagerMapper;

    @Autowired
    IHostInfoMapper hostInfoMapper;

    @Autowired
    IRoomManagerMapper roomManagerMapper;

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

    /**
     * 通过用户id和用户类型查询用户信息（个人中心页面显示）
     * @param userType
     * @param account
     * @return
     */
    @Override
    public UserInfoDto getInfo(int userType,String account) {
        UserInfoDto userInfoDto = new UserInfoDto();
        if ("1".equals(userType)) {
            /*SuperManagerDto superManagerDto = superManagerMapper.getById(userId);
            userInfoDto.setUserZSName(superManagerDto.getSuperName());
            userInfoDto.setNickName(superManagerDto.getSuperNickname());
            userInfoDto.setAge(superManagerDto.getSuperAge());
            userInfoDto.setIdNum(superManagerDto.getSuperIdcard());
            userInfoDto.setPhone(superManagerDto.getSuperPhone());
            userInfoDto.setLoc(superManagerDto.getSuperLoc());*/
        } else if (userType == 2) {
            HostInfoDto hostInfoDto = hostInfoMapper.getByName(account);
            userInfoDto.setUserZSName(hostInfoDto.getHostName());
            userInfoDto.setNickName(hostInfoDto.getHostNickname());
            userInfoDto.setAge(hostInfoDto.getHostAge());
            userInfoDto.setIdNum(hostInfoDto.getHostIdcard());
            userInfoDto.setPhone(hostInfoDto.getHostPhone());
            userInfoDto.setLoc(hostInfoDto.getHostLoc());
        } else if ("3".equals(userType)) {
            /*RoomManagerDto roomManagerDto = roomManagerMapper.getById(userId);
            userInfoDto.setUserZSName(roomManagerDto.getRoomName());
            userInfoDto.setNickName(roomManagerDto.getRoomNickname());
            userInfoDto.setAge(roomManagerDto.getRoomAge());
            userInfoDto.setIdNum(roomManagerDto.getRoomIdcard());
            userInfoDto.setPhone(roomManagerDto.getRoomPhone());
            userInfoDto.setLoc(roomManagerDto.getRoomLoc());*/
        } else if ("4".equals(userType)) {
            /*AudienceInfoDto audienceInfoDto = audienceInfoMapper.getById(userId);
            userInfoDto.setUserZSName(audienceInfoDto.getAudienceName());
            userInfoDto.setNickName(audienceInfoDto.getAudienceNickname());
            userInfoDto.setAge(audienceInfoDto.getAudienceAge());
            userInfoDto.setIdNum(audienceInfoDto.getAudienceIdcard());
            userInfoDto.setPhone(audienceInfoDto.getAudiencePhone());
            userInfoDto.setLoc(audienceInfoDto.getAudienceLoc());*/
        }
        return userInfoDto;
    }

    /**
     * 修改密码
     * @param userInfoDto
     * @return
     */
    @Override
    public Integer updatePassWord(UserInfoDto userInfoDto) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        UserInfoEntity userInfoEntity1 = BeanConverterUtil.beanConvert(userInfoEntity,userInfoDto);
        return userInfoMapper.updateById(userInfoEntity1);
    }

}
