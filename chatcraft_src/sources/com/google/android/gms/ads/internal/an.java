package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.bqj;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xn;
import java.lang.ref.WeakReference;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class an {

    /* renamed from: a, reason: collision with root package name */
    private final ap f1521a;

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f1522b;
    private bqj c;
    private boolean d;
    private boolean e;
    private long f;

    public an(a aVar) {
        this(aVar, new ap(xn.f3583a));
    }

    private an(a aVar, ap apVar) {
        this.d = false;
        this.e = false;
        this.f = 0L;
        this.f1521a = apVar;
        this.f1522b = new ao(this, new WeakReference(aVar));
    }

    public final void a(bqj bqjVar) {
        this.c = bqjVar;
    }

    public final void a() {
        this.d = false;
        this.f1521a.a(this.f1522b);
    }

    public final void b() {
        this.e = true;
        if (this.d) {
            this.f1521a.a(this.f1522b);
        }
    }

    public final void c() {
        this.e = false;
        if (this.d) {
            this.d = false;
            a(this.c, this.f);
        }
    }

    public final void d() {
        this.e = false;
        this.d = false;
        if (this.c != null && this.c.c != null) {
            this.c.c.remove("_ad");
        }
        a(this.c, 0L);
    }

    public final boolean e() {
        return this.d;
    }

    public final void b(bqj bqjVar) {
        a(bqjVar, 60000L);
    }

    public final void a(bqj bqjVar, long j) {
        if (this.d) {
            xe.e("An ad refresh is already scheduled.");
            return;
        }
        this.c = bqjVar;
        this.d = true;
        this.f = j;
        if (this.e) {
            return;
        }
        StringBuilder sb = new StringBuilder(65);
        sb.append("Scheduling ad refresh ");
        sb.append(j);
        sb.append(" milliseconds from now.");
        xe.d(sb.toString());
        this.f1521a.a(this.f1522b, j);
    }

    static /* synthetic */ boolean a(an anVar, boolean z) {
        anVar.d = false;
        return false;
    }
}
