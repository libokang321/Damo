package com.bawei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bawei.base.BaseActivity;

public class Main2Activity extends BaseActivity {

    private WebView web;

    //视图
    @Override
    public int bindLayout() {
        return R.layout.activity_main2;
    }
    //控件
    @Override
    public void bindView() {
        web = findViewById(R.id.web);
    }
    //数据
    @Override
    public void bindData() {
        web.loadUrl("file:///android_asset/Baway.html");
        web.setWebViewClient(new WebViewClient());
    }
    //监听
    @Override
    public void bindEvent() {

    }
}
