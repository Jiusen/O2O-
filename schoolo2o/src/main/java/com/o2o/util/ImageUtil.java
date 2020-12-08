package com.o2o.util;

import com.o2o.dto.ImageHolder;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/26 14:39
 * @Description
 */
public class ImageUtil {

    //得到resources的路径
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    private static Logger logger =LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 将 CommonsMultipartFile 转化为 File
     * @param cFile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile){
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * 生成缩略图->文件存储
     * @param thumbnail 图片文件输入流\文件名
     * @param targetAddr 目标地址
     * @return 返回新的图片的相对地址（目的：换机器的话，直接从数据库得到图片地址，不需要再更换BasePath，解耦）
    */
    public static String generateThumbnail(ImageHolder thumbnail, String targetAddr){
        String realFileName = getRandomFileName(); //文件名
        String extension = getFileExtension(thumbnail.getImageName()); //扩展名：.jsp
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;  //图片相对路径
        logger.debug("current relativeAddr is: " + relativeAddr);
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr); //图片在机器上的URL
        logger.debug("dest complete addr is: " + dest);
        try{
            Thumbnails.of(thumbnail.getImageName()).size(200,200)
                    .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                    .outputQuality(0.8f)
                    .toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径上所涉及的目录，即 /home/Jiusenproject/image/xxx.jpg
     * 那么 home Jiusenproject image 这三个文件夹都得自动创建
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFielParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFielParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件名的扩展名
     * @param fileName 文件名
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机的文件（当前年月日时分秒 + 5位随机数）
     * @return
     */
    public static String getRandomFileName() {
        //获取随机的5位数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sdf.format(new Date());
        return nowTimeStr + rannum;
    }

    /**
     * 图片压缩例子
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("D:/Jiusenproject/image/xiaohuangren.jpg"))
                .size(200,200).watermark(Positions.BOTTOM_RIGHT,
                ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f).outputQuality(0.8f)
            .toFile("D:/Jiusenproject/image/xiaohuangrennew.jpg");
    }

    /**
     * storePath是文件的路径还是目录的路径，
     * 如果storePath是文件路径则删除该文件
     * 如果storePath是目录路径则删除该目录下的所有文件
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath){
        File fileOrPath = new File(PathUtil.getImgBasePath() +storePath);
        if (fileOrPath.exists()){
            if (fileOrPath.isDirectory()){
                File[] files = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++) { //删除目录下的所有文件
                    files[i].delete();
                }
            }
            fileOrPath.delete(); //删除目录 or 文件
        }
    }
}