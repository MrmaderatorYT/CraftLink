package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.afu;
import com.google.android.gms.internal.ads.qj;

@qj
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f1632a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup.LayoutParams f1633b;
    public final ViewGroup c;
    public final Context d;

    public i(afu afuVar) throws g {
        this.f1633b = afuVar.getLayoutParams();
        ViewParent parent = afuVar.getParent();
        this.d = afuVar.r();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new g("Could not get the parent of the WebView for an overlay.");
        }
        this.c = (ViewGroup) parent;
        this.f1632a = this.c.indexOfChild(afuVar.getView());
        this.c.removeView(afuVar.getView());
        afuVar.b(true);
    }
}
