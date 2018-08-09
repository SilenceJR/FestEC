package com.silence.festec;

import android.os.Handler;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;

import com.silence.latte.activity.ProxyActivity;
import com.silence.latte.delegates.LatteFragment;
import com.silence.latte.ec.launcher.LauncherFragment;
import com.silence.latte.ec.launcher.LauncherScrollFragment;

import java.util.regex.Pattern;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteFragment setRootDelegate() {
        return new LauncherFragment();

    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }





}
