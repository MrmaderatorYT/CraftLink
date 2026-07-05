package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes.dex */
public final class bnt implements Comparator<bnh> {
    public bnt(bns bnsVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(bnh bnhVar, bnh bnhVar2) {
        bnh bnhVar3 = bnhVar;
        bnh bnhVar4 = bnhVar2;
        if (bnhVar3.b() < bnhVar4.b()) {
            return -1;
        }
        if (bnhVar3.b() > bnhVar4.b()) {
            return 1;
        }
        if (bnhVar3.a() < bnhVar4.a()) {
            return -1;
        }
        if (bnhVar3.a() > bnhVar4.a()) {
            return 1;
        }
        float fD = (bnhVar3.d() - bnhVar3.b()) * (bnhVar3.c() - bnhVar3.a());
        float fD2 = (bnhVar4.d() - bnhVar4.b()) * (bnhVar4.c() - bnhVar4.a());
        if (fD > fD2) {
            return -1;
        }
        return fD < fD2 ? 1 : 0;
    }
}
