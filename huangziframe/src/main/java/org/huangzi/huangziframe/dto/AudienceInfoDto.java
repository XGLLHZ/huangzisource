package org.huangzi.huangziframe.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.huangzi.huangziframe.util.BaseDto;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 20:56
 * @description: 观众列表实体
 */
@Data
@Accessors(chain = true)
public class AudienceInfoDto extends BaseDto {

    /**
     * 观众id
     */
    private int id;

    /**
     * 观众姓名
     */
    private String audienceName;

    /**
     * 观众昵称
     */
    private String audienceNickname;

    /**
     * 观众帐号
     */
    private String audienceAccount;

    /**
     * 观众头像
     */
    private String audienceLogo;

    /**
     * 观众性别
     */
    private String audienceGender;

    /**
     * 观众年龄
     */
    private String audienceAge;

    /**
     * 观众身份证号
     */
    private String audienceIdcard;

    /**
     * 观众电话
     */
    private String audiencePhone;

    /**
     * 观众银行账号
     */
    private String audienceBank;

    /**
     * 观众地址
     */
    private String audienceLoc;

    /**
     * 逻辑删除状态：0：可用；1：已删除
     */
    private int deleteFlag;

}
