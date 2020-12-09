package com.o2o.service;

import com.o2o.dto.ImageHolder;
import com.o2o.dto.ProductExecution;
import com.o2o.entity.Product;
import com.o2o.exceptions.ProductCategoryOperationException;
import com.o2o.exceptions.ProductOperationException;

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
                                throws ProductOperationException;

    /**
     * 查询商品列表并分页，可输入的条件有： 商品名（模糊），商品状态， 商铺Id， 商品类别
     * @param productCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);

    /**
     * 通过商品id查询唯一的商品信息
     *
     * @param productId
     * @return
     */
    Product getProductById(long productId);

    /**
     * 修改商品信息以及图片处理
     *
     * @param product
     * @param thumbnail 缩略图、文件流
     * @param productImageHolderImgs 商品详情图列表
     * @return
     */
    ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImageHolderImgs) throws ProductOperationException;

}
