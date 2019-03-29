package org.huangzi.huangziframe.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 20:48
 * @description: 主播粉丝表
 */
@Data
@Accessors(chain = true)
@TableName("HOST_FANS")
public class HostFansEntity {

    /**
     * 粉丝id
     */
    @TableId(value = "ID")
    @TableField("ID")
    private int id;

    /**
     * 主播id：外键-主播表id
     */
    @TableField("HOST_ID")
    private int hostId;

    /**
     * 观众id：外键-观众表id
     */
    @TableField("AUDIENCE_ID")
    private int audienceId;

    /**
     * 粉丝状态：0：正常；1：禁言
     */
    @TableField("FANS_FLAG")
    private int fansFlag;

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
