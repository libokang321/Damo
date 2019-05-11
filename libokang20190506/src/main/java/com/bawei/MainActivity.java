package com.bawei;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.adapter.FPagerAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.frag.Frag01;
import com.bawei.frag.Frag02;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ViewPager pager;
    private TabLayout tabLayout;
    private ArrayList<String> list_tab;
    private ArrayList<Fragment> list_frag;

    //视图
    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }
    //控件
    @Override
    public void bindView() {
        pager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tablayout);
    }
//数据
    @Override
    public void bindData() {
        //tabLayout数据
        list_tab = new ArrayList<>();
        list_tab.add("首页");
        list_tab.add("我的");
        tabLayout.addTab(tabLayout.newTab().setText(list_tab.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(list_tab.get(1)));
        //fragment数据
        list_frag = new ArrayList<>();
        //添加页面
        list_frag.add(new Frag01());
        list_frag.add(new Frag02());
        //适配器
        FPagerAdapter fPagerAdapter = new FPagerAdapter(getSupportFragmentManager(), list_tab, list_frag);
        pager.setAdapter(fPagerAdapter);
        tabLayout.setupWithViewPager(pager);
    }
//监听
    @Override
    public void bindEvent() {

    }
}
