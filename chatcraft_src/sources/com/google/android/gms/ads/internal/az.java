package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ViewSwitcher;
import com.google.android.gms.internal.ads.aab;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.yj;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class az extends ViewSwitcher {

    /* renamed from: a, reason: collision with root package name */
    private final yj f1538a;

    /* renamed from: b, reason: collision with root package name */
    private final aab f1539b;
    private boolean c;

    public az(Context context, String str, String str2, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        super(context);
        this.f1538a = new yj(context);
        this.f1538a.a(str);
        this.f1538a.b(str2);
        this.c = true;
        if (context instanceof Activity) {
            this.f1539b = new aab((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
        } else {
            this.f1539b = new aab(null, this, onGlobalLayoutListener, onScrollChangedListener);
        }
        this.f1539b.a();
    }

    public final yj a() {
        return this.f1538a;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.c) {
            return false;
        }
        this.f1538a.a(motionEvent);
        return false;
    }

    @Override // android.widget.ViewAnimator, android.view.ViewGroup
    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            KeyEvent.Callback childAt = getChildAt(i2);
            if (childAt != null && (childAt instanceof afu)) {
                arrayList.add((afu) childAt);
            }
        }
        super.removeAllViews();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((afu) obj).destroy();
        }
    }

    public final void b() {
        xe.a("Disable position monitoring on adFrame.");
        if (this.f1539b != null) {
            this.f1539b.b();
        }
    }

    public final void c() {
        xe.a("Enable debug gesture detector on adFrame.");
        this.c = true;
    }

    public final void d() {
        xe.a("Disable debug gesture detector on adFrame.");
        this.c = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1539b != null) {
            this.f1539b.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1539b != null) {
            this.f1539b.d();
        }
    }
}
