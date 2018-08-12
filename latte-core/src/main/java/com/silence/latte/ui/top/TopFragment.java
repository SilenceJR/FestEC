package com.silence.latte.ui.top;

import android.support.v4.app.Fragment;

public class TopFragment {
    private final String TITLE;
    private final Fragment FRAGMENT;

    public TopFragment(String title, Fragment fragment) {
        this.TITLE = title;
        this.FRAGMENT = fragment;
    }

    public String getTitle() {
        return TITLE;
    }

    public Fragment getFragment() {
        return FRAGMENT;
    }
}
