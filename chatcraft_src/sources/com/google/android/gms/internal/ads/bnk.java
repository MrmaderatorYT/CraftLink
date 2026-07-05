package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes.dex */
final class bnk implements Comparator<bnq> {
    bnk(bnj bnjVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(bnq bnqVar, bnq bnqVar2) {
        bnq bnqVar3 = bnqVar;
        bnq bnqVar4 = bnqVar2;
        int i = bnqVar3.c - bnqVar4.c;
        return i != 0 ? i : (int) (bnqVar3.f2880a - bnqVar4.f2880a);
    }
}
