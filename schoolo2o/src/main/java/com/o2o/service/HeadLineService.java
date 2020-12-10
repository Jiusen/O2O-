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

    List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException;
}
