package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
final class arr extends aro {
    private arr() {
        super();
    }

    @Override // com.google.android.gms.internal.ads.aro
    final <L> List<L> a(Object obj, long j) {
        arf arfVarC = c(obj, j);
        if (arfVarC.a()) {
            return arfVarC;
        }
        int size = arfVarC.size();
        arf arfVarA = arfVarC.a(size == 0 ? 10 : size << 1);
        atv.a(obj, j, arfVarA);
        return arfVarA;
    }

    @Override // com.google.android.gms.internal.ads.aro
    final void b(Object obj, long j) {
        c(obj, j).b();
    }

    @Override // com.google.android.gms.internal.ads.aro
    final <E> void a(Object obj, Object obj2, long j) {
        arf arfVarC = c(obj, j);
        arf arfVarC2 = c(obj2, j);
        int size = arfVarC.size();
        int size2 = arfVarC2.size();
        if (size > 0 && size2 > 0) {
            if (!arfVarC.a()) {
                arfVarC = arfVarC.a(size2 + size);
            }
            arfVarC.addAll(arfVarC2);
        }
        if (size > 0) {
            arfVarC2 = arfVarC;
        }
        atv.a(obj, j, arfVarC2);
    }

    private static <E> arf<E> c(Object obj, long j) {
        return (arf) atv.f(obj, j);
    }
}
