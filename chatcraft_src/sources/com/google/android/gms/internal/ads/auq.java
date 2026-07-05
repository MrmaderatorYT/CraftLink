package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class auq implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private auo<?, ?> f2283a;

    /* renamed from: b, reason: collision with root package name */
    private Object f2284b;
    private List<auv> c = new ArrayList();

    auq() {
    }

    final void a(auv auvVar) throws zzbuy {
        if (this.c != null) {
            this.c.add(auvVar);
            return;
        }
        if (this.f2284b instanceof aus) {
            byte[] bArr = auvVar.f2290b;
            aul aulVarA = aul.a(bArr, 0, bArr.length);
            int iG = aulVarA.g();
            if (iG != bArr.length - aum.a(iG)) {
                throw zzbuy.a();
            }
            aus ausVarA = ((aus) this.f2284b).a(aulVarA);
            this.f2283a = this.f2283a;
            this.f2284b = ausVarA;
            this.c = null;
            return;
        }
        if (this.f2284b instanceof aus[]) {
            Collections.singletonList(auvVar);
            throw new NoSuchMethodError();
        }
        Collections.singletonList(auvVar);
        throw new NoSuchMethodError();
    }

    final int a() {
        if (this.f2284b != null) {
            throw new NoSuchMethodError();
        }
        int iD = 0;
        for (auv auvVar : this.c) {
            iD += aum.d(auvVar.f2289a) + 0 + auvVar.f2290b.length;
        }
        return iD;
    }

    final void a(aum aumVar) throws zzbus {
        if (this.f2284b != null) {
            throw new NoSuchMethodError();
        }
        for (auv auvVar : this.c) {
            aumVar.c(auvVar.f2289a);
            aumVar.c(auvVar.f2290b);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof auq)) {
            return false;
        }
        auq auqVar = (auq) obj;
        if (this.f2284b != null && auqVar.f2284b != null) {
            if (this.f2283a != auqVar.f2283a) {
                return false;
            }
            if (!this.f2283a.f2280a.isArray()) {
                return this.f2284b.equals(auqVar.f2284b);
            }
            if (this.f2284b instanceof byte[]) {
                return Arrays.equals((byte[]) this.f2284b, (byte[]) auqVar.f2284b);
            }
            if (this.f2284b instanceof int[]) {
                return Arrays.equals((int[]) this.f2284b, (int[]) auqVar.f2284b);
            }
            if (this.f2284b instanceof long[]) {
                return Arrays.equals((long[]) this.f2284b, (long[]) auqVar.f2284b);
            }
            if (this.f2284b instanceof float[]) {
                return Arrays.equals((float[]) this.f2284b, (float[]) auqVar.f2284b);
            }
            if (this.f2284b instanceof double[]) {
                return Arrays.equals((double[]) this.f2284b, (double[]) auqVar.f2284b);
            }
            if (this.f2284b instanceof boolean[]) {
                return Arrays.equals((boolean[]) this.f2284b, (boolean[]) auqVar.f2284b);
            }
            return Arrays.deepEquals((Object[]) this.f2284b, (Object[]) auqVar.f2284b);
        }
        if (this.c != null && auqVar.c != null) {
            return this.c.equals(auqVar.c);
        }
        try {
            return Arrays.equals(b(), auqVar.b());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(b()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private final byte[] b() throws zzbus {
        byte[] bArr = new byte[a()];
        a(aum.a(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final auq clone() {
        auq auqVar = new auq();
        try {
            auqVar.f2283a = this.f2283a;
            if (this.c == null) {
                auqVar.c = null;
            } else {
                auqVar.c.addAll(this.c);
            }
            if (this.f2284b != null) {
                if (this.f2284b instanceof aus) {
                    auqVar.f2284b = (aus) ((aus) this.f2284b).clone();
                } else if (this.f2284b instanceof byte[]) {
                    auqVar.f2284b = ((byte[]) this.f2284b).clone();
                } else {
                    int i = 0;
                    if (this.f2284b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f2284b;
                        byte[][] bArr2 = new byte[bArr.length][];
                        auqVar.f2284b = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.f2284b instanceof boolean[]) {
                        auqVar.f2284b = ((boolean[]) this.f2284b).clone();
                    } else if (this.f2284b instanceof int[]) {
                        auqVar.f2284b = ((int[]) this.f2284b).clone();
                    } else if (this.f2284b instanceof long[]) {
                        auqVar.f2284b = ((long[]) this.f2284b).clone();
                    } else if (this.f2284b instanceof float[]) {
                        auqVar.f2284b = ((float[]) this.f2284b).clone();
                    } else if (this.f2284b instanceof double[]) {
                        auqVar.f2284b = ((double[]) this.f2284b).clone();
                    } else if (this.f2284b instanceof aus[]) {
                        aus[] ausVarArr = (aus[]) this.f2284b;
                        aus[] ausVarArr2 = new aus[ausVarArr.length];
                        auqVar.f2284b = ausVarArr2;
                        while (i < ausVarArr.length) {
                            ausVarArr2[i] = (aus) ausVarArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return auqVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
