package com.o2o.service.impl;

import com.o2o.dao.AreaDao;
import com.o2o.entity.Area;
import com.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/25 15:17
 * @Description
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;


    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
