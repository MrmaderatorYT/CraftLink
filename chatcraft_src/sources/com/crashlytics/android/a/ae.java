package com.crashlytics.android.a;

import android.content.Context;
import android.content.res.Resources;
import io.fabric.sdk.android.services.b.r;
import java.util.Map;
import java.util.UUID;

/* compiled from: SessionMetadataCollector.java */
/* loaded from: classes.dex */
class ae {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1249a;

    /* renamed from: b, reason: collision with root package name */
    private final io.fabric.sdk.android.services.b.r f1250b;
    private final String c;
    private final String d;

    public ae(Context context, io.fabric.sdk.android.services.b.r rVar, String str, String str2) {
        this.f1249a = context;
        this.f1250b = rVar;
        this.c = str;
        this.d = str2;
    }

    public ac a() throws Resources.NotFoundException {
        Map<r.a, String> mapH = this.f1250b.h();
        return new ac(this.f1250b.c(), UUID.randomUUID().toString(), this.f1250b.b(), this.f1250b.j(), mapH.get(r.a.FONT_TOKEN), io.fabric.sdk.android.services.b.i.m(this.f1249a), this.f1250b.d(), this.f1250b.g(), this.c, this.d);
    }
}
