package com.silence.latte.ui.top;

import android.support.v4.app.Fragment;

import com.silence.latte.ui.buttom.BottomItemFragment;
import com.silence.latte.ui.buttom.BottomTabBean;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author Silence
 */
public final class ItemBuilder {

    private final LinkedList<TopFragment> ITEMS = new LinkedList<>();

    static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public final ItemBuilder addItem(TopFragment topFragment) {
        ITEMS.add(topFragment);
        return this;
    }

    public final ItemBuilder addItem(String title, Fragment fragment) {
        ITEMS.add(new TopFragment(title, fragment));
        return this;
    }

    public final ItemBuilder addItems(LinkedList<TopFragment> items) {
        ITEMS.clear();
        ITEMS.addAll(items);
        return this;
    }


    public final LinkedList<TopFragment> build() {
        return ITEMS;
    }

}
