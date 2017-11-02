package com.example.asdf.myapplication.util;
import  okhttp3.OkHttpClient;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 麦 on 2017/10/18.
 */

public class HttpUtil {
    public static void sendOkHttpRequests(String address,okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        //Request是OkHttp中访问的请求，Builder是辅助类。Response即OkHttp中的响应。
        Request request = new Request.Builder().url(address).build();
       client.newCall(request).enqueue(callback);
    }
}
