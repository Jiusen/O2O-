package com.o2o.entity;

import java.util.Date;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/25 14:02
 * @Description 微信账号信息
 */
public class WechatAuth {
    private Long wechatAuthId;
    private Long openId;
    private Date createTime;
    private PersonInfo personInfo;
    public Long getWechatAuthId() {
        return wechatAuthId;
    }
    public void setWechatAuthId(Long wechatAuthId) {
        this.wechatAuthId = wechatAuthId;
    }
    public Long getOpenId() {
        return openId;
    }
    public void setOpenId(Long openId) {
        this.openId = openId;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public PersonInfo getPersonInfo() {
        return personInfo;
    }
    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}