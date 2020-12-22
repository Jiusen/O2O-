package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.o2o.dao.LocalAuthDao;
import com.o2o.entity.LocalAuth;
import com.o2o.entity.PersonInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/18 16:05
 * @Description
 */
public class LocalAuthDaoTest extends BaseTest {

    @Autowired
    private LocalAuthDao localAuthDao;
    private static final String username = "testusername";
    private static final String password = "testpassword";

    @Test
    public void testInsertLocalAuth() {
        //新增一条平台账号信息
        LocalAuth localAuth = new LocalAuth();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1L);
        //给平台账号绑定上用户信息
        localAuth.setPersonInfo(personInfo);
        localAuth.setUsername(username);
        localAuth.setPassword(password);
        localAuth.setCeateTime(new Date());
        int effectedNum = localAuthDao.insertLocalAuth(localAuth);
        System.out.println(effectedNum);
    }

    @Test
    public void testQueryLocalByUserNameAndPwd() {
        //按照账号和密码查询用户信息
        LocalAuth localAuth = localAuthDao.queryLocalByUserNameAndPwd(username, password);
        System.out.println(localAuth.getPersonInfo().getName());
        System.out.println(localAuth.getUsername());
    }

    @Test
    public void testQueryLocalByUserId() {
        //按照用户Id查询平台账号，进而获取用户信息
        LocalAuth localAuth = localAuthDao.queryLocalByUserId(1L);
        System.out.println(localAuth.getUsername());
        System.out.println(localAuth.getPersonInfo().getEnableStatus());
    }

    @Test
    public void testUpdateLocalAuth() {
        //依据用户Id，平台账号，以及旧密码修改平台账号密码
        Date now = new Date();
        int effectedNum = localAuthDao.updateLocalAuth(1L, username, password,password + "new", now);
        System.out.println(effectedNum);
        //查询出该平台账号的最新信息
        LocalAuth localAuth = localAuthDao.queryLocalByUserId(1L);
        //输出新密码
        System.out.println(localAuth.getPassword());
    }
}
