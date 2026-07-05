package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import javax.annotation.concurrent.GuardedBy;

@qj
@TargetApi(19)
/* loaded from: classes.dex */
public final class on extends ok {
    private Object d;

    @GuardedBy("mPopupWindowLock")
    private PopupWindow e;

    @GuardedBy("mPopupWindowLock")
    private boolean f;

    on(Context context, wl wlVar, afu afuVar, oj ojVar) {
        super(context, wlVar, afuVar, ojVar);
        this.d = new Object();
        this.f = false;
    }

    @Override // com.google.android.gms.internal.ads.ok
    protected final void d() {
        Window window = this.f3308a instanceof Activity ? ((Activity) this.f3308a).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) this.f3308a).isDestroyed()) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(this.f3308a);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(this.f3309b.getView(), -1, -1);
        synchronized (this.d) {
            if (this.f) {
                return;
            }
            this.e = new PopupWindow((View) frameLayout, 1, 1, false);
            this.e.setOutsideTouchable(true);
            this.e.setClippingEnabled(false);
            xe.b("Displaying the 1x1 popup off the screen.");
            try {
                this.e.showAtLocation(window.getDecorView(), 0, -1, -1);
            } catch (Exception unused) {
                this.e = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.od, com.google.android.gms.internal.ads.yi
    public final void b() {
        e();
        super.b();
    }

    @Override // com.google.android.gms.internal.ads.od
    protected final void a(int i) {
        e();
        super.a(i);
    }

    private final void e() {
        synchronized (this.d) {
            this.f = true;
            if ((this.f3308a instanceof Activity) && ((Activity) this.f3308a).isDestroyed()) {
                this.e = null;
            }
            if (this.e != null) {
                if (this.e.isShowing()) {
                    this.e.dismiss();
                }
                this.e = null;
            }
        }
    }
}
