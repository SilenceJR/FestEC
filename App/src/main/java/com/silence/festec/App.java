package com.silence.festec;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.silence.latte.app.Latte;
import com.silence.latte.ec.icon.FontEcModule;
import com.squareup.leakcanary.LeakCanary;

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

        initStetho();
        LeakCanary.install(this);

    }

    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this)).build());
    }
}
