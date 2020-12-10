package com.o2o.web.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/9 18:45
 * @Description
 */
@Controller
@RequestMapping(value = "/frontend", method = RequestMethod.GET)
public class FrontendController {

    /**
     * 首页路由
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String index(HttpServletResponse response) {
        //后续进行拦截器配置
        response.setContentType("text/html;charset=utf-8");
        return "frontend/index";
    }

    /**
     * 商品详情页路由
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/productdetail", method = RequestMethod.GET)
    private String productdetail(HttpServletResponse response) {
        //后续进行拦截器配置
        response.setContentType("text/html;charset=utf-8");
        return "frontend/productdetail";
    }

    /**
     * 店铺详情页路由
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/shopdetail", method = RequestMethod.GET)
    private String shopdetail(HttpServletResponse response) {
        //后续进行拦截器配置
        response.setContentType("text/html;charset=utf-8");
        return "frontend/shopdetail";
    }

    /**
     * 商品列表页路由
     *
     * @param response
     * @return
     */
    @RequestMapping(value = "/shoplist", method = RequestMethod.GET)
    private String shoplist(HttpServletResponse response) {
        //后续进行拦截器配置
        response.setContentType("text/html;charset=utf-8");
        return "frontend/shoplist";
    }
}
