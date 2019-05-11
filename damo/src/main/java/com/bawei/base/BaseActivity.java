package com.bawei.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.R;

/*
 *@Auther:姓名
 *@Date: 时间
 *@Description:功能
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
