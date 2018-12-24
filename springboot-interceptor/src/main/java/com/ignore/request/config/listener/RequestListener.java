package com.ignore.request.config.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:25 2018/12/24
 */
@Component
public class RequestListener implements ApplicationListener<ServletRequestHandledEvent>{
    private Logger logger = LogManager.getLogger();
    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        logger.info("接受到ServletRequestHandledEvent事件:{}", event);
        //销毁当前请求session
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = attributes.getRequest();
        servletRequest.getSession().invalidate();
    }
}
