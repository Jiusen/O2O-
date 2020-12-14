package com.o2o.dao;

import com.o2o.entity.PersonInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/14 9:44
 * @Description
 */
public interface PersonInfoDao {

    /**
     * 根据查询条件分页返回用户信息列表
     *
     * @param personInfoCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    List<PersonInfo> queryPersonInfoList(@Param("personInfoCondition") PersonInfo personInfoCondition, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    /**
     * 根据查询条件返回总数，配合queryPersonInfoList使用
     *
     * @param personInfoCondition
     * @return
     */
    int queryPersonInfoCount(@Param("personInfoCondition") PersonInfo personInfoCondition);

    /**
     * 通过用户id查询用户
     *
     * @param userId
     * @return
     */
    PersonInfo queryPersonInfoById(long userId);

    /**
     * 添加用户信息
     *
     * @param personInfo
     * @return
     */
    int insertPersonInfo(PersonInfo personInfo);

    /**
     * 修改用户信息
     *
     * @param personInfo
     * @return
     */
    int updatePersonInfo(PersonInfo personInfo);
}
