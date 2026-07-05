package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public abstract class bgs extends bgi {
    public final int i;

    public bgs(bja bjaVar, bjd bjdVar, bab babVar, int i, Object obj, long j, long j2, int i2) {
        super(bjaVar, bjdVar, 1, babVar, i, obj, j, j2);
        bjq.a(babVar);
        this.i = i2;
    }

    public abstract boolean g();

    public int f() {
        return this.i + 1;
    }
}
