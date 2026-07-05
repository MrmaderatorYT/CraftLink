package com.crashlytics.android.c;

import com.crashlytics.android.c.ao;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: InvalidSessionReport.java */
/* loaded from: classes.dex */
class z implements ao {

    /* renamed from: a, reason: collision with root package name */
    private final File[] f1435a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, String> f1436b = new HashMap(ap.f1319a);
    private final String c;

    public z(String str, File[] fileArr) {
        this.f1435a = fileArr;
        this.c = str;
    }

    @Override // com.crashlytics.android.c.ao
    public String a() {
        return this.f1435a[0].getName();
    }

    @Override // com.crashlytics.android.c.ao
    public String b() {
        return this.c;
    }

    @Override // com.crashlytics.android.c.ao
    public File c() {
        return this.f1435a[0];
    }

    @Override // com.crashlytics.android.c.ao
    public File[] d() {
        return this.f1435a;
    }

    @Override // com.crashlytics.android.c.ao
    public Map<String, String> e() {
        return Collections.unmodifiableMap(this.f1436b);
    }

    @Override // com.crashlytics.android.c.ao
    public void f() {
        for (File file : this.f1435a) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Removing invalid report file at " + file.getPath());
            file.delete();
        }
    }

    @Override // com.crashlytics.android.c.ao
    public ao.a g() {
        return ao.a.JAVA;
    }
}
