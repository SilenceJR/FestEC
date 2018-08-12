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
}
