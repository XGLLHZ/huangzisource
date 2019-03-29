package org.huangzi.huangziframe.util;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: guohao
 * @date: 2019/2/12/14:35
 * @description: 基础实体模型
 */
@Data
@Accessors(chain = true)
public class BaseDto {

    /**
     * 分页参数-当前页面
     * 默认为1
     */
    public Integer currentPage = 1;

    /**
     * 分页参数-页面大小
     * 默认为10
     */
    public Integer pageSize = 10;

}
