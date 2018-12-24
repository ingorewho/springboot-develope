package com.ignore.request.config.listener;

import org.apache.catalina.SessionEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author: ignore1992
 * @Description: Session监听器
 * @Date: Created In 16:40 2018/12/24
 */
public class RequestSessionListener implements HttpSessionListener {
    private Logger logger = LogManager.getLogger();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("session创建:{}", se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("session销毁:{}", se.getSession().getId());
    }
}
