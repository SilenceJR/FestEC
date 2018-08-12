package com.silence.latte.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.silence.latte.ui.top.TopFragment;

import java.util.LinkedList;

public class TopFragmentViewPager extends FragmentPagerAdapter {

    private LinkedList<TopFragment> ITEMS = null;
    private FragmentManager mFm;

    public TopFragmentViewPager(FragmentManager fm) {
        super(fm);
    }

    public TopFragmentViewPager(FragmentManager fm, LinkedList<TopFragment> ITEMS) {
        super(fm);
        mFm = fm;
        this.ITEMS = ITEMS;
        fm.beginTransaction().commitAllowingStateLoss();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        mFm.beginTransaction().show(fragment).commit();
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        Fragment fragment = ITEMS.get(position).getFragment();
        mFm.beginTransaction().hide(fragment).commit();
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
