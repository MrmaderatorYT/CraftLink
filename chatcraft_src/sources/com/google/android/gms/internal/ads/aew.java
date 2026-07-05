package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@qj
/* loaded from: classes.dex */
public final class aew implements Iterable<aeu> {

    /* renamed from: a, reason: collision with root package name */
    private final List<aeu> f1914a = new ArrayList();

    public static boolean a(adk adkVar) {
        aeu aeuVarB = b(adkVar);
        if (aeuVarB == null) {
            return false;
        }
        aeuVarB.f1912b.a();
        return true;
    }

    static aeu b(adk adkVar) {
        Iterator<aeu> it = com.google.android.gms.ads.internal.ax.C().iterator();
        while (it.hasNext()) {
            aeu next = it.next();
            if (next.f1911a == adkVar) {
                return next;
            }
        }
        return null;
    }

    public final void a(aeu aeuVar) {
        this.f1914a.add(aeuVar);
    }

    public final void b(aeu aeuVar) {
        this.f1914a.remove(aeuVar);
    }

    @Override // java.lang.Iterable
    public final Iterator<aeu> iterator() {
        return this.f1914a.iterator();
    }

    public final int a() {
        return this.f1914a.size();
    }
}
