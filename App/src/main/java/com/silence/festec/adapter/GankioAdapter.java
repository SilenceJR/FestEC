package com.silence.festec.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.silence.festec.R;
import com.silence.festec.moder.GankioModer;

import java.util.List;

public class GankioAdapter extends BaseQuickAdapter<GankioModer.ResultsBean, BaseViewHolder> {

    public GankioAdapter(@Nullable List<GankioModer.ResultsBean> data) {
        super(R.layout.item_gankio, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankioModer.ResultsBean item) {
        helper.setText(R.id.tv_1, item.getContent());
    }
}
