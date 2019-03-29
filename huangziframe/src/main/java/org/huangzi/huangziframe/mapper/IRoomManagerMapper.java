package org.huangzi.huangziframe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.huangzi.huangziframe.dto.RoomManagerDto;
import org.huangzi.huangziframe.entity.RoomManagerEntity;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 21:04
 * @description: 房管表mappper接口
 */
public interface IRoomManagerMapper extends BaseMapper<RoomManagerEntity> {

    /**
     * 获取房管信息列表
     * @param page 分页参数
     * @param condition 查询条件
     * @return 房管信息列表
     */
    List<RoomManagerDto> list(Page<RoomManagerDto> page, @Param("condition") RoomManagerDto condition);

    /**
     * 获取数据总数
     * @return 数据总数
     */
    Integer getTotal();

    /**
     * 获取单个房管信息
     * @param id 房管id
     * @return 房管信息
     */
    RoomManagerDto getById(int id);

}
