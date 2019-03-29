package org.huangzi.huangziframe.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.HostInfoDto;
import org.huangzi.huangziframe.entity.HostInfoEntity;
import org.huangzi.huangziframe.mapper.IHostInfoMapper;
import org.huangzi.huangziframe.service.IHostInfoService;
import org.huangzi.huangziframe.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 21:11
 * @description:
 */
@Service
public class HostInfoServiceImpl implements IHostInfoService {

    @Autowired
    private IHostInfoMapper hostInfoMapper;

    /**
     * 获取主播列表
     * @param hostInfoDto 查询参数
     * @return 主播列表
     */
    @Override
    public Page<HostInfoDto> list(HostInfoDto hostInfoDto) {
        Page<HostInfoDto> page = new Page<>(hostInfoDto.getCurrentPage(),hostInfoDto.getPageSize());
        List<HostInfoDto> list = hostInfoMapper.list(page,hostInfoDto);
        page.setRecords(list);
        return page;
    }

    /**
     * 获取数据总数
     * @return 数据总数
     */
    @Override
    public Integer getTotal(){
        return hostInfoMapper.getTotal();
    }

    /**
     * 获取单个主播信息
     * @param id 主播id
     * @return 主播信息
     */
    @Override
    public HostInfoDto getById(int id){
        return hostInfoMapper.getById(id);
    }

    /**
     * 增加主播信息
     * @param hostInfoDto 主播信息
     * @return 是否增加成功
     */
    @Override
    public Integer insert(HostInfoDto hostInfoDto) {
        HostInfoEntity hostInfoEntitys = new HostInfoEntity();
        HostInfoEntity hostInfoEntity = BeanConverterUtil.beanConvert(hostInfoEntitys,hostInfoDto);
        return hostInfoMapper.insert(hostInfoEntity);
    }

    /**
     * 删除主播信息
     * @param id 主播id
     * @return 是否删除成功
     */
    @Override
    public Integer delete(int id) {
        return hostInfoMapper.deleteById(id);
    }

    /**
     * 修改主播信息
     * @param hostInfoDto 主播信息
     * @return 是否修改成功
     */
    @Override
    public Integer update(HostInfoDto hostInfoDto){
        HostInfoEntity hostInfoEntitys = new HostInfoEntity();
        HostInfoEntity hostInfoEntity = BeanConverterUtil.beanConvert(hostInfoEntitys,hostInfoDto);
        return hostInfoMapper.updateById(hostInfoEntity);
    }

}
