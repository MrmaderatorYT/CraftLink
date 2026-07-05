package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class bli implements blq {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2803a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final WeakHashMap<wk, blj> f2804b = new WeakHashMap<>();
    private final ArrayList<blj> c = new ArrayList<>();
    private final Context d;
    private final aar e;
    private final hv f;

    public bli(Context context, aar aarVar) {
        this.d = context.getApplicationContext();
        this.e = aarVar;
        this.f = new hv(context.getApplicationContext(), aarVar, (String) bra.e().a(o.f3306a));
    }

    public final void a(bqn bqnVar, wk wkVar) {
        a(bqnVar, wkVar, wkVar.f3544b.getView());
    }

    public final void a(bqn bqnVar, wk wkVar, View view) {
        a(bqnVar, wkVar, new blp(view, wkVar), (afu) null);
    }

    public final void a(bqn bqnVar, wk wkVar, View view, afu afuVar) {
        a(bqnVar, wkVar, new blp(view, wkVar), afuVar);
    }

    public final void a(bqn bqnVar, wk wkVar, bmu bmuVar, afu afuVar) {
        blj bljVar;
        synchronized (this.f2803a) {
            if (e(wkVar)) {
                bljVar = this.f2804b.get(wkVar);
            } else {
                blj bljVar2 = new blj(this.d, bqnVar, wkVar, this.e, bmuVar);
                bljVar2.a(this);
                this.f2804b.put(wkVar, bljVar2);
                this.c.add(bljVar2);
                bljVar = bljVar2;
            }
            if (afuVar != null) {
                bljVar.a(new blr(bljVar, afuVar));
            } else {
                bljVar.a(new blv(bljVar, this.f, this.d));
            }
        }
    }

    private final boolean e(wk wkVar) {
        boolean z;
        synchronized (this.f2803a) {
            blj bljVar = this.f2804b.get(wkVar);
            z = bljVar != null && bljVar.c();
        }
        return z;
    }

    public final void a(wk wkVar) {
        synchronized (this.f2803a) {
            blj bljVar = this.f2804b.get(wkVar);
            if (bljVar != null) {
                bljVar.b();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.blq
    public final void a(blj bljVar) {
        synchronized (this.f2803a) {
            if (!bljVar.c()) {
                this.c.remove(bljVar);
                Iterator<Map.Entry<wk, blj>> it = this.f2804b.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue() == bljVar) {
                        it.remove();
                    }
                }
            }
        }
    }

    public final void b(wk wkVar) {
        synchronized (this.f2803a) {
            blj bljVar = this.f2804b.get(wkVar);
            if (bljVar != null) {
                bljVar.d();
            }
        }
    }

    public final void c(wk wkVar) {
        synchronized (this.f2803a) {
            blj bljVar = this.f2804b.get(wkVar);
            if (bljVar != null) {
                bljVar.e();
            }
        }
    }

    public final void d(wk wkVar) {
        synchronized (this.f2803a) {
            blj bljVar = this.f2804b.get(wkVar);
            if (bljVar != null) {
                bljVar.f();
            }
        }
    }
}
