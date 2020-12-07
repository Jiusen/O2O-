package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.o2o.dao.ProductCategoryDao;
import com.o2o.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}
