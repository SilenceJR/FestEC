package com.silence.latte.ui.buttom;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author Silence
 */
public final class ItemBuilder {

    private final LinkedHashMap<BottomTabBean, BottomItemFragment> ITEMS = new LinkedHashMap<>();

    static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public final ItemBuilder addItem(BottomTabBean bean, BottomItemFragment fragment) {
        ITEMS.put(bean, fragment);
        return this;
    }

    public final ItemBuilder addItems(LinkedHashMap<BottomTabBean, BottomItemFragment> items) {
        ITEMS.clear();
        ITEMS.putAll(items);
        return this;
    }


    public final LinkedHashMap<BottomTabBean, BottomItemFragment> build() {
        return ITEMS;
    }

}
