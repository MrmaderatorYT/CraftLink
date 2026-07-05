package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class iy {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3185a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("mLock")
    private jg f3186b;

    public final jg a(Context context, aar aarVar) {
        jg jgVar;
        synchronized (this.f3185a) {
            if (this.f3186b == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                this.f3186b = new jg(context, aarVar, (String) bra.e().a(o.f3306a));
            }
            jgVar = this.f3186b;
        }
        return jgVar;
    }
}
