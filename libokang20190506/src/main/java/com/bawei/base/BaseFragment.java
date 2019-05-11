package com.bawei.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
 *@Auther:李伯康
 *@Date: 20190507
 *@Description:基类
 * */public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(bindLayout(),container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
