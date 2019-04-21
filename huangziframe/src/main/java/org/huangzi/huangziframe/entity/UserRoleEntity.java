package org.huangzi.huangziframe.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: XGLLHZ
 * @date: 2019/4/9 21:11
 * @description: 用户角色表
 */
@Data
@Accessors(chain = true)
@TableName("USER_ROLE")
public class UserRoleEntity {

    /**
     * ID
     */
    @TableId(value = "ID")
    @TableField("ID")
    private int id;

    /**
     * 用户id
     */
    @TableField("USER_ID")
    private int userId;

    /**
     * 角色id
     */
    @TableField("ROLE_ID")
    private int roleId;

}
