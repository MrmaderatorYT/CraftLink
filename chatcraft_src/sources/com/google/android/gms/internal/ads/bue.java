package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

@qj
/* loaded from: classes.dex */
public final class bue {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3036a;

    public bue(Context context) {
        com.google.android.gms.common.internal.i.a(context, "Context can not be null");
        this.f3036a = context;
    }

    public final boolean a() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return a(intent);
    }

    public final boolean b() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return a(intent);
    }

    public final boolean c() {
        return ((Boolean) zt.a(this.f3036a, new buf())).booleanValue() && com.google.android.gms.common.b.c.a(this.f3036a).a("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(14)
    public final boolean d() {
        return a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }

    private final boolean a(Intent intent) {
        com.google.android.gms.common.internal.i.a(intent, "Intent can not be null");
        return !this.f3036a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }
}
