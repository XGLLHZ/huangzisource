package org.huangzi.huangziframe.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.huangzi.huangziframe.util.BaseDto;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 20:54
 * @description: 主播列表实体
 */
@Data
@Accessors(chain = true)
public class HostInfoDto extends BaseDto {

    /**
     * 主播id
     */
    private int id;

    /**
     * 主播房间号
     */
    private String hostRoom;

    /**
     * 主播姓名
     */
    private String hostName;

    /**
     * 主播昵称
     */
    private String hostNickname;

    /**
     * 主播账号
     */
    private String hostAccount;

    /**
     * 主播头像名称
     */
    private String hostLogo;

    /**
     * 主播头像地址
     */
    private String hostLogoUrl;

    /**
     * 主播性别
     */
    private String hostGender;

    /**
     * 主播年龄
     */
    private String hostAge;

    /**
     * 主播身份证号
     */
    private String hostIdcard;

    /**
     * 主播电话
     */
    private String hostPhone;

    /**
     * 主播银行账号
     */
    private String hostBank;

    /**
     * 主播地址
     */
    private String hostLoc;

    /**
     * 主播粉丝数量
     */
    private int hostFansCount;

    /**
     * 直播类别：外键-直播种类表id
     */
    private int hostType;

    /**
     * 直播状态：0：休息；1：直播；2：被安排
     */
    private int hostFlag;

    /**
     * 直播标题
     */
    private String hostTitle;

    /**
     * 直播头像地址
     */
    private String liveLogoUrl;

    /**
     * 直播流名称
     */
    private String hostLiuname;

    /**
     * 直播流地址
     */
    private String liuUrl;

    /**
     * 逻辑删除状态：0：可用；1：已删除
     */
    private int deleteFlag;

}
