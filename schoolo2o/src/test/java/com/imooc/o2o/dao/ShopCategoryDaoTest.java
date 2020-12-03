package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.o2o.dao.AreaDao;
import com.o2o.dao.ShopCategoryDao;
import com.o2o.entity.Area;
import com.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/25 15:10
 * @Description
 */
public class ShopCategoryDaoTest extends BaseTest {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void testQueryArea() {
        List<ShopCategory> areaList = shopCategoryDao.queryShopCategory(new ShopCategory());
        System.out.println(areaList.size() + "+++++");
        ShopCategory testCategory = new ShopCategory();
        ShopCategory parentCategory = new ShopCategory();
        parentCategory.setShopCategoryId(1L);
        testCategory.setParent(parentCategory);
        List<ShopCategory> areaList2 = shopCategoryDao.queryShopCategory(testCategory);
        System.out.println(areaList2.size() + "+++++");
        System.out.println(areaList2.get(0).getShopCategoryName());
    }
}