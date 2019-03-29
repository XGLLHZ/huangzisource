package org.huangzi.huangziframe.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.huangzi.huangziframe.util.BaseDto;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 20:58
 * @description: 主播粉丝列表实体
 */
@Data
@Accessors(chain = true)
public class HostFansDto extends BaseDto {

    /**
     * 粉丝id
     */
    private int id;

    /**
     * 主播id：外键-主播表id
     */
    private int hostId;

    /**
     * 观众id：外键-观众表id
     */
    private int audienceId;

    /**
     * 粉丝状态：0：正常；1：禁言
     */
    private int fansFlag;

    /**
     * 粉丝姓名
     */
    private String hostFansName;

    /**
     * 粉丝昵称
     */
    private String hostFansNickname;

    /**
     * 粉丝账号
     */
    private String hostFansAccount;

    /**
     * 粉丝性别
     */
    private String hostFansGender;

    /**
     * 粉丝年龄
     */
    private String hostFansAge;

    /**
     * 粉丝身份证号
     */
    private String hostFansIdcard;

    /**
     * 粉丝电话
     */
    private String hostFansPhone;

    /**
     * 粉丝银行账号
     */
    private String hostFansBank;

    /**
     * 粉丝地址
     */
    private String hostFansLoc;

    /**
     * 逻辑删除状态：0：可用；1：已删除
     */
    private int deleteFlag;

}
