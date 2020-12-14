package com.o2o.service.impl;

import com.o2o.dao.PersonInfoDao;
import com.o2o.dto.PersonInfoExecution;
import com.o2o.entity.PersonInfo;
import com.o2o.enums.PersonInfoStateEnum;
import com.o2o.exceptions.PersonInfoOperationException;
import com.o2o.service.PersonInfoService;
import com.o2o.util.PageCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/14 10:19
 * @Description
 */
@Service
public class PersonInfoServiceImpl implements PersonInfoService {

    @Autowired
    PersonInfoDao personInfoDao;

    @Override
    public PersonInfo getPersonInfoById(Long userId) {
        return personInfoDao.queryPersonInfoById(userId);
    }

    @Override
    public PersonInfoExecution getPersonInfoList(PersonInfo personInfoCondition, int pageIndex, int pageSize) {
        //页转行
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        //获取用户信息列表
        List<PersonInfo> personInfoList = personInfoDao.queryPersonInfoList(personInfoCondition, rowIndex, pageSize);
        int count = personInfoDao.queryPersonInfoCount(personInfoCondition);
        PersonInfoExecution personInfoExecution = new PersonInfoExecution();
        if (personInfoList != null) {
            personInfoExecution.setPersonInfoList(personInfoList);
            personInfoExecution.setCount(count);
        } else {
            personInfoExecution.setState(PersonInfoStateEnum.INNER_ERROR.getState());
        }
        return personInfoExecution;
    }

    @Override
    @Transactional
    public PersonInfoExecution modifyPersonInfo(PersonInfo personInfo) {
        //空值判断，主要是判断用户的Id是否为空
        if (personInfo == null || personInfo.getUserId() == null) {
            return new PersonInfoExecution(PersonInfoStateEnum.EMPTY);
        } else {
            try {
                //更新用户信息
                int effectedNum = personInfoDao.updatePersonInfo(personInfo);
                if (effectedNum <= 0) {
                    return new PersonInfoExecution(PersonInfoStateEnum.INNER_ERROR);
                } else {
                    personInfo = personInfoDao.queryPersonInfoById(personInfo.getUserId());
                    return new PersonInfoExecution(PersonInfoStateEnum.SUCCESS, personInfo);
                }
            } catch (Exception e) {
                throw new PersonInfoOperationException("updatePersonInfo error: " + e.getMessage());
            }
        }
    }
}
