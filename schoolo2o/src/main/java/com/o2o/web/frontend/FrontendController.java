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

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String index(HttpServletResponse response) {
        //后续进行拦截器配置
        response.setContentType("text/html;charset=utf-8");
        return "frontend/index";
    }
}
