package com.silence.latte.util.storage;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.silence.latte.app.Latte;

public class LattePreference {

    private static final SharedPreferences PREFERENCES = PreferenceManager.getDefaultSharedPreferences(Latte.getApplication());
    private static final String APP_PREFERENCES_KEY = "profile";

    public static SharedPreferences getAppPreference() {
        return PREFERENCES;
    }

    public static void setAppProFile(String value) {
        getAppPreference()
                .edit()
                .putString(APP_PREFERENCES_KEY, value)
                .apply();
    }

    public static String getAppProFile() {
        return getAppPreference().getString(APP_PREFERENCES_KEY, null);
    }

    public static JSONObject getAppProFileJson() {
        final String proFile = getAppProFile();
        return JSON.parseObject(proFile);
    }

    public static void removeAppProFile() {
        getAppPreference()
                .edit()
                .remove(APP_PREFERENCES_KEY)
                .apply();
    }

    public static void clearAppPreference() {
        getAppPreference()
                .edit()
                .clear()
                .apply();
    }

    public static void setAppFlag(String key, boolean flag) {
        getAppPreference()
                .edit()
                .putBoolean(key, flag)
                .apply();
    }

    public static boolean getAppFlag(String key) {
        return getAppPreference().getBoolean(key, false);
    }


}
