package com.silence.latte.ec.bean;

import java.util.List;

public class GankioBean {
    /**
     * _id : 5b6aac809d21226f48f68bf0
     * createdAt : 2018-08-08T16:40:32.198Z
     * desc : 功能完备的Drawable工具箱，通过代码构建种类多样的Drawable，摆脱枯燥重复的drawable.xml文件
     * images : ["https://ww1.sinaimg.cn/large/0073sXn7gy1fu3bhjbgc3g30a00hs1kx","https://ww1.sinaimg.cn/large/0073sXn7gy1fu3bhju7n3j31401z4qh6","https://ww1.sinaimg.cn/large/0073sXn7gy1fu3bhklcekg30a00hs18m","https://ww1.sinaimg.cn/large/0073sXn7gy1fu3bhl25zvj31401z417j"]
     * publishedAt : 2018-08-09T00:00:00.0Z
     * source : web
     * type : Android
     * url : https://github.com/duanhong169/DrawableToolbox
     * used : true
     * who : Hong Duan
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;
    private List<String> images;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
