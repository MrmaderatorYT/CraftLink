package io.netty.util.a.a;

import io.netty.util.a.a.c;
import io.netty.util.a.f;
import java.io.Serializable;

/* compiled from: LongAdderV8.java */
/* loaded from: classes.dex */
public class b extends c implements f, Serializable {
    @Override // io.netty.util.a.a.c
    final long a(long j, long j2) {
        return j + j2;
    }

    @Override // io.netty.util.a.f
    public void a(long j) {
        int length;
        c.a aVar;
        c.a[] aVarArr = this.d;
        if (aVarArr == null) {
            long j2 = this.e;
            if (b(j2, j2 + j)) {
                return;
            }
        }
        int[] iArr = f4639a.get();
        boolean zA = true;
        if (iArr != null && aVarArr != null && (length = aVarArr.length) >= 1 && (aVar = aVarArr[(length - 1) & iArr[0]]) != null) {
            long j3 = aVar.f4642a;
            zA = aVar.a(j3, j3 + j);
            if (zA) {
                return;
            }
        }
        a(j, iArr, zA);
    }

    @Override // io.netty.util.a.f
    public void a() {
        a(1L);
    }

    public long b() {
        long j = this.e;
        c.a[] aVarArr = this.d;
        if (aVarArr != null) {
            for (c.a aVar : aVarArr) {
                if (aVar != null) {
                    j += aVar.f4642a;
                }
            }
        }
        return j;
    }

    public String toString() {
        return Long.toString(b());
    }

    @Override // java.lang.Number
    public long longValue() {
        return b();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) b();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return b();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return b();
    }
}
