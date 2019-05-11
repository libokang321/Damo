package com.bawei.bean;

/*
 *@Auther:李伯康
 *@Date: 20190507
 *@Description:bean类
 * */public class JsonBean {
     private String imageUrl;
     private String name;
     private String summary;

    public JsonBean(String imageUrl, String name, String summary) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.summary = summary;
    }

    public JsonBean() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "JsonBean{" +
                "imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
