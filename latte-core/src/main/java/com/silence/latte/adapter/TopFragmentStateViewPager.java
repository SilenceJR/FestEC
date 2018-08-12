package com.silence.latte.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.silence.latte.ui.top.TopFragment;

import java.util.LinkedList;

public class TopFragmentStateViewPager extends FragmentStatePagerAdapter {

    private LinkedList<TopFragment> ITEMS = null;

    public TopFragmentStateViewPager(FragmentManager fm) {
        super(fm);
    }

    public TopFragmentStateViewPager(FragmentManager fm, LinkedList<TopFragment> ITEMS) {
        super(fm);
        this.ITEMS = ITEMS;
        fm.beginTransaction().commitAllowingStateLoss();
    }

    @Override
    public int getCount() {
        return ITEMS.size();
    }

    @Override
    public Fragment getItem(int position) {
        return ITEMS.get(position).getFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return ITEMS.get(position).getTitle();
    }
}
