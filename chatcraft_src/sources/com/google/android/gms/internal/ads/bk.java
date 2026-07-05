package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public final class bk implements com.google.android.gms.ads.internal.gmsg.ac<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<bg> f2754a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2755b;

    public bk(bg bgVar, String str) {
        this.f2754a = new WeakReference<>(bgVar);
        this.f2755b = str;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) {
        bg bgVar;
        String str = map.get("ads_id");
        String str2 = map.get("eventName");
        if (TextUtils.isEmpty(str) || !this.f2755b.equals(str)) {
            return;
        }
        if ("_ai".equals(str2)) {
            bg bgVar2 = this.f2754a.get();
            if (bgVar2 != null) {
                bgVar2.y();
                return;
            }
            return;
        }
        if (!"_ac".equals(str2) || (bgVar = this.f2754a.get()) == null) {
            return;
        }
        bgVar.z();
    }
}
