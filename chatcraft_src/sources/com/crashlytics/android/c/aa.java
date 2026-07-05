package com.crashlytics.android.c;

import android.content.Context;
import java.io.File;
import java.util.Set;

/* compiled from: LogFileManager.java */
/* loaded from: classes.dex */
class aa {

    /* renamed from: a, reason: collision with root package name */
    private static final b f1295a = new b();

    /* renamed from: b, reason: collision with root package name */
    private final Context f1296b;
    private final a c;
    private y d;

    /* compiled from: LogFileManager.java */
    public interface a {
        File a();
    }

    aa(Context context, a aVar) {
        this(context, aVar, null);
    }

    aa(Context context, a aVar, String str) {
        this.f1296b = context;
        this.c = aVar;
        this.d = f1295a;
        a(str);
    }

    final void a(String str) {
        this.d.c();
        this.d = f1295a;
        if (str == null) {
            return;
        }
        if (!io.fabric.sdk.android.services.b.i.a(this.f1296b, "com.crashlytics.CollectCustomLogs", true)) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
        } else {
            a(b(str), 65536);
        }
    }

    void a(long j, String str) {
        this.d.a(j, str);
    }

    d a() {
        return this.d.a();
    }

    byte[] b() {
        return this.d.b();
    }

    void c() {
        this.d.d();
    }

    void a(Set<String> set) {
        File[] fileArrListFiles = this.c.a().listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (!set.contains(a(file))) {
                    file.delete();
                }
            }
        }
    }

    void a(File file, int i) {
        this.d = new am(file, i);
    }

    private File b(String str) {
        return new File(this.c.a(), "crashlytics-userlog-" + str + ".temp");
    }

    private String a(File file) {
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(".temp");
        return iLastIndexOf == -1 ? name : name.substring("crashlytics-userlog-".length(), iLastIndexOf);
    }

    /* compiled from: LogFileManager.java */
    private static final class b implements y {
        @Override // com.crashlytics.android.c.y
        public d a() {
            return null;
        }

        @Override // com.crashlytics.android.c.y
        public void a(long j, String str) {
        }

        @Override // com.crashlytics.android.c.y
        public byte[] b() {
            return null;
        }

        @Override // com.crashlytics.android.c.y
        public void c() {
        }

        @Override // com.crashlytics.android.c.y
        public void d() {
        }

        private b() {
        }
    }
}
