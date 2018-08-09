package com.silence.latte.util.timer;

import java.util.TimerTask;

public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener ITimerListener) {
        mITimerListener = ITimerListener;
    }

    @Override
    public void run() {
        if (null != mITimerListener) {
            mITimerListener.onTimer();
        }
    }
}
