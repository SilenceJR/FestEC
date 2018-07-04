package com.silence.festec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.silence.latte.activity.ProxyActivity;
import com.silence.latte.app.Latte;
import com.silence.latte.delegates.LatteDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new AppDelegate();
    }
}
