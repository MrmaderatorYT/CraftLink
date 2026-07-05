package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import java.io.InputStream;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class bok {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("mLock")
    private boc f2900a;

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("mLock")
    private boolean f2901b;
    private final Context c;
    private final Object d = new Object();

    bok(Context context) {
        this.c = context;
    }

    final Future<InputStream> a(bod bodVar) {
        bol bolVar = new bol(this);
        bom bomVar = new bom(this, bodVar, bolVar);
        boq boqVar = new boq(this, bolVar);
        synchronized (this.d) {
            this.f2900a = new boc(this.c, com.google.android.gms.ads.internal.ax.u().a(), bomVar, boqVar);
            this.f2900a.e();
        }
        return bolVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        synchronized (this.d) {
            if (this.f2900a == null) {
                return;
            }
            this.f2900a.h();
            this.f2900a = null;
            Binder.flushPendingCommands();
        }
    }

    static /* synthetic */ boolean a(bok bokVar, boolean z) {
        bokVar.f2901b = true;
        return true;
    }
}
