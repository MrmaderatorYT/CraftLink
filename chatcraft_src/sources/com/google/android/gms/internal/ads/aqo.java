package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class aqo<FieldDescriptorType extends aqq<FieldDescriptorType>> {
    private static final aqo d = new aqo(true);

    /* renamed from: b, reason: collision with root package name */
    private boolean f2175b;
    private boolean c = false;

    /* renamed from: a, reason: collision with root package name */
    private final ata<FieldDescriptorType, Object> f2174a = ata.a(16);

    private aqo() {
    }

    private aqo(boolean z) {
        c();
    }

    public static <T extends aqq<T>> aqo<T> a() {
        return d;
    }

    final boolean b() {
        return this.f2174a.isEmpty();
    }

    public final void c() {
        if (this.f2175b) {
            return;
        }
        this.f2174a.a();
        this.f2175b = true;
    }

    public final boolean d() {
        return this.f2175b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof aqo) {
            return this.f2174a.equals(((aqo) obj).f2174a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2174a.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        if (this.c) {
            return new ark(this.f2174a.entrySet().iterator());
        }
        return this.f2174a.entrySet().iterator();
    }

    final Iterator<Map.Entry<FieldDescriptorType, Object>> f() {
        if (this.c) {
            return new ark(this.f2174a.e().iterator());
        }
        return this.f2174a.e().iterator();
    }

    private final Object a(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f2174a.get(fielddescriptortype);
        return obj instanceof arh ? arh.a() : obj;
    }

    private final void a(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.d()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                a(fielddescriptortype.b(), obj2);
            }
            obj = arrayList;
        } else {
            a(fielddescriptortype.b(), obj);
        }
        if (obj instanceof arh) {
            this.c = true;
        }
        this.f2174a.a((ata<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(com.google.android.gms.internal.ads.aue r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.ads.ara.a(r3)
            int[] r0 = com.google.android.gms.internal.ads.aqp.f2176a
            com.google.android.gms.internal.ads.auj r2 = r2.a()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1e;
                case 9: goto L15;
                default: goto L14;
            }
        L14:
            goto L43
        L15:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.asf
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.arh
            if (r2 == 0) goto L43
            goto L26
        L1e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.arb
            if (r2 == 0) goto L43
        L26:
            r1 = 1
            goto L43
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.apo
            if (r2 != 0) goto L26
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L43
            goto L26
        L31:
            boolean r0 = r3 instanceof java.lang.String
            goto L42
        L34:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r0 = r3 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L42
        L40:
            boolean r0 = r3 instanceof java.lang.Integer
        L42:
            r1 = r0
        L43:
            if (r1 == 0) goto L46
            return
        L46:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aqo.a(com.google.android.gms.internal.ads.aue, java.lang.Object):void");
    }

    public final boolean g() {
        for (int i = 0; i < this.f2174a.c(); i++) {
            if (!a((Map.Entry) this.f2174a.b(i))) {
                return false;
            }
        }
        Iterator it = this.f2174a.d().iterator();
        while (it.hasNext()) {
            if (!a((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.c() == auj.MESSAGE) {
            if (key.d()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((asf) it.next()).k()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof asf) {
                    if (!((asf) value).k()) {
                        return false;
                    }
                } else {
                    if (value instanceof arh) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void a(aqo<FieldDescriptorType> aqoVar) {
        for (int i = 0; i < aqoVar.f2174a.c(); i++) {
            b(aqoVar.f2174a.b(i));
        }
        Iterator it = aqoVar.f2174a.d().iterator();
        while (it.hasNext()) {
            b((Map.Entry) it.next());
        }
    }

    private static Object a(Object obj) {
        if (obj instanceof asm) {
            return ((asm) obj).a();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void b(Map.Entry<FieldDescriptorType, Object> entry) {
        asf asfVarF;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof arh) {
            value = arh.a();
        }
        if (key.d()) {
            Object objA = a((aqo<FieldDescriptorType>) key);
            if (objA == null) {
                objA = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objA).add(a(it.next()));
            }
            this.f2174a.a((ata<FieldDescriptorType, Object>) key, (FieldDescriptorType) objA);
            return;
        }
        if (key.c() == auj.MESSAGE) {
            Object objA2 = a((aqo<FieldDescriptorType>) key);
            if (objA2 == null) {
                this.f2174a.a((ata<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
                return;
            }
            if (objA2 instanceof asm) {
                asfVarF = key.a((asm) objA2, (asm) value);
            } else {
                asfVarF = key.a(((asf) objA2).o(), (asf) value).f();
            }
            this.f2174a.a((ata<FieldDescriptorType, Object>) key, (FieldDescriptorType) asfVarF);
            return;
        }
        this.f2174a.a((ata<FieldDescriptorType, Object>) key, (FieldDescriptorType) a(value));
    }

    static void a(zzbqk zzbqkVar, aue aueVar, int i, Object obj) {
        if (aueVar == aue.j) {
            asf asfVar = (asf) obj;
            ara.a(asfVar);
            zzbqkVar.a(i, 3);
            asfVar.a(zzbqkVar);
            zzbqkVar.a(i, 4);
        }
        zzbqkVar.a(i, aueVar.b());
        switch (aqp.f2177b[aueVar.ordinal()]) {
            case 1:
                zzbqkVar.a(((Double) obj).doubleValue());
                break;
            case 2:
                zzbqkVar.a(((Float) obj).floatValue());
                break;
            case 3:
                zzbqkVar.a(((Long) obj).longValue());
                break;
            case 4:
                zzbqkVar.a(((Long) obj).longValue());
                break;
            case 5:
                zzbqkVar.a(((Integer) obj).intValue());
                break;
            case 6:
                zzbqkVar.c(((Long) obj).longValue());
                break;
            case 7:
                zzbqkVar.d(((Integer) obj).intValue());
                break;
            case 8:
                zzbqkVar.a(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((asf) obj).a(zzbqkVar);
                break;
            case 10:
                zzbqkVar.a((asf) obj);
                break;
            case 11:
                if (obj instanceof apo) {
                    zzbqkVar.a((apo) obj);
                    break;
                } else {
                    zzbqkVar.a((String) obj);
                    break;
                }
            case 12:
                if (obj instanceof apo) {
                    zzbqkVar.a((apo) obj);
                    break;
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzbqkVar.c(bArr, 0, bArr.length);
                    break;
                }
            case 13:
                zzbqkVar.b(((Integer) obj).intValue());
                break;
            case 14:
                zzbqkVar.d(((Integer) obj).intValue());
                break;
            case 15:
                zzbqkVar.c(((Long) obj).longValue());
                break;
            case 16:
                zzbqkVar.c(((Integer) obj).intValue());
                break;
            case 17:
                zzbqkVar.b(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof arb) {
                    zzbqkVar.a(((arb) obj).a());
                    break;
                } else {
                    zzbqkVar.a(((Integer) obj).intValue());
                    break;
                }
        }
    }

    public final int h() {
        int iB = 0;
        for (int i = 0; i < this.f2174a.c(); i++) {
            Map.Entry<K, Object> entryB = this.f2174a.b(i);
            iB += b((aqq<?>) entryB.getKey(), entryB.getValue());
        }
        Iterator it = this.f2174a.d().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iB += b((aqq<?>) entry.getKey(), entry.getValue());
        }
        return iB;
    }

    public final int i() {
        int iC = 0;
        for (int i = 0; i < this.f2174a.c(); i++) {
            iC += c(this.f2174a.b(i));
        }
        Iterator it = this.f2174a.d().iterator();
        while (it.hasNext()) {
            iC += c((Map.Entry) it.next());
        }
        return iC;
    }

    private static int c(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.c() == auj.MESSAGE && !key.d() && !key.e()) {
            if (value instanceof arh) {
                return zzbqk.b(entry.getKey().a(), (arh) value);
            }
            return zzbqk.d(entry.getKey().a(), (asf) value);
        }
        return b((aqq<?>) key, value);
    }

    static int a(aue aueVar, int i, Object obj) {
        int iE = zzbqk.e(i);
        if (aueVar == aue.j) {
            ara.a((asf) obj);
            iE <<= 1;
        }
        return iE + b(aueVar, obj);
    }

    private static int b(aue aueVar, Object obj) {
        switch (aqp.f2177b[aueVar.ordinal()]) {
            case 1:
                return zzbqk.b(((Double) obj).doubleValue());
            case 2:
                return zzbqk.b(((Float) obj).floatValue());
            case 3:
                return zzbqk.d(((Long) obj).longValue());
            case 4:
                return zzbqk.e(((Long) obj).longValue());
            case 5:
                return zzbqk.f(((Integer) obj).intValue());
            case 6:
                return zzbqk.g(((Long) obj).longValue());
            case 7:
                return zzbqk.i(((Integer) obj).intValue());
            case 8:
                return zzbqk.b(((Boolean) obj).booleanValue());
            case 9:
                return zzbqk.c((asf) obj);
            case 10:
                if (obj instanceof arh) {
                    return zzbqk.a((arh) obj);
                }
                return zzbqk.b((asf) obj);
            case 11:
                if (obj instanceof apo) {
                    return zzbqk.b((apo) obj);
                }
                return zzbqk.b((String) obj);
            case 12:
                if (obj instanceof apo) {
                    return zzbqk.b((apo) obj);
                }
                return zzbqk.b((byte[]) obj);
            case 13:
                return zzbqk.g(((Integer) obj).intValue());
            case 14:
                return zzbqk.j(((Integer) obj).intValue());
            case 15:
                return zzbqk.h(((Long) obj).longValue());
            case 16:
                return zzbqk.h(((Integer) obj).intValue());
            case 17:
                return zzbqk.f(((Long) obj).longValue());
            case 18:
                if (obj instanceof arb) {
                    return zzbqk.k(((arb) obj).a());
                }
                return zzbqk.k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int b(aqq<?> aqqVar, Object obj) {
        aue aueVarB = aqqVar.b();
        int iA = aqqVar.a();
        if (aqqVar.d()) {
            int iA2 = 0;
            if (aqqVar.e()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iA2 += b(aueVarB, it.next());
                }
                return zzbqk.e(iA) + iA2 + zzbqk.l(iA2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iA2 += a(aueVarB, iA, it2.next());
            }
            return iA2;
        }
        return a(aueVarB, iA, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() {
        aqo aqoVar = new aqo();
        for (int i = 0; i < this.f2174a.c(); i++) {
            Map.Entry<K, Object> entryB = this.f2174a.b(i);
            aqoVar.a((aqo) entryB.getKey(), entryB.getValue());
        }
        Iterator it = this.f2174a.d().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aqoVar.a((aqo) entry.getKey(), entry.getValue());
        }
        aqoVar.c = this.c;
        return aqoVar;
    }
}
