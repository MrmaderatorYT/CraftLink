package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class bgj implements bcf {

    /* renamed from: a, reason: collision with root package name */
    public final bcc f2643a;

    /* renamed from: b, reason: collision with root package name */
    private final bab f2644b;
    private final SparseArray<bgk> c = new SparseArray<>();
    private boolean d;
    private bgl e;
    private bck f;
    private bab[] g;

    public bgj(bcc bccVar, bab babVar) {
        this.f2643a = bccVar;
        this.f2644b = babVar;
    }

    public final bck b() {
        return this.f;
    }

    public final bab[] c() {
        return this.g;
    }

    public final void a(bgl bglVar) {
        this.e = bglVar;
        if (!this.d) {
            this.f2643a.a(this);
            this.d = true;
            return;
        }
        this.f2643a.a(0L, 0L);
        for (int i = 0; i < this.c.size(); i++) {
            this.c.valueAt(i).a(bglVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.bcf
    public final bcm a(int i, int i2) {
        bgk bgkVar = this.c.get(i);
        if (bgkVar != null) {
            return bgkVar;
        }
        bjq.b(this.g == null);
        bgk bgkVar2 = new bgk(i, i2, this.f2644b);
        bgkVar2.a(this.e);
        this.c.put(i, bgkVar2);
        return bgkVar2;
    }

    @Override // com.google.android.gms.internal.ads.bcf
    public final void a() {
        bab[] babVarArr = new bab[this.c.size()];
        for (int i = 0; i < this.c.size(); i++) {
            babVarArr[i] = this.c.valueAt(i).f2645a;
        }
        this.g = babVarArr;
    }

    @Override // com.google.android.gms.internal.ads.bcf
    public final void a(bck bckVar) {
        this.f = bckVar;
    }
}
