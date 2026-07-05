package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class aup implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final auq f2281a = new auq();

    /* renamed from: b, reason: collision with root package name */
    private boolean f2282b;
    private int[] c;
    private auq[] d;
    private int e;

    aup() {
        this(10);
    }

    private aup(int i) {
        this.f2282b = false;
        int iC = c(i);
        this.c = new int[iC];
        this.d = new auq[iC];
        this.e = 0;
    }

    final auq a(int i) {
        int iD = d(i);
        if (iD < 0 || this.d[iD] == f2281a) {
            return null;
        }
        return this.d[iD];
    }

    final void a(int i, auq auqVar) {
        int iD = d(i);
        if (iD >= 0) {
            this.d[iD] = auqVar;
            return;
        }
        int i2 = iD ^ (-1);
        if (i2 < this.e && this.d[i2] == f2281a) {
            this.c[i2] = i;
            this.d[i2] = auqVar;
            return;
        }
        if (this.e >= this.c.length) {
            int iC = c(this.e + 1);
            int[] iArr = new int[iC];
            auq[] auqVarArr = new auq[iC];
            System.arraycopy(this.c, 0, iArr, 0, this.c.length);
            System.arraycopy(this.d, 0, auqVarArr, 0, this.d.length);
            this.c = iArr;
            this.d = auqVarArr;
        }
        if (this.e - i2 != 0) {
            int i3 = i2 + 1;
            System.arraycopy(this.c, i2, this.c, i3, this.e - i2);
            System.arraycopy(this.d, i2, this.d, i3, this.e - i2);
        }
        this.c[i2] = i;
        this.d[i2] = auqVar;
        this.e++;
    }

    final int a() {
        return this.e;
    }

    final auq b(int i) {
        return this.d[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aup)) {
            return false;
        }
        aup aupVar = (aup) obj;
        if (this.e != aupVar.e) {
            return false;
        }
        int[] iArr = this.c;
        int[] iArr2 = aupVar.c;
        int i = this.e;
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
            auq[] auqVarArr = this.d;
            auq[] auqVarArr2 = aupVar.d;
            int i3 = this.e;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                }
                if (!auqVarArr[i4].equals(auqVarArr2[i4])) {
                    z2 = false;
                    break;
                }
                i4++;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = 17;
        for (int i = 0; i < this.e; i++) {
            iHashCode = (((iHashCode * 31) + this.c[i]) * 31) + this.d[i].hashCode();
        }
        return iHashCode;
    }

    private static int c(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    private final int d(int i) {
        int i2 = this.e - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.c[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else {
                if (i5 <= i) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return i3 ^ (-1);
    }

    public final /* synthetic */ Object clone() {
        int i = this.e;
        aup aupVar = new aup(i);
        System.arraycopy(this.c, 0, aupVar.c, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.d[i2] != null) {
                aupVar.d[i2] = (auq) this.d[i2].clone();
            }
        }
        aupVar.e = i;
        return aupVar;
    }
}
