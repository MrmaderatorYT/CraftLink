package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class ars extends api<Long> implements arf<Long>, asr, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final ars f2212a;

    /* renamed from: b, reason: collision with root package name */
    private long[] f2213b;
    private int c;

    ars() {
        this(new long[10], 0);
    }

    private ars(long[] jArr, int i) {
        this.f2213b = jArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.f2213b, i2, this.f2213b, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ars)) {
            return super.equals(obj);
        }
        ars arsVar = (ars) obj;
        if (this.c != arsVar.c) {
            return false;
        }
        long[] jArr = arsVar.f2213b;
        for (int i = 0; i < this.c; i++) {
            if (this.f2213b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.c; i++) {
            iA = (iA * 31) + ara.a(this.f2213b[i]);
        }
        return iA;
    }

    public final long b(int i) {
        c(i);
        return this.f2213b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    public final void a(long j) {
        a(this.c, j);
    }

    private final void a(int i, long j) {
        c();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(d(i));
        }
        if (this.c < this.f2213b.length) {
            System.arraycopy(this.f2213b, i, this.f2213b, i + 1, this.c - i);
        } else {
            long[] jArr = new long[((this.c * 3) / 2) + 1];
            System.arraycopy(this.f2213b, 0, jArr, 0, i);
            System.arraycopy(this.f2213b, i, jArr, i + 1, this.c - i);
            this.f2213b = jArr;
        }
        this.f2213b[i] = j;
        this.c++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        c();
        ara.a(collection);
        if (!(collection instanceof ars)) {
            return super.addAll(collection);
        }
        ars arsVar = (ars) collection;
        if (arsVar.c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.c < arsVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + arsVar.c;
        if (i > this.f2213b.length) {
            this.f2213b = Arrays.copyOf(this.f2213b, i);
        }
        System.arraycopy(arsVar.f2213b, 0, this.f2213b, this.c, arsVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Long.valueOf(this.f2213b[i]))) {
                System.arraycopy(this.f2213b, i + 1, this.f2213b, i, this.c - i);
                this.c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void c(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(d(i));
        }
    }

    private final String d(int i) {
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
        long jLongValue = ((Long) obj).longValue();
        c();
        c(i);
        long j = this.f2213b[i];
        this.f2213b[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        c(i);
        long j = this.f2213b[i];
        if (i < this.c - 1) {
            System.arraycopy(this.f2213b, i + 1, this.f2213b, i, this.c - i);
        }
        this.c--;
        this.modCount++;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.ads.arf
    public final /* synthetic */ arf<Long> a(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new ars(Arrays.copyOf(this.f2213b, i), this.c);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(b(i));
    }

    static {
        ars arsVar = new ars();
        f2212a = arsVar;
        arsVar.b();
    }
}
