package com.silence.latte.ec.icon;

import com.joanzapata.iconify.Icon;

public enum EcIcons implements Icon {

    icon_test('\ue6ac'),
    icon_test_2('\ue7bf');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace("_", "-");
    }

    @Override
    public char character() {
        return character;
    }
}
