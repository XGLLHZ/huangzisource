package org.huangzi.huangziframe.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.huangzi.huangziframe.util.BaseDto;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/3/28 19:52
 * @description: 用户信息实体
 */
@Data
@Accessors(chain = true)
public class UserInfoDto extends BaseDto {

    /**
     * 用户id
     */
    private int id;

    /**
     * 用户用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户类型：1：超管；2：主播；3：房管；4：观众
     */
    private int userType;

    /**
     * 逻辑删除状态：0：可用；1：已删除
     */
    private int deleteFlag;

    /**
     * 用户具有的角色列表
     */
    private RoleInfoDto roleInfoDto;

}
