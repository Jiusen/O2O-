package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.o2o.dao.PersonInfoDao;
import com.o2o.entity.PersonInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/15 20:04
 * @Description
 */
public class PersonInfoDaoTest  extends BaseTest {

    @Autowired
    private PersonInfoDao personInfoDao;

    @Test
    public void testInnsertPersonInfo() {
        //设置新增的用户信息
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName("我爱你");
        personInfo.setGender("女");
        personInfo.setUserType(1);
        personInfo.setCreateTime(new Date());
        personInfo.setLastEditTime(new Date());
        personInfo.setEnableStatus(1);
        int effectedNum = personInfoDao.insertPersonInfo(personInfo);
        System.out.println(effectedNum);
    }

    @Test
    public void testQueryPersonInfoById() {
        long userId = 1;
        //查询Id为1的用户信息
        PersonInfo person = personInfoDao.queryPersonInfoById(userId);
        System.out.println(person.getName());
    }
}
