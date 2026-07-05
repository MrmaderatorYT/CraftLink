package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

@qj
/* loaded from: classes.dex */
public final class kh implements js {

    /* renamed from: a, reason: collision with root package name */
    private final ri f3228a;

    /* renamed from: b, reason: collision with root package name */
    private final kk f3229b;
    private final Context c;
    private final ju e;
    private final boolean f;
    private final long g;
    private final long h;
    private final ac i;
    private final boolean j;
    private final String k;
    private jx m;
    private final boolean o;
    private final Object d = new Object();
    private boolean l = false;
    private List<ka> n = new ArrayList();

    public kh(Context context, ri riVar, kk kkVar, ju juVar, boolean z, boolean z2, String str, long j, long j2, ac acVar, boolean z3) {
        this.c = context;
        this.f3228a = riVar;
        this.f3229b = kkVar;
        this.e = juVar;
        this.f = z;
        this.j = z2;
        this.k = str;
        this.g = j;
        this.h = j2;
        this.i = acVar;
        this.o = z3;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:50:0x0177
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // com.google.android.gms.internal.ads.js
    public final com.google.android.gms.internal.ads.ka a(java.util.List<com.google.android.gms.internal.ads.jt> r36) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.kh.a(java.util.List):com.google.android.gms.internal.ads.ka");
    }

    @Override // com.google.android.gms.internal.ads.js
    public final void a() {
        synchronized (this.d) {
            this.l = true;
            if (this.m != null) {
                this.m.a();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.js
    public final List<ka> b() {
        return this.n;
    }
}
