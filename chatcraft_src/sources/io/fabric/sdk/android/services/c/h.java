package io.fabric.sdk.android.services.c;

import android.content.Context;
import io.fabric.sdk.android.services.b.t;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: QueueFileEventStorage.java */
/* loaded from: classes.dex */
public class h implements c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4251a;

    /* renamed from: b, reason: collision with root package name */
    private final File f4252b;
    private final String c;
    private final File d;
    private t e;
    private File f;

    public h(Context context, File file, String str, String str2) {
        this.f4251a = context;
        this.f4252b = file;
        this.c = str2;
        this.d = new File(this.f4252b, str);
        this.e = new t(this.d);
        e();
    }

    private void e() {
        this.f = new File(this.f4252b, this.c);
        if (this.f.exists()) {
            return;
        }
        this.f.mkdirs();
    }

    @Override // io.fabric.sdk.android.services.c.c
    public void a(byte[] bArr) {
        this.e.a(bArr);
    }

    @Override // io.fabric.sdk.android.services.c.c
    public int a() {
        return this.e.a();
    }

    @Override // io.fabric.sdk.android.services.c.c
    public void a(String str) throws Throwable {
        this.e.close();
        a(this.d, new File(this.f, str));
        this.e = new t(this.d);
    }

    private void a(File file, File file2) throws Throwable {
        FileInputStream fileInputStream;
        OutputStream outputStreamA;
        OutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                outputStreamA = a(file2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            io.fabric.sdk.android.services.b.i.a(fileInputStream, outputStreamA, new byte[1024]);
            io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream, "Failed to close file input stream");
            io.fabric.sdk.android.services.b.i.a((Closeable) outputStreamA, "Failed to close output stream");
            file.delete();
        } catch (Throwable th3) {
            outputStream = outputStreamA;
            th = th3;
            io.fabric.sdk.android.services.b.i.a((Closeable) fileInputStream, "Failed to close file input stream");
            io.fabric.sdk.android.services.b.i.a((Closeable) outputStream, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    public OutputStream a(File file) {
        return new FileOutputStream(file);
    }

    @Override // io.fabric.sdk.android.services.c.c
    public List<File> a(int i) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f.listFiles()) {
            arrayList.add(file);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    @Override // io.fabric.sdk.android.services.c.c
    public void a(List<File> list) {
        for (File file : list) {
            io.fabric.sdk.android.services.b.i.a(this.f4251a, String.format("deleting sent analytics file %s", file.getName()));
            file.delete();
        }
    }

    @Override // io.fabric.sdk.android.services.c.c
    public List<File> c() {
        return Arrays.asList(this.f.listFiles());
    }

    @Override // io.fabric.sdk.android.services.c.c
    public void d() {
        try {
            this.e.close();
        } catch (IOException unused) {
        }
        this.d.delete();
    }

    @Override // io.fabric.sdk.android.services.c.c
    public boolean b() {
        return this.e.b();
    }

    @Override // io.fabric.sdk.android.services.c.c
    public boolean a(int i, int i2) {
        return this.e.a(i, i2);
    }
}
