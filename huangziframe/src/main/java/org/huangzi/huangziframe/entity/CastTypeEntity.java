package org.huangzi.huangziframe.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 20:47
 * @description: 直播种类表
 */
@Data
@Accessors(chain = true)
@TableName("CAST_TYPE")
public class CastTypeEntity {

    /**
     * 直播种类id
     */
    @TableId(value = "ID")
    @TableField("ID")
    private int id;

    /**
     * 直播种类名称
     */
    @TableField("CAST_NAME")
    private String castName;

    /**
     * 直播种类图像
     */
    @TableField("CAST_LOGO")
    private String castLogo;

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
