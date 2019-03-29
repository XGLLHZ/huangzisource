package org.huangzi.huangziframe.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 20:48
 * @description: 房管表
 */
@Data
@Accessors(chain = true)
@TableName("ROOM_MANAGER")
public class RoomManagerEntity {

    /**
     * 房管id
     */
    @TableId(value = "ID")
    @TableField("ID")
    private int id;

    /**
     * 房间号：外键-主播表房间号hostRoom
     */
    @TableField("ROOM_ROOM")
    private String roomRoom;

    /**
     * 房管姓名
     */
    @TableField("ROOM_NAME")
    private String roomName;

    /**
     * 房管昵称
     */
    @TableField("ROOM_NICKNAME")
    private String roomNickname;

    /**
     * 房管账号
     */
    @TableField("ROOM_ACCOUNT")
    private String roomAccount;

    /**
     * 房管密码
     */
    @TableField("ROOM_PASSWORD")
    private String roomPassword;

    /**
     * 房管头像
     */
    @TableField("ROOM_LOGO")
    private String roomLogo;

    /**
     * 房管性别
     */
    @TableField("ROOM_GENDER")
    private String roomGender;

    /**
     * 房管年龄
     */
    @TableField("ROOM_AGE")
    private String roomAge;

    /**
     * 房管身份证号
     */
    @TableField("ROOM_IDCARD")
    private String roomIdcard;

    /**
     * 房管电话
     */
    @TableField("ROOM_PHONE")
    private String roomPhone;

    /**
     * 房管银行账号
     */
    @TableField("ROOM_BANK")
    private String roomBank;

    /**
     * 房管地址
     */
    @TableField("ROOM_LOC")
    private String roomLoc;

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
