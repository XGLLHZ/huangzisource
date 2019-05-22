package org.huangzi.huangziframe.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.huangzi.huangziframe.dto.CastTypeDto;
import org.huangzi.huangziframe.dto.HostInfoDto;
import org.huangzi.huangziframe.service.INavInfoService;
import org.huangzi.huangziframe.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/5/21 8:58
 * @description: 首页导航各页面前端控制器-全部、分类、视频、操作
 */
@RestController
@RequestMapping("/api/navinfo")
public class NavInfoController {

    @Autowired
    INavInfoService navInfoService;

    /**
     * 获取全部直播信息列表
     * @param hostInfoDto
     * @return
     */
    @RequestMapping("/alllive/list")
    public BaseResult getAllLiveList(@RequestBody HostInfoDto hostInfoDto) {
        BaseResult baseResult = new BaseResult();
        Page<HostInfoDto> page = navInfoService.getAllLiveList(hostInfoDto);
        List<HostInfoDto> list = page.getRecords();
        baseResult.setList(list);
        return baseResult;
    }

    /**
     * 获取主播信息和主播直播信息
     * @param hostInfoDto
     * @return
     */
    @RequestMapping("/alllive/get")
    public HostInfoDto getHostInfo(@RequestBody HostInfoDto hostInfoDto) {
        return navInfoService.getHostInfo(hostInfoDto);
    }

    /**
     * 获取直播分类页面信息列表
     * @param castTypeDto
     * @return
     */
    @RequestMapping("/kind/list")
    public BaseResult getKindList(@RequestBody CastTypeDto castTypeDto) {
        BaseResult baseResult = new BaseResult();
        Page<CastTypeDto> page = navInfoService.getKindList(castTypeDto);
        List<CastTypeDto> list = page.getRecords();
        baseResult.setList(list);
        return baseResult;
    }

    /**
     * 获取单个直播类别信息
     * @param castTypeDto
     * @return
     */
    @RequestMapping("/kind/get")
    public CastTypeDto getCastType(@RequestBody CastTypeDto castTypeDto) {
        return navInfoService.getCastType(castTypeDto);
    }

    /**
     * 根据直播类别获取主播及直播信息列表
     * @param hostInfoDto
     * @return
     */
    @RequestMapping("/castkind")
    public BaseResult getLiveListByCastType(@RequestBody HostInfoDto hostInfoDto) {
        BaseResult baseResult = new BaseResult();
        Page<HostInfoDto> page = navInfoService.getLiveListByCastType(hostInfoDto);
        List<HostInfoDto> list = page.getRecords();
        baseResult.setList(list);
        return baseResult;
    }

}
