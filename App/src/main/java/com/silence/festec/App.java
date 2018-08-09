package com.silence.festec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.silence.latte.app.Latte;
import com.silence.latte.ec.icon.FontEcModule;

import cn.jpush.android.api.JPushInterface;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withIcon(new IoniconsModule())
                .withApiHost("http://gank.io")
                .configure();

        JPushInterface.init(this);
        JPushInterface.setDebugMode(true);

    }
}
