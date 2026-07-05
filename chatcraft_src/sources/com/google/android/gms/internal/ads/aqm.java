package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import java.util.Map;

/* loaded from: classes.dex */
final class aqm extends aql<Object> {
    aqm() {
    }

    @Override // com.google.android.gms.internal.ads.aql
    final boolean a(asf asfVar) {
        return asfVar instanceof aqy.c;
    }

    @Override // com.google.android.gms.internal.ads.aql
    final aqo<Object> a(Object obj) {
        return ((aqy.c) obj).zzfqa;
    }

    @Override // com.google.android.gms.internal.ads.aql
    final void a(Object obj, aqo<Object> aqoVar) {
        ((aqy.c) obj).zzfqa = aqoVar;
    }

    @Override // com.google.android.gms.internal.ads.aql
    final aqo<Object> b(Object obj) {
        aqo<Object> aqoVarA = a(obj);
        if (!aqoVarA.d()) {
            return aqoVarA;
        }
        aqo<Object> aqoVar = (aqo) aqoVarA.clone();
        a(obj, aqoVar);
        return aqoVar;
    }

    @Override // com.google.android.gms.internal.ads.aql
    final void c(Object obj) {
        a(obj).c();
    }

    @Override // com.google.android.gms.internal.ads.aql
    final <UT, UB> UB a(asw aswVar, Object obj, aqk aqkVar, aqo<Object> aqoVar, UB ub, ato<UT, UB> atoVar) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.aql
    final int a(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.aql
    final void a(auk aukVar, Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.aql
    final Object a(aqk aqkVar, asf asfVar, int i) {
        return aqkVar.a(asfVar, i);
    }

    @Override // com.google.android.gms.internal.ads.aql
    final void a(asw aswVar, Object obj, aqk aqkVar, aqo<Object> aqoVar) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.aql
    final void a(apo apoVar, Object obj, aqk aqkVar, aqo<Object> aqoVar) {
        throw new NoSuchMethodError();
    }
}
