package org.huangzi.huangziframe.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.HostInfoDto;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 21:10
 * @description: 主播表事务层
 */
public interface IHostInfoService {

    /**
     * 获取主播列表
     * @param hostInfoDto 查询参数
     * @return 主播列表
     */
    Page<HostInfoDto> list(HostInfoDto hostInfoDto);

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

    /**
     * 新增主播信息
     * @param hostInfoDto 主播信息
     * @return  是否新增成功
     */
    Integer insert(HostInfoDto hostInfoDto);

    /**
     * 删除主播信息
     * @param id 主播ids
     * @return 是否删除成功
     */
    Integer delete(int id);

    /**
     * 修改主播信息
     * @param hostInfoDto 主播信息
     * @return 是否修改成功
     */
    Integer update(HostInfoDto hostInfoDto);

}
