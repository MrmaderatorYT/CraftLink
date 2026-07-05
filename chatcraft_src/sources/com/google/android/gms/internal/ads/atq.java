package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class atq extends ato<atp, atp> {
    atq() {
    }

    @Override // com.google.android.gms.internal.ads.ato
    final boolean a(asw aswVar) {
        return false;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(Object obj, atp atpVar) {
        ((aqy) obj).zzfpu = atpVar;
    }

    @Override // com.google.android.gms.internal.ads.ato
    final void d(Object obj) {
        ((aqy) obj).zzfpu.c();
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ int f(atp atpVar) {
        return atpVar.e();
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ int e(atp atpVar) {
        return atpVar.d();
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ atp c(atp atpVar, atp atpVar2) {
        atp atpVar3 = atpVar;
        atp atpVar4 = atpVar2;
        return atpVar4.equals(atp.a()) ? atpVar3 : atp.a(atpVar3, atpVar4);
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ void b(atp atpVar, auk aukVar) {
        atpVar.a(aukVar);
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ void a(atp atpVar, auk aukVar) {
        atpVar.b(aukVar);
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ void b(Object obj, atp atpVar) {
        a2(obj, atpVar);
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ atp c(Object obj) {
        atp atpVar = ((aqy) obj).zzfpu;
        if (atpVar != atp.a()) {
            return atpVar;
        }
        atp atpVarB = atp.b();
        a2(obj, atpVarB);
        return atpVarB;
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ atp b(Object obj) {
        return ((aqy) obj).zzfpu;
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ void a(Object obj, atp atpVar) {
        a2(obj, atpVar);
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ atp a(atp atpVar) {
        atp atpVar2 = atpVar;
        atpVar2.c();
        return atpVar2;
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ atp a() {
        return atp.b();
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ void a(atp atpVar, int i, atp atpVar2) {
        atpVar.a((i << 3) | 3, atpVar2);
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ void a(atp atpVar, int i, apo apoVar) {
        atpVar.a((i << 3) | 2, apoVar);
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ void b(atp atpVar, int i, long j) {
        atpVar.a((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ void a(atp atpVar, int i, int i2) {
        atpVar.a((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.ads.ato
    final /* synthetic */ void a(atp atpVar, int i, long j) {
        atpVar.a(i << 3, Long.valueOf(j));
    }
}
