package com.o2o.exceptions;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/27 10:08
 * @Description
 */
public class ShopOperationException extends RuntimeException{

    private static final long serialVersionUID = -2864678205736653900L;

    public ShopOperationException(String msg){
        super(msg);
    }
}
