package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class asb implements asa {
    asb() {
    }

    @Override // com.google.android.gms.internal.ads.asa
    public final Map<?, ?> a(Object obj) {
        return (arz) obj;
    }

    @Override // com.google.android.gms.internal.ads.asa
    public final ary<?, ?> f(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.asa
    public final Map<?, ?> b(Object obj) {
        return (arz) obj;
    }

    @Override // com.google.android.gms.internal.ads.asa
    public final boolean c(Object obj) {
        return !((arz) obj).d();
    }

    @Override // com.google.android.gms.internal.ads.asa
    public final Object d(Object obj) {
        ((arz) obj).c();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.asa
    public final Object e(Object obj) {
        return arz.a().b();
    }

    @Override // com.google.android.gms.internal.ads.asa
    public final Object a(Object obj, Object obj2) {
        arz arzVarB = (arz) obj;
        arz arzVar = (arz) obj2;
        if (!arzVar.isEmpty()) {
            if (!arzVarB.d()) {
                arzVarB = arzVarB.b();
            }
            arzVarB.a(arzVar);
        }
        return arzVarB;
    }

    @Override // com.google.android.gms.internal.ads.asa
    public final int a(int i, Object obj, Object obj2) {
        arz arzVar = (arz) obj;
        if (arzVar.isEmpty()) {
            return 0;
        }
        Iterator it = arzVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
