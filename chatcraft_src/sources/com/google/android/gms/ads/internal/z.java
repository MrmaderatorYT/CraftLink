package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.aar;
import com.google.android.gms.internal.ads.abq;
import com.google.android.gms.internal.ads.bra;
import com.google.android.gms.internal.ads.bsl;
import com.google.android.gms.internal.ads.jt;
import com.google.android.gms.internal.ads.ju;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.kn;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.tq;
import com.google.android.gms.internal.ads.vb;
import com.google.android.gms.internal.ads.xe;
import com.google.android.gms.internal.ads.yj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class z extends bsl {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f1657b = new Object();

    @GuardedBy("sLock")
    private static z c;

    /* renamed from: a, reason: collision with root package name */
    private final Context f1658a;
    private final Object d = new Object();
    private boolean e = false;
    private aar f;

    public static z a(Context context, aar aarVar) {
        z zVar;
        synchronized (f1657b) {
            if (c == null) {
                c = new z(context.getApplicationContext(), aarVar);
            }
            zVar = c;
        }
        return zVar;
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void a(kk kkVar) {
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void b(String str) {
    }

    private z(Context context, aar aarVar) {
        this.f1658a = context;
        this.f = aarVar;
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void a() {
        synchronized (f1657b) {
            if (this.e) {
                xe.e("Mobile ads is initialized already.");
                return;
            }
            this.e = true;
            com.google.android.gms.internal.ads.o.a(this.f1658a);
            ax.i().a(this.f1658a, this.f);
            ax.k().a(this.f1658a);
        }
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void a(String str) {
        com.google.android.gms.internal.ads.o.a(this.f1658a);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.bL)).booleanValue()) {
            ax.m().a(this.f1658a, this.f, str, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void a(String str, com.google.android.gms.dynamic.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.google.android.gms.internal.ads.o.a(this.f1658a);
        boolean zBooleanValue = ((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.bL)).booleanValue() | ((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.aq)).booleanValue();
        Runnable runnable = null;
        if (((Boolean) bra.e().a(com.google.android.gms.internal.ads.o.aq)).booleanValue()) {
            zBooleanValue = true;
            final Runnable runnable2 = (Runnable) com.google.android.gms.dynamic.b.a(aVar);
            runnable = new Runnable(this, runnable2) { // from class: com.google.android.gms.ads.internal.aa

                /* renamed from: a, reason: collision with root package name */
                private final z f1498a;

                /* renamed from: b, reason: collision with root package name */
                private final Runnable f1499b;

                {
                    this.f1498a = this;
                    this.f1499b = runnable2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    final z zVar = this.f1498a;
                    final Runnable runnable3 = this.f1499b;
                    abq.f1816a.execute(new Runnable(zVar, runnable3) { // from class: com.google.android.gms.ads.internal.ac

                        /* renamed from: a, reason: collision with root package name */
                        private final z f1501a;

                        /* renamed from: b, reason: collision with root package name */
                        private final Runnable f1502b;

                        {
                            this.f1501a = zVar;
                            this.f1502b = runnable3;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f1501a.a(this.f1502b);
                        }
                    });
                }
            };
        }
        if (zBooleanValue) {
            ax.m().a(this.f1658a, this.f, str, runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void a(float f) {
        ax.j().a(f);
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final float b() {
        return ax.j().a();
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void a(boolean z) {
        ax.j().a(z);
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final boolean c() {
        return ax.j().b();
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final String d() {
        return this.f.f1790a;
    }

    @Override // com.google.android.gms.internal.ads.bsk
    public final void a(com.google.android.gms.dynamic.a aVar, String str) {
        if (aVar == null) {
            xe.c("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) com.google.android.gms.dynamic.b.a(aVar);
        if (context == null) {
            xe.c("Context is null. Failed to open debug menu.");
            return;
        }
        yj yjVar = new yj(context);
        yjVar.a(str);
        yjVar.b(this.f.f1790a);
        yjVar.a();
    }

    final /* synthetic */ void a(Runnable runnable) {
        Context context = this.f1658a;
        com.google.android.gms.common.internal.i.b("Adapters must be initialized on the main thread.");
        Map<String, ju> mapE = ax.i().k().h().e();
        if (mapE == null || mapE.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                xe.c("Could not initialize rewarded ads.", th);
                return;
            }
        }
        tq tqVarI = tq.I();
        if (tqVarI != null) {
            Collection<ju> collectionValues = mapE.values();
            HashMap map = new HashMap();
            com.google.android.gms.dynamic.a aVarA = com.google.android.gms.dynamic.b.a(context);
            Iterator<ju> it = collectionValues.iterator();
            while (it.hasNext()) {
                for (jt jtVar : it.next().f3211a) {
                    String str = jtVar.k;
                    for (String str2 : jtVar.c) {
                        if (!map.containsKey(str2)) {
                            map.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((Collection) map.get(str2)).add(str);
                        }
                    }
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    vb vbVarC = tqVarI.c(str3);
                    if (vbVarC != null) {
                        kn knVarA = vbVarC.a();
                        if (!knVarA.g() && knVarA.m()) {
                            knVarA.a(aVarA, vbVarC.b(), (List<String>) entry.getValue());
                            String strValueOf = String.valueOf(str3);
                            xe.b(strValueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(strValueOf) : new String("Initialized rewarded video mediation adapter "));
                        }
                    }
                } catch (Throwable th2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 56);
                    sb.append("Failed to initialize rewarded video mediation adapter \"");
                    sb.append(str3);
                    sb.append("\"");
                    xe.c(sb.toString(), th2);
                }
            }
        }
    }
}
