package com.ignore.request.config.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: ignore1992
 * @Description: 定义请求拦截
 * @Date: Created In 14:25 2018/12/24
 */
public class RequestInterceptor implements HandlerInterceptor {
    private Logger logger = LogManager.getLogger();
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse , Object o) throws Exception {
        //前置处理
        //获取session，没有则创建
        httpServletRequest.getSession();
        logger.info("执行拦截器前置处理");
        String token = httpServletRequest.getParameter("token");
        logger.info("http请求中token值为:{}", token);
        if (StringUtils.isEmpty(token) || !token.equals("123456")){
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse , Object o , ModelAndView modelAndView) throws Exception {
        //后置处理
        logger.info("执行拦截器后置处理");
        int status = httpServletResponse.getStatus();
        logger.info("http返回码:{}", status);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse , Object o , Exception e) throws Exception {
        logger.info("执行拦截器回调函数处理");
    }
}
