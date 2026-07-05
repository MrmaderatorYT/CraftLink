package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class jg {

    /* renamed from: a, reason: collision with root package name */
    private static final yu<hk> f3194a = new jh();

    /* renamed from: b, reason: collision with root package name */
    private static final yu<hk> f3195b = new ji();
    private final hv c;

    public jg(Context context, aar aarVar, String str) {
        this.c = new hv(context, aarVar, str, f3194a, f3195b);
    }

    public final <I, O> ix<I, O> a(String str, ja<I> jaVar, iz<O> izVar) {
        return new jj(this.c, str, jaVar, izVar);
    }
}
