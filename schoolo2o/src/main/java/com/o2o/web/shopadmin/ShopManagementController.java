package com.o2o.web.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.enums.ShopStateEnum;
import com.o2o.service.ShopService;
import com.o2o.util.HttpServletRequestUtil;
import com.o2o.util.ImageUtil;
import com.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/27 13:45
 * @Description
 */
@Controller
@RequestMapping("/shop")
public class ShopManagementController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/registershop", method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> registerShop(HttpServletRequest request){

        Map<String,Object> modelMap = new HashMap<>();

        //1、接受并转化响应的参数，包括店铺信息以及图片信息
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (Exception e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }

        //图片信息
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(request)){ //判断是否有文件流
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg"); //得到文件上传流水
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "上传图片不能为空");
            return modelMap;
        }

        //2、注册店铺
        if (shop != null && shopImg != null){
            PersonInfo owner = new PersonInfo();
            owner.setUserId(1L);
            shop.setOwner(owner);
            File shopImgFile = new File(PathUtil.getImgBasePath() + ImageUtil.getRandomFileName());
            try {
                shopImgFile.createNewFile();
            } catch (IOException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.getMessage());
                return modelMap;
            }
            try {
                inputStreamToFile(shopImg.getInputStream(), shopImgFile);
            } catch (IOException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.getMessage());
                return modelMap;
            }
            ShopExecution shopExecution = shopService.addShop(shop, shopImgFile); //店铺注册
            if (shopExecution.getState() == ShopStateEnum.CHECK.getState()){
                modelMap.put("success", true);
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", shopExecution.getStateInfo());
            }
            return modelMap;
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入店铺信息");
            return modelMap;
        }
        //3、返回结果
    }

    /**
     * InputStream => File
     * @param inputStream
     * @param file
     */
    private static void inputStreamToFile(InputStream inputStream, File file){
        OutputStream outputStream = null;
        try{
            outputStream = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = inputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            throw new RuntimeException("调用inputStreamToFile产生异常: " + e.getMessage());
        } finally {
            /*
             每当try块完成（成功与否）时，它将尝试关闭finally块中的流（ inputStream和outputStream ），但是当inputStream.read(buffer))可能失败，您需要检查首先，如果它不是null否则你将获得NPE。
             */
            try {
                if (outputStream != null){
                    outputStream.close();
                }
                if (inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e){
                throw new RuntimeException("inputStreamToFile关闭io产生异常: " + e.getMessage());
            }
        }
    }
}
