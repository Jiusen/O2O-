package com.o2o.service;

import com.o2o.dto.ProductCategoryExecution;
import com.o2o.entity.ProductCategory;
import com.o2o.exceptions.ProductCategoryOperationException;

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

    /**
     * 批量插入数据
     *
     * @param productCategoryList
     * @return
     */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;
}
