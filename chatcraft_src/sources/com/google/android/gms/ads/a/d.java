package com.google.android.gms.ads.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.f;
import com.google.android.gms.ads.j;
import com.google.android.gms.ads.k;
import com.google.android.gms.internal.ads.aan;
import com.google.android.gms.internal.ads.btg;

/* loaded from: classes.dex */
public final class d extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private final btg f1465a;

    public final j getVideoController() {
        return this.f1465a.k();
    }

    public final void setVideoOptions(k kVar) {
        this.f1465a.a(kVar);
    }

    public final k getVideoOptions() {
        return this.f1465a.m();
    }

    public final com.google.android.gms.ads.a getAdListener() {
        return this.f1465a.b();
    }

    public final com.google.android.gms.ads.d getAdSize() {
        return this.f1465a.c();
    }

    public final com.google.android.gms.ads.d[] getAdSizes() {
        return this.f1465a.d();
    }

    public final String getAdUnitId() {
        return this.f1465a.e();
    }

    public final a getAppEventListener() {
        return this.f1465a.f();
    }

    public final c getOnCustomRenderedAdLoadedListener() {
        return this.f1465a.g();
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.f1465a.a(z);
    }

    public final void setAdListener(com.google.android.gms.ads.a aVar) {
        this.f1465a.a(aVar);
    }

    public final void setAdSizes(com.google.android.gms.ads.d... dVarArr) {
        if (dVarArr == null || dVarArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.f1465a.b(dVarArr);
    }

    public final void setAdUnitId(String str) {
        this.f1465a.a(str);
    }

    public final void setAppEventListener(a aVar) {
        this.f1465a.a(aVar);
    }

    public final void setCorrelator(f fVar) {
        this.f1465a.a(fVar);
    }

    public final void setOnCustomRenderedAdLoadedListener(c cVar) {
        this.f1465a.a(cVar);
    }

    public final String getMediationAdapterClassName() {
        return this.f1465a.j();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int iA;
        int measuredWidth = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i, i2);
            measuredWidth = childAt.getMeasuredWidth();
            iA = childAt.getMeasuredHeight();
        } else {
            com.google.android.gms.ads.d adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                aan.b("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int iB = adSize.b(context);
                iA = adSize.a(context);
                measuredWidth = iB;
            } else {
                iA = 0;
            }
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(iA, getSuggestedMinimumHeight()), i2));
    }
}
