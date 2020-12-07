package com.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Jiusen Guo
 * @Date 2020/11/27 17:54
 * @Description
 */
@Controller
@RequestMapping(value = "shopadmin", method = { RequestMethod.GET })
public class ShopAdminController {

    @RequestMapping(value = "/shopoperation")
    public String shopOperation(HttpServletResponse response) {
        //后续进行拦截器配置
        response.setContentType("text/html;charset=utf-8");
        // 转发至店铺注册/编辑页面
        return "shop/shopoperation";
    }

    @RequestMapping(value = "/shoplist")
    public String shopList(HttpServletResponse response) {
        //后续进行拦截器配置
        response.setContentType("text/html;charset=utf-8");
        // 转发至店铺注册/编辑页面
        return "shop/shoplist";
    }

    @RequestMapping(value = "/shopmanagement")
    public String shopmanagement(HttpServletResponse response) {
        //后续进行拦截器配置
        response.setContentType("text/html;charset=utf-8");
        // 转发至店铺注册/编辑页面
        return "shop/shopmanagement";
    }

    @RequestMapping(value = "/productcategorymanagement", method = RequestMethod.GET)
    public String productCategoryManage(HttpServletResponse response) {
        //后续进行拦截器配置
        response.setContentType("text/html;charset=utf-8");
        // 转发至店铺注册/编辑页面
        return "shop/productcategorymanagement";
    }
}
