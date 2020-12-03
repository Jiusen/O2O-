package com.o2o.service;

import com.o2o.entity.ShopCategory;

import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/3 14:21
 * @Description 商品类别服务
 */
public interface ShopCategoryService {
    /**
     * 店铺类别列表
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
