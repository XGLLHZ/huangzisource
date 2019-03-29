package org.huangzi.huangziframe.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.RoomManagerDto;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 23:32
 * @description: 房管表事务层
 */
public interface IRoomManagerService {

    /** 列表
     * @param roomManagerDto 查询参数
     * @return 列表
     */
    Page<RoomManagerDto> list(RoomManagerDto roomManagerDto);

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
    RoomManagerDto getById(int id);

    /**
     * 新增
     * @param roomManagerDto
     * @return 是否新增成功
     */
    Integer insert(RoomManagerDto roomManagerDto);

    /**
     * 删除
     * @param id id
     * @return 是否删除成功
     */
    Integer delete(int id);

    /**
     * 修改
     * @param roomManagerDto
     * @return 是否修改成功
     */
    Integer update(RoomManagerDto roomManagerDto);

}
