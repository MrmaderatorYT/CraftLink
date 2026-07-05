package com.crashlytics.android.c;

import android.content.Context;
import android.os.Bundle;

/* compiled from: ManifestUnityVersionProvider.java */
/* loaded from: classes.dex */
class ab implements aw {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1297a;

    /* renamed from: b, reason: collision with root package name */
    private final String f1298b;

    public ab(Context context, String str) {
        this.f1297a = context;
        this.f1298b = str;
    }

    @Override // com.crashlytics.android.c.aw
    public String a() {
        try {
            Bundle bundle = this.f1297a.getPackageManager().getApplicationInfo(this.f1298b, 128).metaData;
            if (bundle != null) {
                return bundle.getString("io.fabric.unity.crashlytics.version");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
