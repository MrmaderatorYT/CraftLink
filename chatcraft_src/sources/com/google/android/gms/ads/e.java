package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.aan;
import com.google.android.gms.internal.ads.bqa;
import com.google.android.gms.internal.ads.btg;

/* loaded from: classes.dex */
class e extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    protected final btg f1488a;

    public e(Context context, int i) {
        super(context);
        this.f1488a = new btg(this, i);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f1488a = new btg(this, attributeSet, false, i);
    }

    public e(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f1488a = new btg(this, attributeSet, false, i2);
    }

    public void c() {
        this.f1488a.a();
    }

    public a getAdListener() {
        return this.f1488a.b();
    }

    public d getAdSize() {
        return this.f1488a.c();
    }

    public String getAdUnitId() {
        return this.f1488a.e();
    }

    public void a(c cVar) {
        this.f1488a.a(cVar.a());
    }

    public void b() {
        this.f1488a.h();
    }

    public void a() {
        this.f1488a.i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(a aVar) {
        this.f1488a.a(aVar);
        if (aVar == 0) {
            this.f1488a.a((bqa) null);
            this.f1488a.a((com.google.android.gms.ads.a.a) null);
            return;
        }
        if (aVar instanceof bqa) {
            this.f1488a.a((bqa) aVar);
        }
        if (aVar instanceof com.google.android.gms.ads.a.a) {
            this.f1488a.a((com.google.android.gms.ads.a.a) aVar);
        }
    }

    public void setAdSize(d dVar) {
        this.f1488a.a(dVar);
    }

    public void setAdUnitId(String str) {
        this.f1488a.a(str);
    }

    public String getMediationAdapterClassName() {
        return this.f1488a.j();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
    protected void onMeasure(int i, int i2) {
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
