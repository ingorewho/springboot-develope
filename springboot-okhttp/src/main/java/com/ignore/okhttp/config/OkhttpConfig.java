package com.ignore.okhttp.config;

import com.ignore.okhttp.interceptor.OkInterceptor;
import com.ignore.okhttp.interceptor.OkNetInterceptor;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:48 2019/1/31
 */
@Configuration
public class OkhttpConfig {
    @Autowired
    private OkInterceptor okInterceptor;
    @Autowired
    private OkNetInterceptor okNetInterceptor;

    @Bean
    public OkHttpClient okHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(okInterceptor)
                .addNetworkInterceptor(okNetInterceptor)
                .retryOnConnectionFailure(true)
                .sslSocketFactory(getTrustedSSLSocketFactory())
                .hostnameVerifier(DO_NOT_VERIFY)
                .connectionPool(new ConnectionPool(10, 10, TimeUnit.MINUTES));

        return builder.build();
    }

    TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    X509Certificate[] x509Certificates = new X509Certificate[0];
                    return x509Certificates;
                }
                @Override
                public void checkClientTrusted(
                        X509Certificate[] certs, String authType) {
                }
                @Override
                public void checkServerTrusted(
                        X509Certificate[] certs, String authType) {
                }
            }
    };

    HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    private SSLSocketFactory getTrustedSSLSocketFactory() {
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            return sc.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
