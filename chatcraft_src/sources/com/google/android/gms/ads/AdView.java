package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public final class AdView extends e {
    public AdView(Context context) {
        super(context, 0);
        com.google.android.gms.common.internal.i.a(context, "Context cannot be null");
    }

    public AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
    }

    public final j getVideoController() {
        if (this.f1488a != null) {
            return this.f1488a.k();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.e
    public final /* bridge */ /* synthetic */ String getMediationAdapterClassName() {
        return super.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.ads.e
    public final /* bridge */ /* synthetic */ void setAdUnitId(String str) {
        super.setAdUnitId(str);
    }

    @Override // com.google.android.gms.ads.e
    public final /* bridge */ /* synthetic */ void setAdSize(d dVar) {
        super.setAdSize(dVar);
    }

    @Override // com.google.android.gms.ads.e
    public final /* bridge */ /* synthetic */ void setAdListener(a aVar) {
        super.setAdListener(aVar);
    }

    @Override // com.google.android.gms.ads.e
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.ads.e
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.ads.e
    public final /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.google.android.gms.ads.e
    public final /* bridge */ /* synthetic */ String getAdUnitId() {
        return super.getAdUnitId();
    }

    @Override // com.google.android.gms.ads.e
    public final /* bridge */ /* synthetic */ d getAdSize() {
        return super.getAdSize();
    }

    @Override // com.google.android.gms.ads.e
    public final /* bridge */ /* synthetic */ a getAdListener() {
        return super.getAdListener();
    }

    @Override // com.google.android.gms.ads.e
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }
}
