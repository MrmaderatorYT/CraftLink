package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.yj;

@qj
/* loaded from: classes.dex */
final class h extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    boolean f1630a;

    /* renamed from: b, reason: collision with root package name */
    private yj f1631b;

    public h(Context context, String str, String str2) {
        super(context);
        this.f1631b = new yj(context, str);
        this.f1631b.b(str2);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f1630a) {
            return false;
        }
        this.f1631b.a(motionEvent);
        return false;
    }
}
