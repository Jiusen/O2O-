package com.o2o.service;

import com.o2o.dto.WechatAuthExecution;
import com.o2o.entity.WechatAuth;
import com.o2o.exceptions.WechatAuthOperationException;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/14 11:22
 * @Description
 */
public interface WechatAuthService {
    /**
     * 通过openId查找平台对应的微信帐号
     *
     * @param openId
     * @return
     */
    WechatAuth getWechatAuthByOpenId(String openId);

    /**
     * 注册本平台的微信帐号
     *
     * @param wechatAuth
     * @return
     * @throws RuntimeException
     */
    WechatAuthExecution register(WechatAuth wechatAuth) throws WechatAuthOperationException;
}
