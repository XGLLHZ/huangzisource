package org.huangzi.huangziframe.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.CastTypeDto;
import org.huangzi.huangziframe.dto.HostInfoDto;

/**
 * @author: XGLLHZ
 * @date: 2019/5/21 9:45
 * @description: 首页导航各页面事务层-全部、分类、视频、操作
 */
public interface INavInfoService {

    /**
     * 获取全部直播页面信息列表
     * @param hostInfoDto
     * @return
     */
    Page<HostInfoDto> getAllLiveList(HostInfoDto hostInfoDto);

    /**
     * 根据主播id获取主播信息和主播直播信息
     * @param hostInfoDto
     * @return
     */
    HostInfoDto getHostInfo(HostInfoDto hostInfoDto);

    /**
     * 获取直播分类页面信息列表
     * @param castTypeDto
     * @return
     */
    Page<CastTypeDto> getKindList(CastTypeDto castTypeDto);

    /**
     * 获取单个直播分类信息
     * @param castTypeDto
     * @return
     */
    CastTypeDto getCastType(CastTypeDto castTypeDto);

    /**
     * 根据直播类别获取主播及直播信息列表
     * @param hostInfoDto
     * @return
     */
    Page<HostInfoDto> getLiveListByCastType(HostInfoDto hostInfoDto);

}
