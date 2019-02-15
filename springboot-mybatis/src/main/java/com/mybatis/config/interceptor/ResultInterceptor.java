package com.mybatis.config.interceptor;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 11:42 2019/2/15
 */
@Intercepts({
        @Signature(type = ResultSetHandler.class, method = "handleResultSets", args={Statement.class})
})
public class ResultInterceptor implements Interceptor{
    private Logger logger = LogManager.getLogger();
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("进入结果处理拦截器.原始对象:{}", invocation);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
