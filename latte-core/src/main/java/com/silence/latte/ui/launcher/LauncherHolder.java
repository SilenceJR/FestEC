package com.silence.latte.ui.launcher;

import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.silence.latte.R;

public class LauncherHolder extends Holder<Integer> {


    private AppCompatImageView mIv;

    public LauncherHolder(View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        mIv = itemView.findViewById(R.id.iv);
    }

    @Override
    public void updateUI(Integer data) {
        mIv.setBackgroundResource(data);
    }
}
