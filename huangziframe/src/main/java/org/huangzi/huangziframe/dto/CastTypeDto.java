package org.huangzi.huangziframe.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.huangzi.huangziframe.util.BaseDto;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 20:57
 * @description: 直播类别列表实体
 */
@Data
@Accessors(chain = true)
public class CastTypeDto extends BaseDto {

    /**
     * 直播种类id
     */
    private int id;

    /**
     * 直播种类名称
     */
    private String castName;

    /**
     * 直播种类图像
     */
    private String castLogo;

    /**
     * 直播种类logobase64值
     */
    private String logoBase;

    /**
     * 逻辑删除状态：0：可用；1：已删除
     */
    private int deleteFlag;

}
