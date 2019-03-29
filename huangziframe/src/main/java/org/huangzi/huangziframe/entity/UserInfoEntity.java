package org.huangzi.huangziframe.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: XGLLHZ
 * @date: 2019/3/5 23:02
 * @description: 用户表
 */
@Data
@Accessors(chain = true)
@TableName("USER_INFO")
public class UserInfoEntity {

    /**
     * 用户id
     */
    @TableId(value = "ID")
    @TableField("ID")
    private int id;

    /**
     * 用户用户名
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 用户密码
     */
    @TableField("USER_PASSWORD")
    private String userPassword;

    /**
     * 用户类型：1：超管；2：主播；3：房管；4：观众
     */
    @TableField("USER_TYPE")
    private int userType;

    /**
     * 逻辑删除状态：0：可用；1：已删除
     */
    @TableField("DELETE_FLAG")
    private int deleteFlag;

    /**
     * 备用字段1
     */
    @TableField("SPARE_FIELD1")
    private static String spareField1;

    /**
     * 备用字段2
     */
    @TableField("SPARE_FIELD2")
    private static String spareField2;

    /**
     * 备用字段3
     */
    @TableField("SPARE_FIELD3")
    private static String spareField3;

    /**
     * 备用字段4
     */
    @TableField("SPARE_FIELD4")
    private static String spareField4;

    /**
     * 备用字段5
     */
    @TableField("SPARE_FIELD5")
    private static String spareField5;

}
