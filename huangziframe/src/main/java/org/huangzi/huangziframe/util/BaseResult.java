package org.huangzi.huangziframe.util;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author: guohao
 * @date: 2019/2/12/14:10
 * @description: 基础容器返回
 */
@Data
@Accessors(chain = true)
public class BaseResult {

    /**
     * 数据总数
     */
    public Integer total;

    /**
     * 分页参数-当前页面
     */
    public Integer currentPage;

    /**
     * 分页参数-页面大小
     */
    public Integer pageSize;

    /**
     * 数据列表
     */
    public List list;

}

