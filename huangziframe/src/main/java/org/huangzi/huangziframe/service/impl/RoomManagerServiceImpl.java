package org.huangzi.huangziframe.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.RoomManagerDto;
import org.huangzi.huangziframe.entity.RoomManagerEntity;
import org.huangzi.huangziframe.mapper.IRoomManagerMapper;
import org.huangzi.huangziframe.service.IRoomManagerService;
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
public class RoomManagerServiceImpl implements IRoomManagerService {

    @Autowired
    IRoomManagerMapper roomManagerMapper;

    /**
     * 获取房管信息列表
     * @param roomManagerDto 查询参数
     * @return 房管信息列表
     */
    @Override
    public Page<RoomManagerDto> list(RoomManagerDto roomManagerDto) {
        Page<RoomManagerDto> page = new Page<>(roomManagerDto.getCurrentPage(),roomManagerDto.getPageSize());
        List<RoomManagerDto> list = roomManagerMapper.list(page,roomManagerDto);
        page.setRecords(list);
        return page;
    }

    /**
     * 获取数据总数
     * @return 数据总数
     */
    @Override
    public Integer getTotal() {
        return roomManagerMapper.getTotal();
    }

    /**
     * 获取单个房管信息
     * @param id id
     * @return 单个
     */
    @Override
    public RoomManagerDto getById(int id) {
        return roomManagerMapper.getById(id);
    }

    /**
     * 新增
     * @param roomManagerDto
     * @return 是否新增成功
     */
    @Override
    public Integer insert(RoomManagerDto roomManagerDto) {
        RoomManagerEntity roomManagerEntitys = new RoomManagerEntity();
        RoomManagerEntity roomManagerEntity = BeanConverterUtil.beanConvert(roomManagerEntitys,roomManagerDto);
        return roomManagerMapper.insert(roomManagerEntity);
    }

    /**
     * 删除
     * @param id id
     * @return 是否删除成功
     */
    @Override
    public Integer delete(int id) {
        return roomManagerMapper.deleteById(id);
    }

    /**
     * 修改
     * @param roomManagerDto
     * @return 是否修改成功
     */
    @Override
    public Integer update(RoomManagerDto roomManagerDto) {
        RoomManagerEntity roomManagerEntitys = new RoomManagerEntity();
        RoomManagerEntity roomManagerEntity = BeanConverterUtil.beanConvert(roomManagerEntitys,roomManagerDto);
        return roomManagerMapper.updateById(roomManagerEntity);
    }

}
