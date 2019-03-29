package org.huangzi.huangziframe.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.SuperManagerDto;
import org.huangzi.huangziframe.entity.SuperManagerEntity;
import org.huangzi.huangziframe.mapper.ISuperManagerMapper;
import org.huangzi.huangziframe.service.ISuperManagerService;
import org.huangzi.huangziframe.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 23:45
 * @description:
 */
@Service
public class SuperManagerServiceImpl implements ISuperManagerService {

    @Autowired
    ISuperManagerMapper superManagerMapper;

    /**
     * 获取超管信息列表
     * @param superManagerDto 查询参数
     * @return 超管信息列表
     */
    @Override
    public Page<SuperManagerDto> list(SuperManagerDto superManagerDto) {
        Page<SuperManagerDto> page = new Page<>(superManagerDto.getCurrentPage(),superManagerDto.getPageSize());
        List<SuperManagerDto> list = superManagerMapper.list(page,superManagerDto);
        page.setRecords(list);
        return page;
    }

    /**
     * 获取数据总数
     * @return 数据总数
     */
    @Override
    public Integer getTotal() {
        return superManagerMapper.getTotal();
    }

    /**
     * 获取单个超管信息
     * @param id id
     * @return 单个
     */
    @Override
    public SuperManagerDto getById(int id) {
        return superManagerMapper.getById(id);
    }

    /**
     * 新增
     * @param superManagerDto
     * @return 是否新增成功
     */
    @Override
    public Integer insert(SuperManagerDto superManagerDto) {
        SuperManagerEntity superManagerEntitys = new SuperManagerEntity();
        SuperManagerEntity superManagerEntity = BeanConverterUtil.beanConvert(superManagerEntitys,superManagerDto);
        return superManagerMapper.insert(superManagerEntity);
    }

    /**
     * 删除
     * @param id id
     * @return 是否删除成功
     */
    @Override
    public Integer delete(int id) {
        return superManagerMapper.deleteById(id);
    }

    /**
     * 修改
     * @param superManagerDto
     * @return 是否修改成功
     */
    @Override
    public Integer update(SuperManagerDto superManagerDto) {
        SuperManagerEntity superManagerEntitys = new SuperManagerEntity();
        SuperManagerEntity superManagerEntity = BeanConverterUtil.beanConvert(superManagerEntitys,superManagerDto);
        return superManagerMapper.updateById(superManagerEntity);
    }

}
