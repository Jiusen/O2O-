package com.o2o.enums;

import com.o2o.dto.ShopExecution;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/26 17:40
 * @Description
 */
public enum ShopStateEnum {

    CHECK(0,"审核中"),

    OFFLINE(-1,"非法店铺"),

    SUCCESS(1,"操作成功"),

    PASS(2,"通过认证"),

    INNER_ERROR(-1001,"内部系统错误"),

    NULL_SHOPID(-1002,"ShopId为空");


    private int state;
    private String stateInfo;

    /**
     * 不希望第三方使用、修改
     * @param state
     * @param stateInfo
     */
    private ShopStateEnum(int state, String stateInfo){
        this.state = state;
        this.stateInfo = stateInfo;
    }

    /**
     * 根据传入的state返回响应的enum值
     * @param state
     * @return
     */
    public static ShopStateEnum stateOf(int state){
        for(ShopStateEnum stateEnum : values()){
            if(stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
