package com.ignore.okhttp.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: ignore1992
 * @Description: 全局拦截器
 * @Date: Created In 16:10 2019/1/31
 */
@Component
public class OkInterceptor implements Interceptor{
    private Logger logger = LogManager.getLogger();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startTime = System.currentTimeMillis();
        Response response = chain.proceed(request);
        long endTime = System.currentTimeMillis();
        System.out.println("请求耗时: " + (endTime - startTime) + "ms");
        return response;
    }
}
