package io.netty.util.concurrent;

import java.util.Arrays;

/* compiled from: DefaultFutureListeners.java */
/* loaded from: classes.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private r<? extends p<?>>[] f4733a = new r[2];

    /* renamed from: b, reason: collision with root package name */
    private int f4734b;
    private int c;

    g(r<? extends p<?>> rVar, r<? extends p<?>> rVar2) {
        this.f4733a[0] = rVar;
        this.f4733a[1] = rVar2;
        this.f4734b = 2;
        if (rVar instanceof s) {
            this.c++;
        }
        if (rVar2 instanceof s) {
            this.c++;
        }
    }

    public void a(r<? extends p<?>> rVar) {
        r<? extends p<?>>[] rVarArr = this.f4733a;
        int i = this.f4734b;
        if (i == rVarArr.length) {
            rVarArr = (r[]) Arrays.copyOf(rVarArr, i << 1);
            this.f4733a = rVarArr;
        }
        rVarArr[i] = rVar;
        this.f4734b = i + 1;
        if (rVar instanceof s) {
            this.c++;
        }
    }

    public r<? extends p<?>>[] a() {
        return this.f4733a;
    }

    public int b() {
        return this.f4734b;
    }
}
