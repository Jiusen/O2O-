package com.o2o.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Jiusen Guo
 * @Date 2020/12/3 17:57
 * @Description 验证码工具类
 */
public class CodeUtil {

    /**
     * 判断验证码是否一致
     * @param request
     * @return
     */
    public static boolean checkVerifyCode(HttpServletRequest request){
        //真正的验证码
        String verifyCodeExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //实际输入的验证码
        String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");

        if(verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)){
            return false;
        }
        return true;
    }
}
