package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class agj extends bsx {

    /* renamed from: a, reason: collision with root package name */
    private final adk f1962a;
    private final boolean c;
    private final boolean d;

    @GuardedBy("lock")
    private int e;

    @GuardedBy("lock")
    private bsz f;

    @GuardedBy("lock")
    private boolean g;

    @GuardedBy("lock")
    private float i;

    @GuardedBy("lock")
    private float j;

    @GuardedBy("lock")
    private float k;

    @GuardedBy("lock")
    private boolean l;

    @GuardedBy("lock")
    private boolean m;

    /* renamed from: b, reason: collision with root package name */
    private final Object f1963b = new Object();

    @GuardedBy("lock")
    private boolean h = true;

    public agj(adk adkVar, float f, boolean z, boolean z2) {
        this.f1962a = adkVar;
        this.i = f;
        this.c = z;
        this.d = z2;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final void a() {
        a("play", null);
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final void b() {
        a("pause", null);
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final void a(boolean z) {
        a(z ? "mute" : "unmute", null);
    }

    public final void a(buc bucVar) {
        a(bucVar.f3034a, bucVar.f3035b, bucVar.c);
    }

    public final void a(boolean z, boolean z2, boolean z3) {
        synchronized (this.f1963b) {
            this.l = z2;
            this.m = z3;
        }
        a("initialState", com.google.android.gms.common.util.d.a("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    private final void a(String str, Map<String, String> map) {
        final HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put("action", str);
        abq.f1816a.execute(new Runnable(this, map2) { // from class: com.google.android.gms.internal.ads.agk

            /* renamed from: a, reason: collision with root package name */
            private final agj f1964a;

            /* renamed from: b, reason: collision with root package name */
            private final Map f1965b;

            {
                this.f1964a = this;
                this.f1965b = map2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1964a.a(this.f1965b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final boolean c() {
        boolean z;
        synchronized (this.f1963b) {
            z = this.h;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final int d() {
        int i;
        synchronized (this.f1963b) {
            i = this.e;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final float h() {
        float f;
        synchronized (this.f1963b) {
            f = this.k;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final float e() {
        float f;
        synchronized (this.f1963b) {
            f = this.i;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final float f() {
        float f;
        synchronized (this.f1963b) {
            f = this.j;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final void a(bsz bszVar) {
        synchronized (this.f1963b) {
            this.f = bszVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final bsz g() {
        bsz bszVar;
        synchronized (this.f1963b) {
            bszVar = this.f;
        }
        return bszVar;
    }

    @Override // com.google.android.gms.internal.ads.bsw
    public final boolean i() {
        boolean z;
        synchronized (this.f1963b) {
            z = this.c && this.l;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    @Override // com.google.android.gms.internal.ads.bsw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j() {
        /*
            r2 = this;
            boolean r0 = r2.i()
            java.lang.Object r1 = r2.f1963b
            monitor-enter(r1)
            if (r0 != 0) goto L15
            boolean r0 = r2.m     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto L15
            boolean r0 = r2.d     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto L15
            r0 = 1
            goto L16
        L13:
            r0 = move-exception
            goto L18
        L15:
            r0 = 0
        L16:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L13
            return r0
        L18:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L13
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agj.j():boolean");
    }

    public final void a(float f) {
        synchronized (this.f1963b) {
            this.j = f;
        }
    }

    public final void k() {
        boolean z;
        int i;
        synchronized (this.f1963b) {
            z = this.h;
            i = this.e;
            this.e = 3;
        }
        b(i, 3, z, z);
    }

    public final void a(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        int i2;
        synchronized (this.f1963b) {
            this.i = f2;
            this.j = f;
            z2 = this.h;
            this.h = z;
            i2 = this.e;
            this.e = i;
            float f4 = this.k;
            this.k = f3;
            if (Math.abs(this.k - f4) > 1.0E-4f) {
                this.f1962a.getView().invalidate();
            }
        }
        b(i2, i, z2, z);
    }

    private final void b(final int i, final int i2, final boolean z, final boolean z2) {
        abq.f1816a.execute(new Runnable(this, i, i2, z, z2) { // from class: com.google.android.gms.internal.ads.agl

            /* renamed from: a, reason: collision with root package name */
            private final agj f1966a;

            /* renamed from: b, reason: collision with root package name */
            private final int f1967b;
            private final int c;
            private final boolean d;
            private final boolean e;

            {
                this.f1966a = this;
                this.f1967b = i;
                this.c = i2;
                this.d = z;
                this.e = z2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1966a.a(this.f1967b, this.c, this.d, this.e);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final /* synthetic */ void a(int r7, int r8, boolean r9, boolean r10) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f1963b
            monitor-enter(r0)
            r1 = 0
            r2 = 1
            if (r7 == r8) goto L9
            r7 = 1
            goto La
        L9:
            r7 = 0
        La:
            boolean r3 = r6.g     // Catch: java.lang.Throwable -> L8b
            if (r3 != 0) goto L12
            if (r8 != r2) goto L12
            r3 = 1
            goto L13
        L12:
            r3 = 0
        L13:
            if (r7 == 0) goto L19
            if (r8 != r2) goto L19
            r4 = 1
            goto L1a
        L19:
            r4 = 0
        L1a:
            if (r7 == 0) goto L21
            r5 = 2
            if (r8 != r5) goto L21
            r5 = 1
            goto L22
        L21:
            r5 = 0
        L22:
            if (r7 == 0) goto L29
            r7 = 3
            if (r8 != r7) goto L29
            r7 = 1
            goto L2a
        L29:
            r7 = 0
        L2a:
            if (r9 == r10) goto L2e
            r8 = 1
            goto L2f
        L2e:
            r8 = 0
        L2f:
            boolean r9 = r6.g     // Catch: java.lang.Throwable -> L8b
            if (r9 != 0) goto L35
            if (r3 == 0) goto L36
        L35:
            r1 = 1
        L36:
            r6.g = r1     // Catch: java.lang.Throwable -> L8b
            com.google.android.gms.internal.ads.bsz r9 = r6.f     // Catch: java.lang.Throwable -> L8b
            if (r9 != 0) goto L3e
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
            return
        L3e:
            if (r3 == 0) goto L4c
            com.google.android.gms.internal.ads.bsz r9 = r6.f     // Catch: android.os.RemoteException -> L46 java.lang.Throwable -> L8b
            r9.a()     // Catch: android.os.RemoteException -> L46 java.lang.Throwable -> L8b
            goto L4c
        L46:
            r9 = move-exception
            java.lang.String r1 = "Unable to call onVideoStart()"
            com.google.android.gms.internal.ads.xe.c(r1, r9)     // Catch: java.lang.Throwable -> L8b
        L4c:
            if (r4 == 0) goto L5a
            com.google.android.gms.internal.ads.bsz r9 = r6.f     // Catch: android.os.RemoteException -> L54 java.lang.Throwable -> L8b
            r9.b()     // Catch: android.os.RemoteException -> L54 java.lang.Throwable -> L8b
            goto L5a
        L54:
            r9 = move-exception
            java.lang.String r1 = "Unable to call onVideoPlay()"
            com.google.android.gms.internal.ads.xe.c(r1, r9)     // Catch: java.lang.Throwable -> L8b
        L5a:
            if (r5 == 0) goto L68
            com.google.android.gms.internal.ads.bsz r9 = r6.f     // Catch: android.os.RemoteException -> L62 java.lang.Throwable -> L8b
            r9.c()     // Catch: android.os.RemoteException -> L62 java.lang.Throwable -> L8b
            goto L68
        L62:
            r9 = move-exception
            java.lang.String r1 = "Unable to call onVideoPause()"
            com.google.android.gms.internal.ads.xe.c(r1, r9)     // Catch: java.lang.Throwable -> L8b
        L68:
            if (r7 == 0) goto L7b
            com.google.android.gms.internal.ads.bsz r7 = r6.f     // Catch: android.os.RemoteException -> L70 java.lang.Throwable -> L8b
            r7.d()     // Catch: android.os.RemoteException -> L70 java.lang.Throwable -> L8b
            goto L76
        L70:
            r7 = move-exception
            java.lang.String r9 = "Unable to call onVideoEnd()"
            com.google.android.gms.internal.ads.xe.c(r9, r7)     // Catch: java.lang.Throwable -> L8b
        L76:
            com.google.android.gms.internal.ads.adk r7 = r6.f1962a     // Catch: java.lang.Throwable -> L8b
            r7.n()     // Catch: java.lang.Throwable -> L8b
        L7b:
            if (r8 == 0) goto L89
            com.google.android.gms.internal.ads.bsz r7 = r6.f     // Catch: android.os.RemoteException -> L83 java.lang.Throwable -> L8b
            r7.a(r10)     // Catch: android.os.RemoteException -> L83 java.lang.Throwable -> L8b
            goto L89
        L83:
            r7 = move-exception
            java.lang.String r8 = "Unable to call onVideoMute()"
            com.google.android.gms.internal.ads.xe.c(r8, r7)     // Catch: java.lang.Throwable -> L8b
        L89:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
            return
        L8b:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agj.a(int, int, boolean, boolean):void");
    }

    final /* synthetic */ void a(Map map) {
        this.f1962a.a("pubVideoCmd", (Map<String, ?>) map);
    }
}
