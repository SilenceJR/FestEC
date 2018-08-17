package com.silence.latte.ec.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.silence.latte.ec.R;
import com.silence.latte.ec.bean.GankioAndroidBean;
import com.silence.latte.ec.bean.GankioImageBean;
import com.silence.latte.ui.widget.RatioImageView;

import java.util.List;

public class GankioAndroidAdapter extends BaseMultiItemQuickAdapter<GankioAndroidBean, BaseViewHolder>  {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public GankioAndroidAdapter(List<GankioAndroidBean> data) {
        super(data);

        addItemType(GankioAndroidBean.TEXT, R.layout.item_gankio_android);
        addItemType(GankioAndroidBean.TEXT_IMAGE, R.layout.item_gankio_android_image);
        openLoadAnimation();
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(View view) {
        return super.createBaseViewHolder(view);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankioAndroidBean item) {
        helper.setText(R.id.item_tv, item.getDesc());
        AppCompatImageView iv = helper.getView(R.id.item_iv);
        if (null != item.getImages() && 0 != item.getImages().size()) {
            Glide.with(mContext)
                    .load(item.getImages().get(0))
                    .into(iv);
        }
    }

}
