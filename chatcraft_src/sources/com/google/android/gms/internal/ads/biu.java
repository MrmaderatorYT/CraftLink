package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public abstract class biu {

    /* renamed from: a, reason: collision with root package name */
    private biv f2714a;

    public abstract biw a(bah[] bahVarArr, bgf bgfVar);

    public abstract void a(Object obj);

    public final void a(biv bivVar) {
        this.f2714a = bivVar;
    }

    protected final void a() {
        if (this.f2714a != null) {
            this.f2714a.c();
        }
    }
}
