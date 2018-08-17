package com.silence.latte.ui.top;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.silence.latte.R;
import com.silence.latte.R2;
import com.silence.latte.adapter.TopFragmentViewPager;
import com.silence.latte.delegates.LatteFragment;

import java.util.LinkedList;

import butterknife.BindView;

public abstract class BaseTopFragment extends LatteFragment implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R2.id.view_page)
    ViewPager mViewPager;
    @BindView(R2.id.toolbar)
    Toolbar mToolbar;
    @BindView(R2.id.navigation)
    NavigationView mNavigationView;
    @BindView(R2.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R2.id.drawer_layout)
    DrawerLayout mDrawerLayout;


    private final LinkedList<TopFragment> ITEMS = new LinkedList<>();


    public abstract LinkedList<TopFragment> setItems(ItemBuilder builder);


    @Override
    public Object setLayout() {
        return R.layout.fragment_top;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ItemBuilder builder = ItemBuilder.builder();
        LinkedList<TopFragment> items = setItems(builder);
        ITEMS.clear();
        ITEMS.addAll(items);
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initToolbar();
        initView();

    }

    private void initToolbar() {
        mToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
    }

    protected void initView() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(_mActivity, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);


        final int size = ITEMS.size();
        for (int i = 0; i < size; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(ITEMS.get(i).getTitle()));
        }
        TopFragmentViewPager adapter = new TopFragmentViewPager(getChildFragmentManager(), ITEMS);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
