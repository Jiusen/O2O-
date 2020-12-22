package com.o2o.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2o.cache.JedisUtil;
import com.o2o.dao.ShopCategoryDao;
import com.o2o.dto.ImageHolder;
import com.o2o.dto.ShopCategoryExecution;
import com.o2o.entity.HeadLine;
import com.o2o.entity.ShopCategory;
import com.o2o.enums.ShopCategoryStateEnum;
import com.o2o.exceptions.AreaOperationException;
import com.o2o.exceptions.HeadLineOperationException;
import com.o2o.exceptions.ShopCategoryOperationException;
import com.o2o.service.ShopCategoryService;
import com.o2o.util.ImageUtil;
import com.o2o.util.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/3 14:23
 * @Description 商品类别
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    ShopCategoryDao shopCategoryDao;
    @Autowired
    private JedisUtil.Keys jedisKeys;
    @Autowired
    private JedisUtil.Strings jedisStrings;
    private static Logger logger = LoggerFactory.getLogger(ShopCategoryServiceImpl.class);

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        //定义redis的key的前缀
        String key = SCLISTKEY;
        //定义连接对象
        List<ShopCategory> shopCategoryList = null;
        //定义jackson数据转换操作类
        ObjectMapper mapper = new ObjectMapper();
        //拼接出redis的key
        if (shopCategoryCondition == null) {
            //若查询条件为空，则列出所有首页大类，即parentId为空的店铺类别
            key = key + "_allfirstlevel";
        } else if (shopCategoryCondition != null && shopCategoryCondition.getParent() != null && shopCategoryCondition.getParent().getShopCategoryId() != null) {
            //若parentId为非空，则列出该parentId下的所有子类别
            key = key + "_parent" + shopCategoryCondition.getParent().getShopCategoryId();
        } else if (shopCategoryCondition != null) { //new ShopCategoryCondition()
            //列出所有子类别，不管其属于哪个类，都列出来
            key = key + "_allsecondlevel";
        }
        //判断key是否存在
        if (!jedisKeys.exists(key)) {
            //若不存在，则从数据库里面取出相应数据
            shopCategoryList = shopCategoryDao.queryShopCategory(shopCategoryCondition);
            //将相关的实体类集合转换成String，存入redis里面相应的key中
            String jsonString;
            try {
                jsonString = mapper.writeValueAsString(shopCategoryList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new HeadLineOperationException(e.getMessage());
            }
            jedisStrings.set(key, jsonString);
        } else {
            //若存在，则直接从redis里面取出相应数据
            String jsonString = jedisStrings.get(key);
            //指定要将string转换成的集合类型
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, ShopCategory.class);
            try {
                //将相关的key对应的value里的string转换成对象的实体类集合
                logger.info(jsonString);
                logger.info(javaType.toString());
                shopCategoryList = mapper.readValue(jsonString, javaType);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
                throw new AreaOperationException(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return shopCategoryList;
    }

    @Override
    @Transactional
    public ShopCategoryExecution addShopCategory(ShopCategory shopCategory, ImageHolder thumbnail) {
        // 空值判断
        if (shopCategory != null) {
            // 设定默认值
            shopCategory.setCreateTime(new Date());
            shopCategory.setLastEditTime(new Date());
            if (thumbnail != null) {
                // 若上传有图片流，则进行存储操作，并给shopCategory实体类设置上相对路径
                addThumbnail(shopCategory, thumbnail);
            }
            try {
                // 往数据库添加店铺类别信息
                int effectedNum = shopCategoryDao.insertShopCategory(shopCategory);
                if (effectedNum > 0) {
                    return new ShopCategoryExecution(ShopCategoryStateEnum.SUCCESS, shopCategory);
                } else {
                    return new ShopCategoryExecution(ShopCategoryStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new ShopCategoryOperationException("添加店铺类别信息失败:" + e.toString());
            }
        } else {
            return new ShopCategoryExecution(ShopCategoryStateEnum.EMPTY);
        }
    }

    @Override
    public ShopCategoryExecution modifyShopCategory(ShopCategory shopCategory, ImageHolder thumbnail) {
        return null;
    }

    /**
     * 存储图片
     *
     * @param shopCategory
     * @param thumbnail
     */
    private void addThumbnail(ShopCategory shopCategory, ImageHolder thumbnail) {
        String dest = PathUtil.getShopCategoryPath();
        String thumbnailAddr = ImageUtil.generateNormalImg(thumbnail, dest);
        shopCategory.setShopCategoryImg(thumbnailAddr);
    }


    @Override
    public ShopCategory getShopCategoryById(Long shopCategoryId) {
        return shopCategoryDao.queryShopCategoryById(shopCategoryId);
    }
}
