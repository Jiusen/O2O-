package com.o2o.dao;

import com.o2o.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 批量新增商品类别
     *
     * @param productCategoryList
     * @return
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    /**
     *
     * @param productCategoryId 商品类别id
     * @param ShopId 商铺id
     * @return 删除某个商铺下的某个商品
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long ShopId);
}
