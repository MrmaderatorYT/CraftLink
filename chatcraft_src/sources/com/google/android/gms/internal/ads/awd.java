package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class awd {

    /* renamed from: a, reason: collision with root package name */
    private static String f2339a;

    public static String a(Context context) {
        if (f2339a != null) {
            return f2339a;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        String str = resolveInfoResolveActivity != null ? resolveInfoResolveActivity.activityInfo.packageName : null;
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction("androidx.browser.customtabs.action.CustomTabsService");
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            f2339a = null;
        } else if (arrayList.size() == 1) {
            f2339a = (String) arrayList.get(0);
        } else if (!TextUtils.isEmpty(str) && !a(context, intent) && arrayList.contains(str)) {
            f2339a = str;
        } else if (arrayList.contains("com.android.chrome")) {
            f2339a = "com.android.chrome";
        } else if (arrayList.contains("com.chrome.beta")) {
            f2339a = "com.chrome.beta";
        } else if (arrayList.contains("com.chrome.dev")) {
            f2339a = "com.chrome.dev";
        } else if (arrayList.contains("com.google.android.apps.chrome")) {
            f2339a = "com.google.android.apps.chrome";
        }
        return f2339a;
    }

    private static boolean a(Context context, Intent intent) {
        List<ResolveInfo> listQueryIntentActivities;
        try {
            listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
        } catch (RuntimeException unused) {
            Log.e("CustomTabsHelper", "Runtime exception while getting specialized handlers");
        }
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() != 0) {
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                IntentFilter intentFilter = resolveInfo.filter;
                if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
