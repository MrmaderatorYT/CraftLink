package com.crashlytics.android.c;

import java.io.File;
import java.io.IOException;

/* compiled from: CrashlyticsFileMarker.java */
/* loaded from: classes.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    private final String f1419a;

    /* renamed from: b, reason: collision with root package name */
    private final io.fabric.sdk.android.services.d.a f1420b;

    public m(String str, io.fabric.sdk.android.services.d.a aVar) {
        this.f1419a = str;
        this.f1420b = aVar;
    }

    public boolean a() {
        try {
            return d().createNewFile();
        } catch (IOException e) {
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Error creating marker: " + this.f1419a, e);
            return false;
        }
    }

    public boolean b() {
        return d().exists();
    }

    public boolean c() {
        return d().delete();
    }

    private File d() {
        return new File(this.f1420b.a(), this.f1419a);
    }
}
