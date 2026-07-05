package com.crashlytics.android.c;

import io.fabric.sdk.android.services.b.t;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* compiled from: QueueFileLogStore.java */
/* loaded from: classes.dex */
class am implements y {

    /* renamed from: a, reason: collision with root package name */
    private final File f1310a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1311b;
    private io.fabric.sdk.android.services.b.t c;

    /* compiled from: QueueFileLogStore.java */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f1314a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1315b;

        public a(byte[] bArr, int i) {
            this.f1314a = bArr;
            this.f1315b = i;
        }
    }

    public am(File file, int i) {
        this.f1310a = file;
        this.f1311b = i;
    }

    @Override // com.crashlytics.android.c.y
    public void a(long j, String str) {
        f();
        b(j, str);
    }

    @Override // com.crashlytics.android.c.y
    public d a() {
        a aVarE = e();
        if (aVarE == null) {
            return null;
        }
        return d.a(aVarE.f1314a, 0, aVarE.f1315b);
    }

    @Override // com.crashlytics.android.c.y
    public byte[] b() {
        a aVarE = e();
        if (aVarE == null) {
            return null;
        }
        return aVarE.f1314a;
    }

    private a e() {
        if (!this.f1310a.exists()) {
            return null;
        }
        f();
        if (this.c == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[this.c.a()];
        try {
            this.c.a(new t.c() { // from class: com.crashlytics.android.c.am.1
                @Override // io.fabric.sdk.android.services.b.t.c
                public void a(InputStream inputStream, int i) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr2 = iArr;
                        iArr2[0] = iArr2[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException e) {
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return new a(bArr, iArr[0]);
    }

    @Override // com.crashlytics.android.c.y
    public void c() throws IOException {
        io.fabric.sdk.android.services.b.i.a(this.c, "There was a problem closing the Crashlytics log file.");
        this.c = null;
    }

    @Override // com.crashlytics.android.c.y
    public void d() throws IOException {
        c();
        this.f1310a.delete();
    }

    private void f() {
        if (this.c == null) {
            try {
                this.c = new io.fabric.sdk.android.services.b.t(this.f1310a);
            } catch (IOException e) {
                io.fabric.sdk.android.c.g().e("CrashlyticsCore", "Could not open log file: " + this.f1310a, e);
            }
        }
    }

    private void b(long j, String str) {
        if (this.c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i = this.f1311b / 4;
            if (str.length() > i) {
                str = "..." + str.substring(str.length() - i);
            }
            this.c.a(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes("UTF-8"));
            while (!this.c.b() && this.c.a() > this.f1311b) {
                this.c.c();
            }
        } catch (IOException e) {
            io.fabric.sdk.android.c.g().e("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", e);
        }
    }
}
