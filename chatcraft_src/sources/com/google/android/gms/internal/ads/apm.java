package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class apm extends api<Boolean> implements arf<Boolean>, asr, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final apm f2147a;

    /* renamed from: b, reason: collision with root package name */
    private boolean[] f2148b;
    private int c;

    apm() {
        this(new boolean[10], 0);
    }

    private apm(boolean[] zArr, int i) {
        this.f2148b = zArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.f2148b, i2, this.f2148b, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof apm)) {
            return super.equals(obj);
        }
        apm apmVar = (apm) obj;
        if (this.c != apmVar.c) {
            return false;
        }
        boolean[] zArr = apmVar.f2148b;
        for (int i = 0; i < this.c; i++) {
            if (this.f2148b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.c; i++) {
            iA = (iA * 31) + ara.a(this.f2148b[i]);
        }
        return iA;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    public final void a(boolean z) {
        a(this.c, z);
    }

    private final void a(int i, boolean z) {
        c();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(c(i));
        }
        if (this.c < this.f2148b.length) {
            System.arraycopy(this.f2148b, i, this.f2148b, i + 1, this.c - i);
        } else {
            boolean[] zArr = new boolean[((this.c * 3) / 2) + 1];
            System.arraycopy(this.f2148b, 0, zArr, 0, i);
            System.arraycopy(this.f2148b, i, zArr, i + 1, this.c - i);
            this.f2148b = zArr;
        }
        this.f2148b[i] = z;
        this.c++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        c();
        ara.a(collection);
        if (!(collection instanceof apm)) {
            return super.addAll(collection);
        }
        apm apmVar = (apm) collection;
        if (apmVar.c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.c < apmVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + apmVar.c;
        if (i > this.f2148b.length) {
            this.f2148b = Arrays.copyOf(this.f2148b, i);
        }
        System.arraycopy(apmVar.f2148b, 0, this.f2148b, this.c, apmVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Boolean.valueOf(this.f2148b[i]))) {
                System.arraycopy(this.f2148b, i + 1, this.f2148b, i, this.c - i);
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
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        c();
        b(i);
        boolean z = this.f2148b[i];
        this.f2148b[i] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        b(i);
        boolean z = this.f2148b[i];
        if (i < this.c - 1) {
            System.arraycopy(this.f2148b, i + 1, this.f2148b, i, this.c - i);
        }
        this.c--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.ads.arf
    public final /* synthetic */ arf<Boolean> a(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new apm(Arrays.copyOf(this.f2148b, i), this.c);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        b(i);
        return Boolean.valueOf(this.f2148b[i]);
    }

    static {
        apm apmVar = new apm();
        f2147a = apmVar;
        apmVar.b();
    }
}
