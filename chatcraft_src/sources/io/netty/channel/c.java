package io.netty.channel;

import io.netty.channel.ag;
import io.netty.channel.ar;
import java.util.ArrayList;

/* compiled from: AdaptiveRecvByteBufAllocator.java */
/* loaded from: classes.dex */
public class c extends ag {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final c f4536a;

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f4537b;
    private final int c;
    private final int d;
    private final int e;

    static {
        int i;
        ArrayList arrayList = new ArrayList();
        int i2 = 16;
        while (true) {
            if (i2 >= 512) {
                break;
            }
            arrayList.add(Integer.valueOf(i2));
            i2 += 16;
        }
        for (i = 512; i > 0; i <<= 1) {
            arrayList.add(Integer.valueOf(i));
        }
        f4537b = new int[arrayList.size()];
        for (int i3 = 0; i3 < f4537b.length; i3++) {
            f4537b[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        f4536a = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(int i) {
        int length = f4537b.length - 1;
        int i2 = 0;
        while (length >= i2) {
            if (length == i2) {
                return length;
            }
            int i3 = (i2 + length) >>> 1;
            int i4 = f4537b[i3];
            int i5 = i3 + 1;
            if (i > f4537b[i5]) {
                i2 = i5;
            } else {
                if (i >= i4) {
                    return i == i4 ? i3 : i5;
                }
                length = i3 - 1;
            }
        }
        return i2;
    }

    /* compiled from: AdaptiveRecvByteBufAllocator.java */
    private final class a extends ag.a {
        private final int c;
        private final int d;
        private int e;
        private int f;
        private boolean g;

        public a(int i, int i2, int i3) {
            super();
            this.c = i;
            this.d = i2;
            this.e = c.c(i3);
            this.f = c.f4537b[this.e];
        }

        @Override // io.netty.channel.ar.a
        public int a() {
            return this.f;
        }

        private void d(int i) {
            if (i <= c.f4537b[Math.max(0, (this.e - 1) - 1)]) {
                if (this.g) {
                    this.e = Math.max(this.e - 1, this.c);
                    this.f = c.f4537b[this.e];
                    this.g = false;
                    return;
                }
                this.g = true;
                return;
            }
            if (i >= this.f) {
                this.e = Math.min(this.e + 4, this.d);
                this.f = c.f4537b[this.e];
                this.g = false;
            }
        }

        @Override // io.netty.channel.ag.a, io.netty.channel.ar.a
        public void b() {
            d(f());
        }
    }

    public c() {
        this(64, 1024, 65536);
    }

    public c(int i, int i2, int i3) {
        if (i <= 0) {
            throw new IllegalArgumentException("minimum: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("initial: " + i2);
        }
        if (i3 < i2) {
            throw new IllegalArgumentException("maximum: " + i3);
        }
        int iC = c(i);
        if (f4537b[iC] < i) {
            this.c = iC + 1;
        } else {
            this.c = iC;
        }
        int iC2 = c(i3);
        if (f4537b[iC2] > i3) {
            this.d = iC2 - 1;
        } else {
            this.d = iC2;
        }
        this.e = i2;
    }

    @Override // io.netty.channel.ar
    public ar.a a() {
        return new a(this.c, this.d, this.e);
    }
}
