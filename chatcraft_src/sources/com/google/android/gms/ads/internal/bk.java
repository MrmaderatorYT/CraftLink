package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
final class bk implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bu f1552a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ bi f1553b;

    bk(bi biVar, bu buVar) {
        this.f1553b = biVar;
        this.f1552a = buVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.f1552a.a();
        if (this.f1553b.f1550b == null) {
            return false;
        }
        this.f1553b.f1550b.c();
        return false;
    }
}
