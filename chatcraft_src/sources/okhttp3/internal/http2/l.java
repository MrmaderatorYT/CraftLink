package okhttp3.internal.http2;

import java.util.Arrays;

/* compiled from: Settings.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private int f5219a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f5220b = new int[10];

    void a() {
        this.f5219a = 0;
        Arrays.fill(this.f5220b, 0);
    }

    l a(int i, int i2) {
        if (i < 0 || i >= this.f5220b.length) {
            return this;
        }
        this.f5219a = (1 << i) | this.f5219a;
        this.f5220b[i] = i2;
        return this;
    }

    boolean a(int i) {
        return ((1 << i) & this.f5219a) != 0;
    }

    int b(int i) {
        return this.f5220b[i];
    }

    int b() {
        return Integer.bitCount(this.f5219a);
    }

    int c() {
        if ((this.f5219a & 2) != 0) {
            return this.f5220b[1];
        }
        return -1;
    }

    int c(int i) {
        return (this.f5219a & 16) != 0 ? this.f5220b[4] : i;
    }

    int d(int i) {
        return (this.f5219a & 32) != 0 ? this.f5220b[5] : i;
    }

    int d() {
        if ((this.f5219a & 128) != 0) {
            return this.f5220b[7];
        }
        return 65535;
    }

    void a(l lVar) {
        for (int i = 0; i < 10; i++) {
            if (lVar.a(i)) {
                a(i, lVar.b(i));
            }
        }
    }
}
