package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class gw extends hi<iu> implements he, hk {

    /* renamed from: a, reason: collision with root package name */
    private final ahv f3117a;

    /* renamed from: b, reason: collision with root package name */
    private hl f3118b;

    /* JADX WARN: Multi-variable type inference failed */
    public gw(Context context, aar aarVar) throws zzbgq {
        try {
            this.f3117a = new ahv(context, new hd(this));
            this.f3117a.setWillNotDraw(true);
            this.f3117a.addJavascriptInterface(new hc(this), "GoogleJsInterface");
            com.google.android.gms.ads.internal.ax.e().a(context, aarVar.f1790a, this.f3117a.getSettings());
            super.a(this);
        } catch (Throwable th) {
            throw new zzbgq("Init failed.", th);
        }
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

    @Override // com.google.android.gms.internal.ads.hk
    public final void a(String str) {
        b(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", str));
    }

    @Override // com.google.android.gms.internal.ads.hk
    public final void b(final String str) {
        abq.f1816a.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.gx

            /* renamed from: a, reason: collision with root package name */
            private final gw f3119a;

            /* renamed from: b, reason: collision with root package name */
            private final String f3120b;

            {
                this.f3119a = this;
                this.f3120b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3119a.g(this.f3120b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.hk
    public final void c(final String str) {
        abq.f1816a.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.gy

            /* renamed from: a, reason: collision with root package name */
            private final gw f3121a;

            /* renamed from: b, reason: collision with root package name */
            private final String f3122b;

            {
                this.f3121a = this;
                this.f3122b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3121a.f(this.f3122b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.hk
    public final void a(hl hlVar) {
        this.f3118b = hlVar;
    }

    @Override // com.google.android.gms.internal.ads.hk
    public final void a() {
        this.f3117a.destroy();
    }

    @Override // com.google.android.gms.internal.ads.hk
    public final boolean b() {
        return this.f3117a.C();
    }

    @Override // com.google.android.gms.internal.ads.hk
    public final iv c() {
        return new iw(this);
    }

    @Override // com.google.android.gms.internal.ads.he, com.google.android.gms.internal.ads.hu
    public final void d(final String str) {
        abq.f1816a.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.gz

            /* renamed from: a, reason: collision with root package name */
            private final gw f3123a;

            /* renamed from: b, reason: collision with root package name */
            private final String f3124b;

            {
                this.f3123a = this;
                this.f3124b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f3123a.e(this.f3124b);
            }
        });
    }

    final /* synthetic */ void e(String str) {
        this.f3117a.d(str);
    }

    final /* synthetic */ void f(String str) {
        this.f3117a.loadUrl(str);
    }

    final /* synthetic */ void g(String str) {
        this.f3117a.loadData(str, "text/html", "UTF-8");
    }
}
