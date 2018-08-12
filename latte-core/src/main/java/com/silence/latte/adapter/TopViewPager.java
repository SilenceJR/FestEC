package com.silence.latte.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.ViewGroup;

import com.joanzapata.iconify.widget.IconTextView;
import com.silence.latte.R;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class TopViewPager extends PagerAdapter {

    private LinkedHashMap<CharSequence, CharSequence> ITEMS = null;
    private Context mContext;

    public TopViewPager(Context context, LinkedHashMap<CharSequence, CharSequence> ITEMS) {
        this.ITEMS = ITEMS;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return ITEMS.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = View.inflate(mContext, R.layout.bottom_item_icon_text_layout, null);
        IconTextView icon = view.findViewById(R.id.icon_bottom_item);
        AppCompatTextView title = view.findViewById(R.id.tv_bottom_item);
        for (Map.Entry<CharSequence, CharSequence> item : ITEMS.entrySet()) {
            CharSequence key = item.getKey();
            CharSequence value = item.getValue();
            icon.setText(key);
            title.setText(value);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
