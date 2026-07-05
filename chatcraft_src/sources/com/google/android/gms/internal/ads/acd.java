package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;

@qj
/* loaded from: classes.dex */
public final class acd {
    public static void a(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        new ace(view, onGlobalLayoutListener).a();
    }

    public static void a(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        new acf(view, onScrollChangedListener).a();
    }
}
