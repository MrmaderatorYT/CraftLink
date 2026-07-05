package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: classes.dex */
public class b {
    public static boolean a() {
        return false;
    }

    public static boolean a(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            return (com.google.android.gms.common.b.c.a(context).a(str, 0).flags & 2097152) != 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
