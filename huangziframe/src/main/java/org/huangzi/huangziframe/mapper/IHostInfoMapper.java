package org.huangzi.huangziframe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.huangzi.huangziframe.dto.HostInfoDto;
import org.huangzi.huangziframe.entity.HostInfoEntity;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 21:01
 * @description: 主播表mapper接口
 */
public interface IHostInfoMapper extends BaseMapper<HostInfoEntity> {

    /**
     * 获取主播信息列表
     * @param page 分页参数
     * @param condition 查询条件
     * @return 主播信息列表
     */
    List<HostInfoDto> list(Page<HostInfoDto> page, @Param("condition") HostInfoDto condition);

    /**
     * 获取数据总数
     * @return 数据总数
     */
    Integer getTotal();

    /**
     * 获取单个主播信息
     * @param id 主播id
     * @return 主播信息
     */
    HostInfoDto getById(int id);

}
