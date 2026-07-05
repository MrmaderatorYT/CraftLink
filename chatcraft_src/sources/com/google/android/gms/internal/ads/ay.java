package com.google.android.gms.internal.ads;

import android.view.View;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@qj
/* loaded from: classes.dex */
public final class ay extends da implements bh {

    /* renamed from: a, reason: collision with root package name */
    private final ao f2397a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2398b;
    private final androidx.b.g<String, at> c;
    private final androidx.b.g<String, String> d;
    private bsw e;
    private View f;
    private final Object g = new Object();
    private bf h;

    public ay(String str, androidx.b.g<String, at> gVar, androidx.b.g<String, String> gVar2, ao aoVar, bsw bswVar, View view) {
        this.f2398b = str;
        this.c = gVar;
        this.d = gVar2;
        this.f2397a = aoVar;
        this.e = bswVar;
        this.f = view;
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final String a() {
        return "3";
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final String a(String str) {
        return this.d.get(str);
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final cd b(String str) {
        return this.c.get(str);
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final List<String> e() {
        String[] strArr = new String[this.c.size() + this.d.size()];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.c.size()) {
            strArr[i3] = this.c.b(i2);
            i2++;
            i3++;
        }
        while (i < this.d.size()) {
            strArr[i3] = this.d.b(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.ads.cz, com.google.android.gms.internal.ads.bh
    public final String b() {
        return this.f2398b;
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final void a(bf bfVar) {
        synchronized (this.g) {
            this.h = bfVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final com.google.android.gms.dynamic.a f() {
        return com.google.android.gms.dynamic.b.a(this.h);
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final ao c() {
        return this.f2397a;
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final bsw g() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final boolean a(com.google.android.gms.dynamic.a aVar) {
        if (this.h == null) {
            aan.c("Attempt to call renderVideoInMediaView before ad initialized.");
            return false;
        }
        if (this.f == null) {
            return false;
        }
        az azVar = new az(this);
        this.h.a((FrameLayout) com.google.android.gms.dynamic.b.a(aVar), azVar);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.bh
    public final View d() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final void c(String str) {
        synchronized (this.g) {
            if (this.h == null) {
                aan.c("#001 Attempt to perform click before app native ad initialized.");
            } else {
                this.h.a(null, str, null, null, null, false);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final void h() {
        synchronized (this.g) {
            if (this.h == null) {
                aan.c("#002 Attempt to record impression before native ad initialized.");
            } else {
                this.h.a((View) null, (Map<String, WeakReference<View>>) null);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final com.google.android.gms.dynamic.a i() {
        return com.google.android.gms.dynamic.b.a(this.h.p().getApplicationContext());
    }

    @Override // com.google.android.gms.internal.ads.cz
    public final void j() {
        xn.f3583a.post(new ba(this));
        this.e = null;
        this.f = null;
    }

    static /* synthetic */ bf a(ay ayVar, bf bfVar) {
        ayVar.h = null;
        return null;
    }
}
