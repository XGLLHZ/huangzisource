package org.huangzi.huangziframe.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/3/7 20:38
 * @description: 权限信息实体
 */
@Data
@Accessors(chain = true)
public class MenuInfoDto {

    /**
     * 资源ID
     */
    private int id;

    /**
     * 请求路径规则
     */
    private String menuUrl;

    /**
     * 路由path
     */
    private String menuPath;

    /**
     * 组件名称
     */
    private String menuComponent;

    /**
     * 组件名
     */
    private String menuComname;

    /**
     * 菜单切换时是否保活
     */
    private String menuKeeplive;

    /**
     * 是否登陆后才可访问
     */
    private String menuRequireauth;

    /**
     * 获取拥有此权限的角色列表
     */
    private List<RoleInfoDto> roleInfoDtoList;

}
