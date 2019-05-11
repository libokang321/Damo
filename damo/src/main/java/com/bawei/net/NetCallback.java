package com.bawei.net;

/*
 *@Auther:姓名
 *@Date: 时间
 *@Description:功能
 * */public interface NetCallback {

    //     响应成功
    void onSuccess(String result);

    //     响应失败
    void onFial(String msg);
}
