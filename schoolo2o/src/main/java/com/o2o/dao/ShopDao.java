package com.o2o.dao;

import com.o2o.entity.Shop;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/26 9:54
 * @Description 店铺
 */
public interface ShopDao {

    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int intsertShop(Shop shop);
}