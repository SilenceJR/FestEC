package com.silence.festec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.silence.latte.app.Latte;
import com.silence.latte.ec.icon.FontEcModule;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://www.baidu.com")
                .configure();
    }
}
