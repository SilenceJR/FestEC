package com.silence.latte.activity;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;
import android.view.KeyEvent;
import android.widget.Toast;

import com.silence.latte.R;
import com.silence.latte.delegates.LatteFragment;

import me.yokeyword.fragmentation.SupportActivity;

public abstract class ProxyActivity extends SupportActivity {

    public abstract LatteFragment setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState) {
        @SuppressLint("RestrictedApi") final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);

        setContentView(container);
        if (null == savedInstanceState) {
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    @Override
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {
            if (isExit) {
                super.onBackPressedSupport();
            } else {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_LONG).show();
                isExit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                }, 2000);
            }
        } else {
            super.onBackPressedSupport();
        }
    }

    private boolean isExit = false;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
