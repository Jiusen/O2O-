package com.o2o.util;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/4 16:56
 * @Description
 */
public class PageCalculator {
    public static int calculateRowIndex(int pageIndex, int pageSize){
        return (pageIndex > 0) ? (pageIndex - 1)*pageSize:0;
    }
}
