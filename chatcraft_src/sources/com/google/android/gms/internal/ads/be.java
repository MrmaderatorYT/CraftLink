package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class be extends bj {
    private kw c;
    private kz d;
    private lc e;
    private final bg f;
    private bf g;
    private boolean h;
    private boolean i;
    private final Object j;

    public be(Context context, bg bgVar, axe axeVar, kw kwVar, bh bhVar) {
        this(context, bgVar, axeVar, bhVar);
        this.c = kwVar;
    }

    @Override // com.google.android.gms.internal.ads.bj
    public final afu j() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final void k() {
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final void l() {
    }

    public be(Context context, bg bgVar, axe axeVar, kz kzVar, bh bhVar) {
        this(context, bgVar, axeVar, bhVar);
        this.d = kzVar;
    }

    public be(Context context, bg bgVar, axe axeVar, lc lcVar, bh bhVar) {
        this(context, bgVar, axeVar, bhVar);
        this.e = lcVar;
    }

    private be(Context context, bg bgVar, axe axeVar, bh bhVar) {
        super(context, bgVar, null, axeVar, null, bhVar, null, null);
        this.h = false;
        this.i = false;
        this.j = new Object();
        this.f = bgVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0038, code lost:
    
        r4 = null;
     */
    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View a(android.view.View.OnClickListener r3, boolean r4) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.j
            monitor-enter(r0)
            com.google.android.gms.internal.ads.bf r1 = r2.g     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto Lf
            com.google.android.gms.internal.ads.bf r1 = r2.g     // Catch: java.lang.Throwable -> L44
            android.view.View r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> L44
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L44
            return r3
        Lf:
            r3 = 0
            com.google.android.gms.internal.ads.lc r4 = r2.e     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            if (r4 == 0) goto L1b
            com.google.android.gms.internal.ads.lc r4 = r2.e     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            com.google.android.gms.dynamic.a r4 = r4.l()     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            goto L38
        L1b:
            com.google.android.gms.internal.ads.kw r4 = r2.c     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            if (r4 == 0) goto L26
            com.google.android.gms.internal.ads.kw r4 = r2.c     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            com.google.android.gms.dynamic.a r4 = r4.n()     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            goto L38
        L26:
            com.google.android.gms.internal.ads.kz r4 = r2.d     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            if (r4 == 0) goto L37
            com.google.android.gms.internal.ads.kz r4 = r2.d     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            com.google.android.gms.dynamic.a r4 = r4.k()     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            goto L38
        L31:
            r4 = move-exception
            java.lang.String r1 = "Failed to call getAdChoicesContent"
            com.google.android.gms.internal.ads.xe.c(r1, r4)     // Catch: java.lang.Throwable -> L44
        L37:
            r4 = r3
        L38:
            if (r4 == 0) goto L42
            java.lang.Object r3 = com.google.android.gms.dynamic.b.a(r4)     // Catch: java.lang.Throwable -> L44
            android.view.View r3 = (android.view.View) r3     // Catch: java.lang.Throwable -> L44
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L44
            return r3
        L42:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L44
            return r3
        L44:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L44
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.be.a(android.view.View$OnClickListener, boolean):android.view.View");
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final boolean a() {
        synchronized (this.j) {
            if (this.g != null) {
                return this.g.a();
            }
            return this.f.R();
        }
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final boolean b() {
        synchronized (this.j) {
            if (this.g != null) {
                return this.g.b();
            }
            return this.f.T();
        }
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final boolean c() {
        synchronized (this.j) {
            if (this.g != null) {
                return this.g.c();
            }
            return this.f.S();
        }
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final void a(dv dvVar) {
        synchronized (this.j) {
            if (this.g != null) {
                this.g.a(dvVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final void d() {
        synchronized (this.j) {
            if (this.g != null) {
                this.g.d();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final void a(View view) {
        synchronized (this.j) {
            if (this.g != null) {
                this.g.a(view);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final void a(View view, Map<String, WeakReference<View>> map) {
        com.google.android.gms.common.internal.i.b("recordImpression must be called on the main UI thread.");
        synchronized (this.j) {
            this.f2721a = true;
            if (this.g != null) {
                this.g.a(view, map);
                this.f.ac();
            } else {
                try {
                    if (this.e != null && !this.e.p()) {
                        this.e.r();
                        this.f.ac();
                    } else if (this.c != null && !this.c.j()) {
                        this.c.i();
                        this.f.ac();
                    } else if (this.d != null && !this.d.h()) {
                        this.d.g();
                        this.f.ac();
                    }
                } catch (RemoteException e) {
                    xe.c("Failed to call recordImpression", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final void e() {
        com.google.android.gms.common.internal.i.b("recordDownloadedImpression must be called on main UI thread.");
        synchronized (this.j) {
            this.f2722b = true;
            if (this.g != null) {
                this.g.e();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final void a(MotionEvent motionEvent) {
        synchronized (this.j) {
            if (this.g != null) {
                this.g.a(motionEvent);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final void a(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        com.google.android.gms.common.internal.i.b("performClick must be called on the main UI thread.");
        synchronized (this.j) {
            if (this.i && b()) {
                return;
            }
            if (this.g != null) {
                this.g.a(view, map, bundle, view2);
                this.f.e();
            } else {
                e(view);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final void f() {
        this.i = true;
        if (this.g != null) {
            this.g.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final void g() {
        com.google.android.gms.common.internal.i.b("recordCustomClickGesture must be called on the main UI thread.");
        synchronized (this.j) {
            if (this.g != null) {
                if (this.i) {
                    this.g.f();
                }
                this.g.g();
                this.f.e();
            } else if (!this.i) {
                xe.e("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
            } else if (!b()) {
                xe.e("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
            } else if (q() != null) {
                e(q().c());
            }
        }
    }

    private final void e(View view) {
        try {
            if (this.e != null && !this.e.q()) {
                this.e.a(com.google.android.gms.dynamic.b.a(view));
                this.f.e();
            } else if (this.c != null && !this.c.k()) {
                this.c.a(com.google.android.gms.dynamic.b.a(view));
                this.f.e();
            } else {
                if (this.d == null || this.d.i()) {
                    return;
                }
                this.d.a(com.google.android.gms.dynamic.b.a(view));
                this.f.e();
            }
        } catch (RemoteException e) {
            xe.c("Failed to call performClick", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.bj
    public final void a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        synchronized (this.j) {
            this.h = true;
            HashMap<String, View> mapB = b(map);
            HashMap<String, View> mapB2 = b(map2);
            try {
                if (this.e != null) {
                    this.e.a(com.google.android.gms.dynamic.b.a(view), com.google.android.gms.dynamic.b.a(mapB), com.google.android.gms.dynamic.b.a(mapB2));
                } else if (this.c != null) {
                    this.c.a(com.google.android.gms.dynamic.b.a(view), com.google.android.gms.dynamic.b.a(mapB), com.google.android.gms.dynamic.b.a(mapB2));
                    this.c.b(com.google.android.gms.dynamic.b.a(view));
                } else if (this.d != null) {
                    this.d.a(com.google.android.gms.dynamic.b.a(view), com.google.android.gms.dynamic.b.a(mapB), com.google.android.gms.dynamic.b.a(mapB2));
                    this.d.b(com.google.android.gms.dynamic.b.a(view));
                }
            } catch (RemoteException e) {
                xe.c("Failed to call prepareAd", e);
            }
            this.h = false;
        }
    }

    private static HashMap<String, View> b(Map<String, WeakReference<View>> map) {
        HashMap<String, View> map2 = new HashMap<>();
        if (map == null) {
            return map2;
        }
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view = entry.getValue().get();
                if (view != null) {
                    map2.put(entry.getKey(), view);
                }
            }
        }
        return map2;
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final void b(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.j) {
            try {
                if (this.e != null) {
                    this.e.b(com.google.android.gms.dynamic.b.a(view));
                } else if (this.c != null) {
                    this.c.c(com.google.android.gms.dynamic.b.a(view));
                } else if (this.d != null) {
                    this.d.c(com.google.android.gms.dynamic.b.a(view));
                }
            } catch (RemoteException e) {
                xe.c("Failed to call untrackView", e);
            }
        }
    }

    public final boolean h() {
        boolean z;
        synchronized (this.j) {
            z = this.h;
        }
        return z;
    }

    public final void a(bf bfVar) {
        synchronized (this.j) {
            this.g = bfVar;
        }
    }

    public final bf i() {
        bf bfVar;
        synchronized (this.j) {
            bfVar = this.g;
        }
        return bfVar;
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final void m() {
        if (this.g != null) {
            this.g.m();
        }
    }

    @Override // com.google.android.gms.internal.ads.bj, com.google.android.gms.internal.ads.bf
    public final void n() {
        if (this.g != null) {
            this.g.n();
        }
    }
}
