package com.bawei.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.R;

/*
 *@Auther:李伯康
 *@Date: 20190507
 *@Description:基类
 * */public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        bindView();
        bindData();
        bindEvent();
    }

    //绑定视图
    public abstract int bindLayout();
    //绑定控件
    public abstract void bindView();
    //绑定数据
    public abstract void bindData();
    //绑定监听
    public abstract void bindEvent();
}
