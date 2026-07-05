package com.google.android.gms.internal.ads;

import android.util.Log;

/* loaded from: classes.dex */
public final class avw extends awb {

    /* renamed from: a, reason: collision with root package name */
    private String f2329a;

    public avw(String str) {
        this.f2329a = str;
    }

    @Override // com.google.android.gms.internal.ads.awb
    public final void a(String str) {
        String str2 = this.f2329a;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(":");
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
