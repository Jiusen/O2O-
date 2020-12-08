package com.o2o.service;

import com.o2o.dto.ImageHolder;
import com.o2o.dto.ProductExecution;
import com.o2o.entity.Product;
import com.o2o.exceptions.ProductCategoryOperationException;

import java.io.InputStream;
import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/7 17:32
 * @Description
 */
public interface ProductService {

    /**
     * 添加商品信息以及图片处理
     *
     * @param product
     * @param thumbnail
     * @param productImgHolderList
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductExecution addProduct(Product product
                                , ImageHolder thumbnail
                                , List<ImageHolder> productImgHolderList)
                                throws ProductCategoryOperationException;

    /**
     * 查询商品列表并分页，可输入的条件有： 商品名（模糊），商品状态， 商铺Id， 商品类别
     * @param productCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);


}
