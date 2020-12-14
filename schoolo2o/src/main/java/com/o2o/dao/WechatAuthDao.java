package com.o2o.dao;

import com.o2o.entity.WechatAuth;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/14 10:56
 * @Description
 */
public interface WechatAuthDao {

    /**
     * 通过openId查询对应本平台的微信账号
     *
     * @param openId
     * @return
     */
    WechatAuth queryWechatInfoByOpenId(String openId);

    /**
     * 添加对应本平台的微信账号
     *
     * @param wechatAuth
     * @return
     */
    int insertWechatAuth(WechatAuth wechatAuth);
}
