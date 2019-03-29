package org.huangzi.huangziframe.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.huangzi.huangziframe.util.BaseDto;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 20:59
 * @description: 房管列表实体
 */
@Data
@Accessors(chain = true)
public class RoomManagerDto extends BaseDto {

    /**
     * 房管id
     */
    private int id;

    /**
     * 房间号：外键-主播表房间号hostRoom
     */
    private String roomRoom;

    /**
     * 房管姓名
     */
    private String roomName;

    /**
     * 房管昵称
     */
    private String roomNickname;

    /**
     * 房管账号
     */
    private String roomAccount;

    /**
     * 房管头像
     */
    private String roomLogo;

    /**
     * 房管性别
     */
    private String roomGender;

    /**
     * 房管年龄
     */
    private String roomAge;

    /**
     * 房管身份证号
     */
    private String roomIdcard;

    /**
     * 房管电话
     */
    private String roomPhone;

    /**
     * 房管银行账号
     */
    private String roomBank;

    /**
     * 房管地址
     */
    private String roomLoc;

    /**
     * 逻辑删除状态：0：可用；1：已删除
     */
    private int deleteFlag;

}
