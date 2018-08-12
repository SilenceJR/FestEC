package com.silence.latte.ec.main.index;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silence.latte.ec.R;
import com.silence.latte.ec.ui.fragment.AppFragment;
import com.silence.latte.ui.buttom.BaseButtomFragment;
import com.silence.latte.ui.buttom.BottomItemFragment;
import com.silence.latte.ui.buttom.BottomTabBean;
import com.silence.latte.ui.buttom.ItemBuilder;

import java.util.LinkedHashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppBottomFragment extends BaseButtomFragment {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemFragment> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemFragment> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), GankioImageFragment.newInstance());
        items.put(new BottomTabBean("{fa-sort}", "分类"), AppFragment.newInstance());
        items.put(new BottomTabBean("{fa-compass}", "发现"), IndexFragment.newInstance());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), IndexFragment.newInstance());
        items.put(new BottomTabBean("{fa-user}", "我的"), IndexFragment.newInstance());
        return builder.addItems(items).build();
    }

    public static AppBottomFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AppBottomFragment fragment = new AppBottomFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int setIndexFragment() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
