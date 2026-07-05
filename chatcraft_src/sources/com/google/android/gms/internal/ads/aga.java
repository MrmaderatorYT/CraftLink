package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class aga {
    public static abl<afu> a(final Context context, final aar aarVar, final String str, final axe axeVar, final com.google.android.gms.ads.internal.bt btVar) {
        return aaz.a(aaz.a((Object) null), new aau(context, axeVar, aarVar, btVar, str) { // from class: com.google.android.gms.internal.ads.agb

            /* renamed from: a, reason: collision with root package name */
            private final Context f1950a;

            /* renamed from: b, reason: collision with root package name */
            private final axe f1951b;
            private final aar c;
            private final com.google.android.gms.ads.internal.bt d;
            private final String e;

            {
                this.f1950a = context;
                this.f1951b = axeVar;
                this.c = aarVar;
                this.d = btVar;
                this.e = str;
            }

            @Override // com.google.android.gms.internal.ads.aau
            public final abl a(Object obj) {
                Context context2 = this.f1950a;
                axe axeVar2 = this.f1951b;
                aar aarVar2 = this.c;
                com.google.android.gms.ads.internal.bt btVar2 = this.d;
                String str2 = this.e;
                com.google.android.gms.ads.internal.ax.f();
                afu afuVarA = aga.a(context2, ahh.a(), BuildConfig.FLAVOR, false, false, axeVar2, aarVar2, null, null, btVar2, bos.a());
                final abu abuVarA = abu.a(afuVarA);
                afuVarA.w().a(new ahc(abuVarA) { // from class: com.google.android.gms.internal.ads.agd

                    /* renamed from: a, reason: collision with root package name */
                    private final abu f1954a;

                    {
                        this.f1954a = abuVarA;
                    }

                    @Override // com.google.android.gms.internal.ads.ahc
                    public final void a(boolean z) {
                        this.f1954a.a();
                    }
                });
                afuVarA.loadUrl(str2);
                return abuVarA;
            }
        }, abq.f1816a);
    }

    public static afu a(final Context context, final ahh ahhVar, final String str, final boolean z, final boolean z2, final axe axeVar, final aar aarVar, final ac acVar, final com.google.android.gms.ads.internal.aq aqVar, final com.google.android.gms.ads.internal.bt btVar, final bos bosVar) {
        o.a(context);
        if (((Boolean) bra.e().a(o.am)).booleanValue()) {
            return ahn.a(context, ahhVar, str, z, z2, axeVar, aarVar, acVar, aqVar, btVar, bosVar);
        }
        try {
            return (afu) zt.a(new Callable(context, ahhVar, str, z, z2, axeVar, aarVar, acVar, aqVar, btVar, bosVar) { // from class: com.google.android.gms.internal.ads.agc

                /* renamed from: a, reason: collision with root package name */
                private final Context f1952a;

                /* renamed from: b, reason: collision with root package name */
                private final ahh f1953b;
                private final String c;
                private final boolean d;
                private final boolean e;
                private final axe f;
                private final aar g;
                private final ac h;
                private final com.google.android.gms.ads.internal.aq i;
                private final com.google.android.gms.ads.internal.bt j;
                private final bos k;

                {
                    this.f1952a = context;
                    this.f1953b = ahhVar;
                    this.c = str;
                    this.d = z;
                    this.e = z2;
                    this.f = axeVar;
                    this.g = aarVar;
                    this.h = acVar;
                    this.i = aqVar;
                    this.j = btVar;
                    this.k = bosVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context2 = this.f1952a;
                    ahh ahhVar2 = this.f1953b;
                    String str2 = this.c;
                    boolean z3 = this.d;
                    boolean z4 = this.e;
                    axe axeVar2 = this.f;
                    aar aarVar2 = this.g;
                    ac acVar2 = this.h;
                    com.google.android.gms.ads.internal.aq aqVar2 = this.i;
                    com.google.android.gms.ads.internal.bt btVar2 = this.j;
                    bos bosVar2 = this.k;
                    age ageVar = new age(agg.a(context2, ahhVar2, str2, z3, z4, axeVar2, aarVar2, acVar2, aqVar2, btVar2, bosVar2));
                    ageVar.setWebViewClient(com.google.android.gms.ads.internal.ax.g().a(ageVar, bosVar2, z4));
                    ageVar.setWebChromeClient(new afl(ageVar));
                    return ageVar;
                }
            });
        } catch (Throwable th) {
            throw new zzbgq("Webview initialization failed.", th);
        }
    }
}
