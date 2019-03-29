package org.huangzi.huangziframe.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.HostFansDto;
import org.huangzi.huangziframe.entity.HostFansEntity;
import org.huangzi.huangziframe.mapper.IHostFansMapper;
import org.huangzi.huangziframe.service.IHostFansService;
import org.huangzi.huangziframe.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 23:44
 * @description:
 */
@Service
public class HostFansServiceImpl implements IHostFansService {

    @Autowired
    IHostFansMapper hostFansMapper;

    /**
     * 获取主播粉丝列表
     * @param hostFansDto 查询参数
     * @return 主播粉丝列表
     */
    @Override
    public Page<HostFansDto> list(HostFansDto hostFansDto) {
        Page<HostFansDto> page = new Page<>(hostFansDto.getCurrentPage(),hostFansDto.getPageSize());
        List<HostFansDto> list = hostFansMapper.list(page,hostFansDto);
        page.setRecords(list);
        return page;
    }

    /**
     * 获取数据总数
     * @return 数据总数
     */
    @Override
    public Integer getTotal() {
        return hostFansMapper.getTotal();
    }

    /**
     * 获取单个观众信息
     * @param id id
     * @return 单个
     */
    @Override
    public HostFansDto getById(int id) {
        return hostFansMapper.getById(id);
    }

    /**
     * 新增
     * @param hostFansDto
     * @return 是否新增成功
     */
    @Override
    public Integer insert(HostFansDto hostFansDto) {
        HostFansEntity hostFansEntitys = new HostFansEntity();
        HostFansEntity hostFansEntity = BeanConverterUtil.beanConvert(hostFansEntitys,hostFansDto);
        return hostFansMapper.insert(hostFansEntity);
    }

    /**
     * 删除
     * @param id id
     * @return 是否删除成功
     */
    @Override
    public Integer delete(int id) {
        return hostFansMapper.deleteById(id);
    }

    /**
     * 修改
     * @param hostFansDto
     * @return 是否修改成功
     */
    @Override
    public Integer update(HostFansDto hostFansDto) {
        HostFansEntity hostFansEntitys = new HostFansEntity();
        HostFansEntity hostFansEntity = BeanConverterUtil.beanConvert(hostFansEntitys,hostFansDto);
        return hostFansMapper.updateById(hostFansEntity);
    }

}
