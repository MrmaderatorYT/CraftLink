package io.fabric.sdk.android.services.b;

import android.os.SystemClock;
import android.util.Log;

/* compiled from: TimingMetric.java */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private final String f4244a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4245b;
    private final boolean c;
    private long d;
    private long e;

    public w(String str, String str2) {
        this.f4244a = str;
        this.f4245b = str2;
        this.c = !Log.isLoggable(str2, 2);
    }

    public synchronized void a() {
        if (this.c) {
            return;
        }
        this.d = SystemClock.elapsedRealtime();
        this.e = 0L;
    }

    public synchronized void b() {
        if (this.c) {
            return;
        }
        if (this.e != 0) {
            return;
        }
        this.e = SystemClock.elapsedRealtime() - this.d;
        c();
    }

    private void c() {
        Log.v(this.f4245b, this.f4244a + ": " + this.e + "ms");
    }
}
