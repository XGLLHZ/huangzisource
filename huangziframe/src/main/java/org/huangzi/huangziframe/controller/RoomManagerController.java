package org.huangzi.huangziframe.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.RoomManagerDto;
import org.huangzi.huangziframe.service.IRoomManagerService;
import org.huangzi.huangziframe.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/17 22:12
 * @description: 房管表-前端控制器
 */
@RestController
@RequestMapping("/api/roommanager")
public class RoomManagerController {

    @Autowired
    IRoomManagerService roomManagerService;

    /**
     * 获取房管信息列表
     * @param roomManagerDto 查询参数
     * @return 列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public BaseResult list(RoomManagerDto roomManagerDto){
        BaseResult baseResult = new BaseResult();
        Page<RoomManagerDto> page = roomManagerService.list(roomManagerDto);
        List<RoomManagerDto> list = page.getRecords();
        baseResult.setList(list);
        baseResult.setCurrentPage(roomManagerDto.getCurrentPage());
        baseResult.setPageSize(roomManagerDto.getPageSize());
        return baseResult;
    }

    /**
     * 获取单个房管信息
     * @param roomManagerDto id
     * @return 单个
     */
    @RequestMapping("/get")
    @ResponseBody
    public RoomManagerDto get(RoomManagerDto roomManagerDto){
        return roomManagerService.getById(roomManagerDto.getId());
    }

    /**
     * 新增
     * @param roomManagerDto
     * @return 是否新增成功
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Integer insert(RoomManagerDto roomManagerDto){
        return roomManagerService.insert(roomManagerDto);
    }

    /**
     * 删除
     * @param roomManagerDto id
     * @return 是否删除成功
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Integer delete(RoomManagerDto roomManagerDto){
        return roomManagerService.delete(roomManagerDto.getId());
    }

    /**
     * 修改
     * @param roomManagerDto
     * @return 是否修改成功
     */
    @RequestMapping("/update")
    @ResponseBody
    public Integer update(RoomManagerDto roomManagerDto){
        return roomManagerService.update(roomManagerDto);
    }

}
