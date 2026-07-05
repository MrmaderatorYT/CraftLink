package com.google.android.gms.internal.ads;

import android.content.Context;

@qj
/* loaded from: classes.dex */
public final class sq {

    /* renamed from: b, reason: collision with root package name */
    public final bog f3452b;
    public final wf c;
    public final c d;
    public final ti e;
    public final jn f;
    public final tj g;
    public final ns h;
    public final wj i;
    public final sv k;

    /* renamed from: a, reason: collision with root package name */
    public final sy f3451a = null;
    public final boolean j = true;

    private sq(sy syVar, bog bogVar, wf wfVar, c cVar, ti tiVar, jn jnVar, tj tjVar, ns nsVar, wj wjVar, boolean z, sv svVar) {
        this.f3452b = bogVar;
        this.c = wfVar;
        this.d = cVar;
        this.e = tiVar;
        this.f = jnVar;
        this.g = tjVar;
        this.h = nsVar;
        this.i = wjVar;
        this.k = svVar;
    }

    public static sq a(Context context) {
        com.google.android.gms.ads.internal.ax.q().a(context);
        tl tlVar = new tl(context);
        return new sq(null, new boj(), new wg(), new b(), new tg(context, tlVar.b()), new jo(), new tk(), new nr(), new wh(), true, tlVar);
    }
}
