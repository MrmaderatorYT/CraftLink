package com.google.android.gms.internal.ads;

@qj
/* loaded from: classes.dex */
public final class tn extends tu {

    /* renamed from: a, reason: collision with root package name */
    private final String f3479a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3480b;

    public tn(String str, int i) {
        this.f3479a = str;
        this.f3480b = i;
    }

    @Override // com.google.android.gms.internal.ads.tt
    public final String a() {
        return this.f3479a;
    }

    @Override // com.google.android.gms.internal.ads.tt
    public final int b() {
        return this.f3480b;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof tn)) {
            return false;
        }
        tn tnVar = (tn) obj;
        return com.google.android.gms.common.internal.h.a(this.f3479a, tnVar.f3479a) && com.google.android.gms.common.internal.h.a(Integer.valueOf(this.f3480b), Integer.valueOf(tnVar.f3480b));
    }
}
