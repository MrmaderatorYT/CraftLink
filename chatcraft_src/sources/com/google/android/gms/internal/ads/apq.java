package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes.dex */
final class apq implements Comparator<apo> {
    apq() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(apo apoVar, apo apoVar2) {
        apo apoVar3 = apoVar;
        apo apoVar4 = apoVar2;
        apv apvVar = (apv) apoVar3.iterator();
        apv apvVar2 = (apv) apoVar4.iterator();
        while (apvVar.hasNext() && apvVar2.hasNext()) {
            int iCompare = Integer.compare(apo.b(apvVar.a()), apo.b(apvVar2.a()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(apoVar3.a(), apoVar4.a());
    }
}
