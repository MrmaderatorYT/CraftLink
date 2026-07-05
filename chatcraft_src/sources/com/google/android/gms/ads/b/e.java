package com.google.android.gms.ads.b;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.internal.ads.aan;
import com.google.android.gms.internal.ads.ch;

@Deprecated
/* loaded from: classes.dex */
public class e extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f1474a;

    /* renamed from: b, reason: collision with root package name */
    private final ch f1475b;

    public void setAdChoicesView(a aVar) {
        a("1098", aVar);
    }

    public a getAdChoicesView() {
        View viewA = a("1098");
        if (viewA instanceof a) {
            return (a) viewA;
        }
        return null;
    }

    protected final void a(String str, View view) {
        try {
            this.f1475b.a(str, com.google.android.gms.dynamic.b.a(view));
        } catch (RemoteException e) {
            aan.b("Unable to call setAssetView on delegate", e);
        }
    }

    protected final View a(String str) {
        try {
            com.google.android.gms.dynamic.a aVarA = this.f1475b.a(str);
            if (aVarA != null) {
                return (View) com.google.android.gms.dynamic.b.a(aVarA);
            }
            return null;
        } catch (RemoteException e) {
            aan.b("Unable to call getAssetView on delegate", e);
            return null;
        }
    }

    public void setNativeAd(c cVar) {
        try {
            this.f1475b.a((com.google.android.gms.dynamic.a) cVar.a());
        } catch (RemoteException e) {
            aan.b("Unable to call setNativeAd on delegate", e);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f1474a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f1474a == view) {
            return;
        }
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f1474a);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.f1474a != view) {
            super.bringChildToFront(this.f1474a);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.f1475b != null) {
            try {
                this.f1475b.a(com.google.android.gms.dynamic.b.a(view), i);
            } catch (RemoteException e) {
                aan.b("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }
}
