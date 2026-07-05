package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ad;

/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements ad {

    /* renamed from: a, reason: collision with root package name */
    private ad.a f283a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.ad
    public void setOnFitSystemWindowsListener(ad.a aVar) {
        this.f283a = aVar;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.f283a != null) {
            this.f283a.a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
