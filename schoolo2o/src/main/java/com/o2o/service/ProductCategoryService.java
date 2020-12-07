package com.o2o.service;

import com.o2o.entity.ProductCategory;

import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/7 9:45
 * @Description
 */
public interface ProductCategoryService {

    /**
     * 查询指定某个店铺下的所有商品类别信息
     *
     * @param shopId
     * @return
     */
    List<ProductCategory> getProductCategoryList(long shopId);
}
