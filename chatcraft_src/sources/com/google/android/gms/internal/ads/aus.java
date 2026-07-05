package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class aus {
    protected volatile int aa = -1;

    protected int a() {
        return 0;
    }

    public abstract aus a(aul aulVar);

    public void a(aum aumVar) {
    }

    public final int d() {
        int iA = a();
        this.aa = iA;
        return iA;
    }

    public static final byte[] a(aus ausVar) {
        byte[] bArr = new byte[ausVar.d()];
        try {
            aum aumVarA = aum.a(bArr, 0, bArr.length);
            ausVar.a(aumVarA);
            aumVarA.a();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends aus> T a(T t, byte[] bArr) {
        return (T) a(t, bArr, 0, bArr.length);
    }

    private static final <T extends aus> T a(T t, byte[] bArr, int i, int i2) throws zzbuy {
        try {
            aul aulVarA = aul.a(bArr, 0, i2);
            t.a(aulVarA);
            aulVarA.a(0);
            return t;
        } catch (zzbuy e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public String toString() {
        return auu.a(this);
    }

    @Override // 
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public aus clone() {
        return (aus) super.clone();
    }
}
