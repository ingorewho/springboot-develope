package com.ignore.okhttp.process;

import com.ignore.okhttp.callback.OkCallback;
import com.ignore.okhttp.config.OkhttpConfig;
import com.ignore.okhttp.entity.Header;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 18:05 2019/1/30
 */
@Component
public class ProcessOkhttp {
    @Autowired
    private OkHttpClient client;
    @Autowired
    private OkCallback callback;
    /**
     * 同步执行get请求
     * @param url
     * @return
     */
    public  String get(String url, Header header){
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        if (header != null) {
            builder.addHeader(header.getName(), header.getValue());
        }
        Call call = client.newCall(builder.build());
        try {
            Response response = call.execute();
            return response.body().string();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 异步执行get请求
     * @param url
     */
    public  void getAsync(String url, Header header){
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        if (header != null) {
            builder.addHeader(header.getName(), header.getValue());
        }
        Call call = client.newCall(builder.build());
        //提交异步请求，回调函数来处理结果
        call.enqueue(callback);
    }

    public  String post(String url, Header header, RequestBody requestBody){
        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(requestBody);
        if (header != null) {
            builder.addHeader(header.getName(), header.getValue());
        }
        Call call = client.newCall(builder.build());
        try {
            Response response = call.execute();
            return response.body().string();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 异步执行post
     * @param url
     * @param requestBody
     */
    public  void postAsync(String url, Header header,RequestBody requestBody){
        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(requestBody);
        if (header != null) {
            builder.addHeader(header.getName(), header.getValue());
        }
        Call call = client.newCall(builder.build());
        call.enqueue(callback);
    }
}
