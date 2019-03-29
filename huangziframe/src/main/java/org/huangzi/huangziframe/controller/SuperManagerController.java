package org.huangzi.huangziframe.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.SuperManagerDto;
import org.huangzi.huangziframe.service.ISuperManagerService;
import org.huangzi.huangziframe.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/17 22:13
 * @description: 超管表-前端控制器
 */
@RestController
@RequestMapping("/api/supermanager")
public class SuperManagerController {

    @Autowired
    ISuperManagerService superManagerService;

    /**
     * 获取超管列表
     * @param superManagerDto 查询参数
     * @return 列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public BaseResult list(SuperManagerDto superManagerDto){
        BaseResult baseResult = new BaseResult();
        Page<SuperManagerDto> page = superManagerService.list(superManagerDto);
        List<SuperManagerDto> list = page.getRecords();
        baseResult.setList(list);
        baseResult.setCurrentPage(superManagerDto.getCurrentPage());
        baseResult.setPageSize(superManagerDto.getPageSize());
        return baseResult;
    }

    /**
     * 获取单个超管信息
     * @param superManagerDto id
     * @return 单个
     */
    @RequestMapping("/get")
    @ResponseBody
    public SuperManagerDto get(SuperManagerDto superManagerDto){
        return superManagerService.getById(superManagerDto.getId());
    }

    /**
     * 新增
     * @param superManagerDto
     * @return 是否新增成功
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Integer insert(SuperManagerDto superManagerDto){
        return superManagerService.insert(superManagerDto);
    }

    /**
     * 删除
     * @param superManagerDto id
     * @return 是否删除成功
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Integer delete(SuperManagerDto superManagerDto){
        return superManagerService.delete(superManagerDto.getId());
    }

    /**
     * 修改
     * @param superManagerDto
     * @return 是否修改成功
     */
    @RequestMapping("/update")
    @ResponseBody
    public Integer update(SuperManagerDto superManagerDto){
        return superManagerService.update(superManagerDto);
    }

}
