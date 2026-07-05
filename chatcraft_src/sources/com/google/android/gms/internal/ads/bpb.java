package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class bpb {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f2923a;

    /* renamed from: b, reason: collision with root package name */
    private int f2924b;
    private int c;
    private final /* synthetic */ box d;

    private bpb(box boxVar, byte[] bArr) {
        this.d = boxVar;
        this.f2923a = bArr;
    }

    public final synchronized void a() {
        try {
            if (this.d.f2918b) {
                this.d.f2917a.a(this.f2923a);
                this.d.f2917a.a(this.f2924b);
                this.d.f2917a.b(this.c);
                this.d.f2917a.a((int[]) null);
                this.d.f2917a.a();
            }
        } catch (RemoteException e) {
            aan.a("Clearcut log failed", e);
        }
    }

    public final bpb a(int i) {
        this.f2924b = i;
        return this;
    }

    public final bpb b(int i) {
        this.c = i;
        return this;
    }
}
