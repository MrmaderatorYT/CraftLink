package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class pd {

    /* renamed from: b, reason: collision with root package name */
    private final Context f3345b;
    private final axe c;
    private final wl d;
    private final ac e;
    private final com.google.android.gms.ads.internal.ad f;
    private ViewTreeObserver.OnGlobalLayoutListener g;
    private ViewTreeObserver.OnScrollChangedListener h;
    private final DisplayMetrics i;

    /* renamed from: a, reason: collision with root package name */
    private final Object f3344a = new Object();

    @GuardedBy("mLock")
    private int k = -1;

    @GuardedBy("mLock")
    private int l = -1;
    private zr j = new zr(200);

    public pd(Context context, axe axeVar, wl wlVar, ac acVar, com.google.android.gms.ads.internal.ad adVar) {
        this.f3345b = context;
        this.c = axeVar;
        this.d = wlVar;
        this.e = acVar;
        this.f = adVar;
        com.google.android.gms.ads.internal.ax.e();
        this.i = xn.a((WindowManager) context.getSystemService("window"));
    }

    private final void a(afu afuVar, boolean z) {
        afuVar.a("/video", com.google.android.gms.ads.internal.gmsg.n.l);
        afuVar.a("/videoMeta", com.google.android.gms.ads.internal.gmsg.n.m);
        afuVar.a("/precache", new afd());
        afuVar.a("/delayPageLoaded", com.google.android.gms.ads.internal.gmsg.n.p);
        afuVar.a("/instrument", com.google.android.gms.ads.internal.gmsg.n.n);
        afuVar.a("/log", com.google.android.gms.ads.internal.gmsg.n.g);
        afuVar.a("/videoClicked", com.google.android.gms.ads.internal.gmsg.n.h);
        afuVar.a("/trackActiveViewUnit", new pj(this));
        afuVar.a("/untrackActiveViewUnit", new pk(this));
        if (z) {
            afuVar.a("/open", new com.google.android.gms.ads.internal.gmsg.d(null, null));
        }
    }

    private final ViewTreeObserver.OnGlobalLayoutListener a(WeakReference<afu> weakReference) {
        if (this.g == null) {
            this.g = new pl(this, weakReference);
        }
        return this.g;
    }

    private final ViewTreeObserver.OnScrollChangedListener b(WeakReference<afu> weakReference) {
        if (this.h == null) {
            this.h = new pm(this, weakReference);
        }
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(WeakReference<afu> weakReference, boolean z) {
        afu afuVar;
        if (weakReference == null || (afuVar = weakReference.get()) == null || afuVar.getView() == null) {
            return;
        }
        if (!z || this.j.a()) {
            int[] iArr = new int[2];
            afuVar.getView().getLocationOnScreen(iArr);
            bra.a();
            int iB = aac.b(this.i, iArr[0]);
            bra.a();
            int iB2 = aac.b(this.i, iArr[1]);
            synchronized (this.f3344a) {
                if (this.k != iB || this.l != iB2) {
                    this.k = iB;
                    this.l = iB2;
                    afuVar.w().a(this.k, this.l, !z);
                }
            }
        }
    }

    private final afu a() {
        com.google.android.gms.ads.internal.ax.f();
        return aga.a(this.f3345b, ahh.a(), "native-video", false, false, this.c, this.d.f3545a.k, this.e, null, this.f.i(), this.d.i);
    }

    final /* synthetic */ void a(boolean z, final abv abvVar, String str, String str2) {
        try {
            final afu afuVarA = a();
            if (z) {
                afuVarA.a(ahh.c());
            } else {
                afuVarA.a(ahh.b());
            }
            this.f.a(afuVarA);
            WeakReference<afu> weakReference = new WeakReference<>(afuVarA);
            afuVarA.w().a(a(weakReference), b(weakReference));
            a(afuVarA, z);
            afuVarA.w().a(new ahc(this, abvVar, afuVarA) { // from class: com.google.android.gms.internal.ads.pg

                /* renamed from: a, reason: collision with root package name */
                private final pd f3350a;

                /* renamed from: b, reason: collision with root package name */
                private final abv f3351b;
                private final afu c;

                {
                    this.f3350a = this;
                    this.f3351b = abvVar;
                    this.c = afuVarA;
                }

                @Override // com.google.android.gms.internal.ads.ahc
                public final void a(boolean z2) {
                    this.f3350a.a(this.f3351b, this.c, z2);
                }
            });
            afuVarA.a(str, str2, (String) null);
        } catch (Exception e) {
            xe.c("Exception occurred while getting video view", e);
            abvVar.b(null);
        }
    }

    final /* synthetic */ void a(abv abvVar, afu afuVar, boolean z) {
        this.f.Q();
        abvVar.b(afuVar);
    }

    final /* synthetic */ void a(boolean z, final JSONObject jSONObject, final abv abvVar) {
        try {
            final afu afuVarA = a();
            if (z) {
                afuVarA.a(ahh.c());
            } else {
                afuVarA.a(ahh.b());
            }
            this.f.a(afuVarA);
            WeakReference<afu> weakReference = new WeakReference<>(afuVarA);
            afuVarA.w().a(a(weakReference), b(weakReference));
            a(afuVarA, z);
            afuVarA.w().a(new ahd(afuVarA, jSONObject) { // from class: com.google.android.gms.internal.ads.ph

                /* renamed from: a, reason: collision with root package name */
                private final afu f3352a;

                /* renamed from: b, reason: collision with root package name */
                private final JSONObject f3353b;

                {
                    this.f3352a = afuVarA;
                    this.f3353b = jSONObject;
                }

                @Override // com.google.android.gms.internal.ads.ahd
                public final void a() {
                    this.f3352a.b("google.afma.nativeAds.renderVideo", this.f3353b);
                }
            });
            afuVarA.w().a(new ahc(this, abvVar, afuVarA) { // from class: com.google.android.gms.internal.ads.pi

                /* renamed from: a, reason: collision with root package name */
                private final pd f3354a;

                /* renamed from: b, reason: collision with root package name */
                private final abv f3355b;
                private final afu c;

                {
                    this.f3354a = this;
                    this.f3355b = abvVar;
                    this.c = afuVarA;
                }

                @Override // com.google.android.gms.internal.ads.ahc
                public final void a(boolean z2) {
                    this.f3354a.b(this.f3355b, this.c, z2);
                }
            });
            afuVarA.loadUrl((String) bra.e().a(o.by));
        } catch (Exception e) {
            xe.c("Exception occurred while getting video view", e);
            abvVar.b(null);
        }
    }

    final /* synthetic */ void b(abv abvVar, afu afuVar, boolean z) {
        this.f.Q();
        abvVar.b(afuVar);
    }
}
