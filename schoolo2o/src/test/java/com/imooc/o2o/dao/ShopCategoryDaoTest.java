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
        List<ShopCategory> areaList = shopCategoryDao.queryShopCategory(null);
        System.out.println(areaList.get(0).getShopCategoryName());
    }
}