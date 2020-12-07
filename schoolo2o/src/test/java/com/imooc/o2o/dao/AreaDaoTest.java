package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.o2o.dao.AreaDao;
import com.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/25 15:10
 * @Description
 */
public class AreaDaoTest extends BaseTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea() {
        List<Area> areaList = areaDao.queryArea();
        System.out.println(areaList.size() + "+++++");
    }
}