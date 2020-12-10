package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.o2o.dao.HeadLineDao;
import com.o2o.entity.HeadLine;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/9 16:48
 * @Description
 */
public class HeadLineDaoTest extends BaseTest {

    @Autowired
    private HeadLineDao headLineDao;

    @Test
    public void testQueryArea() {
        List<HeadLine> headLineList = headLineDao.queryHeadLine(new HeadLine());
        System.out.println(headLineList.size());
    }
}
