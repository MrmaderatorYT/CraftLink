package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class aqv extends api<Float> implements arf<Float>, asr, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final aqv f2185a;

    /* renamed from: b, reason: collision with root package name */
    private float[] f2186b;
    private int c;

    aqv() {
        this(new float[10], 0);
    }

    private aqv(float[] fArr, int i) {
        this.f2186b = fArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.f2186b, i2, this.f2186b, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aqv)) {
            return super.equals(obj);
        }
        aqv aqvVar = (aqv) obj;
        if (this.c != aqvVar.c) {
            return false;
        }
        float[] fArr = aqvVar.f2186b;
        for (int i = 0; i < this.c; i++) {
            if (this.f2186b[i] != fArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.c; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f2186b[i]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    public final void a(float f) {
        a(this.c, f);
    }

    private final void a(int i, float f) {
        c();
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException(c(i));
        }
        if (this.c < this.f2186b.length) {
            System.arraycopy(this.f2186b, i, this.f2186b, i + 1, this.c - i);
        } else {
            float[] fArr = new float[((this.c * 3) / 2) + 1];
            System.arraycopy(this.f2186b, 0, fArr, 0, i);
            System.arraycopy(this.f2186b, i, fArr, i + 1, this.c - i);
            this.f2186b = fArr;
        }
        this.f2186b[i] = f;
        this.c++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        c();
        ara.a(collection);
        if (!(collection instanceof aqv)) {
            return super.addAll(collection);
        }
        aqv aqvVar = (aqv) collection;
        if (aqvVar.c == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.c < aqvVar.c) {
            throw new OutOfMemoryError();
        }
        int i = this.c + aqvVar.c;
        if (i > this.f2186b.length) {
            this.f2186b = Arrays.copyOf(this.f2186b, i);
        }
        System.arraycopy(aqvVar.f2186b, 0, this.f2186b, this.c, aqvVar.c);
        this.c = i;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Float.valueOf(this.f2186b[i]))) {
                System.arraycopy(this.f2186b, i + 1, this.f2186b, i, this.c - i);
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
        float fFloatValue = ((Float) obj).floatValue();
        c();
        b(i);
        float f = this.f2186b[i];
        this.f2186b[i] = fFloatValue;
        return Float.valueOf(f);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        b(i);
        float f = this.f2186b[i];
        if (i < this.c - 1) {
            System.arraycopy(this.f2186b, i + 1, this.f2186b, i, this.c - i);
        }
        this.c--;
        this.modCount++;
        return Float.valueOf(f);
    }

    @Override // com.google.android.gms.internal.ads.api, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.ads.arf
    public final /* synthetic */ arf<Float> a(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new aqv(Arrays.copyOf(this.f2186b, i), this.c);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        b(i);
        return Float.valueOf(this.f2186b[i]);
    }

    static {
        aqv aqvVar = new aqv();
        f2185a = aqvVar;
        aqvVar.b();
    }
}
