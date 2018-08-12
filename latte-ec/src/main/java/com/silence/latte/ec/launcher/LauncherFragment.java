package com.silence.latte.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.silence.latte.delegates.LatteFragment;
import com.silence.latte.ec.R;
import com.silence.latte.ec.R2;
import com.silence.latte.ec.main.index.AppBottomFragment;
import com.silence.latte.ec.main.top.AppTopFragment;
import com.silence.latte.ec.ui.fragment.AppFragment;
import com.silence.latte.ui.launcher.ScrollLauncherTag;
import com.silence.latte.util.storage.LattePreference;
import com.silence.latte.util.timer.BaseTimerTask;
import com.silence.latte.util.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

@SuppressWarnings("ALL")
public class LauncherFragment extends LatteFragment implements ITimerListener {

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer;
    private Timer mTimer = null;
    private int mCount = 5;

    @Override
    public Object setLayout() {
        return R.layout.fragment_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask timerTask = new BaseTimerTask(this);
        mTimer.schedule(timerTask, 0, 1000);
    }

    private void checkIsShowScroll() {
        if (!LattePreference.getAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name())) {
            startWithPop(LauncherScrollFragment.newInstance());
        } else {
            startWithPop(AppTopFragment.newInstance());
        }
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (null != mTvTimer) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (null != mTimer) {
                            mTimer.cancel();
                            mTimer = null;
                            checkIsShowScroll();
                        }
                    }
                }
            }
        });
    }

    @OnClick(R2.id.tv_launcher_timer)
    public void onViewClicked() {
        if (null != mTimer) {
            mTimer.cancel();
            mTimer = null;
            checkIsShowScroll();
        }
    }

}
