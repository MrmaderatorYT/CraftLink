package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class atp {

    /* renamed from: a, reason: collision with root package name */
    private static final atp f2258a = new atp(0, new int[0], new Object[0], false);

    /* renamed from: b, reason: collision with root package name */
    private int f2259b;
    private int[] c;
    private Object[] d;
    private int e;
    private boolean f;

    public static atp a() {
        return f2258a;
    }

    static atp b() {
        return new atp();
    }

    static atp a(atp atpVar, atp atpVar2) {
        int i = atpVar.f2259b + atpVar2.f2259b;
        int[] iArrCopyOf = Arrays.copyOf(atpVar.c, i);
        System.arraycopy(atpVar2.c, 0, iArrCopyOf, atpVar.f2259b, atpVar2.f2259b);
        Object[] objArrCopyOf = Arrays.copyOf(atpVar.d, i);
        System.arraycopy(atpVar2.d, 0, objArrCopyOf, atpVar.f2259b, atpVar2.f2259b);
        return new atp(i, iArrCopyOf, objArrCopyOf, true);
    }

    private atp() {
        this(0, new int[8], new Object[8], true);
    }

    private atp(int i, int[] iArr, Object[] objArr, boolean z) {
        this.e = -1;
        this.f2259b = i;
        this.c = iArr;
        this.d = objArr;
        this.f = z;
    }

    public final void c() {
        this.f = false;
    }

    final void a(auk aukVar) {
        if (aukVar.a() == aqy.e.k) {
            for (int i = this.f2259b - 1; i >= 0; i--) {
                aukVar.a(this.c[i] >>> 3, this.d[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.f2259b; i2++) {
            aukVar.a(this.c[i2] >>> 3, this.d[i2]);
        }
    }

    public final void b(auk aukVar) {
        if (this.f2259b == 0) {
            return;
        }
        if (aukVar.a() == aqy.e.j) {
            for (int i = 0; i < this.f2259b; i++) {
                a(this.c[i], this.d[i], aukVar);
            }
            return;
        }
        for (int i2 = this.f2259b - 1; i2 >= 0; i2--) {
            a(this.c[i2], this.d[i2], aukVar);
        }
    }

    private static void a(int i, Object obj, auk aukVar) {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 != 5) {
            switch (i3) {
                case 0:
                    aukVar.a(i2, ((Long) obj).longValue());
                    return;
                case 1:
                    aukVar.d(i2, ((Long) obj).longValue());
                    return;
                case 2:
                    aukVar.a(i2, (apo) obj);
                    return;
                case 3:
                    if (aukVar.a() == aqy.e.j) {
                        aukVar.a(i2);
                        ((atp) obj).b(aukVar);
                        aukVar.b(i2);
                        return;
                    } else {
                        aukVar.b(i2);
                        ((atp) obj).b(aukVar);
                        aukVar.a(i2);
                        return;
                    }
                default:
                    throw new RuntimeException(zzbrl.f());
            }
        }
        aukVar.d(i2, ((Integer) obj).intValue());
    }

    public final int d() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int iD = 0;
        for (int i2 = 0; i2 < this.f2259b; i2++) {
            iD += zzbqk.d(this.c[i2] >>> 3, (apo) this.d[i2]);
        }
        this.e = iD;
        return iD;
    }

    public final int e() {
        int i;
        int i2 = this.e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f2259b; i4++) {
            int i5 = this.c[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 5) {
                switch (i7) {
                    case 0:
                        i = zzbqk.e(i6, ((Long) this.d[i4]).longValue());
                        break;
                    case 1:
                        i = zzbqk.g(i6, ((Long) this.d[i4]).longValue());
                        break;
                    case 2:
                        i = zzbqk.c(i6, (apo) this.d[i4]);
                        break;
                    case 3:
                        i = (zzbqk.e(i6) << 1) + ((atp) this.d[i4]).e();
                        break;
                    default:
                        throw new IllegalStateException(zzbrl.f());
                }
            } else {
                i = zzbqk.i(i6, ((Integer) this.d[i4]).intValue());
            }
            i3 += i;
        }
        this.e = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof atp)) {
            return false;
        }
        atp atpVar = (atp) obj;
        if (this.f2259b == atpVar.f2259b) {
            int[] iArr = this.c;
            int[] iArr2 = atpVar.c;
            int i = this.f2259b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                }
                if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                Object[] objArr = this.d;
                Object[] objArr2 = atpVar.d;
                int i3 = this.f2259b;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    }
                    if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    }
                    i4++;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.f2259b + 527) * 31;
        int[] iArr = this.c;
        int i2 = this.f2259b;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i + i3) * 31;
        Object[] objArr = this.d;
        int i6 = this.f2259b;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    final void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f2259b; i2++) {
            asi.a(sb, i, String.valueOf(this.c[i2] >>> 3), this.d[i2]);
        }
    }

    final void a(int i, Object obj) {
        if (!this.f) {
            throw new UnsupportedOperationException();
        }
        if (this.f2259b == this.c.length) {
            int i2 = this.f2259b + (this.f2259b < 4 ? 8 : this.f2259b >> 1);
            this.c = Arrays.copyOf(this.c, i2);
            this.d = Arrays.copyOf(this.d, i2);
        }
        this.c[this.f2259b] = i;
        this.d[this.f2259b] = obj;
        this.f2259b++;
    }
}
