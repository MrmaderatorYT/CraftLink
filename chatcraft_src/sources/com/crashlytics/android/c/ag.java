package com.crashlytics.android.c;

import android.content.Context;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NativeFileUtils.java */
/* loaded from: classes.dex */
final class ag {
    static byte[] a(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArrA = a(fileInputStream);
                io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream);
                return bArrA;
            } catch (FileNotFoundException unused) {
                io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream);
                return null;
            } catch (IOException unused2) {
                io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream2);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            fileInputStream = null;
        } catch (IOException unused4) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static File a(File file, String str) {
        for (File file2 : file.listFiles()) {
            if (file2.getName().endsWith(str)) {
                return file2;
            }
        }
        return null;
    }

    static byte[] b(File file) {
        File fileA = a(file, ".dmp");
        return fileA == null ? new byte[0] : d(fileA);
    }

    private static byte[] d(File file) {
        return a(file);
    }

    static byte[] a(File file, Context context) {
        File fileA = a(file, ".maps");
        if (fileA != null) {
            return c(fileA, context);
        }
        File fileA2 = a(file, ".binary_libs");
        if (fileA2 != null) {
            return b(fileA2, context);
        }
        return null;
    }

    private static byte[] b(File file, Context context) throws Throwable {
        byte[] bArrA = a(file);
        if (bArrA == null || bArrA.length == 0) {
            return null;
        }
        return a(context, new String(bArrA));
    }

    private static byte[] c(File file, Context context) throws Throwable {
        BufferedReader bufferedReader;
        if (!file.exists()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                byte[] bArrA = new c(context, new at()).a(bufferedReader);
                io.fabric.sdk.android.services.b.i.a(bufferedReader);
                return bArrA;
            } catch (Throwable th) {
                th = th;
                io.fabric.sdk.android.services.b.i.a(bufferedReader);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    static byte[] c(File file) {
        File fileA = a(file, ".device_info");
        if (fileA == null) {
            return null;
        }
        return a(fileA);
    }

    private static byte[] a(Context context, String str) {
        return new c(context, new at()).a(str);
    }
}
