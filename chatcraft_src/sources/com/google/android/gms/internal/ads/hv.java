package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class hv {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3146a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f3147b;
    private final String c;
    private final aar d;
    private yu<hk> e;
    private yu<hk> f;
    private ip g;
    private int h;

    public hv(Context context, aar aarVar, String str) {
        this.f3146a = new Object();
        this.h = 1;
        this.c = str;
        this.f3147b = context.getApplicationContext();
        this.d = aarVar;
        this.e = new ik();
        this.f = new ik();
    }

    public hv(Context context, aar aarVar, String str, yu<hk> yuVar, yu<hk> yuVar2) {
        this(context, aarVar, str);
        this.e = yuVar;
        this.f = yuVar2;
    }

    protected final ip a(final axe axeVar) {
        final ip ipVar = new ip(this.f);
        abq.f1816a.execute(new Runnable(this, axeVar, ipVar) { // from class: com.google.android.gms.internal.ads.hw

            /* renamed from: a, reason: collision with root package name */
            private final hv f3148a;

            /* renamed from: b, reason: collision with root package name */
            private final axe f3149b;
            private final ip c;

            {
                this.f3148a = this;
                this.f3149b = axeVar;
                this.c = ipVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3148a.a(this.f3149b, this.c);
            }
        });
        ipVar.a(new ih(this, ipVar), new ii(this, ipVar));
        return ipVar;
    }

    public final il b(axe axeVar) {
        synchronized (this.f3146a) {
            synchronized (this.f3146a) {
                if (this.g != null && this.h == 0) {
                    if (((Boolean) bra.e().a(o.f3307b)).booleanValue()) {
                        this.g.a(new aca(this) { // from class: com.google.android.gms.internal.ads.hx

                            /* renamed from: a, reason: collision with root package name */
                            private final hv f3150a;

                            {
                                this.f3150a = this;
                            }

                            @Override // com.google.android.gms.internal.ads.aca
                            public final void a(Object obj) {
                                this.f3150a.a((hk) obj);
                            }
                        }, hy.f3151a);
                    }
                }
            }
            if (this.g != null && this.g.e() != -1) {
                if (this.h == 0) {
                    return this.g.a();
                }
                if (this.h == 1) {
                    this.h = 2;
                    a((axe) null);
                    return this.g.a();
                }
                if (this.h == 2) {
                    return this.g.a();
                }
                return this.g.a();
            }
            this.h = 2;
            this.g = a((axe) null);
            return this.g.a();
        }
    }

    final /* synthetic */ void a(hk hkVar) {
        if (hkVar.b()) {
            this.h = 1;
        }
    }

    final /* synthetic */ void a(axe axeVar, final ip ipVar) {
        final hk hmVar;
        try {
            Context context = this.f3147b;
            aar aarVar = this.d;
            if (((Boolean) bra.e().a(o.an)).booleanValue()) {
                hmVar = new gw(context, aarVar);
            } else {
                hmVar = new hm(context, aarVar, axeVar, null);
            }
            hmVar.a(new hl(this, ipVar, hmVar) { // from class: com.google.android.gms.internal.ads.hz

                /* renamed from: a, reason: collision with root package name */
                private final hv f3152a;

                /* renamed from: b, reason: collision with root package name */
                private final ip f3153b;
                private final hk c;

                {
                    this.f3152a = this;
                    this.f3153b = ipVar;
                    this.c = hmVar;
                }

                @Override // com.google.android.gms.internal.ads.hl
                public final void a() {
                    final hv hvVar = this.f3152a;
                    final ip ipVar2 = this.f3153b;
                    final hk hkVar = this.c;
                    xn.f3583a.postDelayed(new Runnable(hvVar, ipVar2, hkVar) { // from class: com.google.android.gms.internal.ads.ia

                        /* renamed from: a, reason: collision with root package name */
                        private final hv f3154a;

                        /* renamed from: b, reason: collision with root package name */
                        private final ip f3155b;
                        private final hk c;

                        {
                            this.f3154a = hvVar;
                            this.f3155b = ipVar2;
                            this.c = hkVar;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f3154a.a(this.f3155b, this.c);
                        }
                    }, ij.f3171b);
                }
            });
            hmVar.a("/jsLoaded", new id(this, ipVar, hmVar));
            zs zsVar = new zs();
            ie ieVar = new ie(this, axeVar, hmVar, zsVar);
            zsVar.a(ieVar);
            hmVar.a("/requestReload", ieVar);
            if (this.c.endsWith(".js")) {
                hmVar.a(this.c);
            } else if (this.c.startsWith("<html>")) {
                hmVar.b(this.c);
            } else {
                hmVar.c(this.c);
            }
            xn.f3583a.postDelayed(new Cif(this, ipVar, hmVar), ij.f3170a);
        } catch (Throwable th) {
            xe.b("Error creating webview.", th);
            com.google.android.gms.ads.internal.ax.i().a(th, "SdkJavascriptFactory.loadJavascriptEngine");
            ipVar.d();
        }
    }

    final /* synthetic */ void a(ip ipVar, hk hkVar) {
        synchronized (this.f3146a) {
            if (ipVar.e() != -1 && ipVar.e() != 1) {
                ipVar.d();
                Executor executor = abq.f1816a;
                hkVar.getClass();
                executor.execute(ib.a(hkVar));
                xe.a("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
