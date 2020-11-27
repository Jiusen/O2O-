package com.o2o.service;

import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;

import java.io.File;
import java.io.InputStream;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/27 9:41
 * @Description
 */
public interface ShopService {

    /**
     * 新增店铺
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);
}
