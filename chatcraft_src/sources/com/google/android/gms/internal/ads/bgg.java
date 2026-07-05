package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public abstract class bgg extends bgs {
    private bgh j;
    private int[] k;

    public bgg(bja bjaVar, bjd bjdVar, bab babVar, int i, Object obj, long j, long j2, int i2) {
        super(bjaVar, bjdVar, babVar, i, obj, j, j2, i2);
    }

    public final void a(bgh bghVar) {
        this.j = bghVar;
        this.k = bghVar.a();
    }

    public final int a(int i) {
        return this.k[i];
    }

    protected final bgh d() {
        return this.j;
    }
}
