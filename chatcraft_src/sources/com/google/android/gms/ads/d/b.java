package com.google.android.gms.ads.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.d;
import com.google.android.gms.internal.ads.aan;
import com.google.android.gms.internal.ads.btg;
import com.google.android.gms.internal.ads.qj;

@qj
/* loaded from: classes.dex */
public final class b extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private final btg f1487a;

    public final com.google.android.gms.ads.a getAdListener() {
        return this.f1487a.b();
    }

    public final d getAdSize() {
        return this.f1487a.c();
    }

    public final String getAdUnitId() {
        return this.f1487a.e();
    }

    public final void setAdListener(com.google.android.gms.ads.a aVar) {
        this.f1487a.a(aVar);
    }

    public final void setAdSize(d dVar) {
        this.f1487a.a(dVar);
    }

    public final void setAdUnitId(String str) {
        this.f1487a.a(str);
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
            d adSize = null;
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
