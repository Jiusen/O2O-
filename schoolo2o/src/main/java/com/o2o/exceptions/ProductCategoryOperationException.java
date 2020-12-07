package com.o2o.exceptions;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/27 10:08
 * @Description
 */
public class ProductCategoryOperationException extends RuntimeException{

    private static final long serialVersionUID = -1712944541812052571L;

    public ProductCategoryOperationException(String msg){
        super(msg);
    }
}
