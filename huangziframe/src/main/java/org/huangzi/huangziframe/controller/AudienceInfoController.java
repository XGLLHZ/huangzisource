package org.huangzi.huangziframe.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.AudienceInfoDto;
import org.huangzi.huangziframe.service.IAudienceInfoService;
import org.huangzi.huangziframe.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/17 22:08
 * @description: 观众表-前端控制器
 */
@RestController
@RequestMapping("/api/audience")
public class AudienceInfoController {

    @Autowired
    IAudienceInfoService audienceInfoService;

    /**
     * 获取观众信息列表
     * @param audienceInfoDto
     * @return 列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public BaseResult list(AudienceInfoDto audienceInfoDto){
        BaseResult baseResult =new BaseResult();
        Page<AudienceInfoDto> page = audienceInfoService.list(audienceInfoDto);
        List<AudienceInfoDto> list = page.getRecords();
        baseResult.setList(list);
        baseResult.setCurrentPage(audienceInfoDto.getCurrentPage());
        baseResult.setPageSize(audienceInfoDto.getPageSize());
        return baseResult;
    }

    /**
     * 获取单个观众信息
     * @param audienceInfoDto id
     * @return 单个
     */
    @RequestMapping("/get")
    @ResponseBody
    public AudienceInfoDto get(AudienceInfoDto audienceInfoDto){
        return audienceInfoService.getById(audienceInfoDto.getId());
    }

    /**
     * 新增
     * @param audienceInfoDto
     * @return 是否新增成功
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Integer insert(AudienceInfoDto audienceInfoDto){
        return audienceInfoService.insert(audienceInfoDto);
    }

    /**
     * 删除
     * @param audienceInfoDto id
     * @return 是否删除成功
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Integer delete(AudienceInfoDto audienceInfoDto){
        return audienceInfoService.delete(audienceInfoDto.getId());
    }

    /**
     * 修改
     * @param audienceInfoDto
     * @return 是否修改成功
     */
    @RequestMapping("/update")
    @ResponseBody
    public Integer update(AudienceInfoDto audienceInfoDto){
        return audienceInfoService.update(audienceInfoDto);
    }

}
