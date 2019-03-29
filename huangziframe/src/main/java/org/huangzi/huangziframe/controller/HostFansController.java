package org.huangzi.huangziframe.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.HostFansDto;
import org.huangzi.huangziframe.service.IHostFansService;
import org.huangzi.huangziframe.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/17 22:11
 * @description: 主播粉丝表-前端控制器
 */
@RestController
@RequestMapping("/api/hostfans")
public class HostFansController {

    @Autowired
    IHostFansService hostFansService;

    /**
     * 获取主播粉丝信息列表
     * @param hostFansDto 查询参数
     * @return 列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public BaseResult list(HostFansDto hostFansDto){
        BaseResult baseResult = new BaseResult();
        Page<HostFansDto> page = hostFansService.list(hostFansDto);
        List<HostFansDto> list = page.getRecords();
        baseResult.setList(list);
        baseResult.setCurrentPage(hostFansDto.getCurrentPage());
        baseResult.setPageSize(hostFansDto.getPageSize());
        return baseResult;
    }

    /**
     * 获取单个主播粉丝信息
     * @param hostFansDto id
     * @return 单个
     */
    @RequestMapping("/get")
    @ResponseBody
    public HostFansDto get(HostFansDto hostFansDto){
        return hostFansService.getById(hostFansDto.getId());
    }

    /**
     * 新增
     * @param hostFansDto
     * @return 是否新增成功
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Integer insert(HostFansDto hostFansDto){
        return hostFansService.insert(hostFansDto);
    }

    /**
     * 删除
     * @param hostFansDto id
     * @return 是否删除成功
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Integer delete(HostFansDto hostFansDto){
        return hostFansService.delete(hostFansDto.getId());
    }

    /**
     * 修改
     * @param hostFansDto
     * @return 是否修改成功
     */
    @RequestMapping("/update")
    @ResponseBody
    public Integer update(HostFansDto hostFansDto){
        return hostFansService.update(hostFansDto);
    }

}
