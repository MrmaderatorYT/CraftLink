package com.google.android.gms.internal.ads;

import android.content.Context;

@qj
/* loaded from: classes.dex */
public final class zq extends xa {

    /* renamed from: a, reason: collision with root package name */
    private final aaq f3640a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3641b;

    public zq(Context context, String str, String str2) {
        this(str2, com.google.android.gms.ads.internal.ax.e().b(context, str));
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void c_() {
    }

    private zq(String str, String str2) {
        this.f3640a = new aaq(str2);
        this.f3641b = str;
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void a() {
        this.f3640a.a(this.f3641b);
    }
}
