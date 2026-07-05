package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class arq extends aro {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f2211a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private arq() {
        super();
    }

    @Override // com.google.android.gms.internal.ads.aro
    final <L> List<L> a(Object obj, long j) {
        return a(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.ads.aro
    final void b(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) atv.f(obj, j);
        if (list instanceof arn) {
            objUnmodifiableList = ((arn) list).e();
        } else {
            if (f2211a.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof asr) && (list instanceof arf)) {
                arf arfVar = (arf) list;
                if (arfVar.a()) {
                    arfVar.b();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        atv.a(obj, j, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> a(Object obj, long j, int i) {
        arm armVar;
        List<L> arrayList;
        List<L> listC = c(obj, j);
        if (listC.isEmpty()) {
            if (listC instanceof arn) {
                arrayList = new arm(i);
            } else if ((listC instanceof asr) && (listC instanceof arf)) {
                arrayList = ((arf) listC).a(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            atv.a(obj, j, arrayList);
            return arrayList;
        }
        if (f2211a.isAssignableFrom(listC.getClass())) {
            ArrayList arrayList2 = new ArrayList(listC.size() + i);
            arrayList2.addAll(listC);
            atv.a(obj, j, arrayList2);
            armVar = arrayList2;
        } else if (listC instanceof atr) {
            arm armVar2 = new arm(listC.size() + i);
            armVar2.addAll((atr) listC);
            atv.a(obj, j, armVar2);
            armVar = armVar2;
        } else {
            if (!(listC instanceof asr) || !(listC instanceof arf)) {
                return listC;
            }
            arf arfVar = (arf) listC;
            if (arfVar.a()) {
                return listC;
            }
            arf arfVarA = arfVar.a(listC.size() + i);
            atv.a(obj, j, arfVarA);
            return arfVarA;
        }
        return armVar;
    }

    @Override // com.google.android.gms.internal.ads.aro
    final <E> void a(Object obj, Object obj2, long j) {
        List listC = c(obj2, j);
        List listA = a(obj, j, listC.size());
        int size = listA.size();
        int size2 = listC.size();
        if (size > 0 && size2 > 0) {
            listA.addAll(listC);
        }
        if (size > 0) {
            listC = listA;
        }
        atv.a(obj, j, listC);
    }

    private static <E> List<E> c(Object obj, long j) {
        return (List) atv.f(obj, j);
    }
}
