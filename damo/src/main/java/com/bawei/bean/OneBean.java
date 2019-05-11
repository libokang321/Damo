package com.bawei.bean;

/*
 *@Auther:姓名
 *@Date: 时间
 *@Description:功能
 * */public class OneBean {

    private String phone;
    private String pwd;

    public OneBean(String phone, String pwd) {
        this.phone = phone;
        this.pwd = pwd;
    }

    public OneBean() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "OneBean{" +
                "phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
