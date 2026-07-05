package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
final class at implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ar f1529a;

    at(ar arVar) {
        this.f1529a = arVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f1529a.h == null) {
            return false;
        }
        this.f1529a.h.a(motionEvent);
        return false;
    }
}
