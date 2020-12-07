package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.o2o.dao.ProductCategoryDao;
import com.o2o.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/7 9:39
 * @Description
 */
public class ProductCategoryDaoTest extends BaseTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testQueryByShopId() throws Exception{
        long shopId = 11;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println("该店铺自定义类别数: " + productCategoryList.size());
    }

    @Test
    public void testBatchInsertProductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("商品类别3");
        productCategory.setPriority(1);
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(11L);

        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setProductCategoryName("商品类别4");
        productCategory2.setPriority(4);
        productCategory2.setCreateTime(new Date());
        productCategory2.setShopId(14L);

        List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
        productCategoryList.add(productCategory);
        productCategoryList.add(productCategory2);
        int effectNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
        System.out.println(effectNum);
    }

    @Test
    public void testdeleteProductCategory(){
        long shopId = 11;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);

        for (ProductCategory pc : productCategoryList) {
            if ("商品类别1".equals(pc.getProductCategoryName()) || "商品类别2".equals(pc.getProductCategoryName())) {
                int effectedNum = productCategoryDao.deleteProductCategory(pc.getProductCategoryId(), shopId);
                System.out.println(effectedNum);
            }
        }
    }
}
