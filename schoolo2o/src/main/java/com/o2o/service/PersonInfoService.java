package com.o2o.service;

import com.o2o.dto.PersonInfoExecution;
import com.o2o.entity.PersonInfo;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/14 10:12
 * @Description
 */
public interface PersonInfoService {

    /**
     * 根据用户id获取personInfo信息
     *
     * @param userId
     * @return
     */
    PersonInfo getPersonInfoById(Long userId);

    /**
     * 根据查询条件分页返回用户信息列表
     *
     * @param personInfoCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PersonInfoExecution getPersonInfoList(PersonInfo personInfoCondition, int pageIndex, int pageSize);

    /**
     * 根据传入的PersonInfo修改对应的用户信息
     *
     * @param personInfo
     * @return
     */
    PersonInfoExecution modifyPersonInfo(PersonInfo personInfo);
}
