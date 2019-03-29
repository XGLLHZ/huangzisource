package org.huangzi.huangziframe.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 20:50
 * @description: 超管表
 */
@Data
@Accessors(chain = true)
@TableName("SUPER_MANAGER")
public class SuperManagerEntity {

    /**
     * 超管id
     */
    @TableId(value = "ID")
    @TableField("ID")
    private int id;

    /**
     * 超管姓名
     */
    @TableField("SUPER_NAME")
    private String superName;

    /**
     * 超管昵称
     */
    @TableField("SUPER_NICKNAME")
    private String superNickname;

    /**
     * 超管账号
     */
    @TableField("SUPER_ACCOUNT")
    private String superAccount;

    /**
     * 超管密码
     */
    @TableField("SUPER_PASSWORD")
    private String superPassword;

    /**
     * 超管头像
     */
    @TableField("SUPER_LOGO")
    private String superLogo;

    /**
     * 超管性别
     */
    @TableField("SUPER_GENDER")
    private String superGender;

    /**
     * 超管年龄
     */
    @TableField("SUPER_AGE")
    private String superAge;

    /**
     * 超管身份证号
     */
    @TableField("SUPER_IDCARD")
    private String superIdcard;

    /**
     * 超管电话
     */
    @TableField("SUPER_PHONE")
    private String superPhone;

    /**
     * 超管银行账号
     */
    @TableField("SUPER_BANK")
    private String superBank;

    /**
     * 超管地址
     */
    @TableField("SUPER_LOC")
    private String superLoc;

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
