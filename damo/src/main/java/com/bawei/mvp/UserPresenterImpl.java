package com.bawei.mvp;

import android.content.Context;
import android.content.Intent;

import com.bawei.MainActivity;
import com.bawei.bean.OneBean;
import com.bawei.net.NetCallback;

import java.util.HashMap;
import java.util.Map;

/*
 *@Auther:姓名
 *@Date: 时间
 *@Description:功能
 * */public class UserPresenterImpl implements IUserContract.IUserPresenter {

     private IUserContract.IUserView view;
     private IUserContract.IUserModel model;
    @Override
    public void attach(IUserContract.IUserView view) {
        this.view = view;
        model = new UserModelImpl();
    }

    @Override
    public void detach() {
        if (view!= null){
            view = null;
        }
        if (model != null){
            model = model;
        }
    }

    @Override
    public void regist(OneBean oneBean) {
        Map<String,String> param = new HashMap<>();
        param.put("phone",oneBean.getPhone());
        param.put("pwd",oneBean.getPwd());
        String url = "http://172.17.8.100/small/user/v1/register";
        model.doHttpPost(url, param, new NetCallback() {
            @Override
            public void onSuccess(String result) {
                view.zcSucceed(result);
            }

            @Override
            public void onFial(String msg) {
                view.zcFail();
            }
        });
    }

    @Override
    public void login(OneBean oneBean) {
        Map<String , String> param = new HashMap<>();
        param.put("phone",oneBean.getPhone());
        param.put("pwd",oneBean.getPwd());
        String url = "http://172.17.8.100/small/user/v1/register";
        model.doHttpPost(url, param, new NetCallback() {
            @Override
            public void onSuccess(String result) {
                view.dlSucceed(result);
            }

            @Override
            public void onFial(String msg) {
                view.dlFail();
            }
        });
    }

    @Override
    public OneBean inputToUser(String phone, String pwd) {
        OneBean oneBean = new OneBean(phone, pwd);
        return oneBean;
    }

    @Override
    public void toMain(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
