package com.o2o.service;

import com.o2o.entity.HeadLine;

import java.io.IOException;
import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/9 16:59
 * @Description
 */
public interface HeadLineService {

    public static final String HLLISTKEY = "headlinelist";

    /**
     * 得到头条店铺列表
     *
     * @param headLineCondition
     * @return
     * @throws IOException
     */
    List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException;
}
