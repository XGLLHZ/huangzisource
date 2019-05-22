package org.huangzi.huangziframe.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: XGLLHZ
 * @date: 2019/4/22 21:08
 * @description: OSS对象存储
 */
public class OSSUtil {

    //此五项参数均来自阿里云OSS对象存储
    public final static String endPoint = "http://oss-cn-beijing.aliyuncs.com";   //以北京为例
    public final static String accessKeyId = "LTAIuyM8p0B3hCZe";   //AccessKeyId id
    public final static String accessKeySecret = "GxjhCWuK0LfOsGeCP640AMbu5Hf8HB";   //accessKeySecret 密码
    public final static String bucket = "huangzisource";   //上传的bucket名
    public final static String fileDir = "huangzi/";   //图片保存基路径

    /**
     * 上传图片值阿里云OSS对象存储
     * @param fileName 文件名
*      @param imageBase 图片转换成base64的字符串
     * @return
     */
    public static String uploadImageToOSS(String fileName,String imageBase) {
        //获取阿里云客户端对象
        OSSClient ossClient = new OSSClient(OSSUtil.endPoint,OSSUtil.accessKeyId,OSSUtil.accessKeySecret);
        InputStream inputStream;
        String[] strings = new String[2];
        if (!imageBase.isEmpty()) {
            strings = imageBase.split(",");
            int index = strings[0].indexOf("/");
            int endindex = strings[0].indexOf(";");
            String imageType = strings[0].substring(index+1,endindex);
            String imageName = fileName + "." + imageType;
            String viewImageUrl = "";
            try {
                byte[] bytes = new BASE64Decoder().decodeBuffer(strings[1]);
                inputStream = new ByteArrayInputStream(bytes);
                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentLength(inputStream.available());
                ossClient.putObject(OSSUtil.bucket,fileDir+imageName,inputStream,objectMetadata);
                viewImageUrl = OSSUtil.getImageUrl(imageName,"castlog/");
                ossClient.shutdown();
                return viewImageUrl;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return null;
    }

    /**
     * 获取图片链接
     * @param imageName 图片名称
     * @return
     */
    public static String getImageUrl(String imageName,String fileItemDir) {
        OSSClient ossClient = new OSSClient(OSSUtil.endPoint,OSSUtil.accessKeyId,OSSUtil.accessKeySecret);
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);   //这个好像是有效期
        String url = ossClient.generatePresignedUrl(OSSUtil.bucket,fileDir + fileItemDir + imageName,expiration).toString();
        return url;
    }

    /**
     * 自动生成图片名称
     * @param imageType 图片类型
     * @return
     */
    public static String generateImageName(String imageType) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String imageDate = simpleDateFormat.format(new Date());
        String imageName = imageDate + "." + imageType;
        return imageName;
    }

}
