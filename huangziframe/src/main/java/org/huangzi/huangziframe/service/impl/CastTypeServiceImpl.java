package org.huangzi.huangziframe.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.CastTypeDto;
import org.huangzi.huangziframe.entity.CastTypeEntity;
import org.huangzi.huangziframe.mapper.ICastTypeMapper;
import org.huangzi.huangziframe.service.ICastTypeService;
import org.huangzi.huangziframe.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 23:43
 * @description:
 */
@Service
public class CastTypeServiceImpl implements ICastTypeService {

    @Autowired
    ICastTypeMapper castTypeMapper;

    /**
     * 获取直播种类列表
     * @param castTypeDto 查询参数
     * @return 直播种类列表
     */
    @Override
    public Page<CastTypeDto> list(CastTypeDto castTypeDto) {
        Page<CastTypeDto> page = new Page<>(castTypeDto.getCurrentPage(),castTypeDto.getPageSize());
        List<CastTypeDto> list = castTypeMapper.list(page,castTypeDto);
        page.setRecords(list);
        return page;
    }

    /**
     * 获取数据总数
     * @return 数据总数
     */
    @Override
    public Integer getTotal() {
        return castTypeMapper.getTotal();
    }

    /**
     * 获取单个直播种类信息
     * @param id id
     * @return 单个信息
     */
    @Override
    public CastTypeDto getById(int id) {
        return castTypeMapper.getById(id);
    }

    /**
     * 新增
     * @param castTypeDto
     * @return 是否新增成功
     */
    @Override
    public Integer insert(CastTypeDto castTypeDto) {
        CastTypeEntity castTypeEntitys = new CastTypeEntity();
        CastTypeEntity castTypeEntity = BeanConverterUtil.beanConvert(castTypeEntitys,castTypeDto);
        return castTypeMapper.insert(castTypeEntity);
    }

    /**
     * 删除
     * @param id id
     * @return 是否删除成功
     */
    @Override
    public Integer delete(int id) {
        return castTypeMapper.deleteById(id);
    }

    /**
     * 修改
     * @param castTypeDto
     * @return 是否修改成功
     */
    @Override
    public Integer update(CastTypeDto castTypeDto) {
        CastTypeEntity castTypeEntitys = new CastTypeEntity();
        CastTypeEntity castTypeEntity = BeanConverterUtil.beanConvert(castTypeEntitys,castTypeDto);
        return castTypeMapper.updateById(castTypeEntity);
    }

}
