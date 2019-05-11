package com.bawei.utile;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
 *@Auther:李伯康
 *@Date: 20190507
 *@Description:工具类
 * */public class HTTPUtile {
    //单例模式 懒汉式
    private HTTPUtile() {
    }

    private static HTTPUtile utile;

    public synchronized static HTTPUtile getUtile() {
        if (utile == null) {
            utile = new HTTPUtile();
        }
        return utile;
    }

    //get获取数据
    public String getString(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            if (connection.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer buffer = new StringBuffer();
                String str = "";
                while ((str = reader.readLine()) != null){
                    buffer.append(str);
                }
                //关闭流
                reader.close();
                connection.disconnect();
                return buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //创建接口
    public interface CallBackString{
        void getBackString(String string);
    }
    //Asynctask异步处理
    public void getAsyncTaskString(String urlS, final CallBackString backString){
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return getString(strings[0]);
            }

            @Override
            protected void onPostExecute(String string) {
                super.onPostExecute(string);
                backString.getBackString(string);
            }
        }.execute(urlS);
    }

}
