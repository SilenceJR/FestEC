package com.silence.latte.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.yokeyword.fragmentation.SwipeBackLayout;
import me.yokeyword.fragmentation_swipeback.core.ISwipeBackActivity;
import me.yokeyword.fragmentation_swipeback.core.SwipeBackActivityDelegate;

public class BaseSwipeBackActivity extends BaseActivity implements ISwipeBackActivity {

    private SwipeBackActivityDelegate DELEGATE = new SwipeBackActivityDelegate(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DELEGATE.onCreate(savedInstanceState);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        DELEGATE.onPostCreate(savedInstanceState);
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return DELEGATE.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        DELEGATE.setSwipeBackEnable(enable);
    }

    @Override
    public void setEdgeLevel(SwipeBackLayout.EdgeLevel edgeLevel) {
        DELEGATE.setEdgeLevel(edgeLevel);
    }

    @Override
    public void setEdgeLevel(int widthPixel) {
        DELEGATE.setEdgeLevel(widthPixel);
    }

    @Override
    public boolean swipeBackPriority() {
        return DELEGATE.swipeBackPriority();
    }
}
