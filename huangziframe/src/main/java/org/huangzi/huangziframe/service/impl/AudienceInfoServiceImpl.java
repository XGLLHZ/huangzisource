package org.huangzi.huangziframe.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.AudienceInfoDto;
import org.huangzi.huangziframe.entity.AudienceInfoEntity;
import org.huangzi.huangziframe.mapper.IAudienceInfoMapper;
import org.huangzi.huangziframe.service.IAudienceInfoService;
import org.huangzi.huangziframe.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 23:41
 * @description:
 */
@Service
public class AudienceInfoServiceImpl implements IAudienceInfoService {


    @Autowired
    IAudienceInfoMapper audienceInfoMapper;

    /**
     * 获取观众列表
     * @param audienceInfoDto 查询参数
     * @return 观众列表
     */
    @Override
    public Page<AudienceInfoDto> list(AudienceInfoDto audienceInfoDto) {
        Page<AudienceInfoDto> page = new Page<>(audienceInfoDto.getCurrentPage(),audienceInfoDto.getPageSize());
        List<AudienceInfoDto> list = audienceInfoMapper.list(page,audienceInfoDto);
        page.setRecords(list);
        return page;
    }

    /**
     * 获取数据总数
     * @return 数据总数
     */
    @Override
    public Integer getTotal() {
        return audienceInfoMapper.getTotal();
    }

    /**
     * 获取单个观众信息
     * @param id 观众id
     * @return 观众信息
     */
    @Override
    public AudienceInfoDto getById(int id) {
        return audienceInfoMapper.getById(id);
    }

    /**
     * 新增观众信息
     * @param audienceInfoDto 观众信息
     * @return  是否新增成功
     */
    @Override
    public Integer insert(AudienceInfoDto audienceInfoDto) {
        AudienceInfoEntity audienceInfoEntitys = new AudienceInfoEntity();
        AudienceInfoEntity audienceInfoEntity = BeanConverterUtil.beanConvert(audienceInfoEntitys,audienceInfoDto);
        return audienceInfoMapper.insert(audienceInfoEntity);
    }

    /**
     * 删除观众信息
     * @param id 观众id
     * @return 是否删除成功
     */
    @Override
    public Integer delete(int id) {
        return audienceInfoMapper.deleteById(id);
    }

    /**
     * 修改观众信息
     * @param audienceInfoDto 观众信息
     * @return 是否修改成功
     */
    @Override
    public Integer update(AudienceInfoDto audienceInfoDto) {
        AudienceInfoEntity audienceInfoEntitys = new AudienceInfoEntity();
        AudienceInfoEntity audienceInfoEntity = BeanConverterUtil.beanConvert(audienceInfoEntitys,audienceInfoDto);
        return audienceInfoMapper.updateById(audienceInfoEntity);
    }

}
