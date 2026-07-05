package com.google.android.gms.internal.ads;

import android.content.Context;

@qj
/* loaded from: classes.dex */
public final class hg {

    /* renamed from: a, reason: collision with root package name */
    private Context f3127a;

    public final void a(Context context) {
        if (this.f3127a != null) {
            return;
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f3127a = context;
    }
}
