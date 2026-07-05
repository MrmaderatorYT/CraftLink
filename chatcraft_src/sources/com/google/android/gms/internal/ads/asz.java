package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class asz {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f2241a = d();

    /* renamed from: b, reason: collision with root package name */
    private static final ato<?, ?> f2242b = a(false);
    private static final ato<?, ?> c = a(true);
    private static final ato<?, ?> d = new atq();

    public static void a(Class<?> cls) {
        if (!aqy.class.isAssignableFrom(cls) && f2241a != null && !f2241a.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void a(int i, List<Double> list, auk aukVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.g(i, list, z);
    }

    public static void b(int i, List<Float> list, auk aukVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.f(i, list, z);
    }

    public static void c(int i, List<Long> list, auk aukVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.c(i, list, z);
    }

    public static void d(int i, List<Long> list, auk aukVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.d(i, list, z);
    }

    public static void e(int i, List<Long> list, auk aukVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.n(i, list, z);
    }

    public static void f(int i, List<Long> list, auk aukVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.e(i, list, z);
    }

    public static void g(int i, List<Long> list, auk aukVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.l(i, list, z);
    }

    public static void h(int i, List<Integer> list, auk aukVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.a(i, list, z);
    }

    public static void i(int i, List<Integer> list, auk aukVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.j(i, list, z);
    }

    public static void j(int i, List<Integer> list, auk aukVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.m(i, list, z);
    }

    public static void k(int i, List<Integer> list, auk aukVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.b(i, list, z);
    }

    public static void l(int i, List<Integer> list, auk aukVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.k(i, list, z);
    }

    public static void m(int i, List<Integer> list, auk aukVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.h(i, list, z);
    }

    public static void n(int i, List<Boolean> list, auk aukVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.i(i, list, z);
    }

    public static void a(int i, List<String> list, auk aukVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.a(i, list);
    }

    public static void b(int i, List<apo> list, auk aukVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.b(i, list);
    }

    public static void a(int i, List<?> list, auk aukVar, asx asxVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.a(i, list, asxVar);
    }

    public static void b(int i, List<?> list, auk aukVar, asx asxVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        aukVar.b(i, list, asxVar);
    }

    static int a(List<Long> list) {
        int iD;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ars) {
            ars arsVar = (ars) list;
            iD = 0;
            while (i < size) {
                iD += zzbqk.d(arsVar.b(i));
                i++;
            }
        } else {
            iD = 0;
            while (i < size) {
                iD += zzbqk.d(list.get(i).longValue());
                i++;
            }
        }
        return iD;
    }

    static int a(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * zzbqk.e(i));
    }

    static int b(List<Long> list) {
        int iE;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ars) {
            ars arsVar = (ars) list;
            iE = 0;
            while (i < size) {
                iE += zzbqk.e(arsVar.b(i));
                i++;
            }
        } else {
            iE = 0;
            while (i < size) {
                iE += zzbqk.e(list.get(i).longValue());
                i++;
            }
        }
        return iE;
    }

    static int b(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b(list) + (size * zzbqk.e(i));
    }

    static int c(List<Long> list) {
        int iF;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ars) {
            ars arsVar = (ars) list;
            iF = 0;
            while (i < size) {
                iF += zzbqk.f(arsVar.b(i));
                i++;
            }
        } else {
            iF = 0;
            while (i < size) {
                iF += zzbqk.f(list.get(i).longValue());
                i++;
            }
        }
        return iF;
    }

    static int c(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return c(list) + (size * zzbqk.e(i));
    }

    static int d(List<Integer> list) {
        int iK;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof aqz) {
            aqz aqzVar = (aqz) list;
            iK = 0;
            while (i < size) {
                iK += zzbqk.k(aqzVar.b(i));
                i++;
            }
        } else {
            iK = 0;
            while (i < size) {
                iK += zzbqk.k(list.get(i).intValue());
                i++;
            }
        }
        return iK;
    }

    static int d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d(list) + (size * zzbqk.e(i));
    }

    static int e(List<Integer> list) {
        int iF;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof aqz) {
            aqz aqzVar = (aqz) list;
            iF = 0;
            while (i < size) {
                iF += zzbqk.f(aqzVar.b(i));
                i++;
            }
        } else {
            iF = 0;
            while (i < size) {
                iF += zzbqk.f(list.get(i).intValue());
                i++;
            }
        }
        return iF;
    }

    static int e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return e(list) + (size * zzbqk.e(i));
    }

    static int f(List<Integer> list) {
        int iG;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof aqz) {
            aqz aqzVar = (aqz) list;
            iG = 0;
            while (i < size) {
                iG += zzbqk.g(aqzVar.b(i));
                i++;
            }
        } else {
            iG = 0;
            while (i < size) {
                iG += zzbqk.g(list.get(i).intValue());
                i++;
            }
        }
        return iG;
    }

    static int f(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return f(list) + (size * zzbqk.e(i));
    }

    static int g(List<Integer> list) {
        int iH;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof aqz) {
            aqz aqzVar = (aqz) list;
            iH = 0;
            while (i < size) {
                iH += zzbqk.h(aqzVar.b(i));
                i++;
            }
        } else {
            iH = 0;
            while (i < size) {
                iH += zzbqk.h(list.get(i).intValue());
                i++;
            }
        }
        return iH;
    }

    static int g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * zzbqk.e(i));
    }

    static int h(List<?> list) {
        return list.size() << 2;
    }

    static int h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbqk.i(i, 0);
    }

    static int i(List<?> list) {
        return list.size() << 3;
    }

    static int i(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbqk.g(i, 0L);
    }

    static int j(List<?> list) {
        return list.size();
    }

    static int j(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbqk.b(i, true);
    }

    static int a(int i, List<?> list) {
        int iB;
        int iB2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iE = zzbqk.e(i) * size;
        if (list instanceof arn) {
            arn arnVar = (arn) list;
            while (i2 < size) {
                Object objB = arnVar.b(i2);
                if (objB instanceof apo) {
                    iB2 = zzbqk.b((apo) objB);
                } else {
                    iB2 = zzbqk.b((String) objB);
                }
                iE += iB2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof apo) {
                    iB = zzbqk.b((apo) obj);
                } else {
                    iB = zzbqk.b((String) obj);
                }
                iE += iB;
                i2++;
            }
        }
        return iE;
    }

    static int a(int i, Object obj, asx asxVar) {
        if (obj instanceof arl) {
            return zzbqk.a(i, (arl) obj);
        }
        return zzbqk.b(i, (asf) obj, asxVar);
    }

    static int a(int i, List<?> list, asx asxVar) {
        int iB;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iE = zzbqk.e(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof arl) {
                iB = zzbqk.a((arl) obj);
            } else {
                iB = zzbqk.b((asf) obj, asxVar);
            }
            iE += iB;
        }
        return iE;
    }

    static int b(int i, List<apo> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iE = size * zzbqk.e(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iE += zzbqk.b(list.get(i2));
        }
        return iE;
    }

    static int b(int i, List<asf> list, asx asxVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iC = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iC += zzbqk.c(i, list.get(i2), asxVar);
        }
        return iC;
    }

    public static ato<?, ?> a() {
        return f2242b;
    }

    public static ato<?, ?> b() {
        return c;
    }

    public static ato<?, ?> c() {
        return d;
    }

    private static ato<?, ?> a(boolean z) {
        try {
            Class<?> clsE = e();
            if (clsE == null) {
                return null;
            }
            return (ato) clsE.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> e() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void a(asa asaVar, T t, T t2, long j) {
        atv.a(t, j, asaVar.a(atv.f(t, j), atv.f(t2, j)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T, FT extends aqq<FT>> void a(aql<FT> aqlVar, T t, T t2) {
        aqo<T> aqoVarA = aqlVar.a(t2);
        if (aqoVarA.b()) {
            return;
        }
        aqlVar.b(t).a((aqo) aqoVarA);
    }

    static <T, UT, UB> void a(ato<UT, UB> atoVar, T t, T t2) {
        atoVar.a(t, atoVar.c(atoVar.b(t), atoVar.b(t2)));
    }

    static <UT, UB> UB a(int i, List<Integer> list, ard ardVar, UB ub, ato<UT, UB> atoVar) {
        UB ub2;
        int iIntValue;
        if (ardVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue2 = list.get(i3).intValue();
                if (ardVar.a(iIntValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue2));
                    }
                    i2++;
                } else {
                    ub2 = (UB) a(i, iIntValue2, ub2, atoVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            loop1: while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    iIntValue = it.next().intValue();
                    if (!ardVar.a(iIntValue)) {
                        break;
                    }
                }
                ub = (UB) a(i, iIntValue, ub2, atoVar);
                it.remove();
            }
        }
        return ub2;
    }

    static <UT, UB> UB a(int i, int i2, UB ub, ato<UT, UB> atoVar) {
        if (ub == null) {
            ub = atoVar.a();
        }
        atoVar.a((ato<UT, UB>) ub, i, i2);
        return ub;
    }
}
