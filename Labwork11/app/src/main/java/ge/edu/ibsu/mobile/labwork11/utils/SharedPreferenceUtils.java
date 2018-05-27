package ge.edu.ibsu.mobile.labwork11.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceUtils {
    private static SharedPreferenceUtils mSharedPreferenceUtils;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private SharedPreferenceUtils(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferenceUtils getInstance(Context context) {
        return mSharedPreferenceUtils = mSharedPreferenceUtils != null ? mSharedPreferenceUtils : context != null ? new SharedPreferenceUtils(context) : null;
    }

    public void putString(String key, String value) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(key, value);
        mEditor.apply();
    }

    public String getString(String key) {
        return mSharedPreferences.getString(key, null);
    }
}
