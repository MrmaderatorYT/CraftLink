package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

@qj
/* loaded from: classes.dex */
public final class wy implements bna {

    /* renamed from: b, reason: collision with root package name */
    private final xh f3568b;
    private final wu d;

    /* renamed from: a, reason: collision with root package name */
    private final Object f3567a = new Object();
    private final HashSet<wm> e = new HashSet<>();
    private final HashSet<wx> f = new HashSet<>();
    private final ww c = new ww();

    public wy(String str, xh xhVar) {
        this.d = new wu(str, xhVar);
        this.f3568b = xhVar;
    }

    public final void a(wx wxVar) {
        synchronized (this.f3567a) {
            this.f.add(wxVar);
        }
    }

    public final void a(wm wmVar) {
        synchronized (this.f3567a) {
            this.e.add(wmVar);
        }
    }

    public final void a(HashSet<wm> hashSet) {
        synchronized (this.f3567a) {
            this.e.addAll(hashSet);
        }
    }

    public final Bundle a(Context context, wv wvVar) {
        HashSet<wm> hashSet = new HashSet<>();
        synchronized (this.f3567a) {
            hashSet.addAll(this.e);
            this.e.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.d.a(context, this.c.b()));
        Bundle bundle2 = new Bundle();
        Iterator<wx> it = this.f.iterator();
        while (it.hasNext()) {
            wx next = it.next();
            bundle2.putBundle(next.a(), next.b());
        }
        bundle.putBundle("slots", bundle2);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<wm> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().d());
        }
        bundle.putParcelableArrayList("ads", arrayList);
        wvVar.a(hashSet);
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.bna
    public final void a(boolean z) {
        long jA = com.google.android.gms.ads.internal.ax.l().a();
        if (z) {
            if (jA - this.f3568b.i() > ((Long) bra.e().a(o.av)).longValue()) {
                this.d.f3561a = -1;
                return;
            } else {
                this.d.f3561a = this.f3568b.j();
                return;
            }
        }
        this.f3568b.a(jA);
        this.f3568b.b(this.d.f3561a);
    }

    public final void a() {
        synchronized (this.f3567a) {
            this.d.a();
        }
    }

    public final void b() {
        synchronized (this.f3567a) {
            this.d.b();
        }
    }

    public final void a(bqj bqjVar, long j) {
        synchronized (this.f3567a) {
            this.d.a(bqjVar, j);
        }
    }

    public final wm a(com.google.android.gms.common.util.c cVar, String str) {
        return new wm(cVar, this, this.c.a(), str);
    }
}
