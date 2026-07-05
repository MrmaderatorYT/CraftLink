package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class hm implements he, hk {

    /* renamed from: a, reason: collision with root package name */
    private final afu f3132a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f3133b;

    public hm(Context context, aar aarVar, axe axeVar, com.google.android.gms.ads.internal.bt btVar) {
        this.f3133b = context;
        com.google.android.gms.ads.internal.ax.f();
        this.f3132a = aga.a(context, ahh.a(), BuildConfig.FLAVOR, false, false, axeVar, aarVar, null, null, null, bos.a());
        this.f3132a.getView().setWillNotDraw(true);
    }

    @Override // com.google.android.gms.internal.ads.he
    public final void a(String str, String str2) {
        hf.a(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.gv
    public final void a(String str, Map map) {
        hf.a(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.he, com.google.android.gms.internal.ads.gv
    public final void a(String str, JSONObject jSONObject) {
        hf.b(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.hu
    public final void b(String str, JSONObject jSONObject) {
        hf.a(this, str, jSONObject);
    }

    private static void a(Runnable runnable) {
        bra.a();
        if (aac.b()) {
            runnable.run();
        } else {
            xn.f3583a.post(runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.he, com.google.android.gms.internal.ads.hu
    public final void d(final String str) {
        a(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.hn

            /* renamed from: a, reason: collision with root package name */
            private final hm f3134a;

            /* renamed from: b, reason: collision with root package name */
            private final String f3135b;

            {
                this.f3134a = this;
                this.f3135b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3134a.e(this.f3135b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.hk
    public final void a(String str) {
        a(new hq(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str)));
    }

    @Override // com.google.android.gms.internal.ads.hk
    public final void b(String str) {
        a(new hr(this, str));
    }

    @Override // com.google.android.gms.internal.ads.hk
    public final void c(String str) {
        a(new hs(this, str));
    }

    @Override // com.google.android.gms.internal.ads.iu
    public final void a(String str, com.google.android.gms.ads.internal.gmsg.ac<? super iu> acVar) {
        this.f3132a.a(str, new ht(this, acVar));
    }

    @Override // com.google.android.gms.internal.ads.iu
    public final void b(String str, final com.google.android.gms.ads.internal.gmsg.ac<? super iu> acVar) {
        this.f3132a.a(str, new com.google.android.gms.common.util.k(acVar) { // from class: com.google.android.gms.internal.ads.ho

            /* renamed from: a, reason: collision with root package name */
            private final com.google.android.gms.ads.internal.gmsg.ac f3136a;

            {
                this.f3136a = acVar;
            }

            @Override // com.google.android.gms.common.util.k
            public final boolean a(Object obj) {
                com.google.android.gms.ads.internal.gmsg.ac acVar2 = (com.google.android.gms.ads.internal.gmsg.ac) obj;
                return (acVar2 instanceof ht) && ((ht) acVar2).f3144a.equals(this.f3136a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.hk
    public final void a(hl hlVar) {
        ahb ahbVarW = this.f3132a.w();
        hlVar.getClass();
        ahbVarW.a(hp.a(hlVar));
    }

    @Override // com.google.android.gms.internal.ads.hk
    public final iv c() {
        return new iw(this);
    }

    @Override // com.google.android.gms.internal.ads.hk
    public final void a() {
        this.f3132a.destroy();
    }

    @Override // com.google.android.gms.internal.ads.hk
    public final boolean b() {
        return this.f3132a.C();
    }

    final /* synthetic */ void e(String str) {
        this.f3132a.d(str);
    }
}
