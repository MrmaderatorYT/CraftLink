package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@qj
/* loaded from: classes.dex */
final class fj {

    /* renamed from: a, reason: collision with root package name */
    private final List<gj> f3083a = new ArrayList();

    fj() {
    }

    final void a(gk gkVar) {
        Handler handler = xn.f3583a;
        Iterator<gj> it = this.f3083a.iterator();
        while (it.hasNext()) {
            handler.post(new gi(this, it.next(), gkVar));
        }
        this.f3083a.clear();
    }
}
