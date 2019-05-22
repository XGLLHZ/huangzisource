package org.huangzi.huangziframe.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.CastTypeDto;
import org.huangzi.huangziframe.dto.HostInfoDto;
import org.huangzi.huangziframe.mapper.INavInfoMapper;
import org.huangzi.huangziframe.service.INavInfoService;
import org.huangzi.huangziframe.util.OSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/5/21 9:47
 * @description: 首页导航各页面事务层实现类-全部、分类、视频、操作
 */
@Service
public class NavInfoServiceImpl implements INavInfoService {

    private static final String LIUNAME = "huangzi";
    private static final String LIUURL = "rtmp://119.23.234.176:1935/live/";

    @Autowired
    INavInfoMapper navInfoMapper;

    /**
     * 获取全部直播页面信息列表
     * @param hostInfoDto
     * @return
     */
    @Override
    public Page<HostInfoDto> getAllLiveList(HostInfoDto hostInfoDto) {
        Page<HostInfoDto> page = new Page<>(hostInfoDto.getCurrentPage(),hostInfoDto.getPageSize());
        List<HostInfoDto> list = navInfoMapper.getAllLiveList(page,hostInfoDto);
        for (int i = 0;i<list.size();i++) {
            String hostLogo = list.get(i).getHostLogo();
            list.get(i).setLiveLogoUrl(OSSUtil.getImageUrl(hostLogo,"hostlogo/"));
            list.get(i).setHostFansCount(navInfoMapper.getHostFansCount(list.get(i).getId()));
        }
        page.setRecords(list);
        return page;
    }

    /**
     * 获取主播直播页面信息
     * @param hostInfoDto
     * @return
     */
    @Override
    public HostInfoDto getHostInfo(HostInfoDto hostInfoDto) {
        HostInfoDto hostInfoDto1 = navInfoMapper.getHostInfoAndLiveInfo(hostInfoDto.getId());
        hostInfoDto1.setHostFansCount(navInfoMapper.getHostFansCount(hostInfoDto.getId()));
        hostInfoDto1.setLiuUrl(NavInfoServiceImpl.LIUURL);
        return hostInfoDto1;
    }

    /**
     * 获取直播分类页面信息列表
     * @param castTypeDto
     * @return
     */
    @Override
    public Page<CastTypeDto> getKindList(CastTypeDto castTypeDto) {
        Page<CastTypeDto> page = new Page<>(castTypeDto.getCurrentPage(),castTypeDto.getPageSize());
        List<CastTypeDto> list = navInfoMapper.getKindList(page,castTypeDto);
        List<CastTypeDto> list1 = new ArrayList<>();
        for (int i = 0;i<list.size();i++) {
            String csatLogo = list.get(i).getCastLogo();
            list1.add(list.get(i).setCastLogo(OSSUtil.getImageUrl(csatLogo,"castlogo/")));
        }
        page.setRecords(list1);
        return page;
    }

    /**
     * 获取单个直播分类信息
     * @param castTypeDto
     * @return
     */
    @Override
    public CastTypeDto getCastType(CastTypeDto castTypeDto) {
        return navInfoMapper.getCastType(castTypeDto.getId());
    }

    /**
     * 根据直播类别获取主播及直播信息列表
     * @param hostInfoDto
     * @return
     */
    @Override
    public Page<HostInfoDto> getLiveListByCastType(HostInfoDto hostInfoDto) {
        Page<HostInfoDto> page = new Page<>(hostInfoDto.getCurrentPage(),hostInfoDto.getPageSize());
        List<HostInfoDto> list = navInfoMapper.getLiveListByCastType(page,hostInfoDto);
        for (int i = 0;i<list.size();i++) {
            String hostLogo = list.get(i).getHostLogo();
            list.get(i).setLiveLogoUrl(OSSUtil.getImageUrl(hostLogo,"hostlogo/"));
            list.get(i).setHostFansCount(navInfoMapper.getHostFansCount(list.get(i).getId()));
        }
        page.setRecords(list);
        return page;
    }

}
