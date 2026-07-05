package com.google.android.gms.ads.b;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.internal.ads.aan;
import com.google.android.gms.internal.ads.cm;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap<View, f> f1476a = new WeakHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private cm f1477b;
    private WeakReference<View> c;

    public final void a(c cVar) {
        a((com.google.android.gms.dynamic.a) cVar.a());
    }

    public final void a(k kVar) {
        a((com.google.android.gms.dynamic.a) kVar.k());
    }

    private final void a(com.google.android.gms.dynamic.a aVar) {
        View view = this.c != null ? this.c.get() : null;
        if (view == null) {
            aan.e("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!f1476a.containsKey(view)) {
            f1476a.put(view, this);
        }
        if (this.f1477b != null) {
            try {
                this.f1477b.a(aVar);
            } catch (RemoteException e) {
                aan.b("Unable to call setNativeAd on delegate", e);
            }
        }
    }
}
