package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

@qj
/* loaded from: classes.dex */
public final class vz implements bmk {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3532a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f3533b;
    private String c;
    private boolean d;

    public vz(Context context, String str) {
        this.f3532a = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.c = str;
        this.d = false;
        this.f3533b = new Object();
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void a(boolean z) {
        if (com.google.android.gms.ads.internal.ax.E().a(this.f3532a)) {
            synchronized (this.f3533b) {
                if (this.d == z) {
                    return;
                }
                this.d = z;
                if (TextUtils.isEmpty(this.c)) {
                    return;
                }
                if (this.d) {
                    com.google.android.gms.ads.internal.ax.E().a(this.f3532a, this.c);
                } else {
                    com.google.android.gms.ads.internal.ax.E().b(this.f3532a, this.c);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bmk
    public final void a(bmj bmjVar) {
        a(bmjVar.f2838a);
    }
}
