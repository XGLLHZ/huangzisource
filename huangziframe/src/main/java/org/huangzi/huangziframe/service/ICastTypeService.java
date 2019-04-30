package org.huangzi.huangziframe.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.huangzi.huangziframe.dto.CastTypeDto;

/**
 * @author: XGLLHZ
 * @date: 2019/2/14 23:32
 * @description: 直播种类表事务层
 */
public interface ICastTypeService {

    /**
     * 列表
     * @param castTypeDto 查询参数
     * @return 列表
     */
    Page<CastTypeDto> list(CastTypeDto castTypeDto);

    /**
     * 总数
     * @return 总数
     */
    Integer getTotal();

    /**
     * 查询单个
     * @param id id
     * @return 单个信息
     */
    CastTypeDto getById(int id);

    /**
     * 新增
     * @param castTypeDto
     * @return 是否新增成功
     */
    Integer insert(CastTypeDto castTypeDto);

    /**
     * 删除
     * @param id id
     * @return 是否删除成功
     */
    Integer delete(int id);

    /**
     * 修改
     * @param castTypeDto
     * @return 是否修改成功
     */
    Integer update(CastTypeDto castTypeDto);

    /**
     * 直播类型logo上传
     * @param fileName logo的base64值
     * @param imageBase logo的文件名
     * @return
     */
    String uploadImage(String fileName,String imageBase);

    /**
     * 获取图片在阿里云的链接
     * @param fileName 文件名+.png
     * @return
     */
    String getImageUrl(String fileName);

}
