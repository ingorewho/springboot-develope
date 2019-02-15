package com.ignore.okhttp.interceptor;

import okhttp3.Interceptor;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: ignore1992
 * @Description: 非网页请求拦截器,并且是在组装完请求之后，真正发起网络请求前被调用
 * @Date: Created In 16:14 2019/1/31
 */
@Component
public class OkNetInterceptor implements Interceptor {
    private Logger logger = LogManager.getLogger();
    @Override
    public Response intercept(Chain chain) throws IOException {
        logger.info("执行非网页请求的拦截器.");
        return chain.proceed(chain.request());
    }
}
