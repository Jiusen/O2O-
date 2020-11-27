package com.o2o.service.impl;

import com.o2o.dao.ShopDao;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;
import com.o2o.enums.ShopStateEnum;
import com.o2o.exceptions.ShopOperationException;
import com.o2o.service.ShopService;
import com.o2o.util.ImageUtil;
import com.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/27 9:42
 * @Description
 */
@Service
public class ShopServiceimpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    /**
     * 事务操作
     * @param shop
     * @param shopImg
     * @return
     */
    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, File shopImg) {
        //空值判断
        if(shop == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }

        try{
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectedNum = shopDao.intsertShop(shop);
            if (effectedNum <= 0){
                throw new ShopOperationException("店铺创建失败"); //事务终止，回滚
            } else {
                //存储图片
                try{
                    addShopImg(shop, shopImg);
                } catch (Exception e){
                    throw new ShopOperationException("addShopImg error: " + e.getMessage());
                }
                //更新店铺的图片地址
                effectedNum = shopDao.updateShop(shop);
                if (effectedNum <= 0){
                    throw new ShopOperationException("更新图片地址失败"); //事务终止，回滚
                }
            }
        } catch (Exception e){
            throw new ShopOperationException("addShop error: " + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.stateOf(shop.getEnableStatus()));
    }

    /**
     * 得到处理后的图片的地址
     * @param shop
     * @param shopImg
     */
    private void addShopImg(Shop shop, File shopImg) {
        //获取shop图片目录的相对值路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
        shop.setShopImg(shopImgAddr);
    }
}
