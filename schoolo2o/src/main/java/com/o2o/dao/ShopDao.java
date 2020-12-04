package com.o2o.dao;

import com.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/26 9:54
 * @Description 店铺
 */
public interface ShopDao {
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int intsertShop(Shop shop);
    /**
     * 更新店铺
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
    /**
     * 通过shop id查询店铺
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);
    /**
     * 分页查询店铺，可输入的条件有：店铺名（模糊）、店铺状态、店铺类别、区域Id、owner
     * @param shopCondition 查询条件
     * @param rowIndex 从第第几行开始取
     * @param pageSize 返回的条数
     * @return
     * ‘@Param’的作用：取值时的唯一标识
     */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);
    /**
     * 返回 queryShopList 总数
     * @param shopCondition
     * @return
     */
    int queryShopCount(@Param("shopCondition")Shop shopCondition);
}
