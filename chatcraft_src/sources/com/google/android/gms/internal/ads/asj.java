package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class asj<T> implements asx<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f2227a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    private static final Unsafe f2228b = atv.c();
    private final int[] c;
    private final Object[] d;
    private final int e;
    private final int f;
    private final asf g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final asn o;
    private final aro p;
    private final ato<?, ?> q;
    private final aql<?> r;
    private final asa s;

    private asj(int[] iArr, Object[] objArr, int i, int i2, asf asfVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, asn asnVar, aro aroVar, ato<?, ?> atoVar, aql<?> aqlVar, asa asaVar) {
        this.c = iArr;
        this.d = objArr;
        this.e = i;
        this.f = i2;
        this.i = asfVar instanceof aqy;
        this.j = z;
        this.h = aqlVar != null && aqlVar.a(asfVar);
        this.k = false;
        this.l = iArr2;
        this.m = i3;
        this.n = i4;
        this.o = asnVar;
        this.p = aroVar;
        this.q = atoVar;
        this.r = aqlVar;
        this.g = asfVar;
        this.s = asaVar;
    }

    private static boolean f(int i) {
        return (i & 536870912) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x040e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static <T> com.google.android.gms.internal.ads.asj<T> a(java.lang.Class<T> r37, com.google.android.gms.internal.ads.asd r38, com.google.android.gms.internal.ads.asn r39, com.google.android.gms.internal.ads.aro r40, com.google.android.gms.internal.ads.ato<?, ?> r41, com.google.android.gms.internal.ads.aql<?> r42, com.google.android.gms.internal.ads.asa r43) {
        /*
            Method dump skipped, instructions count: 1170
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.asj.a(java.lang.Class, com.google.android.gms.internal.ads.asd, com.google.android.gms.internal.ads.asn, com.google.android.gms.internal.ads.aro, com.google.android.gms.internal.ads.ato, com.google.android.gms.internal.ads.aql, com.google.android.gms.internal.ads.asa):com.google.android.gms.internal.ads.asj");
    }

    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.asx
    public final T a() {
        return (T) this.o.a(this.g);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01b1  */
    @Override // com.google.android.gms.internal.ads.asx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.asj.a(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.ads.asx
    public final int a(T t) {
        int length = this.c.length;
        int iA = 0;
        for (int i = 0; i < length; i += 3) {
            int iD = d(i);
            int i2 = this.c[i];
            long j = 1048575 & iD;
            switch ((iD & 267386880) >>> 20) {
                case 0:
                    iA = (iA * 53) + ara.a(Double.doubleToLongBits(atv.e(t, j)));
                    break;
                case 1:
                    iA = (iA * 53) + Float.floatToIntBits(atv.d(t, j));
                    break;
                case 2:
                    iA = (iA * 53) + ara.a(atv.b(t, j));
                    break;
                case 3:
                    iA = (iA * 53) + ara.a(atv.b(t, j));
                    break;
                case 4:
                    iA = (iA * 53) + atv.a(t, j);
                    break;
                case 5:
                    iA = (iA * 53) + ara.a(atv.b(t, j));
                    break;
                case 6:
                    iA = (iA * 53) + atv.a(t, j);
                    break;
                case 7:
                    iA = (iA * 53) + ara.a(atv.c(t, j));
                    break;
                case 8:
                    iA = (iA * 53) + ((String) atv.f(t, j)).hashCode();
                    break;
                case 9:
                    Object objF = atv.f(t, j);
                    iA = (iA * 53) + (objF != null ? objF.hashCode() : 37);
                    break;
                case 10:
                    iA = (iA * 53) + atv.f(t, j).hashCode();
                    break;
                case 11:
                    iA = (iA * 53) + atv.a(t, j);
                    break;
                case 12:
                    iA = (iA * 53) + atv.a(t, j);
                    break;
                case 13:
                    iA = (iA * 53) + atv.a(t, j);
                    break;
                case 14:
                    iA = (iA * 53) + ara.a(atv.b(t, j));
                    break;
                case 15:
                    iA = (iA * 53) + atv.a(t, j);
                    break;
                case 16:
                    iA = (iA * 53) + ara.a(atv.b(t, j));
                    break;
                case 17:
                    Object objF2 = atv.f(t, j);
                    iA = (iA * 53) + (objF2 != null ? objF2.hashCode() : 37);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    iA = (iA * 53) + atv.f(t, j).hashCode();
                    break;
                case 50:
                    iA = (iA * 53) + atv.f(t, j).hashCode();
                    break;
                case 51:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + ara.a(Double.doubleToLongBits(b(t, j)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + Float.floatToIntBits(c(t, j));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + ara.a(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + ara.a(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + ara.a(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + ara.a(f(t, j));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + ((String) atv.f(t, j)).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + atv.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + atv.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + ara.a(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + d(t, j);
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + ara.a(e(t, j));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (a((asj<T>) t, i2, i)) {
                        iA = (iA * 53) + atv.f(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode = (iA * 53) + this.q.b(t).hashCode();
        return this.h ? (iHashCode * 53) + this.r.a(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.asx
    public final void b(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.c.length; i += 3) {
            int iD = d(i);
            long j = 1048575 & iD;
            int i2 = this.c[i];
            switch ((iD & 267386880) >>> 20) {
                case 0:
                    if (a((asj<T>) t2, i)) {
                        atv.a(t, j, atv.e(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (a((asj<T>) t2, i)) {
                        atv.a((Object) t, j, atv.d(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (a((asj<T>) t2, i)) {
                        atv.a((Object) t, j, atv.b(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (a((asj<T>) t2, i)) {
                        atv.a((Object) t, j, atv.b(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (a((asj<T>) t2, i)) {
                        atv.a((Object) t, j, atv.a(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (a((asj<T>) t2, i)) {
                        atv.a((Object) t, j, atv.b(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (a((asj<T>) t2, i)) {
                        atv.a((Object) t, j, atv.a(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (a((asj<T>) t2, i)) {
                        atv.a(t, j, atv.c(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (a((asj<T>) t2, i)) {
                        atv.a(t, j, atv.f(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    a(t, t2, i);
                    break;
                case 10:
                    if (a((asj<T>) t2, i)) {
                        atv.a(t, j, atv.f(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (a((asj<T>) t2, i)) {
                        atv.a((Object) t, j, atv.a(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (a((asj<T>) t2, i)) {
                        atv.a((Object) t, j, atv.a(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (a((asj<T>) t2, i)) {
                        atv.a((Object) t, j, atv.a(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (a((asj<T>) t2, i)) {
                        atv.a((Object) t, j, atv.b(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (a((asj<T>) t2, i)) {
                        atv.a((Object) t, j, atv.a(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (a((asj<T>) t2, i)) {
                        atv.a((Object) t, j, atv.b(t2, j));
                        b((asj<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    a(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.p.a(t, t2, j);
                    break;
                case 50:
                    asz.a(this.s, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (a((asj<T>) t2, i2, i)) {
                        atv.a(t, j, atv.f(t2, j));
                        b((asj<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    b(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (a((asj<T>) t2, i2, i)) {
                        atv.a(t, j, atv.f(t2, j));
                        b((asj<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    b(t, t2, i);
                    break;
            }
        }
        if (this.j) {
            return;
        }
        asz.a(this.q, t, t2);
        if (this.h) {
            asz.a(this.r, t, t2);
        }
    }

    private final void a(T t, T t2, int i) {
        long jD = d(i) & 1048575;
        if (a((asj<T>) t2, i)) {
            Object objF = atv.f(t, jD);
            Object objF2 = atv.f(t2, jD);
            if (objF != null && objF2 != null) {
                atv.a(t, jD, ara.a(objF, objF2));
                b((asj<T>) t, i);
            } else if (objF2 != null) {
                atv.a(t, jD, objF2);
                b((asj<T>) t, i);
            }
        }
    }

    private final void b(T t, T t2, int i) {
        int iD = d(i);
        int i2 = this.c[i];
        long j = iD & 1048575;
        if (a((asj<T>) t2, i2, i)) {
            Object objF = atv.f(t, j);
            Object objF2 = atv.f(t2, j);
            if (objF != null && objF2 != null) {
                atv.a(t, j, ara.a(objF, objF2));
                b((asj<T>) t, i2, i);
            } else if (objF2 != null) {
                atv.a(t, j, objF2);
                b((asj<T>) t, i2, i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:415:0x09ca A[PHI: r5
      0x09ca: PHI (r5v4 int) = 
      (r5v1 int)
      (r5v1 int)
      (r5v1 int)
      (r5v16 int)
      (r5v1 int)
      (r5v17 int)
      (r5v18 int)
      (r5v1 int)
      (r5v19 int)
      (r5v1 int)
      (r5v20 int)
      (r5v1 int)
      (r5v21 int)
      (r5v1 int)
      (r5v22 int)
      (r5v1 int)
      (r5v23 int)
      (r5v1 int)
      (r5v24 int)
      (r5v1 int)
      (r5v25 int)
      (r5v1 int)
      (r5v26 int)
      (r5v1 int)
      (r5v27 int)
      (r5v28 int)
      (r5v29 int)
      (r5v30 int)
      (r5v31 int)
      (r5v32 int)
      (r5v33 int)
      (r5v34 int)
      (r5v35 int)
      (r5v36 int)
      (r5v37 int)
      (r5v38 int)
      (r5v39 int)
      (r5v40 int)
      (r5v41 int)
      (r5v42 int)
      (r5v43 int)
      (r5v44 int)
      (r5v1 int)
      (r5v45 int)
      (r5v1 int)
      (r5v46 int)
      (r5v1 int)
      (r5v47 int)
      (r5v1 int)
      (r5v48 int)
      (r5v1 int)
      (r5v49 int)
      (r5v1 int)
      (r5v50 int)
      (r5v1 int)
      (r5v51 int)
      (r5v1 int)
      (r5v52 int)
      (r5v1 int)
      (r5v53 int)
      (r5v1 int)
      (r5v54 int)
      (r5v1 int)
      (r5v55 int)
      (r5v1 int)
      (r5v56 int)
      (r5v1 int)
      (r5v57 int)
      (r5v1 int)
      (r5v58 int)
      (r5v59 int)
      (r5v60 int)
      (r5v1 int)
      (r5v61 int)
      (r5v1 int)
      (r5v62 int)
      (r5v1 int)
      (r5v63 int)
      (r5v1 int)
      (r5v64 int)
      (r5v1 int)
      (r5v65 int)
      (r5v1 int)
      (r5v66 int)
      (r5v1 int)
      (r5v67 int)
      (r5v1 int)
      (r5v68 int)
      (r5v1 int)
      (r5v69 int)
      (r5v70 int)
      (r5v1 int)
      (r5v71 int)
      (r5v1 int)
      (r5v72 int)
      (r5v1 int)
      (r5v73 int)
      (r5v1 int)
      (r5v74 int)
      (r5v1 int)
      (r5v75 int)
      (r5v1 int)
      (r5v76 int)
      (r5v1 int)
      (r5v77 int)
      (r5v1 int)
      (r5v78 int)
      (r5v1 int)
      (r5v79 int)
     binds: [B:253:0x05b6, B:454:0x0a83, B:451:0x0a78, B:452:0x0a7a, B:445:0x0a5a, B:449:0x0a6d, B:448:0x0a64, B:442:0x0a47, B:443:0x0a49, B:439:0x0a37, B:440:0x0a39, B:436:0x0a29, B:437:0x0a2b, B:433:0x0a1b, B:434:0x0a1d, B:430:0x0a10, B:431:0x0a12, B:427:0x0a04, B:428:0x0a06, B:424:0x09f6, B:425:0x09f8, B:421:0x09e8, B:422:0x09ea, B:418:0x09d4, B:419:0x09d6, B:414:0x09be, B:413:0x09b1, B:412:0x09a4, B:411:0x0997, B:410:0x098a, B:409:0x097d, B:408:0x0970, B:407:0x0963, B:406:0x0957, B:405:0x0946, B:404:0x0939, B:403:0x092b, B:402:0x091d, B:401:0x090f, B:400:0x0901, B:399:0x08f3, B:398:0x08e5, B:393:0x08ce, B:397:0x08d8, B:387:0x08ad, B:391:0x08b7, B:381:0x088c, B:385:0x0896, B:375:0x086b, B:379:0x0875, B:369:0x084a, B:373:0x0854, B:363:0x0829, B:367:0x0833, B:357:0x0808, B:361:0x0812, B:351:0x07e7, B:355:0x07f1, B:345:0x07c6, B:349:0x07d0, B:339:0x07a5, B:343:0x07af, B:333:0x0784, B:337:0x078e, B:327:0x0763, B:331:0x076d, B:321:0x0742, B:325:0x074c, B:315:0x0721, B:319:0x072b, B:313:0x0706, B:312:0x06f5, B:310:0x06ea, B:311:0x06ec, B:307:0x06dc, B:308:0x06de, B:304:0x06cb, B:305:0x06cd, B:301:0x06ba, B:302:0x06bc, B:298:0x06a9, B:299:0x06ab, B:295:0x069a, B:296:0x069c, B:292:0x068c, B:293:0x068e, B:289:0x067f, B:290:0x0681, B:283:0x065f, B:287:0x0672, B:286:0x0669, B:280:0x064a, B:281:0x064c, B:277:0x0637, B:278:0x0639, B:274:0x0626, B:275:0x0628, B:271:0x0615, B:272:0x0617, B:268:0x0607, B:269:0x0609, B:265:0x05f8, B:266:0x05fa, B:262:0x05e7, B:263:0x05e9, B:259:0x05d6, B:260:0x05d8, B:256:0x05bf, B:257:0x05c1] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.asx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(T r21) {
        /*
            Method dump skipped, instructions count: 3114
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.asj.b(java.lang.Object):int");
    }

    private static <UT, UB> int a(ato<UT, UB> atoVar, T t) {
        return atoVar.f(atoVar.b(t));
    }

    private static <E> List<E> a(Object obj, long j) {
        return (List) atv.f(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x0546  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    @Override // com.google.android.gms.internal.ads.asx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r14, com.google.android.gms.internal.ads.auk r15) {
        /*
            Method dump skipped, instructions count: 2914
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.asj.a(java.lang.Object, com.google.android.gms.internal.ads.auk):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b(T r20, com.google.android.gms.internal.ads.auk r21) {
        /*
            Method dump skipped, instructions count: 1488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.asj.b(java.lang.Object, com.google.android.gms.internal.ads.auk):void");
    }

    private final <K, V> void a(auk aukVar, int i, Object obj, int i2) {
        if (obj != null) {
            aukVar.a(i, this.s.f(b(i2)), this.s.b(obj));
        }
    }

    private static <UT, UB> void a(ato<UT, UB> atoVar, T t, auk aukVar) {
        atoVar.a((ato<UT, UB>) atoVar.b(t), aukVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.asx
    public final void a(T t, asw aswVar, aqk aqkVar) {
        Object objA;
        if (aqkVar == null) {
            throw new NullPointerException();
        }
        ato atoVar = this.q;
        aql<?> aqlVar = this.r;
        Object objB = null;
        Object objA2 = null;
        while (true) {
            try {
                int iA = aswVar.a();
                int iG = g(iA);
                if (iG < 0) {
                    if (iA == Integer.MAX_VALUE) {
                        for (int i = this.m; i < this.n; i++) {
                            objA2 = a((Object) t, this.l[i], (int) objA2, (ato<UT, int>) atoVar);
                        }
                        if (objA2 != null) {
                            atoVar.b((Object) t, (T) objA2);
                            return;
                        }
                        return;
                    }
                    Object objA3 = !this.h ? null : aqlVar.a(aqkVar, this.g, iA);
                    if (objA3 != null) {
                        if (objB == null) {
                            objB = aqlVar.b(t);
                        }
                        aqo<T> aqoVar = objB;
                        objA2 = aqlVar.a(aswVar, objA3, aqkVar, aqoVar, objA2, atoVar);
                        objB = aqoVar;
                    } else {
                        atoVar.a(aswVar);
                        if (objA2 == null) {
                            objA2 = atoVar.c(t);
                        }
                        if (!atoVar.a((ato) objA2, aswVar)) {
                            for (int i2 = this.m; i2 < this.n; i2++) {
                                objA2 = a((Object) t, this.l[i2], (int) objA2, (ato<UT, int>) atoVar);
                            }
                            if (objA2 != null) {
                                atoVar.b((Object) t, (T) objA2);
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    int iD = d(iG);
                    switch ((267386880 & iD) >>> 20) {
                        case 0:
                            atv.a(t, iD & 1048575, aswVar.d());
                            b((asj<T>) t, iG);
                            break;
                        case 1:
                            atv.a((Object) t, iD & 1048575, aswVar.e());
                            b((asj<T>) t, iG);
                            break;
                        case 2:
                            atv.a((Object) t, iD & 1048575, aswVar.g());
                            b((asj<T>) t, iG);
                            break;
                        case 3:
                            atv.a((Object) t, iD & 1048575, aswVar.f());
                            b((asj<T>) t, iG);
                            break;
                        case 4:
                            atv.a((Object) t, iD & 1048575, aswVar.h());
                            b((asj<T>) t, iG);
                            break;
                        case 5:
                            atv.a((Object) t, iD & 1048575, aswVar.i());
                            b((asj<T>) t, iG);
                            break;
                        case 6:
                            atv.a((Object) t, iD & 1048575, aswVar.j());
                            b((asj<T>) t, iG);
                            break;
                        case 7:
                            atv.a(t, iD & 1048575, aswVar.k());
                            b((asj<T>) t, iG);
                            break;
                        case 8:
                            a(t, iD, aswVar);
                            b((asj<T>) t, iG);
                            break;
                        case 9:
                            if (a((asj<T>) t, iG)) {
                                long j = iD & 1048575;
                                atv.a(t, j, ara.a(atv.f(t, j), aswVar.a(a(iG), aqkVar)));
                                break;
                            } else {
                                atv.a(t, iD & 1048575, aswVar.a(a(iG), aqkVar));
                                b((asj<T>) t, iG);
                                break;
                            }
                        case 10:
                            atv.a(t, iD & 1048575, aswVar.n());
                            b((asj<T>) t, iG);
                            break;
                        case 11:
                            atv.a((Object) t, iD & 1048575, aswVar.o());
                            b((asj<T>) t, iG);
                            break;
                        case 12:
                            int iP = aswVar.p();
                            ard ardVarC = c(iG);
                            if (ardVarC != null && !ardVarC.a(iP)) {
                                objA = asz.a(iA, iP, objA2, (ato<UT, Object>) atoVar);
                                objA2 = objA;
                                break;
                            }
                            atv.a((Object) t, iD & 1048575, iP);
                            b((asj<T>) t, iG);
                            break;
                        case 13:
                            atv.a((Object) t, iD & 1048575, aswVar.q());
                            b((asj<T>) t, iG);
                            break;
                        case 14:
                            atv.a((Object) t, iD & 1048575, aswVar.r());
                            b((asj<T>) t, iG);
                            break;
                        case 15:
                            atv.a((Object) t, iD & 1048575, aswVar.s());
                            b((asj<T>) t, iG);
                            break;
                        case 16:
                            atv.a((Object) t, iD & 1048575, aswVar.t());
                            b((asj<T>) t, iG);
                            break;
                        case 17:
                            if (a((asj<T>) t, iG)) {
                                long j2 = iD & 1048575;
                                atv.a(t, j2, ara.a(atv.f(t, j2), aswVar.b(a(iG), aqkVar)));
                                break;
                            } else {
                                atv.a(t, iD & 1048575, aswVar.b(a(iG), aqkVar));
                                b((asj<T>) t, iG);
                                break;
                            }
                        case 18:
                            aswVar.a(this.p.a(t, iD & 1048575));
                            break;
                        case 19:
                            aswVar.b(this.p.a(t, iD & 1048575));
                            break;
                        case 20:
                            aswVar.d(this.p.a(t, iD & 1048575));
                            break;
                        case 21:
                            aswVar.c(this.p.a(t, iD & 1048575));
                            break;
                        case 22:
                            aswVar.e(this.p.a(t, iD & 1048575));
                            break;
                        case 23:
                            aswVar.f(this.p.a(t, iD & 1048575));
                            break;
                        case 24:
                            aswVar.g(this.p.a(t, iD & 1048575));
                            break;
                        case 25:
                            aswVar.h(this.p.a(t, iD & 1048575));
                            break;
                        case 26:
                            if (f(iD)) {
                                aswVar.j(this.p.a(t, iD & 1048575));
                                break;
                            } else {
                                aswVar.i(this.p.a(t, iD & 1048575));
                                break;
                            }
                        case 27:
                            aswVar.a(this.p.a(t, iD & 1048575), a(iG), aqkVar);
                            break;
                        case 28:
                            aswVar.k(this.p.a(t, iD & 1048575));
                            break;
                        case 29:
                            aswVar.l(this.p.a(t, iD & 1048575));
                            break;
                        case 30:
                            List<Integer> listA = this.p.a(t, iD & 1048575);
                            aswVar.m(listA);
                            objA = asz.a(iA, listA, c(iG), objA2, atoVar);
                            objA2 = objA;
                            break;
                        case 31:
                            aswVar.n(this.p.a(t, iD & 1048575));
                            break;
                        case 32:
                            aswVar.o(this.p.a(t, iD & 1048575));
                            break;
                        case 33:
                            aswVar.p(this.p.a(t, iD & 1048575));
                            break;
                        case 34:
                            aswVar.q(this.p.a(t, iD & 1048575));
                            break;
                        case 35:
                            aswVar.a(this.p.a(t, iD & 1048575));
                            break;
                        case 36:
                            aswVar.b(this.p.a(t, iD & 1048575));
                            break;
                        case 37:
                            aswVar.d(this.p.a(t, iD & 1048575));
                            break;
                        case 38:
                            aswVar.c(this.p.a(t, iD & 1048575));
                            break;
                        case 39:
                            aswVar.e(this.p.a(t, iD & 1048575));
                            break;
                        case 40:
                            aswVar.f(this.p.a(t, iD & 1048575));
                            break;
                        case 41:
                            aswVar.g(this.p.a(t, iD & 1048575));
                            break;
                        case 42:
                            aswVar.h(this.p.a(t, iD & 1048575));
                            break;
                        case 43:
                            aswVar.l(this.p.a(t, iD & 1048575));
                            break;
                        case 44:
                            List<Integer> listA2 = this.p.a(t, iD & 1048575);
                            aswVar.m(listA2);
                            objA = asz.a(iA, listA2, c(iG), objA2, atoVar);
                            objA2 = objA;
                            break;
                        case 45:
                            aswVar.n(this.p.a(t, iD & 1048575));
                            break;
                        case 46:
                            aswVar.o(this.p.a(t, iD & 1048575));
                            break;
                        case 47:
                            aswVar.p(this.p.a(t, iD & 1048575));
                            break;
                        case 48:
                            aswVar.q(this.p.a(t, iD & 1048575));
                            break;
                        case 49:
                            aswVar.b(this.p.a(t, iD & 1048575), a(iG), aqkVar);
                            break;
                        case 50:
                            Object objB2 = b(iG);
                            long jD = d(iG) & 1048575;
                            Object objF = atv.f(t, jD);
                            if (objF == null) {
                                objF = this.s.e(objB2);
                                atv.a(t, jD, objF);
                            } else if (this.s.c(objF)) {
                                Object objE = this.s.e(objB2);
                                this.s.a(objE, objF);
                                atv.a(t, jD, objE);
                                objF = objE;
                            }
                            aswVar.a(this.s.a(objF), this.s.f(objB2), aqkVar);
                            break;
                        case 51:
                            atv.a(t, iD & 1048575, Double.valueOf(aswVar.d()));
                            b((asj<T>) t, iA, iG);
                            break;
                        case 52:
                            atv.a(t, iD & 1048575, Float.valueOf(aswVar.e()));
                            b((asj<T>) t, iA, iG);
                            break;
                        case 53:
                            atv.a(t, iD & 1048575, Long.valueOf(aswVar.g()));
                            b((asj<T>) t, iA, iG);
                            break;
                        case 54:
                            atv.a(t, iD & 1048575, Long.valueOf(aswVar.f()));
                            b((asj<T>) t, iA, iG);
                            break;
                        case 55:
                            atv.a(t, iD & 1048575, Integer.valueOf(aswVar.h()));
                            b((asj<T>) t, iA, iG);
                            break;
                        case 56:
                            atv.a(t, iD & 1048575, Long.valueOf(aswVar.i()));
                            b((asj<T>) t, iA, iG);
                            break;
                        case 57:
                            atv.a(t, iD & 1048575, Integer.valueOf(aswVar.j()));
                            b((asj<T>) t, iA, iG);
                            break;
                        case 58:
                            atv.a(t, iD & 1048575, Boolean.valueOf(aswVar.k()));
                            b((asj<T>) t, iA, iG);
                            break;
                        case 59:
                            a(t, iD, aswVar);
                            b((asj<T>) t, iA, iG);
                            break;
                        case 60:
                            if (a((asj<T>) t, iA, iG)) {
                                long j3 = iD & 1048575;
                                atv.a(t, j3, ara.a(atv.f(t, j3), aswVar.a(a(iG), aqkVar)));
                            } else {
                                atv.a(t, iD & 1048575, aswVar.a(a(iG), aqkVar));
                                b((asj<T>) t, iG);
                            }
                            b((asj<T>) t, iA, iG);
                            break;
                        case 61:
                            atv.a(t, iD & 1048575, aswVar.n());
                            b((asj<T>) t, iA, iG);
                            break;
                        case 62:
                            atv.a(t, iD & 1048575, Integer.valueOf(aswVar.o()));
                            b((asj<T>) t, iA, iG);
                            break;
                        case 63:
                            int iP2 = aswVar.p();
                            ard ardVarC2 = c(iG);
                            if (ardVarC2 != null && !ardVarC2.a(iP2)) {
                                objA = asz.a(iA, iP2, objA2, (ato<UT, Object>) atoVar);
                                objA2 = objA;
                                break;
                            }
                            atv.a(t, iD & 1048575, Integer.valueOf(iP2));
                            b((asj<T>) t, iA, iG);
                            break;
                        case 64:
                            atv.a(t, iD & 1048575, Integer.valueOf(aswVar.q()));
                            b((asj<T>) t, iA, iG);
                            break;
                        case 65:
                            atv.a(t, iD & 1048575, Long.valueOf(aswVar.r()));
                            b((asj<T>) t, iA, iG);
                            break;
                        case 66:
                            atv.a(t, iD & 1048575, Integer.valueOf(aswVar.s()));
                            b((asj<T>) t, iA, iG);
                            break;
                        case 67:
                            atv.a(t, iD & 1048575, Long.valueOf(aswVar.t()));
                            b((asj<T>) t, iA, iG);
                            break;
                        case 68:
                            atv.a(t, iD & 1048575, aswVar.b(a(iG), aqkVar));
                            b((asj<T>) t, iA, iG);
                            break;
                        default:
                            if (objA2 == null) {
                                try {
                                    objA2 = atoVar.a();
                                } catch (zzbrm unused) {
                                    atoVar.a(aswVar);
                                    if (objA2 == null) {
                                        objA2 = atoVar.c(t);
                                    }
                                    if (!atoVar.a((ato) objA2, aswVar)) {
                                        for (int i3 = this.m; i3 < this.n; i3++) {
                                            objA2 = a((Object) t, this.l[i3], (int) objA2, (ato<UT, int>) atoVar);
                                        }
                                        if (objA2 != null) {
                                            atoVar.b((Object) t, (T) objA2);
                                            return;
                                        }
                                        return;
                                    }
                                    break;
                                }
                            }
                            if (!atoVar.a((ato) objA2, aswVar)) {
                                for (int i4 = this.m; i4 < this.n; i4++) {
                                    objA2 = a((Object) t, this.l[i4], (int) objA2, (ato<UT, int>) atoVar);
                                }
                                if (objA2 != null) {
                                    atoVar.b((Object) t, (T) objA2);
                                    return;
                                }
                                return;
                            }
                            break;
                    }
                }
            } catch (Throwable th) {
                for (int i5 = this.m; i5 < this.n; i5++) {
                    objA2 = a((Object) t, this.l[i5], (int) objA2, (ato<UT, int>) atoVar);
                }
                if (objA2 != null) {
                    atoVar.b((Object) t, (T) objA2);
                }
                throw th;
            }
        }
    }

    private static atp e(Object obj) {
        aqy aqyVar = (aqy) obj;
        atp atpVar = aqyVar.zzfpu;
        if (atpVar != atp.a()) {
            return atpVar;
        }
        atp atpVarB = atp.b();
        aqyVar.zzfpu = atpVarB;
        return atpVarB;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int a(asx asxVar, byte[] bArr, int i, int i2, apl aplVar) throws zzbrl {
        int iA = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iA = apk.a(i3, bArr, iA, aplVar);
            i3 = aplVar.f2145a;
        }
        int i4 = iA;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzbrl.a();
        }
        Object objA = asxVar.a();
        int i5 = i3 + i4;
        asxVar.a(objA, bArr, i4, i5, aplVar);
        asxVar.c(objA);
        aplVar.c = objA;
        return i5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int a(asx asxVar, byte[] bArr, int i, int i2, int i3, apl aplVar) throws zzbrl {
        asj asjVar = (asj) asxVar;
        Object objA = asjVar.a();
        int iA = asjVar.a((asj) objA, bArr, i, i2, i3, aplVar);
        asjVar.c((asj) objA);
        aplVar.c = objA;
        return iA;
    }

    private static int a(asx<?> asxVar, int i, byte[] bArr, int i2, int i3, arf<?> arfVar, apl aplVar) throws zzbrl {
        int iA = a((asx) asxVar, bArr, i2, i3, aplVar);
        arfVar.add(aplVar.c);
        while (iA < i3) {
            int iA2 = apk.a(bArr, iA, aplVar);
            if (i != aplVar.f2145a) {
                break;
            }
            iA = a((asx) asxVar, bArr, iA2, i3, aplVar);
            arfVar.add(aplVar.c);
        }
        return iA;
    }

    private static int a(byte[] bArr, int i, int i2, aue aueVar, Class<?> cls, apl aplVar) {
        switch (ask.f2229a[aueVar.ordinal()]) {
            case 1:
                int iB = apk.b(bArr, i, aplVar);
                aplVar.c = Boolean.valueOf(aplVar.f2146b != 0);
                return iB;
            case 2:
                return apk.e(bArr, i, aplVar);
            case 3:
                aplVar.c = Double.valueOf(apk.c(bArr, i));
                return i + 8;
            case 4:
            case 5:
                aplVar.c = Integer.valueOf(apk.a(bArr, i));
                return i + 4;
            case 6:
            case 7:
                aplVar.c = Long.valueOf(apk.b(bArr, i));
                return i + 8;
            case 8:
                aplVar.c = Float.valueOf(apk.d(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iA = apk.a(bArr, i, aplVar);
                aplVar.c = Integer.valueOf(aplVar.f2145a);
                return iA;
            case 12:
            case 13:
                int iB2 = apk.b(bArr, i, aplVar);
                aplVar.c = Long.valueOf(aplVar.f2146b);
                return iB2;
            case 14:
                return a((asx) ass.a().a((Class) cls), bArr, i, i2, aplVar);
            case 15:
                int iA2 = apk.a(bArr, i, aplVar);
                aplVar.c = Integer.valueOf(aqa.g(aplVar.f2145a));
                return iA2;
            case 16:
                int iB3 = apk.b(bArr, i, aplVar);
                aplVar.c = Long.valueOf(aqa.a(aplVar.f2146b));
                return iB3;
            case 17:
                return apk.d(bArr, i, aplVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static int a(int i, byte[] bArr, int i2, int i3, Object obj, apl aplVar) {
        return apk.a(i, bArr, i2, i3, e(obj), aplVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, apl aplVar) throws zzbrl {
        int iA;
        int iB = i;
        arf arfVarA = (arf) f2228b.getObject(t, j2);
        if (!arfVarA.a()) {
            int size = arfVarA.size();
            arfVarA = arfVarA.a(size == 0 ? 10 : size << 1);
            f2228b.putObject(t, j2, arfVarA);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    aqh aqhVar = (aqh) arfVarA;
                    int iA2 = apk.a(bArr, iB, aplVar);
                    int i8 = aplVar.f2145a + iA2;
                    while (iA2 < i8) {
                        aqhVar.a(apk.c(bArr, iA2));
                        iA2 += 8;
                    }
                    if (iA2 == i8) {
                        return iA2;
                    }
                    throw zzbrl.a();
                }
                if (i5 == 1) {
                    aqh aqhVar2 = (aqh) arfVarA;
                    aqhVar2.a(apk.c(bArr, i));
                    int i9 = iB + 8;
                    while (i9 < i2) {
                        int iA3 = apk.a(bArr, i9, aplVar);
                        if (i3 != aplVar.f2145a) {
                            return i9;
                        }
                        aqhVar2.a(apk.c(bArr, iA3));
                        i9 = iA3 + 8;
                    }
                    return i9;
                }
                return iB;
            case 19:
            case 36:
                if (i5 == 2) {
                    aqv aqvVar = (aqv) arfVarA;
                    int iA4 = apk.a(bArr, iB, aplVar);
                    int i10 = aplVar.f2145a + iA4;
                    while (iA4 < i10) {
                        aqvVar.a(apk.d(bArr, iA4));
                        iA4 += 4;
                    }
                    if (iA4 == i10) {
                        return iA4;
                    }
                    throw zzbrl.a();
                }
                if (i5 == 5) {
                    aqv aqvVar2 = (aqv) arfVarA;
                    aqvVar2.a(apk.d(bArr, i));
                    int i11 = iB + 4;
                    while (i11 < i2) {
                        int iA5 = apk.a(bArr, i11, aplVar);
                        if (i3 != aplVar.f2145a) {
                            return i11;
                        }
                        aqvVar2.a(apk.d(bArr, iA5));
                        i11 = iA5 + 4;
                    }
                    return i11;
                }
                return iB;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    ars arsVar = (ars) arfVarA;
                    int iA6 = apk.a(bArr, iB, aplVar);
                    int i12 = aplVar.f2145a + iA6;
                    while (iA6 < i12) {
                        iA6 = apk.b(bArr, iA6, aplVar);
                        arsVar.a(aplVar.f2146b);
                    }
                    if (iA6 == i12) {
                        return iA6;
                    }
                    throw zzbrl.a();
                }
                if (i5 == 0) {
                    ars arsVar2 = (ars) arfVarA;
                    int iB2 = apk.b(bArr, iB, aplVar);
                    arsVar2.a(aplVar.f2146b);
                    while (iB2 < i2) {
                        int iA7 = apk.a(bArr, iB2, aplVar);
                        if (i3 != aplVar.f2145a) {
                            return iB2;
                        }
                        iB2 = apk.b(bArr, iA7, aplVar);
                        arsVar2.a(aplVar.f2146b);
                    }
                    return iB2;
                }
                return iB;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return apk.a(bArr, iB, (arf<?>) arfVarA, aplVar);
                }
                if (i5 == 0) {
                    return apk.a(i3, bArr, i, i2, (arf<?>) arfVarA, aplVar);
                }
                return iB;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    ars arsVar3 = (ars) arfVarA;
                    int iA8 = apk.a(bArr, iB, aplVar);
                    int i13 = aplVar.f2145a + iA8;
                    while (iA8 < i13) {
                        arsVar3.a(apk.b(bArr, iA8));
                        iA8 += 8;
                    }
                    if (iA8 == i13) {
                        return iA8;
                    }
                    throw zzbrl.a();
                }
                if (i5 == 1) {
                    ars arsVar4 = (ars) arfVarA;
                    arsVar4.a(apk.b(bArr, i));
                    int i14 = iB + 8;
                    while (i14 < i2) {
                        int iA9 = apk.a(bArr, i14, aplVar);
                        if (i3 != aplVar.f2145a) {
                            return i14;
                        }
                        arsVar4.a(apk.b(bArr, iA9));
                        i14 = iA9 + 8;
                    }
                    return i14;
                }
                return iB;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    aqz aqzVar = (aqz) arfVarA;
                    int iA10 = apk.a(bArr, iB, aplVar);
                    int i15 = aplVar.f2145a + iA10;
                    while (iA10 < i15) {
                        aqzVar.c(apk.a(bArr, iA10));
                        iA10 += 4;
                    }
                    if (iA10 == i15) {
                        return iA10;
                    }
                    throw zzbrl.a();
                }
                if (i5 == 5) {
                    aqz aqzVar2 = (aqz) arfVarA;
                    aqzVar2.c(apk.a(bArr, i));
                    int i16 = iB + 4;
                    while (i16 < i2) {
                        int iA11 = apk.a(bArr, i16, aplVar);
                        if (i3 != aplVar.f2145a) {
                            return i16;
                        }
                        aqzVar2.c(apk.a(bArr, iA11));
                        i16 = iA11 + 4;
                    }
                    return i16;
                }
                return iB;
            case 25:
            case 42:
                if (i5 == 2) {
                    apm apmVar = (apm) arfVarA;
                    iA = apk.a(bArr, iB, aplVar);
                    int i17 = aplVar.f2145a + iA;
                    while (iA < i17) {
                        iA = apk.b(bArr, iA, aplVar);
                        apmVar.a(aplVar.f2146b != 0);
                    }
                    if (iA != i17) {
                        throw zzbrl.a();
                    }
                    return iA;
                }
                if (i5 == 0) {
                    apm apmVar2 = (apm) arfVarA;
                    iB = apk.b(bArr, iB, aplVar);
                    apmVar2.a(aplVar.f2146b != 0);
                    while (iB < i2) {
                        int iA12 = apk.a(bArr, iB, aplVar);
                        if (i3 == aplVar.f2145a) {
                            iB = apk.b(bArr, iA12, aplVar);
                            apmVar2.a(aplVar.f2146b != 0);
                        }
                    }
                }
                return iB;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iA13 = apk.a(bArr, iB, aplVar);
                        int i18 = aplVar.f2145a;
                        if (i18 < 0) {
                            throw zzbrl.b();
                        }
                        if (i18 == 0) {
                            arfVarA.add(BuildConfig.FLAVOR);
                        } else {
                            arfVarA.add(new String(bArr, iA13, i18, ara.f2199a));
                            iA13 += i18;
                        }
                        while (iA13 < i2) {
                            int iA14 = apk.a(bArr, iA13, aplVar);
                            if (i3 != aplVar.f2145a) {
                                return iA13;
                            }
                            iA13 = apk.a(bArr, iA14, aplVar);
                            int i19 = aplVar.f2145a;
                            if (i19 < 0) {
                                throw zzbrl.b();
                            }
                            if (i19 == 0) {
                                arfVarA.add(BuildConfig.FLAVOR);
                            } else {
                                arfVarA.add(new String(bArr, iA13, i19, ara.f2199a));
                                iA13 += i19;
                            }
                        }
                        return iA13;
                    }
                    int iA15 = apk.a(bArr, iB, aplVar);
                    int i20 = aplVar.f2145a;
                    if (i20 < 0) {
                        throw zzbrl.b();
                    }
                    if (i20 == 0) {
                        arfVarA.add(BuildConfig.FLAVOR);
                    } else {
                        int i21 = iA15 + i20;
                        if (!atx.a(bArr, iA15, i21)) {
                            throw zzbrl.i();
                        }
                        arfVarA.add(new String(bArr, iA15, i20, ara.f2199a));
                        iA15 = i21;
                    }
                    while (iA15 < i2) {
                        int iA16 = apk.a(bArr, iA15, aplVar);
                        if (i3 != aplVar.f2145a) {
                            return iA15;
                        }
                        iA15 = apk.a(bArr, iA16, aplVar);
                        int i22 = aplVar.f2145a;
                        if (i22 < 0) {
                            throw zzbrl.b();
                        }
                        if (i22 == 0) {
                            arfVarA.add(BuildConfig.FLAVOR);
                        } else {
                            int i23 = iA15 + i22;
                            if (!atx.a(bArr, iA15, i23)) {
                                throw zzbrl.i();
                            }
                            arfVarA.add(new String(bArr, iA15, i22, ara.f2199a));
                            iA15 = i23;
                        }
                    }
                    return iA15;
                }
                return iB;
            case 27:
                if (i5 == 2) {
                    return a((asx<?>) a(i6), i3, bArr, i, i2, (arf<?>) arfVarA, aplVar);
                }
                return iB;
            case 28:
                if (i5 == 2) {
                    int iA17 = apk.a(bArr, iB, aplVar);
                    int i24 = aplVar.f2145a;
                    if (i24 < 0) {
                        throw zzbrl.b();
                    }
                    if (i24 > bArr.length - iA17) {
                        throw zzbrl.a();
                    }
                    if (i24 == 0) {
                        arfVarA.add(apo.f2149a);
                    } else {
                        arfVarA.add(apo.a(bArr, iA17, i24));
                        iA17 += i24;
                    }
                    while (iA17 < i2) {
                        int iA18 = apk.a(bArr, iA17, aplVar);
                        if (i3 != aplVar.f2145a) {
                            return iA17;
                        }
                        iA17 = apk.a(bArr, iA18, aplVar);
                        int i25 = aplVar.f2145a;
                        if (i25 < 0) {
                            throw zzbrl.b();
                        }
                        if (i25 > bArr.length - iA17) {
                            throw zzbrl.a();
                        }
                        if (i25 == 0) {
                            arfVarA.add(apo.f2149a);
                        } else {
                            arfVarA.add(apo.a(bArr, iA17, i25));
                            iA17 += i25;
                        }
                    }
                    return iA17;
                }
                return iB;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iA = apk.a(i3, bArr, i, i2, (arf<?>) arfVarA, aplVar);
                    }
                    return iB;
                }
                iA = apk.a(bArr, iB, (arf<?>) arfVarA, aplVar);
                aqy aqyVar = (aqy) t;
                atp atpVar = aqyVar.zzfpu;
                if (atpVar == atp.a()) {
                    atpVar = null;
                }
                atp atpVar2 = (atp) asz.a(i4, arfVarA, c(i6), atpVar, this.q);
                if (atpVar2 != null) {
                    aqyVar.zzfpu = atpVar2;
                }
                return iA;
            case 33:
            case 47:
                if (i5 == 2) {
                    aqz aqzVar3 = (aqz) arfVarA;
                    int iA19 = apk.a(bArr, iB, aplVar);
                    int i26 = aplVar.f2145a + iA19;
                    while (iA19 < i26) {
                        iA19 = apk.a(bArr, iA19, aplVar);
                        aqzVar3.c(aqa.g(aplVar.f2145a));
                    }
                    if (iA19 == i26) {
                        return iA19;
                    }
                    throw zzbrl.a();
                }
                if (i5 == 0) {
                    aqz aqzVar4 = (aqz) arfVarA;
                    int iA20 = apk.a(bArr, iB, aplVar);
                    aqzVar4.c(aqa.g(aplVar.f2145a));
                    while (iA20 < i2) {
                        int iA21 = apk.a(bArr, iA20, aplVar);
                        if (i3 != aplVar.f2145a) {
                            return iA20;
                        }
                        iA20 = apk.a(bArr, iA21, aplVar);
                        aqzVar4.c(aqa.g(aplVar.f2145a));
                    }
                    return iA20;
                }
                return iB;
            case 34:
            case 48:
                if (i5 == 2) {
                    ars arsVar5 = (ars) arfVarA;
                    int iA22 = apk.a(bArr, iB, aplVar);
                    int i27 = aplVar.f2145a + iA22;
                    while (iA22 < i27) {
                        iA22 = apk.b(bArr, iA22, aplVar);
                        arsVar5.a(aqa.a(aplVar.f2146b));
                    }
                    if (iA22 == i27) {
                        return iA22;
                    }
                    throw zzbrl.a();
                }
                if (i5 == 0) {
                    ars arsVar6 = (ars) arfVarA;
                    int iB3 = apk.b(bArr, iB, aplVar);
                    arsVar6.a(aqa.a(aplVar.f2146b));
                    while (iB3 < i2) {
                        int iA23 = apk.a(bArr, iB3, aplVar);
                        if (i3 != aplVar.f2145a) {
                            return iB3;
                        }
                        iB3 = apk.b(bArr, iA23, aplVar);
                        arsVar6.a(aqa.a(aplVar.f2146b));
                    }
                    return iB3;
                }
                return iB;
            case 49:
                if (i5 == 3) {
                    asx asxVarA = a(i6);
                    int i28 = (i3 & (-8)) | 4;
                    iB = a(asxVarA, bArr, i, i2, i28, aplVar);
                    arfVarA.add(aplVar.c);
                    while (iB < i2) {
                        int iA24 = apk.a(bArr, iB, aplVar);
                        if (i3 == aplVar.f2145a) {
                            iB = a(asxVarA, bArr, iA24, i2, i28, aplVar);
                            arfVarA.add(aplVar.c);
                        }
                    }
                }
                return iB;
            default:
                return iB;
        }
    }

    private final <K, V> int a(T t, byte[] bArr, int i, int i2, int i3, long j, apl aplVar) throws zzbrl {
        Unsafe unsafe = f2228b;
        Object objB = b(i3);
        Object object = unsafe.getObject(t, j);
        if (this.s.c(object)) {
            Object objE = this.s.e(objB);
            this.s.a(objE, object);
            unsafe.putObject(t, j, objE);
            object = objE;
        }
        ary<?, ?> aryVarF = this.s.f(objB);
        Map<?, ?> mapA = this.s.a(object);
        int iA = apk.a(bArr, i, aplVar);
        int i4 = aplVar.f2145a;
        if (i4 < 0 || i4 > i2 - iA) {
            throw zzbrl.a();
        }
        int i5 = i4 + iA;
        K k = aryVarF.f2220b;
        V v = aryVarF.d;
        while (iA < i5) {
            int iA2 = iA + 1;
            int i6 = bArr[iA];
            if (i6 < 0) {
                iA2 = apk.a(i6, bArr, iA2, aplVar);
                i6 = aplVar.f2145a;
            }
            int i7 = iA2;
            int i8 = i6 & 7;
            switch (i6 >>> 3) {
                case 1:
                    if (i8 == aryVarF.f2219a.b()) {
                        iA = a(bArr, i7, i2, aryVarF.f2219a, (Class<?>) null, aplVar);
                        k = (K) aplVar.c;
                        break;
                    } else {
                        iA = apk.a(i6, bArr, i7, i2, aplVar);
                        break;
                    }
                case 2:
                    if (i8 == aryVarF.c.b()) {
                        iA = a(bArr, i7, i2, aryVarF.c, aryVarF.d.getClass(), aplVar);
                        v = aplVar.c;
                        break;
                    } else {
                        iA = apk.a(i6, bArr, i7, i2, aplVar);
                        break;
                    }
                default:
                    iA = apk.a(i6, bArr, i7, i2, aplVar);
                    break;
            }
        }
        if (iA != i5) {
            throw zzbrl.h();
        }
        mapA.put(k, v);
        return i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int a(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, apl aplVar) throws zzbrl {
        int iB;
        Unsafe unsafe = f2228b;
        long j2 = this.c[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(apk.c(bArr, i)));
                    iB = i + 8;
                    break;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(apk.d(bArr, i)));
                    iB = i + 4;
                    break;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    iB = apk.b(bArr, i, aplVar);
                    unsafe.putObject(t, j, Long.valueOf(aplVar.f2146b));
                    break;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    iB = apk.a(bArr, i, aplVar);
                    unsafe.putObject(t, j, Integer.valueOf(aplVar.f2145a));
                    break;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(apk.b(bArr, i)));
                    iB = i + 8;
                    break;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(apk.a(bArr, i)));
                    iB = i + 4;
                    break;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    iB = apk.b(bArr, i, aplVar);
                    unsafe.putObject(t, j, Boolean.valueOf(aplVar.f2146b != 0));
                    break;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int iA = apk.a(bArr, i, aplVar);
                    int i9 = aplVar.f2145a;
                    if (i9 == 0) {
                        unsafe.putObject(t, j, BuildConfig.FLAVOR);
                    } else {
                        if ((i6 & 536870912) != 0 && !atx.a(bArr, iA, iA + i9)) {
                            throw zzbrl.i();
                        }
                        unsafe.putObject(t, j, new String(bArr, iA, i9, ara.f2199a));
                        iA += i9;
                    }
                    unsafe.putInt(t, j2, i4);
                    return iA;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int iA2 = a(a(i8), bArr, i, i2, aplVar);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, aplVar.c);
                    } else {
                        unsafe.putObject(t, j, ara.a(object, aplVar.c));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iA2;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    iB = apk.e(bArr, i, aplVar);
                    unsafe.putObject(t, j, aplVar.c);
                    break;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int iA3 = apk.a(bArr, i, aplVar);
                    int i10 = aplVar.f2145a;
                    ard ardVarC = c(i8);
                    if (ardVarC == null || ardVarC.a(i10)) {
                        unsafe.putObject(t, j, Integer.valueOf(i10));
                        iB = iA3;
                        break;
                    } else {
                        e(t).a(i3, Long.valueOf(i10));
                        return iA3;
                    }
                }
                return i;
            case 66:
                if (i5 == 0) {
                    iB = apk.a(bArr, i, aplVar);
                    unsafe.putObject(t, j, Integer.valueOf(aqa.g(aplVar.f2145a)));
                    break;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    iB = apk.b(bArr, i, aplVar);
                    unsafe.putObject(t, j, Long.valueOf(aqa.a(aplVar.f2146b)));
                    break;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    iB = a(a(i8), bArr, i, i2, (i3 & (-8)) | 4, aplVar);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, aplVar.c);
                        break;
                    } else {
                        unsafe.putObject(t, j, ara.a(object2, aplVar.c));
                        break;
                    }
                }
                return i;
            default:
                return i;
        }
        unsafe.putInt(t, j2, i4);
        return iB;
    }

    private final asx a(int i) {
        int i2 = (i / 3) << 1;
        asx asxVar = (asx) this.d[i2];
        if (asxVar != null) {
            return asxVar;
        }
        asx<T> asxVarA = ass.a().a((Class) this.d[i2 + 1]);
        this.d[i2] = asxVarA;
        return asxVarA;
    }

    private final Object b(int i) {
        return this.d[(i / 3) << 1];
    }

    private final ard c(int i) {
        return (ard) this.d[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x035a, code lost:
    
        if (r0 == r11) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x035e, code lost:
    
        r12 = r32;
        r9 = r36;
        r1 = r17;
        r2 = r19;
        r6 = r20;
        r7 = r25;
        r10 = r28;
        r3 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x039f, code lost:
    
        if (r0 == r15) goto L123;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x0090. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int a(T r31, byte[] r32, int r33, int r34, int r35, com.google.android.gms.internal.ads.apl r36) throws com.google.android.gms.internal.ads.zzbrl {
        /*
            Method dump skipped, instructions count: 1150
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.asj.a(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.apl):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0231, code lost:
    
        if (r0 == r15) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01e4, code lost:
    
        if (r0 == r15) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01e6, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0212, code lost:
    
        if (r0 == r15) goto L92;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0062. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    @Override // com.google.android.gms.internal.ads.asx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r29, byte[] r30, int r31, int r32, com.google.android.gms.internal.ads.apl r33) throws com.google.android.gms.internal.ads.zzbrl {
        /*
            Method dump skipped, instructions count: 662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.asj.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.apl):void");
    }

    @Override // com.google.android.gms.internal.ads.asx
    public final void c(T t) {
        for (int i = this.m; i < this.n; i++) {
            long jD = d(this.l[i]) & 1048575;
            Object objF = atv.f(t, jD);
            if (objF != null) {
                atv.a(t, jD, this.s.d(objF));
            }
        }
        int length = this.l.length;
        for (int i2 = this.n; i2 < length; i2++) {
            this.p.b(t, this.l[i2]);
        }
        this.q.d(t);
        if (this.h) {
            this.r.c(t);
        }
    }

    private final <UT, UB> UB a(Object obj, int i, UB ub, ato<UT, UB> atoVar) {
        ard ardVarC;
        int i2 = this.c[i];
        Object objF = atv.f(obj, d(i) & 1048575);
        return (objF == null || (ardVarC = c(i)) == null) ? ub : (UB) a(i, i2, this.s.a(objF), ardVarC, (ard) ub, (ato<UT, ard>) atoVar);
    }

    private final <K, V, UT, UB> UB a(int i, int i2, Map<K, V> map, ard ardVar, UB ub, ato<UT, UB> atoVar) {
        ary<?, ?> aryVarF = this.s.f(b(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!ardVar.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = atoVar.a();
                }
                apw apwVarB = apo.b(arx.a(aryVarF, next.getKey(), next.getValue()));
                try {
                    arx.a(apwVarB.b(), aryVarF, next.getKey(), next.getValue());
                    atoVar.a((ato<UT, UB>) ub, i2, apwVarB.a());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0104, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c7  */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [com.google.android.gms.internal.ads.asx] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.ads.asx] */
    @Override // com.google.android.gms.internal.ads.asx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(T r14) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.asj.d(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(Object obj, int i, asx asxVar) {
        return asxVar.d(atv.f(obj, i & 1048575));
    }

    private static void a(int i, Object obj, auk aukVar) {
        if (obj instanceof String) {
            aukVar.a(i, (String) obj);
        } else {
            aukVar.a(i, (apo) obj);
        }
    }

    private final void a(Object obj, int i, asw aswVar) {
        if (f(i)) {
            atv.a(obj, i & 1048575, aswVar.m());
        } else if (this.i) {
            atv.a(obj, i & 1048575, aswVar.l());
        } else {
            atv.a(obj, i & 1048575, aswVar.n());
        }
    }

    private final int d(int i) {
        return this.c[i + 1];
    }

    private final int e(int i) {
        return this.c[i + 2];
    }

    private static <T> double b(T t, long j) {
        return ((Double) atv.f(t, j)).doubleValue();
    }

    private static <T> float c(T t, long j) {
        return ((Float) atv.f(t, j)).floatValue();
    }

    private static <T> int d(T t, long j) {
        return ((Integer) atv.f(t, j)).intValue();
    }

    private static <T> long e(T t, long j) {
        return ((Long) atv.f(t, j)).longValue();
    }

    private static <T> boolean f(T t, long j) {
        return ((Boolean) atv.f(t, j)).booleanValue();
    }

    private final boolean c(T t, T t2, int i) {
        return a((asj<T>) t, i) == a((asj<T>) t2, i);
    }

    private final boolean a(T t, int i, int i2, int i3) {
        if (this.j) {
            return a((asj<T>) t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean a(T t, int i) {
        if (this.j) {
            int iD = d(i);
            long j = iD & 1048575;
            switch ((iD & 267386880) >>> 20) {
                case 0:
                    return atv.e(t, j) != 0.0d;
                case 1:
                    return atv.d(t, j) != 0.0f;
                case 2:
                    return atv.b(t, j) != 0;
                case 3:
                    return atv.b(t, j) != 0;
                case 4:
                    return atv.a(t, j) != 0;
                case 5:
                    return atv.b(t, j) != 0;
                case 6:
                    return atv.a(t, j) != 0;
                case 7:
                    return atv.c(t, j);
                case 8:
                    Object objF = atv.f(t, j);
                    if (objF instanceof String) {
                        return !((String) objF).isEmpty();
                    }
                    if (objF instanceof apo) {
                        return !apo.f2149a.equals(objF);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return atv.f(t, j) != null;
                case 10:
                    return !apo.f2149a.equals(atv.f(t, j));
                case 11:
                    return atv.a(t, j) != 0;
                case 12:
                    return atv.a(t, j) != 0;
                case 13:
                    return atv.a(t, j) != 0;
                case 14:
                    return atv.b(t, j) != 0;
                case 15:
                    return atv.a(t, j) != 0;
                case 16:
                    return atv.b(t, j) != 0;
                case 17:
                    return atv.f(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int iE = e(i);
        return (atv.a(t, (long) (iE & 1048575)) & (1 << (iE >>> 20))) != 0;
    }

    private final void b(T t, int i) {
        if (this.j) {
            return;
        }
        int iE = e(i);
        long j = iE & 1048575;
        atv.a((Object) t, j, atv.a(t, j) | (1 << (iE >>> 20)));
    }

    private final boolean a(T t, int i, int i2) {
        return atv.a(t, (long) (e(i2) & 1048575)) == i;
    }

    private final void b(T t, int i, int i2) {
        atv.a((Object) t, e(i2) & 1048575, i);
    }

    private final int g(int i) {
        if (i < this.e || i > this.f) {
            return -1;
        }
        return b(i, 0);
    }

    private final int a(int i, int i2) {
        if (i < this.e || i > this.f) {
            return -1;
        }
        return b(i, i2);
    }

    private final int b(int i, int i2) {
        int length = (this.c.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.c[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
