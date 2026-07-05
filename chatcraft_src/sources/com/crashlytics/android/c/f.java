package com.crashlytics.android.c;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: ClsFileOutputStream.java */
/* loaded from: classes.dex */
class f extends FileOutputStream {

    /* renamed from: a, reason: collision with root package name */
    public static final FilenameFilter f1342a = new FilenameFilter() { // from class: com.crashlytics.android.c.f.1
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final String f1343b;
    private File c;
    private File d;
    private boolean e;

    public f(File file, String str) {
        super(new File(file, str + ".cls_temp"));
        this.e = false;
        this.f1343b = file + File.separator + str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1343b);
        sb.append(".cls_temp");
        this.c = new File(sb.toString());
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.e) {
            return;
        }
        this.e = true;
        super.flush();
        super.close();
        File file = new File(this.f1343b + ".cls");
        if (this.c.renameTo(file)) {
            this.c = null;
            this.d = file;
            return;
        }
        String str = BuildConfig.FLAVOR;
        if (file.exists()) {
            str = " (target already exists)";
        } else if (!this.c.exists()) {
            str = " (source does not exist)";
        }
        throw new IOException("Could not rename temp file: " + this.c + " -> " + file + str);
    }

    public void a() throws IOException {
        if (this.e) {
            return;
        }
        this.e = true;
        super.flush();
        super.close();
    }
}
