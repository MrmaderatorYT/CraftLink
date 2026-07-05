package com.google.android.gms.internal.ads;

@qj
/* loaded from: classes.dex */
public final class aeu extends xa {

    /* renamed from: a, reason: collision with root package name */
    final adk f1911a;

    /* renamed from: b, reason: collision with root package name */
    final aex f1912b;
    private final String c;

    aeu(adk adkVar, aex aexVar, String str) {
        this.f1911a = adkVar;
        this.f1912b = aexVar;
        this.c = str;
        com.google.android.gms.ads.internal.ax.C().a(this);
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void a() {
        try {
            this.f1912b.a(this.c);
        } finally {
            xn.f3583a.post(new aev(this));
        }
    }

    @Override // com.google.android.gms.internal.ads.xa
    public final void c_() {
        this.f1912b.a();
    }
}
