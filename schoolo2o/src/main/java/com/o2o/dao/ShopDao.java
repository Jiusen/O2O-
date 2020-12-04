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

    /**
     * 更新店铺
     * @param shop
     * @return
     */
    int updateShop(Shop shop);

    /**
     * 通过shop id查询店铺
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);
}
