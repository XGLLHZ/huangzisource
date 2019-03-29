package org.huangzi.huangziframe.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.AudienceInfoDto;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 23:32
 * @description: 观众表事务层
 */
public interface IAudienceInfoService {

    /**
     * 获取观众列表
     * @param audienceInfoDto 查询参数
     * @return 观众列表
     */
    Page<AudienceInfoDto> list(AudienceInfoDto audienceInfoDto);

    /**
     * 获取数据总数
     * @return 数据总数
     */
    Integer getTotal();

    /**
     * 获取单个观众信息
     * @param id 观众id
     * @return 观众信息
     */
    AudienceInfoDto getById(int id);

    /**
     * 新增观众信息
     * @param audienceInfoDto 观众信息
     * @return  是否新增成功
     */
    Integer insert(AudienceInfoDto audienceInfoDto);

    /**
     * 删除观众信息
     * @param id 观众id
     * @return 是否删除成功
     */
    Integer delete(int id);

    /**
     * 修改观众信息
     * @param audienceInfoDto 观众信息
     * @return 是否修改成功
     */
    Integer update(AudienceInfoDto audienceInfoDto);

}
