package com.imooc.o2o.dao;

import com.imooc.o2o.BaseTest;
import com.o2o.dao.WechatAuthDao;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.WechatAuth;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/16 9:31
 * @Description
 */
public class WechatAuthDaoTest extends BaseTest {

    @Autowired
    private WechatAuthDao wechatAuthDao;

    @Test
    public void testInsertWechatAuth() {
        //新增一条微信账号
        WechatAuth wechatAuth = new WechatAuth();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1L);
        //给微信账号绑定上用户信息
        wechatAuth.setPersonInfo(personInfo);
        //随意设置上openId
        wechatAuth.setOpenId("322222243");
        wechatAuth.setCreateTime(new Date());
        int effectedNum = wechatAuthDao.insertWechatAuth(wechatAuth);
        System.out.println(effectedNum);
    }

    @Test
    public void testQueryWechatAuthByOpenId() {
        WechatAuth wechatAuth = wechatAuthDao.queryWechatInfoByOpenId("o3J4D6HfAJ4nauBjCXonnWo9W1-M");
        System.out.println(wechatAuth.getPersonInfo().getName());
    }
}
