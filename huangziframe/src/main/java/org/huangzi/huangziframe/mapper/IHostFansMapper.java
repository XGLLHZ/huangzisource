package org.huangzi.huangziframe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.huangzi.huangziframe.dto.HostFansDto;
import org.huangzi.huangziframe.entity.HostFansEntity;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 21:03
 * @description: 主播粉丝表mapper接口
 */
public interface IHostFansMapper extends BaseMapper<HostFansEntity> {

    /**
     * 获取主播粉丝信息列表
     * @param page 分页参数
     * @param condition 查询条件
     * @return 粉丝列表
     */
    List<HostFansDto> list(Page<HostFansDto> page,@Param("condition") HostFansDto condition);

    /**
     * 获取数据总数
     * @return 数据总数
     */
    Integer getTotal();

    /**
     * 查询单个主播粉丝信息
     * @param id 粉丝id
     * @return 粉丝信息
     */
    HostFansDto getById(int id);

}
