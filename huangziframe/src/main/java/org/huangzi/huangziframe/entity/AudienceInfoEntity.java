package org.huangzi.huangziframe.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 20:46
 * @description: 观众表
 */
@Data
@Accessors(chain = true)
@TableName("AUDIENCE_INFO")
public class AudienceInfoEntity {

    /**
     * 观众id
     */
    @TableId(value = "ID")
    @TableField("ID")
    private int id;

    /**
     * 观众姓名
     */
    @TableField("AUDIENCE_NAME")
    private String audienceName;

    /**
     * 观众昵称
     */
    @TableField("AUDIENCE_NICKNAME")
    private String audienceNickname;

    /**
     * 观众帐号
     */
    @TableField("AUDIENCE_ACCOUNT")
    private String audienceAccount;

    /**
     * 观众密码
     */
    @TableField("AUDIENCE_PASSWORD")
    private String audiencePassword;

    /**
     * 观众头像
     */
    @TableField("AUDIENCE_LOGO")
    private String audienceLogo;

    /**
     * 观众性别
     */
    @TableField("AUDIENCE_GENDER")
    private String audienceGender;

    /**
     * 观众年龄
     */
    @TableField("AUDIENCE_AGE")
    private String audienceAge;

    /**
     * 观众身份证号
     */
    @TableField("AUDIENCE_IDCARD")
    private String audienceIdcard;

    /**
     * 观众电话
     */
    @TableField("AUDIENCE_PHONE")
    private String audiencePhone;

    /**
     * 观众银行账号
     */
    @TableField("AUDIENCE_BANK")
    private String audienceBank;

    /**
     * 观众地址
     */
    @TableField("AUDIENCE_LOC")
    private String audienceLoc;

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
