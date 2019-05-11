package com.bawei.net;

import android.os.Handler;

import com.google.common.io.CharStreams;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

/*
 *@Auther:姓名
 *@Date: 时间
 *@Description:功能
 * */public class HttpUtile {

    private static final HttpUtile ourInstance = new HttpUtile();
    private Handler mHandler;

    public static HttpUtile getInstance(){
        return ourInstance;
    }
    private HttpUtile(){
        mHandler = new Handler();
    }
    //post 请求数据
    public void doHttpPost(final String url, final Map<String,String> param, final NetCallback callback){
        new Thread(){
            public void run(){
                //请求网络
                HttpURLConnection connection = null;
                try {
                    URL url1 = new URL(url);
                    connection = (HttpURLConnection) url1.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    //向服务器写入数据
                    String body = paramToString(param);
                    connection.setDoOutput(true);
                    connection.getOutputStream().write(body.getBytes());

                    if (connection.getResponseCode() == 200){
                        final String result = CharStreams.toString(new InputStreamReader(connection.getInputStream()));
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.onSuccess(result);
                            }
                        });
                    }
                } catch (final Exception e) {
                    e.printStackTrace();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFial(e.getMessage());
                        }
                    });
                }
            }

        }.start();
    }
    //把 param转成字符串
    private String paramToString(Map<String , String> param){
        StringBuilder stringBuilder = new StringBuilder();
        //变量map
        for (Map.Entry<String, String> entry : param.entrySet()) {
//            把 Map Entry的键和值封装成参数
            stringBuilder.append(entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode(entry.getValue()));
            stringBuilder.append("&");
        }
        return stringBuilder.toString().substring(0,stringBuilder.toString().length() - 1);
    }

}
