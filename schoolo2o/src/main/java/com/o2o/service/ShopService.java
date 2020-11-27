package com.o2o.service;

import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;

import java.io.File;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/27 9:41
 * @Description
 */
public interface ShopService {

    /**
     * 新增店铺
     * @param shop
     * @param shopImg
     * @return
     */
    ShopExecution addShop(Shop shop, File shopImg);
}
