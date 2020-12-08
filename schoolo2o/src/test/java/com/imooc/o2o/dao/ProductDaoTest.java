package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.o2o.dao.ProductDao;
import com.o2o.dao.ProductImgDao;
import com.o2o.entity.Product;
import com.o2o.entity.ProductCategory;
import com.o2o.entity.Shop;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/7 16:53
 * @Description
 */
public class ProductDaoTest extends BaseTest {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void testAInsertProduct() throws Exception {
        Shop shop1 = new Shop();
        shop1.setShopId(11L);
        ProductCategory pc1 = new ProductCategory();
        pc1.setProductCategoryId(1L);
        // 初始化三个商品实例并添加进shopId为1的店铺里，
        // 同时商品类别Id也为1
        Product product1 = new Product();
        product1.setProductName("测试1");
        product1.setProductDesc("测试Desc1");
        product1.setImgAddr("test1");
        product1.setPriority(1);
        product1.setEnableStatus(1);
        product1.setCreateTime(new Date());
        product1.setLastEditTime(new Date());
        product1.setShop(shop1);
        product1.setProductCategory(pc1);
        // 判断添加是否成功
        int effectedNum = productDao.insertProduct(product1);
        System.out.println(effectedNum);
    }
}