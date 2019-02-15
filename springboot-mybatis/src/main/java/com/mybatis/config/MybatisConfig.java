package com.mybatis.config;

import com.mybatis.config.interceptor.ExecutorInterceptor;
import com.mybatis.config.interceptor.ResultInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 11:44 2019/2/15
 */
@Configuration
public class MybatisConfig {
    @Bean
    public String interceptor(SqlSessionFactory sqlSessionFactory){
        sqlSessionFactory.getConfiguration().addInterceptor(new ExecutorInterceptor());
        sqlSessionFactory.getConfiguration().addInterceptor(new ResultInterceptor());
        return "interceptor";
    }
}
