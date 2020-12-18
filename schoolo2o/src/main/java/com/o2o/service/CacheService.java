package com.o2o.service;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/18 10:54
 * @Description
 */
public interface CacheService {

    /**
     * 依据key前缀删除匹配该模式下的所有的key-value 如传入：shopcategory, 则删除shopcategory_allfirstlevel等
     * 以shopcategory打头的key_value都会被清空
     *
     * @param keyPrefix
     */
    void removeFromCache(String keyPrefix);
}
