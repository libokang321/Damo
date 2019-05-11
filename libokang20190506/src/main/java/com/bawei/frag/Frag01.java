package com.bawei.frag;

import android.widget.ScrollView;
import android.widget.Toast;

import com.bawei.R;
import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseFragment;
import com.bawei.bean.JsonBean;
import com.bawei.utile.HTTPUtile;
import com.bawei.view.MyListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/*
 *@Auther:李伯康
 *@Date: 20190507
 *@Description:首页页面
 * */public class Frag01 extends BaseFragment {

    private PullToRefreshScrollView scroll;
    private MyListView listView;
    private String url = "http://172.17.8.100/movieApi/movie/v1/findHotMovieList?count=3&page=";
    private int page = 1;
    private ArrayList<JsonBean> list;
    private MyAdapter myAdapter;

    @Override
    public int bindLayout() {
        return R.layout.frag01;
    }

    @Override
    public void bindView() {
        scroll = getView().findViewById(R.id.scroll);
        listView = getView().findViewById(R.id.lv);
    }

    @Override
    public void bindData() {
        //数据
        HTTPUtile.getUtile().getAsyncTaskString(url + page, new HTTPUtile.CallBackString() {
            @Override
            public void getBackString(String string) {
                try {
                    //JSON原生解析
                    JSONObject jsonObject = new JSONObject(string);
                    list = new ArrayList<>();
                    JSONArray result = jsonObject.getJSONArray("result");
                    for (int i = 0; i < result.length(); i++) {
                        JSONObject object = (JSONObject) result.get(i);
                        String imageUrl = object.getString("imageUrl");
                        String name = object.getString("name");
                        String summary = object.getString("summary");
                        list.add(new JsonBean(imageUrl,name,summary));
                    }
                    //适配器
                    myAdapter = new MyAdapter(getActivity(), list);
                    listView.setAdapter(myAdapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //使PullToRefresh可以上拉，下拉均可
        scroll.setMode(PullToRefreshBase.Mode.BOTH);
    }

    @Override
    public void bindEvent() {
        //上下拉事件
        scroll.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            //下拉刷新
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                page = 1;
                HTTPUtile.getUtile().getAsyncTaskString(url + page, new HTTPUtile.CallBackString() {
                    @Override
                    public void getBackString(String string) {
                        try {
                            //JSON原生解析
                            JSONObject jsonObject = new JSONObject(string);
                            list.clear();
                            JSONArray result = jsonObject.getJSONArray("result");
                            for (int i = 0; i < result.length(); i++) {
                                JSONObject object = (JSONObject) result.get(i);
                                String imageUrl = object.getString("imageUrl");
                                String name = object.getString("name");
                                String summary = object.getString("summary");
                                list.add(new JsonBean(imageUrl,name,summary));
                            }
                            //适配器
                            listView.setAdapter(myAdapter);
                            //刷新适配器
                            myAdapter.notifyDataSetChanged();
                            //停止刷新
                            scroll.onRefreshComplete();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            //上拉加载
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                page++;
                HTTPUtile.getUtile().getAsyncTaskString(url + page, new HTTPUtile.CallBackString() {
                    @Override
                    public void getBackString(String string) {
                        try {
                            //JSON原生解析
                            JSONObject jsonObject = new JSONObject(string);
                            JSONArray result = jsonObject.getJSONArray("result");
                            //判断是否有数据
                            if (result.length() == 0){
                                Toast.makeText(getActivity(),"没数据了",Toast.LENGTH_LONG).show();
                                //停止刷新
                                scroll.onRefreshComplete();
                                return;
                            }
                            for (int i = 0; i < result.length(); i++) {
                                JSONObject object = (JSONObject) result.get(i);
                                String imageUrl = object.getString("imageUrl");
                                String name = object.getString("name");
                                String summary = object.getString("summary");
                                list.add(new JsonBean(imageUrl,name,summary));
                            }
                            //刷新适配器
                            myAdapter.notifyDataSetChanged();
                            //停止刷新
                            scroll.onRefreshComplete();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
