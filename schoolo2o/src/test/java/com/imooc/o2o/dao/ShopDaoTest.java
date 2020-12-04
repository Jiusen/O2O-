package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.o2o.dao.ShopDao;
import com.o2o.entity.Area;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/26 10:38
 * @Description 店铺测试
 */
public class ShopDaoTest extends BaseTest {

    @Autowired
    private ShopDao shopDao;

    @Test
    public void testQueryShopList(){
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1L);
        shopCondition.setShopCategory(shopCategory);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("店铺列表的大小: " + shopList.size());
        System.out.println("店铺总数: " + count);
    }

    @Test
    public void testQueryByShopId(){
        long shopId = 11;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println("areaId: " + shop.getArea().getAreaId());
        System.out.println("areaId: " + shop.getArea().getAreaName());
    }

    @Test
    public void testInsertShop(){
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1l);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1l);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.intsertShop(shop);
        System.out.println("insert受影响的行数: " + effectedNum);
    }

    @Test
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(1l);
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1l);
        shop.setShopName("firesooon");
        shop.setShopDesc("数据改变医疗");
        shop.setShopAddr("杭州西湖古荡");
        shop.setPhone("15137742640");
        shop.setShopImg("无");
        shop.setLastEditTime(new Date());
        shop.setAdvice("已通过");
        int effectedNum = shopDao.updateShop(shop);
        System.out.println("update受影响的行数: " + effectedNum);
    }
}
