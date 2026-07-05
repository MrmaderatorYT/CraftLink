package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class aqz extends api<Integer> implements arf<Integer>, asr, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final aqz f2195a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f2196b;
    private int c;

    public static aqz d() {
        return f2195a;
    }

    aqz() {
        this(new int[10], 0);
    }

    private aqz(int[] iArr, int i) {
        this.f2196b = iArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.f2196b, i2, this.f2196b, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aqz)) {
            return super.equals(obj);
        }
        aqz aqzVar = (aqz) obj;
        if (this.c != aqzVar.c) {
            return false;
        }
        int[] iArr = aqzVar.f2196b;
        for (int i = 0; i < this.c; i++) {
            if (this.f2196b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + this.f2196b[i2];
        }
        return i;
    }

    public final int b(int i) {
        d(i);
        return this.f2196b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    public final void c(int i) {
        a(this.c, i);
    }

    private final void a(int i, int i2) {
        c();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(e(i));
        }
        if (this.c < this.f2196b.length) {
            System.arraycopy(this.f2196b, i, this.f2196b, i + 1, this.c - i);
        } else {
            int[] iArr = new int[((this.c * 3) / 2) + 1];
            System.arraycopy(this.f2196b, 0, iArr, 0, i);
            System.arraycopy(this.f2196b, i, iArr, i + 1, this.c - i);
            this.f2196b = iArr;
        }
        this.f2196b[i] = i2;
        this.c++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        c();
        ara.a(collection);
        if (!(collection instanceof aqz)) {
            return super.addAll(collection);
        }
        aqz aqzVar = (aqz) collection;
        if (aqzVar.c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.c < aqzVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + aqzVar.c;
        if (i > this.f2196b.length) {
            this.f2196b = Arrays.copyOf(this.f2196b, i);
        }
        System.arraycopy(aqzVar.f2196b, 0, this.f2196b, this.c, aqzVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Integer.valueOf(this.f2196b[i]))) {
                System.arraycopy(this.f2196b, i + 1, this.f2196b, i, this.c - i);
                this.c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void d(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    private final String e(int i) {
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
        int iIntValue = ((Integer) obj).intValue();
        c();
        d(i);
        int i2 = this.f2196b[i];
        this.f2196b[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        d(i);
        int i2 = this.f2196b[i];
        if (i < this.c - 1) {
            System.arraycopy(this.f2196b, i + 1, this.f2196b, i, this.c - i);
        }
        this.c--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.ads.arf
    public final /* synthetic */ arf<Integer> a(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new aqz(Arrays.copyOf(this.f2196b, i), this.c);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(b(i));
    }

    static {
        aqz aqzVar = new aqz();
        f2195a = aqzVar;
        aqzVar.b();
    }
}
