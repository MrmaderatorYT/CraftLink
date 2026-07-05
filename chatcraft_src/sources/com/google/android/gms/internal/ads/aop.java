package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public final class aop implements ajl {

    /* renamed from: a, reason: collision with root package name */
    private Mac f2119a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2120b;
    private final String c;
    private final Key d;

    public aop(String str, Key key, int i) throws NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        char c = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != -1823053428) {
            if (iHashCode != 392315118) {
                if (iHashCode == 392317873 && str.equals("HMACSHA512")) {
                    c = 2;
                }
            } else if (str.equals("HMACSHA256")) {
                c = 1;
            }
        } else if (str.equals("HMACSHA1")) {
            c = 0;
        }
        switch (c) {
            case 0:
                if (i > 20) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            case 1:
                if (i > 32) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            case 2:
                if (i > 64) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            default:
                String strValueOf = String.valueOf(str);
                throw new NoSuchAlgorithmException(strValueOf.length() != 0 ? "unknown Hmac algorithm: ".concat(strValueOf) : new String("unknown Hmac algorithm: "));
        }
        this.c = str;
        this.f2120b = i;
        this.d = key;
        this.f2119a = aoe.f2117b.a(str);
        this.f2119a.init(key);
    }

    @Override // com.google.android.gms.internal.ads.ajl
    public final byte[] a(byte[] bArr) throws IllegalStateException, GeneralSecurityException {
        Mac macA;
        try {
            macA = (Mac) this.f2119a.clone();
        } catch (CloneNotSupportedException unused) {
            macA = aoe.f2117b.a(this.c);
            macA.init(this.d);
        }
        macA.update(bArr);
        byte[] bArr2 = new byte[this.f2120b];
        System.arraycopy(macA.doFinal(), 0, bArr2, 0, this.f2120b);
        return bArr2;
    }
}
