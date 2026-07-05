package com.crashlytics.android.c;

import com.crashlytics.android.c.ao;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SessionReport.java */
/* loaded from: classes.dex */
class as implements ao {

    /* renamed from: a, reason: collision with root package name */
    private final File f1327a;

    /* renamed from: b, reason: collision with root package name */
    private final File[] f1328b;
    private final Map<String, String> c;

    public as(File file) {
        this(file, Collections.emptyMap());
    }

    public as(File file, Map<String, String> map) {
        this.f1327a = file;
        this.f1328b = new File[]{file};
        this.c = new HashMap(map);
        if (this.f1327a.length() == 0) {
            this.c.putAll(ap.f1319a);
        }
    }

    @Override // com.crashlytics.android.c.ao
    public File c() {
        return this.f1327a;
    }

    @Override // com.crashlytics.android.c.ao
    public File[] d() {
        return this.f1328b;
    }

    @Override // com.crashlytics.android.c.ao
    public String a() {
        return c().getName();
    }

    @Override // com.crashlytics.android.c.ao
    public String b() {
        String strA = a();
        return strA.substring(0, strA.lastIndexOf(46));
    }

    @Override // com.crashlytics.android.c.ao
    public Map<String, String> e() {
        return Collections.unmodifiableMap(this.c);
    }

    @Override // com.crashlytics.android.c.ao
    public void f() {
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Removing report at " + this.f1327a.getPath());
        this.f1327a.delete();
    }

    @Override // com.crashlytics.android.c.ao
    public ao.a g() {
        return ao.a.JAVA;
    }
}
