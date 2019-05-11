package com.bawei.mvp;

import android.content.Context;

import com.bawei.bean.OneBean;
import com.bawei.net.NetCallback;

import java.util.Map;

/*
 *@Auther:姓名
 *@Date: 时间
 *@Description:功能
 * */
public interface IUserContract {

    public interface IUserView {
        //注册成功
        void zcSucceed(String result);

        // 注册失败
        void zcFail();

        // 登录成功
        void dlSucceed(String result);

        // 登录失败
        void dlFail();
    }
    //用户 M 接口
    public interface IUserModel{
        void doHttpPost(String url, Map<String,String> param, NetCallback callback);
    }

    public interface IUserPresenter{
//        绑定VIew
        void attach(IUserView view);
//        解绑 释放内存
        void detach();
//        注册业务逻辑
        void regist(OneBean oneBean);
//        绑定VIew
        void login(OneBean oneBean);

        OneBean inputToUser(String phone,String pwd);
        //跳转到主页面
        void toMain(Context context);
    }
}
