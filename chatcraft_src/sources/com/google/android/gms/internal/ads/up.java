package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
final class up implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ kn f3497a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bqj f3498b;
    private final /* synthetic */ uv c;
    private final /* synthetic */ un d;

    up(un unVar, kn knVar, bqj bqjVar, uv uvVar) {
        this.d = unVar;
        this.f3497a = knVar;
        this.f3498b = bqjVar;
        this.c = uvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3497a.a(com.google.android.gms.dynamic.b.a(this.d.c), this.f3498b, (String) null, this.c, this.d.g);
        } catch (RemoteException e) {
            String strValueOf = String.valueOf(this.d.f3493a);
            xe.c(strValueOf.length() != 0 ? "Fail to initialize adapter ".concat(strValueOf) : new String("Fail to initialize adapter "), e);
            this.d.a(this.d.f3493a, 0);
        }
    }
}
