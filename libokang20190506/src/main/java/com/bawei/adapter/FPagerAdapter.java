package com.bawei.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/*
 *@Auther:李伯康
 *@Date: 20190507
 *@Description:FragmentPagerAdapter适配器
 * */public class FPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<String> list_tab;
    private ArrayList<Fragment> list_frag;

    public FPagerAdapter(FragmentManager fm, ArrayList<String> list_tab, ArrayList<Fragment> list_frag) {
        super(fm);
        this.list_tab = list_tab;
        this.list_frag = list_frag;
    }

    @Override
    public Fragment getItem(int i) {
        return list_frag.get(i);
    }

    @Override
    public int getCount() {
        return list_frag.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list_tab.get(position);
    }
}
