package org.huangzi.huangziframe.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.huangzi.huangziframe.dto.HostInfoDto;
import org.huangzi.huangziframe.service.IHostInfoService;
import org.huangzi.huangziframe.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 21:13
 * @description: 主播表前端控制器
 */
@RestController
@RequestMapping("/api/hostinfo")
public class HostInfoController {

    @Autowired
    IHostInfoService hostInfoService;
    /**
     * 获取主播信息列表
     * @param hostInfoDto 查询参数
     * @return 主播信息列表
     */
    @RequestMapping("/list")
    public BaseResult list(@RequestBody @Param("hostInfoDto") HostInfoDto hostInfoDto){
        BaseResult baseResult = new BaseResult();
        Page<HostInfoDto> page = hostInfoService.list(hostInfoDto);
        List<HostInfoDto> list = page.getRecords();
        baseResult.setList(list);
        baseResult.setTotal(hostInfoService.getTotal());
        baseResult.setCurrentPage(hostInfoDto.getCurrentPage());
        baseResult.setPageSize(hostInfoDto.getPageSize());
        return baseResult;
    }

    /**
     * 获取单个主播信息
     * @param hostInfoDto 主播id
     * @return 主播信息
     */
    @RequestMapping("/get")
    public HostInfoDto get(@RequestBody HostInfoDto hostInfoDto){
        return hostInfoService.getById(hostInfoDto.getId());
    }

    /**
     * 新增主播信息
     * @param hostInfoDto 主播信息
     * @return 是否新增成功
     */
    @RequestMapping("/insert")
    public Integer insert(@RequestBody @Param("hostInfoDto") HostInfoDto hostInfoDto){
        return hostInfoService.insert(hostInfoDto);
    }

    /**
     * 删除主播信息
     * @param hostInfoDto 主播id
     * @return 是否删除成功
     */
    @RequestMapping("/delete")
    public Integer delete(@RequestBody  @Param("hostInfoDto") HostInfoDto hostInfoDto){
        System.out.println(hostInfoDto.getId());
        return hostInfoService.delete(hostInfoDto.getId());
    }

    /**
     * 修改主播信息
     * @param hostInfoDto 主播信息
     * @return 是否修改成功
     */
    @RequestMapping("/update")
    public Integer update(@RequestBody @Param("hostInfoDto") HostInfoDto hostInfoDto){
        return hostInfoService.update(hostInfoDto);
    }

}
