package com.google.android.gms.ads.b;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.internal.ads.aan;
import com.google.android.gms.internal.ads.ch;

/* loaded from: classes.dex */
public final class l extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f1480a;

    /* renamed from: b, reason: collision with root package name */
    private final ch f1481b;

    private final void a(String str, View view) {
        try {
            this.f1481b.a(str, com.google.android.gms.dynamic.b.a(view));
        } catch (RemoteException e) {
            aan.b("Unable to call setAssetView on delegate", e);
        }
    }

    public final void setHeadlineView(View view) {
        a("3001", view);
    }

    public final void setCallToActionView(View view) {
        a("3002", view);
    }

    public final void setIconView(View view) {
        a("3003", view);
    }

    public final void setBodyView(View view) {
        a("3004", view);
    }

    public final void setAdvertiserView(View view) {
        a("3005", view);
    }

    public final void setStoreView(View view) {
        a("3006", view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.f1481b.b(com.google.android.gms.dynamic.b.a(view));
        } catch (RemoteException e) {
            aan.b("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setPriceView(View view) {
        a("3007", view);
    }

    public final void setImageView(View view) {
        a("3008", view);
    }

    public final void setStarRatingView(View view) {
        a("3009", view);
    }

    public final void setMediaView(b bVar) {
        a("3010", bVar);
    }

    public final void setAdChoicesView(a aVar) {
        a("3011", aVar);
    }

    public final void setNativeAd(k kVar) {
        try {
            this.f1481b.a((com.google.android.gms.dynamic.a) kVar.k());
        } catch (RemoteException e) {
            aan.b("Unable to call setNativeAd on delegate", e);
        }
    }

    private final View a(String str) {
        try {
            com.google.android.gms.dynamic.a aVarA = this.f1481b.a(str);
            if (aVarA != null) {
                return (View) com.google.android.gms.dynamic.b.a(aVarA);
            }
            return null;
        } catch (RemoteException e) {
            aan.b("Unable to call getAssetView on delegate", e);
            return null;
        }
    }

    public final View getHeadlineView() {
        return a("3001");
    }

    public final View getCallToActionView() {
        return a("3002");
    }

    public final View getIconView() {
        return a("3003");
    }

    public final View getBodyView() {
        return a("3004");
    }

    public final View getStoreView() {
        return a("3006");
    }

    public final View getPriceView() {
        return a("3007");
    }

    public final View getAdvertiserView() {
        return a("3005");
    }

    public final View getImageView() {
        return a("3008");
    }

    public final View getStarRatingView() {
        return a("3009");
    }

    public final b getMediaView() {
        View viewA = a("3010");
        if (viewA instanceof b) {
            return (b) viewA;
        }
        if (viewA == null) {
            return null;
        }
        aan.b("View is not an instance of MediaView");
        return null;
    }

    public final a getAdChoicesView() {
        View viewA = a("3011");
        if (viewA instanceof a) {
            return (a) viewA;
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f1480a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.f1480a == view) {
            return;
        }
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f1480a);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.f1480a != view) {
            super.bringChildToFront(this.f1480a);
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.f1481b != null) {
            try {
                this.f1481b.a(com.google.android.gms.dynamic.b.a(view), i);
            } catch (RemoteException e) {
                aan.b("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }
}
