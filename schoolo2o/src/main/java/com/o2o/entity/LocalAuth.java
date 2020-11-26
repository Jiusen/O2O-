package com.o2o.entity;

import java.util.Date;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/25 14:03
 * @Description 本地账号
 */
public class LocalAuth {
    private Long localAuthId;
    private String username;
    private String password;
    private Date ceateTime;
    private Date lastEditTime;
    private PersonInfo personInfo;
    public Long getLocalAuthId() {
        return localAuthId;
    }
    public void setLocalAuthId(Long localAuthId) {
        this.localAuthId = localAuthId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getCeateTime() {
        return ceateTime;
    }
    public void setCeateTime(Date ceateTime) {
        this.ceateTime = ceateTime;
    }
    public Date getLastEditTime() {
        return lastEditTime;
    }
    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
    public PersonInfo getPersonInfo() {
        return personInfo;
    }
    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
