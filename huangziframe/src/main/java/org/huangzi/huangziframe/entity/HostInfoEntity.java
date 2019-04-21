package org.huangzi.huangziframe.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 20:44
 * @description: 主播表
 */
@Data
@Accessors(chain = true)
@TableName("HOST_INFO")
public class HostInfoEntity {

    /**
     * 主播id
     */
    @TableId(value = "ID")
    @TableField("ID")
    private int id;

    /**
     * 主播房间号
     */
    @TableField("HOST_ROOM")
    private String hostRoom;

    /**
     * 直播类别：外键-直播种类表id
     */
    @TableField("HOST_TYPE")
    private int hostType;

    /**
     * 直播状态：0：休息；1：直播；2：被安排
     */
    @TableField("HOST_FLAG")
    private int hostFlag;

    /**
     * 直播标题
     */
    @TableField("HOST_TITLE")
    private String hostTitle;

    /**
     * 主播姓名
     */
    @TableField("HOST_NAME")
    private String hostName;

    /**
     * 主播昵称
     */
    @TableField("HOST_NICKNAME")
    private String hostNickname;

    /**
     * 主播账号
     */
    @TableField("HOST_ACCOUNT")
        private String hostAccount;

    /**
     * 主播密码
     */
    @TableField("HOST_PASSWORD")
    private String hostPassword;

    /**
     * 主播头像
     */
    @TableField("HOST_LOGO")
    private String hostLogo;

    /**
     * 主播性别
     */
    @TableField("HOST_GENDER")
    private String hostGender;

    /**
     * 主播年龄
     */
    @TableField("HOST_AGE")
    private String hostAge;

    /**
     * 主播身份证号
     */
    @TableField("HOST_IDCARD")
    private String hostIdcard;

    /**
     * 主播电话
     */
    @TableField("HOST_PHONE")
    private String hostPhone;

    /**
     * 主播银行账号
     */
    @TableField("HOST_BANK")
    private String hostBank;

    /**
     * 主播地址
     */
    @TableField("HOST_LOC")
    private String hostLoc;

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
