package com.bawei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.R;
import com.bawei.bean.JsonBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/*
 *@Auther:李伯康
 *@Date: 20190507
 *@Description:BaseAdapter适配器
 * */public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<JsonBean> list;

    public MyAdapter(Context context, ArrayList<JsonBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)){
            case 0:
                ViewHondler01 hondler01 = null;
                if (view == null){
                    view = View.inflate(context,R.layout.item01,null);
                    hondler01 = new ViewHondler01();
                    hondler01.img11 = view.findViewById(R.id.img11);
                    hondler01.img12 = view.findViewById(R.id.img12);
                    hondler01.tv11 = view.findViewById(R.id.tv11);
                    hondler01.tv12 = view.findViewById(R.id.tv12);
                    view.setTag(hondler01);
                }else {
                    hondler01 = (ViewHondler01) view.getTag();
                }
                JsonBean jsonBean = list.get(i);
                Glide.with(context).load(jsonBean.getImageUrl()).into(hondler01.img11);
                Glide.with(context).load(jsonBean.getImageUrl()).into(hondler01.img12);
                hondler01.tv12.setText(jsonBean.getSummary());
                hondler01.tv11.setText(jsonBean.getName());
                break;
            case 1:
                ViewHondler02 hondler02 = null;
                if (view == null){
                    view = View.inflate(context,R.layout.item02,null);
                    hondler02 = new ViewHondler02();
                    hondler02.img21 = view.findViewById(R.id.img21);
                    hondler02.tv21 = view.findViewById(R.id.tv21);
                    view.setTag(hondler02);
                }else {
                    hondler02 = (ViewHondler02) view.getTag();
                }
                JsonBean jsonBean2 = list.get(i);
                Glide.with(context).load(jsonBean2.getImageUrl()).into(hondler02.img21);
                hondler02.tv21.setText(jsonBean2.getName());
                break;
        }
        return view;
    }
    class ViewHondler01{
        ImageView img11;
        ImageView img12;
        TextView tv11;
        TextView tv12;
    }
    class ViewHondler02{
        ImageView img21;
        TextView tv21;
    }
    //多条目
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }
}
