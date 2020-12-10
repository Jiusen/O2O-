package com.o2o.util;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/26 15:27
 * @Description 路径处理类
 */
public class PathUtil {

    /**
     * 系统属性-文件分隔符
     */
    private static String seperator = System.getProperty("file.separator");

    /**
     * 得到图片存储的根地址
     * @return
     */
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:/Jiusenproject/image/";
        } else {
            basePath = "/home/Jiusenproject/image/";
        }
        basePath = basePath.replace("/",seperator);
        return  basePath;
    }

    /**
     * 得到商铺图片
     * @param shopId 商铺id
     * @return
     */
    public static String getShopImagePath(long shopId){
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/",seperator);
    }

    /**
     * 得到头条图片
     *
     * @return
     */
    public static String getHeadLineImagePath() {
        String imagePath = "/upload/images/item/headtitle/";
        return imagePath.replace("/", seperator);
    }

    /**
     * 得到店铺分类图片
     *
     * @return
     */
    public static String getShopCategoryPath() {
        String imagePath = "/upload/images/item/shopcategory/";
        return imagePath.replace("/", seperator);
    }
}