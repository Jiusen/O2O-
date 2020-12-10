package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.o2o.dao.ShopDao;
import com.o2o.dto.ImageHolder;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Area;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.ShopCategory;
import com.o2o.enums.ShopStateEnum;
import com.o2o.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/27 10:18
 * @Description
 */
public class ShopServiceTest extends BaseTest {

    @Autowired
    private ShopService shopService;

    @Test
    public void testQueryShopList(){
        Shop shopCondition = new Shop();
        ShopExecution shopExecutionhopExecution = shopService.getShopList(shopCondition, 1, 3);
        System.out.println("店铺总数为: " + shopExecutionhopExecution.getCount());
        System.out.println("店铺列表数为: " + shopExecutionhopExecution.getShopList().size());
        System.out.println(shopExecutionhopExecution.getShopList().get(0).getShopId());
        System.out.println(shopExecutionhopExecution.getShopList().get(1).getShopId());
        System.out.println(shopExecutionhopExecution.getShopList().get(2).getShopId());
    }

    @Test
    public void testModifyShop() throws FileNotFoundException {
        Shop shop = new Shop();
        shop.setShopId(12L);
        shop.setShopName("修改后的店铺名称");
        File shopImg = new File("D:/Jiusenproject/image/dabai.jpg");
        InputStream shopInputStream = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder("dabai.jpg", shopInputStream);
        ShopExecution shopExecution = shopService.modifyShop(shop, imageHolder);
        System.out.println("新的店铺图片地址: " + shopExecution.getShop().getShopImg());
    }

    @Test
    public void testUpdateShop() throws FileNotFoundException {

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
        shop.setShopName("火树科技");
        shop.setShopDesc("数据改变医疗");
        shop.setShopAddr("浙江省杭州市西湖区古荡联合大厦10楼");
        shop.setPhone("15137742640");
        shop.setAdvice("审核中");
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        File shopImg = new File("D:/Jiusenproject/image/xiaohuangren.jpg");
        InputStream inputStream = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder(shopImg.getName(), inputStream);
        ShopExecution shopExecution = shopService.addShop(shop,imageHolder);
        System.out.println(shopExecution.getState());
    }

    @Test
    public void getShopList() {
        Shop shopCondtion = new Shop();
        Shop shopCondition = compactShopCondition4Search(12, -1, -1, "小黄人");
        int pageIndex = 1;
        int pageSize = 3;
        ShopExecution se = shopService.getShopList(shopCondition, pageIndex, pageSize);
        System.out.println("exit");
    }

    private Shop compactShopCondition4Search(long parentId, long shopCategoryId, int areaId, String shopName) {
        Shop shopCondition = new Shop();
        if (parentId != -1L) {
            //查询某一级ShopCategory下面所有二级ShopCategory里面的店铺列表
            ShopCategory childCategory = new ShopCategory();
            ShopCategory parentCategory = new ShopCategory();
            parentCategory.setShopCategoryId(parentId);
            childCategory.setParent(parentCategory);
            shopCondition.setShopCategory(childCategory);
        }
        if (shopCategoryId != -1L) {
            //查询某个二级ShopCategory下面的店铺列表
            ShopCategory shopCategory = new ShopCategory();
            shopCategory.setShopCategoryId(shopCategoryId);
            shopCondition.setShopCategory(shopCategory);
        }
        if (areaId != -1L) {
            //查询位于某个区域Id下的店铺列表
            Area area = new Area();
            area.setAreaId(areaId);
            shopCondition.setArea(area);
        }
        if (shopName != null) {
            //查询名字里包含shopName的店铺列表
            System.out.println(shopName);
            shopCondition.setShopName(shopName);
        }
        //前端展示的店铺都是审核成功的店铺
        shopCondition.setEnableStatus(1);
        return shopCondition;
    }
}
