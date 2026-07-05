package com.ccs.craftlink.theme;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.Log;

import androidx.appcompat.app.AppCompatDelegate;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class ThemeManager {
    private static final String TAG = "ThemeManager";
    private static ThemeManager instance;
    private static final String PREFS_NAME = "craftlink_theme";
    private static final String KEY_THEME_MODE = "theme_mode";

    public enum ThemeMode {
        SYSTEM,
        LIGHT,
        DARK
    }

    private final SharedPreferences prefs;
    private final Context context;
    private final BehaviorSubject<ThemeMode> themeMode = BehaviorSubject.createDefault(ThemeMode.SYSTEM);

    public static ThemeManager getInstance(Context context) {
        if (instance == null) {
            instance = new ThemeManager(context.getApplicationContext());
        }
        return instance;
    }

    private ThemeManager(Context context) {
        this.context = context.getApplicationContext();
        prefs = this.context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        ThemeMode saved = ThemeMode.values()[prefs.getInt(KEY_THEME_MODE, 0)];
        themeMode.onNext(saved);
        applyTheme(saved);
    }

    public Observable<ThemeMode> observeThemeMode() {
        return themeMode;
    }

    public ThemeMode getCurrentMode() {
        return themeMode.getValue();
    }

    public void setThemeMode(ThemeMode mode) {
        themeMode.onNext(mode);
        prefs.edit().putInt(KEY_THEME_MODE, mode.ordinal()).apply();
        applyTheme(mode);
        ThemeUpdateReceiver.updateWidgets(context);
        Log.i(TAG, "Theme mode set to: " + mode);
    }

    private void applyTheme(ThemeMode mode) {
        switch (mode) {
            case LIGHT:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case DARK:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case SYSTEM:
            default:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                break;
        }
    }

    public static boolean isDarkMode(Context context) {
        int nightModeFlags = context.getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        return nightModeFlags == Configuration.UI_MODE_NIGHT_YES;
    }
}
