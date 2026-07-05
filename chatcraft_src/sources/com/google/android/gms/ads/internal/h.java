package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.aac;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.axa;
import com.google.android.gms.internal.ads.axd;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.xl;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
/* loaded from: classes.dex */
public final class h implements axa, Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final List<Object[]> f1609a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<axa> f1610b;
    private Context c;
    private aar d;
    private CountDownLatch e;

    public h(ay ayVar) {
        this(ayVar.c, ayVar.e);
    }

    private h(Context context, aar aarVar) {
        this.f1609a = new Vector();
        this.f1610b = new AtomicReference<>();
        this.e = new CountDownLatch(1);
        this.c = context;
        this.d = aarVar;
        bra.a();
        if (aac.b()) {
            xl.a(this);
        } else {
            run();
        }
    }

    private final boolean a() throws InterruptedException {
        try {
            this.e.await();
            return true;
        } catch (InterruptedException e) {
            xe.c("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void b() {
        if (this.f1609a.isEmpty()) {
            return;
        }
        for (Object[] objArr : this.f1609a) {
            if (objArr.length == 1) {
                this.f1610b.get().a((MotionEvent) objArr[0]);
            } else if (objArr.length == 3) {
                this.f1610b.get().a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.f1609a.clear();
    }

    private static Context b(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    @Override // com.google.android.gms.internal.ads.axa
    public final String a(Context context) {
        axa axaVar;
        if (!a() || (axaVar = this.f1610b.get()) == null) {
            return BuildConfig.FLAVOR;
        }
        b();
        return axaVar.a(b(context));
    }

    @Override // com.google.android.gms.internal.ads.axa
    public final String a(Context context, String str, View view) {
        return a(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.axa
    public final String a(Context context, String str, View view, Activity activity) {
        axa axaVar;
        if (!a() || (axaVar = this.f1610b.get()) == null) {
            return BuildConfig.FLAVOR;
        }
        b();
        return axaVar.a(b(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.axa
    public final void a(View view) {
        axa axaVar = this.f1610b.get();
        if (axaVar != null) {
            axaVar.a(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.axa
    public final void a(MotionEvent motionEvent) {
        axa axaVar = this.f1610b.get();
        if (axaVar != null) {
            b();
            axaVar.a(motionEvent);
        } else {
            this.f1609a.add(new Object[]{motionEvent});
        }
    }

    @Override // com.google.android.gms.internal.ads.axa
    public final void a(int i, int i2, int i3) {
        axa axaVar = this.f1610b.get();
        if (axaVar != null) {
            b();
            axaVar.a(i, i2, i3);
        } else {
            this.f1609a.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.d.d;
            if (!((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.ay)).booleanValue() && z2) {
                z = true;
            }
            this.f1610b.set(axd.a(this.d.f1790a, b(this.c), z));
        } finally {
            this.e.countDown();
            this.c = null;
            this.d = null;
        }
    }
}
