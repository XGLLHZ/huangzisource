package org.huangzi.huangziframe.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.huangzi.huangziframe.dto.CastTypeDto;
import org.huangzi.huangziframe.service.ICastTypeService;
import org.huangzi.huangziframe.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: XGLLHZ
 * @date: 2019/2/17 22:10
 * @description: 直播种类表-前端控制器
 */
@RestController
@RequestMapping("/api/casttype")
public class CastTypeController {

    @Autowired
    ICastTypeService castTypeService;

    /**
     * 获取直播种类信息列表
     * @param castTypeDto 查询参数
     * @return 列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public BaseResult list(CastTypeDto castTypeDto){
        BaseResult baseResult =new BaseResult();
        Page<CastTypeDto> page = castTypeService.list(castTypeDto);
        List<CastTypeDto> list = page.getRecords();
        baseResult.setList(list);
        baseResult.setCurrentPage(castTypeDto.getCurrentPage());
        baseResult.setPageSize(castTypeDto.getPageSize());
        return baseResult;
    }

    /**
     * 获取单个直播种类信息
     * @param castTypeDto id
     * @return 单个
     */
    @RequestMapping("/get")
    @ResponseBody
    public CastTypeDto get(CastTypeDto castTypeDto){
        return castTypeService.getById(castTypeDto.getId());
    }

    /**
     * 新增
     * @param castTypeDto
     * @return 是否新增成功
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Integer insert(CastTypeDto castTypeDto){
        return castTypeService.insert(castTypeDto);
    }

    /**
     * 删除
     * @param castTypeDto id
     * @return 是否删除成功
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Integer delete(CastTypeDto castTypeDto){
        return castTypeService.delete(castTypeDto.getId());
    }

    /**
     * 修改
     * @param castTypeDto
     * @return 是否修改成功
     */
    @RequestMapping("/update")
    @ResponseBody
    public Integer update(CastTypeDto castTypeDto){
        return castTypeService.update(castTypeDto);
    }

    /**
     * 直播类型logo上传
     * @param castTypeDto logo的base64值和文件名
     * @return
     */
    @RequestMapping("/upload")
    public BaseResult uploadImage(@RequestBody CastTypeDto castTypeDto) {
        BaseResult baseResult = new BaseResult();
        baseResult.setOssUrl(castTypeService.uploadImage(castTypeDto.getCastLogo(),castTypeDto.getLogoBase()));
        return baseResult;
    }

    /**
     * 从阿里云获取图片链接
     * @param castTypeDto
     * @return
     */
    @RequestMapping("/geturl")
    public BaseResult getImageUrl(@RequestBody CastTypeDto castTypeDto) {
        BaseResult baseResult = new BaseResult();
        baseResult.setOssUrl(castTypeService.getImageUrl(castTypeDto.getCastLogo()));
        return baseResult;
    }

}
