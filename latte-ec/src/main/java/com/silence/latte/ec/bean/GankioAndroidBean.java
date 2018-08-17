package com.silence.latte.ec.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class GankioAndroidBean extends GankioBean implements MultiItemEntity{

    public static int TEXT = 1;
    public static int TEXT_IMAGE = 2;

    @Override
    public int getItemType() {
        return null == getImages()|| 0==getImages().size() ? TEXT: TEXT_IMAGE;
    }

    @Override
    public String toString() {
        return "GankioAndroidBean{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                ", images=" + images +
                '}';
    }
}
