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
import java.util.List;

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

    @Test
    public void testBQueryProductList() throws Exception {
        Product productCondition = new Product();
        // 分页查询，预期返回三条结果
        List<Product> productList = productDao.queryProductList(productCondition, 0, 3);
        System.out.println(productList.size());
        // 查询名称为测试的商品总数
        int count = productDao.queryProductCount(productCondition);
        System.out.println(count);
        // 使用商品名称模糊查询，预期返回两条结果
        productCondition.setProductName("测试");
        productList = productDao.queryProductList(productCondition, 0, 3);
        System.out.println(productList.size());
        count = productDao.queryProductCount(productCondition);
        System.out.println(count);
    }

    @Test
    public void testQueryProductList() {
        Product productCondition = new Product();
        //分页查询，预期返回三条结果
        List<Product> productList = productDao.queryProductList(productCondition, 0, 50);
        System.out.println(productList.size());
        //查询名称包含测试的商品总数
        productCondition.setProductName("测试");
        int count = productDao.queryProductCount(productCondition);
        System.out.println("count: " + count);
        //模糊查询: 名称包含测试的商品总数
        productList = productDao.queryProductList(productCondition, 0, 50);
        System.out.println("包含'测试'的商品名数量: " + productList.size());

    }

    @Test
    public void testInsertProduct() throws Exception {
        Shop shop1 = new Shop();
        shop1.setShopId(14L);
        ProductCategory pc1 = new ProductCategory();
        pc1.setProductCategoryId(1L);
        // 初始化三个商品实例并添加进shopId为1的店铺里，
        // 同时商品类别Id也为1
        Product product1 = new Product();
        product1.setProductName("测试");
        product1.setProductDesc("测试");
        product1.setImgAddr("test1");
        product1.setPriority(1);
        product1.setEnableStatus(1);
        product1.setCreateTime(new Date());
        product1.setLastEditTime(new Date());
        product1.setShop(shop1);
        product1.setProductCategory(pc1);
        Product product2 = new Product();
        product2.setProductName("测试2");
        product2.setProductDesc("测试Desc2");
        product2.setImgAddr("test2");
        product2.setPriority(2);
        product2.setEnableStatus(0);
        product2.setCreateTime(new Date());
        product2.setLastEditTime(new Date());
        product2.setShop(shop1);
        product2.setProductCategory(pc1);
        Product product3 = new Product();
        product3.setProductName("test3");
        product3.setProductDesc("测试Desc3");
        product3.setImgAddr("test3");
        product3.setPriority(3);
        product3.setEnableStatus(1);
        product3.setCreateTime(new Date());
        product3.setLastEditTime(new Date());
        product3.setShop(shop1);
        product3.setProductCategory(pc1);
        // 判断添加是否成功
        int effectedNum = productDao.insertProduct(product1);
        System.out.println(effectedNum);
        effectedNum = productDao.insertProduct(product2);
        System.out.println(effectedNum);
        effectedNum = productDao.insertProduct(product3);
        System.out.println(effectedNum);
    }

    @Test
    public void testUpdateProductCategoryToNull() {
        //将productCategoryId为2的商品类别下面的商品的商品类别置为空
        int effectNum = productDao.updateProductCategoryToNull(2l);
        System.out.println(effectNum);
    }
}
