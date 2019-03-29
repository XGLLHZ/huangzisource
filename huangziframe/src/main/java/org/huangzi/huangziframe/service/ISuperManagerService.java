package org.huangzi.huangziframe.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.SuperManagerDto;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 23:32
 * @description: 超管表事务层
 */
public interface ISuperManagerService {

    /** 列表
     * @param superManagerDto 查询参数
     * @return 列表
     */
    Page<SuperManagerDto> list(SuperManagerDto superManagerDto);

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
    SuperManagerDto getById(int id);

    /**
     * 新增
     * @param superManagerDto
     * @return 是否新增成功
     */
    Integer insert(SuperManagerDto superManagerDto);

    /**
     * 删除
     * @param id id
     * @return 是否删除成功
     */
    Integer delete(int id);

    /**
     * 修改
     * @param superManagerDto
     * @return 是否修改成功
     */
    Integer update(SuperManagerDto superManagerDto);

}
