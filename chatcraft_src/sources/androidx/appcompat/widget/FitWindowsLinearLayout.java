package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.ad;

/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements ad {

    /* renamed from: a, reason: collision with root package name */
    private ad.a f284a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.ad
    public void setOnFitSystemWindowsListener(ad.a aVar) {
        this.f284a = aVar;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.f284a != null) {
            this.f284a.a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
