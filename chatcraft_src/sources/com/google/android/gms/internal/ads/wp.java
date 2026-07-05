package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class wp {

    /* renamed from: b, reason: collision with root package name */
    private bli f3554b;
    private Context f;
    private aar g;
    private String j;
    private abl<ArrayList<String>> n;

    /* renamed from: a, reason: collision with root package name */
    private final Object f3553a = new Object();
    private final xi c = new xi();
    private final wy d = new wy(bra.f(), this.c);
    private boolean e = false;

    @Nullable
    private r h = null;

    @Nullable
    private Boolean i = null;
    private final AtomicInteger k = new AtomicInteger(0);
    private final ws l = new ws(null);
    private final Object m = new Object();

    @Nullable
    public final r a() {
        r rVar;
        synchronized (this.f3553a) {
            rVar = this.h;
        }
        return rVar;
    }

    public final void a(Boolean bool) {
        synchronized (this.f3553a) {
            this.i = bool;
        }
    }

    public final Boolean b() {
        Boolean bool;
        synchronized (this.f3553a) {
            bool = this.i;
        }
        return bool;
    }

    public final void a(boolean z) {
        this.l.a(z);
    }

    public final boolean c() {
        return this.l.a();
    }

    public final boolean d() {
        return this.l.b();
    }

    public final void e() {
        this.l.c();
    }

    @TargetApi(23)
    public final void a(Context context, aar aarVar) {
        synchronized (this.f3553a) {
            if (!this.e) {
                this.f = context.getApplicationContext();
                this.g = aarVar;
                com.google.android.gms.ads.internal.ax.h().a(this.d);
                r rVar = null;
                this.c.a(this.f, (String) null, true);
                qd.a(this.f, this.g);
                this.j = com.google.android.gms.ads.internal.ax.e().b(context, aarVar.f1790a);
                this.f3554b = new bli(context.getApplicationContext(), this.g);
                com.google.android.gms.ads.internal.ax.n();
                if (!((Boolean) bra.e().a(o.K)).booleanValue()) {
                    xe.a("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                } else {
                    rVar = new r();
                }
                this.h = rVar;
                if (this.h != null) {
                    aax.a((abl) new wr(this).c(), "AppState.registerCsiReporter");
                }
                this.e = true;
                m();
            }
        }
    }

    public final bli f() {
        return this.f3554b;
    }

    @Nullable
    public final Resources g() {
        if (this.g.d) {
            return this.f.getResources();
        }
        try {
            aao.a(this.f).getResources();
            return null;
        } catch (zzbbg e) {
            xe.c("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void a(Throwable th, String str) {
        qd.a(this.f, this.g).a(th, str);
    }

    public final void b(Throwable th, String str) {
        qd.a(this.f, this.g).a(th, str, ((Float) bra.e().a(o.g)).floatValue());
    }

    public final void h() {
        this.k.incrementAndGet();
    }

    public final void i() {
        this.k.decrementAndGet();
    }

    public final int j() {
        return this.k.get();
    }

    @Deprecated
    public final xh k() {
        xi xiVar;
        synchronized (this.f3553a) {
            xiVar = this.c;
        }
        return xiVar;
    }

    @Nullable
    public final Context l() {
        return this.f;
    }

    public final abl<ArrayList<String>> m() {
        if (com.google.android.gms.common.util.j.c() && this.f != null) {
            if (!((Boolean) bra.e().a(o.bj)).booleanValue()) {
                synchronized (this.m) {
                    if (this.n != null) {
                        return this.n;
                    }
                    abl<ArrayList<String>> ablVarA = xl.a(new Callable(this) { // from class: com.google.android.gms.internal.ads.wq

                        /* renamed from: a, reason: collision with root package name */
                        private final wp f3555a;

                        {
                            this.f3555a = this;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.f3555a.o();
                        }
                    });
                    this.n = ablVarA;
                    return ablVarA;
                }
            }
        }
        return aaz.a(new ArrayList());
    }

    @TargetApi(16)
    private static ArrayList<String> a(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfoB = com.google.android.gms.common.b.c.a(context).b(context.getApplicationInfo().packageName, 4096);
            if (packageInfoB.requestedPermissions == null || packageInfoB.requestedPermissionsFlags == null) {
                return arrayList;
            }
            for (int i = 0; i < packageInfoB.requestedPermissions.length; i++) {
                if ((packageInfoB.requestedPermissionsFlags[i] & 2) != 0) {
                    arrayList.add(packageInfoB.requestedPermissions[i]);
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException unused) {
            return arrayList;
        }
    }

    public final wy n() {
        return this.d;
    }

    final /* synthetic */ ArrayList o() {
        return a(to.a(this.f));
    }
}
