package com.o2o.dao;

import com.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/3 12:23
 * @Description
 */
public interface ShopCategoryDao {

     List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategory);

}
