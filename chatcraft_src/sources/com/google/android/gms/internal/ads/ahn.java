package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class ahn {
    public static afu a(final Context context, final ahh ahhVar, final String str, final boolean z, final boolean z2, final axe axeVar, final aar aarVar, final ac acVar, final com.google.android.gms.ads.internal.aq aqVar, final com.google.android.gms.ads.internal.bt btVar, bos bosVar) throws zzbgq {
        try {
            return (afu) zt.a(new Callable(context, ahhVar, str, z, z2, axeVar, aarVar, acVar, aqVar, btVar) { // from class: com.google.android.gms.internal.ads.ahp

                /* renamed from: a, reason: collision with root package name */
                private final Context f1988a;

                /* renamed from: b, reason: collision with root package name */
                private final ahh f1989b;
                private final String c;
                private final boolean d;
                private final boolean e;
                private final axe f;
                private final aar g;
                private final ac h;
                private final com.google.android.gms.ads.internal.aq i;
                private final com.google.android.gms.ads.internal.bt j;

                {
                    this.f1988a = context;
                    this.f1989b = ahhVar;
                    this.c = str;
                    this.d = z;
                    this.e = z2;
                    this.f = axeVar;
                    this.g = aarVar;
                    this.h = acVar;
                    this.i = aqVar;
                    this.j = btVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context2 = this.f1988a;
                    ahh ahhVar2 = this.f1989b;
                    String str2 = this.c;
                    boolean z3 = this.d;
                    boolean z4 = this.e;
                    axe axeVar2 = this.f;
                    aar aarVar2 = this.g;
                    ac acVar2 = this.h;
                    com.google.android.gms.ads.internal.aq aqVar2 = this.i;
                    com.google.android.gms.ads.internal.bt btVar2 = this.j;
                    ahi ahiVar = new ahi();
                    ahq ahqVar = new ahq(new ahg(context2), ahiVar, ahhVar2, str2, z3, z4, axeVar2, aarVar2, acVar2, aqVar2, btVar2);
                    age ageVar = new age(ahqVar);
                    ahqVar.setWebChromeClient(new afl(ageVar));
                    ahiVar.a(ageVar, z4);
                    return ageVar;
                }
            });
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.ax.i().a(th, "AdWebViewFactory.newAdWebView2");
            throw new zzbgq("Webview initialization failed.", th);
        }
    }
}
