package com.ccs.craftlink.battery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import com.ccs.craftlink.R;

public class BatteryHelper {
    private static final String TAG = "BatteryHelper";

    public static boolean isBatteryOptimizationDisabled(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            return pm != null && pm.isIgnoringBatteryOptimizations(context.getPackageName());
        }
        return true;
    }

    public static void requestDisableBatteryOptimization(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PowerManager pm = (PowerManager) activity.getSystemService(Context.POWER_SERVICE);
            if (pm != null && !pm.isIgnoringBatteryOptimizations(activity.getPackageName())) {
                showBatteryOptimizationDialog(activity);
            }
        }
    }

    private static void showBatteryOptimizationDialog(Activity activity) {
        new AlertDialog.Builder(activity)
                .setTitle("Battery Optimization")
                .setMessage("CraftLink works best when battery optimization is disabled. " +
                        "This ensures stable connections and anti-AFK features work reliably.\n\n" +
                        "Would you like to disable battery optimization for CraftLink?")
                .setPositiveButton("Open Settings", (dialog, which) -> openBatterySettings(activity))
                .setNegativeButton("Later", null)
                .setNeutralButton("Don't ask again", (dialog, which) -> {
                    android.content.SharedPreferences prefs =
                            activity.getSharedPreferences("craftlink_settings", Context.MODE_PRIVATE);
                    prefs.edit().putBoolean("skip_battery_optimization_prompt", true).apply();
                })
                .show();
    }

    public static void openBatterySettings(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, "Failed to open battery settings", e);
            try {
                Intent intent = new Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
                context.startActivity(intent);
            } catch (Exception e2) {
                Log.e(TAG, "Failed to open battery optimization settings", e2);
            }
        }
    }

    public static boolean shouldShowPrompt(Context context) {
        android.content.SharedPreferences prefs =
                context.getSharedPreferences("craftlink_settings", Context.MODE_PRIVATE);
        return !prefs.getBoolean("skip_battery_optimization_prompt", false)
                && !isBatteryOptimizationDisabled(context);
    }
}
