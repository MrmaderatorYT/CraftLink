package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes.dex */
final class afx implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ View f1944a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ vv f1945b;
    private final /* synthetic */ int c;
    private final /* synthetic */ afv d;

    afx(afv afvVar, View view, vv vvVar, int i) {
        this.d = afvVar;
        this.f1944a = view;
        this.f1945b = vvVar;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.a(this.f1944a, this.f1945b, this.c - 1);
    }
}
