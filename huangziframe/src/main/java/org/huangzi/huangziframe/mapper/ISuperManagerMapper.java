package org.huangzi.huangziframe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.huangzi.huangziframe.dto.SuperManagerDto;
import org.huangzi.huangziframe.entity.SuperManagerEntity;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 21:05
 * @description: 超管表mapper接口
 */
public interface ISuperManagerMapper extends BaseMapper<SuperManagerEntity> {

    /**
     * 获取超管信息列表
     * @param page 分页参数
     * @param condition 查询条件
     * @return 超管信息列表
     */
    List<SuperManagerDto> list(Page<SuperManagerDto> page, @Param("condition") SuperManagerDto condition);

    /**
     * 获取数据总数
     * @return 数据总数
     */
    Integer getTotal();

    /**
     * 获取单个超管信息
     * @param id 超管id
     * @return 超管信息
     */
    SuperManagerDto getById(int id);

}
