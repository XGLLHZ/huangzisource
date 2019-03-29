package org.huangzi.huangziframe.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.HostFansDto;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 23:32
 * @description: 主播粉丝表事务层
 */
public interface IHostFansService {

    /** 列表
     * @param hostFansDto 查询参数
     * @return 列表
     */
    Page<HostFansDto> list(HostFansDto hostFansDto);

    /**
     * 总数
     * @return 总数
     */
    Integer getTotal();

    /**
     * 查询单个
     * @param id id
     * @return 单个信息
     */
    HostFansDto getById(int id);

    /**
     * 新增
     * @param hostFansDto
     * @return 是否新增成功
     */
    Integer insert(HostFansDto hostFansDto);

    /**
     * 删除
     * @param id id
     * @return 是否删除成功
     */
    Integer delete(int id);

    /**
     * 修改
     * @param hostFansDto
     * @return 是否修改成功
     */
    Integer update(HostFansDto hostFansDto);

}
