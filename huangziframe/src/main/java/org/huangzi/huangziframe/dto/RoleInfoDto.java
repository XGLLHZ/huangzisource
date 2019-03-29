package org.huangzi.huangziframe.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: XGLLHZ
 * @date: 2019/3/6 21:17
 * @description: 角色表信息实体
 */
@Data
@Accessors(chain = true)
public class RoleInfoDto {

    /**
     * 角色ID
     */
    private int id;

    /**
     * 角色英文名
     */
    private String roleNamey;

    /**
     * 角色中文名
     */
    private String roleNamez;

}
