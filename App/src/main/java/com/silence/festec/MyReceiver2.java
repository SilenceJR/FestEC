package com.silence.festec;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.service.JPushMessageReceiver;

public class MyReceiver2 extends JPushMessageReceiver {

    private static final String TAG = "JIGUANG";
    public static String regId;
}
