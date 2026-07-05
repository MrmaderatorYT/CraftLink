package androidx.core.f;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter.java */
/* loaded from: classes.dex */
public class b extends Writer {

    /* renamed from: a, reason: collision with root package name */
    private final String f610a;

    /* renamed from: b, reason: collision with root package name */
    private StringBuilder f611b = new StringBuilder(128);

    public b(String str) {
        this.f610a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                a();
            } else {
                this.f611b.append(c);
            }
        }
    }

    private void a() {
        if (this.f611b.length() > 0) {
            Log.d(this.f610a, this.f611b.toString());
            this.f611b.delete(0, this.f611b.length());
        }
    }
}
