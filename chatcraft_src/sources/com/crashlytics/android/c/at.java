package com.crashlytics.android.c;

import com.crashlytics.android.c.c;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: Sha1FileIdStrategy.java */
/* loaded from: classes.dex */
class at implements c.a {
    at() {
    }

    @Override // com.crashlytics.android.c.c.a
    public String a(File file) {
        return a(file.getPath());
    }

    private static String a(String str) throws Throwable {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            try {
                String strB = io.fabric.sdk.android.services.b.i.b(bufferedInputStream2);
                io.fabric.sdk.android.services.b.i.a((Closeable) bufferedInputStream2);
                return strB;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                io.fabric.sdk.android.services.b.i.a((Closeable) bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
