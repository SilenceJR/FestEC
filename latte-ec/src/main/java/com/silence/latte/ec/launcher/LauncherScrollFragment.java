package com.silence.latte.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.silence.latte.delegates.LatteFragment;
import com.silence.latte.ec.R;
import com.silence.latte.ec.register.RegisterFragment;
import com.silence.latte.ui.launcher.LauncherHolderCreator;
import com.silence.latte.ui.launcher.ScrollLauncherTag;
import com.silence.latte.util.storage.LattePreference;

import java.util.ArrayList;

public class LauncherScrollFragment extends LatteFragment implements OnItemClickListener {

    private ConvenientBanner<Integer> mConvenientBanner = null;
    private static final ArrayList<Integer> INTEGERS = new ArrayList<>();

    public static LauncherScrollFragment newInstance() {

        Bundle args = new Bundle();

        LauncherScrollFragment fragment = new LauncherScrollFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private void initBanner() {
        INTEGERS.add(R.drawable.launcher_01);
        INTEGERS.add(R.drawable.launcher_02);
        mConvenientBanner.setPages(new LauncherHolderCreator(), INTEGERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setCanLoop(false)
                .setOnItemClickListener(this);
    }

    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initBanner();

    }

    @Override
    public void onItemClick(int position) {
        if (position == INTEGERS.size() - 1) {
            LattePreference.setAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name(), true);
            //检测用户是否登录

            startWithPop(RegisterFragment.newInstance());
        }
    }

}
