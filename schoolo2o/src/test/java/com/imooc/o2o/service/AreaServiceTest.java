package com.imooc.o2o.service;

import com.imooc.o2o.BaseTest;
import com.o2o.entity.Area;
import com.o2o.service.CacheService;
import com.o2o.service.impl.AreaServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/25 16:29
 * @Description
 */
public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaServiceImpl areaService;
    @Autowired
    private CacheService cacheService;

    @Test
    public void testQueryArea() {
        List<Area> areaList = areaService.getAreaList();
        System.out.println(areaList.size() + "+++++");
        cacheService.removeFromCache(areaService.AREALISTKEY);
        areaList = areaService.getAreaList();
    }
}
