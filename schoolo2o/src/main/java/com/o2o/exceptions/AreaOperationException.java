package com.o2o.exceptions;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/17 17:49
 * @Description
 */
public class AreaOperationException extends RuntimeException{


    private static final long serialVersionUID = -7359155501360876172L;

    public AreaOperationException(String message) {
        super(message);
    }
}
