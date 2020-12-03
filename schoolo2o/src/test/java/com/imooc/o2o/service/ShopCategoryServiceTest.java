package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.o2o.entity.Area;
import com.o2o.entity.ShopCategory;
import com.o2o.service.AreaService;
import com.o2o.service.ShopCategoryService;
import com.o2o.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/3 15:02
 * @Description
 */
public class ShopCategoryServiceTest extends BaseTest {

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopCategoryService shopCategoryService;

    @Autowired
    private AreaService areaService;

    @Test
    public void testgetShopCategoryList(){
        Map<String,Object> modelMap = new HashMap<>();
        List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
        List<Area> areaList = new ArrayList<Area>();

        shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
        areaList = areaService.getAreaList();
        modelMap.put("shopCategoryList", shopCategoryList);
        modelMap.put("areaList", areaList);


    }
}
