package com.silence.latte.ec.main.top;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.silence.latte.ec.ui.fragment.AppFragment;
import com.silence.latte.ui.top.BaseTopFragment;
import com.silence.latte.ui.top.TopFragment;

import java.util.LinkedList;

import me.yokeyword.fragmentation.ISupportFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppTopFragment extends BaseTopFragment {

    public static AppTopFragment newInstance() {

        Bundle args = new Bundle();

        AppTopFragment fragment = new AppTopFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public LinkedList<TopFragment> setItems(com.silence.latte.ui.top.ItemBuilder builder) {
        final LinkedList<TopFragment> items = new LinkedList<>();
        items.add(new TopFragment("主页", GankioAndroidFragment.newInstance()));
        items.add(new TopFragment("分类", AppFragment.newInstance()));
        items.add(new TopFragment("发现", GankioImageFragment.newInstance()));
        items.add(new TopFragment("购物车", IndexFragment.newInstance()));
        items.add(new TopFragment("我的", IndexFragment.newInstance()));
        return builder.addItems(items).build();
    }

}
