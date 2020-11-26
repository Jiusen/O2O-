package com.o2o.dao;

import com.o2o.entity.Area;
import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/25 15:04
 * @Description
 */
public interface AreaDao {
    /**
     * 列出区域列表
     * @return areaList
     */
    List<Area> queryArea();
}
