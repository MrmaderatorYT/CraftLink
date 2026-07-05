package com.google.android.gms.internal.ads;

import com.github.steveice10.mc.v1_5.util.Constants;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
public abstract class apo implements Serializable, Iterable<Byte> {

    /* renamed from: a, reason: collision with root package name */
    public static final apo f2149a = new apy(ara.f2200b);

    /* renamed from: b, reason: collision with root package name */
    private static final apt f2150b;
    private static final Comparator<apo> d;
    private int c = 0;

    apo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte b2) {
        return b2 & Constants.DimensionIds.NETHER;
    }

    public abstract byte a(int i);

    public abstract int a();

    protected abstract int a(int i, int i2, int i3);

    public abstract apo a(int i, int i2);

    protected abstract String a(Charset charset);

    abstract void a(apn apnVar);

    protected abstract void a(byte[] bArr, int i, int i2, int i3);

    public abstract boolean d();

    public abstract aqa e();

    public abstract boolean equals(Object obj);

    public static apo a(byte[] bArr, int i, int i2) {
        b(i, i + i2, bArr.length);
        return new apy(f2150b.a(bArr, i, i2));
    }

    public static apo a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    static apo b(byte[] bArr) {
        return new apy(bArr);
    }

    public static apo a(String str) {
        return new apy(str.getBytes(ara.f2199a));
    }

    public final byte[] b() {
        int iA = a();
        if (iA == 0) {
            return ara.f2200b;
        }
        byte[] bArr = new byte[iA];
        a(bArr, 0, 0, iA);
        return bArr;
    }

    public final String c() {
        return a() == 0 ? BuildConfig.FLAVOR : a(ara.f2199a);
    }

    public final int hashCode() {
        int iA = this.c;
        if (iA == 0) {
            int iA2 = a();
            iA = a(iA2, 0, iA2);
            if (iA == 0) {
                iA = 1;
            }
            this.c = iA;
        }
        return iA;
    }

    static apw b(int i) {
        return new apw(i, null);
    }

    protected final int f() {
        return this.c;
    }

    static int b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(a()));
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new app(this);
    }

    static {
        app appVar = null;
        f2150b = apj.a() ? new apz(appVar) : new apr(appVar);
        d = new apq();
    }
}
