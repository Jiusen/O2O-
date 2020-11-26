package com.o2o.web.superadmin;

import com.o2o.entity.Area;
import com.o2o.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/25 16:46
 * @Description
 */
@Controller
@RequestMapping("/superAdmin")
public class AreaController {

    //日志记录
    Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private AreaService areaService;

    /*
        得到所有区域
        返回json到前端
    */
    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> listArea(){
        logger.info("===start===");
        long startTime = System.currentTimeMillis();
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Area> list = new ArrayList<>();
        try{
            list = areaService.getAreaList();
            modelMap.put("rows",list);
            modelMap.put("total",list.size());
        } catch (Exception e){
            logger.error("error message: " + e.getMessage());
            e.printStackTrace();
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
        }
        long endTime = System.currentTimeMillis();
        logger.debug("costTime:[{}ms]", endTime - startTime);
        logger.info("===end===");
        return modelMap;
    }
}
