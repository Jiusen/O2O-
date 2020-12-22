package com.o2o.web.local;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/local")
public class LocalController {
	/**
	 * 绑定帐号页路由
	 * 
	 * @return
	 */
	@RequestMapping(value = "/accountbind", method = RequestMethod.GET)
	private String accountbind(HttpServletResponse response) {
		//后续进行拦截器配置
		response.setContentType("text/html;charset=utf-8");
		return "local/accountbind";
	}
	/**
	 * 修改密码页路由
	 * 
	 * @return
	 */
	@RequestMapping(value = "/changepsw", method = RequestMethod.GET)
	private String changepsw(HttpServletResponse response) {
		//后续进行拦截器配置
		response.setContentType("text/html;charset=utf-8");
		return "local/changepsw";
	}	
	/**
	 * 登录页路由
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	private String login(HttpServletResponse response) {
		//后续进行拦截器配置
		response.setContentType("text/html;charset=utf-8");
		return "local/login";
	}	
}
