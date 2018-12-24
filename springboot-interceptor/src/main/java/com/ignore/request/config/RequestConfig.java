package com.ignore.request.config;

import com.ignore.request.config.interceptor.RequestInterceptor;
import com.ignore.request.config.listener.RequestListener;
import com.ignore.request.config.listener.RequestSessionListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: ignore1992
 * @Description: 拦截器配置
 * @Date: Created In 14:46 2018/12/24
 */
@Configuration
public class RequestConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**");
    }

    /**
     * 显示注册http session监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean listenerRegist(){
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();
        registrationBean.setListener(new RequestSessionListener());
        return registrationBean;
    }
}
