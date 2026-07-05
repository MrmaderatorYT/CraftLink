package com.crashlytics.android.c;

import com.crashlytics.android.c.ao;
import java.io.File;
import java.util.Map;

/* compiled from: NativeSessionReport.java */
/* loaded from: classes.dex */
class ah implements ao {

    /* renamed from: a, reason: collision with root package name */
    private final File f1304a;

    @Override // com.crashlytics.android.c.ao
    public String a() {
        return null;
    }

    @Override // com.crashlytics.android.c.ao
    public File c() {
        return null;
    }

    @Override // com.crashlytics.android.c.ao
    public Map<String, String> e() {
        return null;
    }

    public ah(File file) {
        this.f1304a = file;
    }

    @Override // com.crashlytics.android.c.ao
    public void f() {
        for (File file : d()) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Removing native report file at " + file.getPath());
            file.delete();
        }
        io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Removing native report directory at " + this.f1304a);
        this.f1304a.delete();
    }

    @Override // com.crashlytics.android.c.ao
    public String b() {
        return this.f1304a.getName();
    }

    @Override // com.crashlytics.android.c.ao
    public File[] d() {
        return this.f1304a.listFiles();
    }

    @Override // com.crashlytics.android.c.ao
    public ao.a g() {
        return ao.a.NATIVE;
    }
}
