package org.huangzi.huangziframe.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.huangzi.huangziframe.util.BaseDto;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 21:00
 * @description: 超管列表实体
 */
@Data
@Accessors(chain = true)
public class SuperManagerDto extends BaseDto {

    /**
     * 超管id
     */
    private int id;

    /**
     * 超管姓名
     */
    private String superName;

    /**
     * 超管昵称
     */
    private String superNickname;

    /**
     * 超管账号
     */
    private String superAccount;

    /**
     * 超管头像
     */
    private String superLogo;

    /**
     * 超管性别
     */
    private String superGender;

    /**
     * 超管年龄
     */
    private String superAge;

    /**
     * 超管身份证号
     */
    private String superIdcard;

    /**
     * 超管电话
     */
    private String superPhone;

    /**
     * 超管银行账号
     */
    private String superBank;

    /**
     * 超管地址
     */
    private String superLoc;

    /**
     * 逻辑删除状态：0：可用；1：已删除
     */
    private int deleteFlag;

}
