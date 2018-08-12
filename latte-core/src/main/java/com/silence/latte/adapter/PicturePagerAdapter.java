package com.silence.latte.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.LinkedList;

public class PicturePagerAdapter extends PagerAdapter {

    public static final int ADD_FRONT = -1;
    public static final int ADD_END = 1;
    public static final int ADD_NONE = 0;

    private LinkedList<String> mItems;

    public void initList(LinkedList<String> items) {
        this.mItems = items;
    }

    public int appendList(int page, LinkedList<String> items) {
        if (0 == getCount()) {
            return ADD_NONE;
        }
        return ADD_NONE;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
