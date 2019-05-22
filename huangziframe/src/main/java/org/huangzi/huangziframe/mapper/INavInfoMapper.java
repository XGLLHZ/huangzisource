package org.huangzi.huangziframe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.huangzi.huangziframe.dto.CastTypeDto;
import org.huangzi.huangziframe.dto.HostInfoDto;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/5/21 9:37
 * @description: 首页导航各页面mapper-全部、分类、视频、操作
 */
public interface INavInfoMapper extends BaseMapper<HostInfoDto> {

    /**
     * 获取全部直播页面信息
     * @param page
     * @param hostInfoDto
     * @return
     */
    List<HostInfoDto> getAllLiveList(Page<HostInfoDto> page,@Param("condition") HostInfoDto hostInfoDto);

    /**
     * 获取主播粉丝数量
     * @param id
     * @return
     */
    int getHostFansCount(@Param("condition") int id);

    /**
     * 获取主播信息和主播直播信息
     * @param id
     * @return
     */
    HostInfoDto getHostInfoAndLiveInfo(@Param("condition") int id);

    /**
     * 获取直播分类页面信息列表
     * @param page
     * @param castTypeDto
     * @return
     */
    List<CastTypeDto> getKindList(Page<CastTypeDto> page,@Param("condition") CastTypeDto castTypeDto);

    /**
     * 获取单个直播分类信息
     * @param id
     * @return
     */
    CastTypeDto getCastType(@Param("condition") int id);

    /**
     * 根据直播类别获取主播及直播信息列表
     * @param hostInfoDto
     * @param page
     * @return
     */
    List<HostInfoDto> getLiveListByCastType(Page<HostInfoDto> page,@Param("condition") HostInfoDto hostInfoDto);

}
