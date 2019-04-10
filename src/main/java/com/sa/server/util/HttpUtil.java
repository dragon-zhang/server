/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.sa.server.util;

import com.sa.server.pojo.common.Base64RequestBody;
import com.sa.server.pojo.common.RequestParams;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 使用okhttp请求token和调用服务
 */
public class HttpUtil {

    private OkHttpClient client;
    private static volatile HttpUtil instance;

    private HttpUtil() {
    }

    public static HttpUtil getInstance() {
        if (instance == null) {
            synchronized (HttpUtil.class) {
                if (instance == null) {
                    instance = new HttpUtil();
                }
            }
        }
        return instance;
    }

    public void init() {
        client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .build();
    }

    public String post(String path, RequestParams params) {
        return post(path, "images", params);
    }

    private String post(String path, String key, RequestParams params) {
        long pre = System.currentTimeMillis();
        Base64RequestBody body = new Base64RequestBody();

        body.setKey(key);
        body.setFileParams(params.getFileParams());
        body.setStringParams(params.getStringParams());
        body.setJsonParams(params.getJsonParams());

        final Request request = new Request.Builder()
                .url(path)
                .post(body)
                .build();

        if (client == null) {
            return path;
        }

        Response response;
        try {
            response = client.newCall(request).execute();
            if (response.body() != null) {
                String result = response.body().string();
                long requestTime = (System.currentTimeMillis() - pre) / 1000;
                System.out.println("use " + requestTime + "s,BaiDuApi returns:" + result);
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getAccessToken(String url, String param) {

        RequestBody body = RequestBody.create(MediaType.parse("text/html"), param);
        final Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放资源
     */
    public void release() {
        client = null;
    }
}
