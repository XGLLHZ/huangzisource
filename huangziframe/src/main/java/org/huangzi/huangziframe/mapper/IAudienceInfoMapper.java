package org.huangzi.huangziframe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.huangzi.huangziframe.dto.AudienceInfoDto;
import org.huangzi.huangziframe.entity.AudienceInfoEntity;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 22:01
 * @description: 观众表mapper接口
 */
public interface IAudienceInfoMapper extends BaseMapper<AudienceInfoEntity> {

    /**
     * 获取观众信息列表
     * @param page 分页参数
     * @param condition 查询条件
     * @return 观众信息列表
     */
    List<AudienceInfoDto> list(Page<AudienceInfoDto> page, @Param("condition") AudienceInfoDto condition);

    /**
     * 获取数据总数
     * @return 数据总数
     */
    Integer getTotal();

    /**
     * 查询单个观众信息
     * @param id 观众id
     * @return 观众信息
     */
    AudienceInfoDto getById(int id);

}
