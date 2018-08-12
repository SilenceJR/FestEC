package com.silence.festec;

import com.silence.latte.activity.ProxyActivity;
import com.silence.latte.delegates.LatteFragment;
import com.silence.latte.ec.launcher.LauncherFragment;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteFragment setRootDelegate() {
        return new LauncherFragment();

    }




}
