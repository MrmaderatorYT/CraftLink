package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
final class ahk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ View f1982a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ vv f1983b;
    private final /* synthetic */ int c;
    private final /* synthetic */ ahi d;

    ahk(ahi ahiVar, View view, vv vvVar, int i) {
        this.d = ahiVar;
        this.f1982a = view;
        this.f1983b = vvVar;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.a(this.f1982a, this.f1983b, this.c - 1);
    }
}
