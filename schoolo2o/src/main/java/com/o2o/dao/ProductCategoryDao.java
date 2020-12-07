package com.o2o.dao;

import com.o2o.entity.ProductCategory;

import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/7 9:27
 * @Description
 */
public interface ProductCategoryDao {

    /**
     * 通过shop id查询店铺商品类别
     *
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategoryList(long shopId);
}
