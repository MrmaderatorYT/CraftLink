package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.WindowManager;

@TargetApi(16)
/* loaded from: classes.dex */
public final class bku {

    /* renamed from: a, reason: collision with root package name */
    private final bkv f2777a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f2778b;
    private final long c;
    private final long d;
    private long e;
    private long f;
    private long g;
    private boolean h;
    private long i;
    private long j;
    private long k;

    public bku() {
        this(-1.0d);
    }

    public bku(Context context) {
        this(((WindowManager) context.getSystemService("window")).getDefaultDisplay() != null ? r3.getDefaultDisplay().getRefreshRate() : -1.0d);
    }

    private bku(double d) {
        this.f2778b = d != -1.0d;
        if (this.f2778b) {
            this.f2777a = bkv.a();
            this.c = (long) (1.0E9d / d);
            this.d = (this.c * 80) / 100;
        } else {
            this.f2777a = null;
            this.c = -1L;
            this.d = -1L;
        }
    }

    public final void a() {
        this.h = false;
        if (this.f2778b) {
            this.f2777a.b();
        }
    }

    public final void b() {
        if (this.f2778b) {
            this.f2777a.c();
        }
    }

    public final long a(long j, long j2) {
        long j3;
        long j4;
        long j5;
        long j6 = 1000 * j;
        if (this.h) {
            if (j != this.e) {
                this.k++;
                this.f = this.g;
            }
            if (this.k >= 6) {
                j4 = ((j6 - this.j) / this.k) + this.f;
                if (b(j4, j2)) {
                    this.h = false;
                } else {
                    j3 = (this.i + j4) - this.j;
                }
            } else if (b(j6, j2)) {
                this.h = false;
            }
            j3 = j2;
            j4 = j6;
        } else {
            j3 = j2;
            j4 = j6;
        }
        if (!this.h) {
            this.j = j6;
            this.i = j2;
            this.k = 0L;
            this.h = true;
        }
        this.e = j;
        this.g = j4;
        if (this.f2777a == null || this.f2777a.f2780a == 0) {
            return j3;
        }
        long j7 = this.f2777a.f2780a;
        long j8 = this.c;
        long j9 = j7 + (((j3 - j7) / j8) * j8);
        if (j3 <= j9) {
            j5 = j9 - j8;
        } else {
            j9 = j8 + j9;
            j5 = j9;
        }
        if (j9 - j3 >= j3 - j5) {
            j9 = j5;
        }
        return j9 - this.d;
    }

    private final boolean b(long j, long j2) {
        return Math.abs((j2 - this.i) - (j - this.j)) > 20000000;
    }
}
