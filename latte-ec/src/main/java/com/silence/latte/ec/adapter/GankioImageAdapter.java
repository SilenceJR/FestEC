package com.silence.latte.ec.adapter;

import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.silence.latte.ec.R;
import com.silence.latte.ec.bean.GankioImageBean;
import com.silence.latte.ui.widget.RatioImageView;

import java.util.List;

public class GankioImageAdapter extends BaseQuickAdapter<GankioImageBean, BaseViewHolder> {

    public GankioImageAdapter(@Nullable List<GankioImageBean> data) {
        super(R.layout.item_gankio_image, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankioImageBean item) {
        final RatioImageView iv = (RatioImageView) helper.getView(R.id.iv);
        ViewCompat.setTransitionName(iv, String.valueOf(helper.getAdapterPosition()) + "_image");
        iv.setRatio(0.618F);
        Glide.with(mContext)
                .load(item.getUrl())
                .into(iv);
    }
}
