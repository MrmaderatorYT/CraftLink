package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class aqh extends api<Double> implements arf<Double>, asr, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final aqh f2165a;

    /* renamed from: b, reason: collision with root package name */
    private double[] f2166b;
    private int c;

    aqh() {
        this(new double[10], 0);
    }

    private aqh(double[] dArr, int i) {
        this.f2166b = dArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.f2166b, i2, this.f2166b, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aqh)) {
            return super.equals(obj);
        }
        aqh aqhVar = (aqh) obj;
        if (this.c != aqhVar.c) {
            return false;
        }
        double[] dArr = aqhVar.f2166b;
        for (int i = 0; i < this.c; i++) {
            if (this.f2166b[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.c; i++) {
            iA = (iA * 31) + ara.a(Double.doubleToLongBits(this.f2166b[i]));
        }
        return iA;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    public final void a(double d) {
        a(this.c, d);
    }

    private final void a(int i, double d) {
        c();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(c(i));
        }
        if (this.c < this.f2166b.length) {
            System.arraycopy(this.f2166b, i, this.f2166b, i + 1, this.c - i);
        } else {
            double[] dArr = new double[((this.c * 3) / 2) + 1];
            System.arraycopy(this.f2166b, 0, dArr, 0, i);
            System.arraycopy(this.f2166b, i, dArr, i + 1, this.c - i);
            this.f2166b = dArr;
        }
        this.f2166b[i] = d;
        this.c++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        c();
        ara.a(collection);
        if (!(collection instanceof aqh)) {
            return super.addAll(collection);
        }
        aqh aqhVar = (aqh) collection;
        if (aqhVar.c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.c < aqhVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + aqhVar.c;
        if (i > this.f2166b.length) {
            this.f2166b = Arrays.copyOf(this.f2166b, i);
        }
        System.arraycopy(aqhVar.f2166b, 0, this.f2166b, this.c, aqhVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Double.valueOf(this.f2166b[i]))) {
                System.arraycopy(this.f2166b, i + 1, this.f2166b, i, this.c - i);
                this.c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void b(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(c(i));
        }
    }

    private final String c(int i) {
        int i2 = this.c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        c();
        b(i);
        double d = this.f2166b[i];
        this.f2166b[i] = dDoubleValue;
        return Double.valueOf(d);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        b(i);
        double d = this.f2166b[i];
        if (i < this.c - 1) {
            System.arraycopy(this.f2166b, i + 1, this.f2166b, i, this.c - i);
        }
        this.c--;
        this.modCount++;
        return Double.valueOf(d);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.ads.arf
    public final /* synthetic */ arf<Double> a(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new aqh(Arrays.copyOf(this.f2166b, i), this.c);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        b(i);
        return Double.valueOf(this.f2166b[i]);
    }

    static {
        aqh aqhVar = new aqh();
        f2165a = aqhVar;
        aqhVar.b();
    }
}
