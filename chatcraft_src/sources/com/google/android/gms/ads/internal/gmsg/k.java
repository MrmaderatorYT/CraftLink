package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.xe;
import java.util.Map;

@qj
/* loaded from: classes.dex */
public final class k implements ac<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final l f1601a;

    public k(l lVar) {
        this.f1601a = lVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            xe.e("App event with no name parameter.");
        } else {
            this.f1601a.a(str, map.get("info"));
        }
    }
}
