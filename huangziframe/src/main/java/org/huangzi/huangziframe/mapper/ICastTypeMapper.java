package org.huangzi.huangziframe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.huangzi.huangziframe.dto.CastTypeDto;
import org.huangzi.huangziframe.entity.CastTypeEntity;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 21:03
 * @description: 直播种类表mapper接口
 */
public interface ICastTypeMapper extends BaseMapper<CastTypeEntity> {

    /**
     * 获取直播种类信息列表
     * @param page 分页参数
     * @param condition 查询条件
     * @return 直播种类信息列表
     */
    List<CastTypeDto> list(Page<CastTypeDto> page, @Param("condition") CastTypeDto condition);

    /**
     * 获取数据总数
     * @return 数据总数
     */
    Integer getTotal();

    /**
     * 查询单个直播种类信息
     * @param id 直播种类id
     * @return 直播种类信息
     */
    CastTypeDto getById(int id);

}
