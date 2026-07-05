package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.r;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes.dex */
abstract class k extends r {

    /* renamed from: a, reason: collision with root package name */
    private int f1747a;

    protected k(byte[] bArr) {
        com.google.android.gms.common.internal.i.b(bArr.length == 25);
        this.f1747a = Arrays.hashCode(bArr);
    }

    abstract byte[] c();

    public int hashCode() {
        return this.f1747a;
    }

    public boolean equals(Object obj) {
        com.google.android.gms.dynamic.a aVarA;
        if (obj == null || !(obj instanceof q)) {
            return false;
        }
        try {
            q qVar = (q) obj;
            if (qVar.b() == hashCode() && (aVarA = qVar.a()) != null) {
                return Arrays.equals(c(), (byte[]) com.google.android.gms.dynamic.b.a(aVarA));
            }
            return false;
        } catch (RemoteException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    @Override // com.google.android.gms.common.internal.q
    public final com.google.android.gms.dynamic.a a() {
        return com.google.android.gms.dynamic.b.a(c());
    }

    @Override // com.google.android.gms.common.internal.q
    public final int b() {
        return hashCode();
    }

    protected static byte[] a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
