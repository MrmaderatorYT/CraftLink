package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class anx {

    /* renamed from: a, reason: collision with root package name */
    private ECPublicKey f2103a;

    public anx(ECPublicKey eCPublicKey) {
        this.f2103a = eCPublicKey;
    }

    public final any a(String str, byte[] bArr, byte[] bArr2, int i, aoc aocVar) throws IllegalStateException, GeneralSecurityException {
        byte[] bArr3;
        KeyPair keyPairA = anz.a(this.f2103a.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairA.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairA.getPrivate();
        ECPublicKey eCPublicKey2 = this.f2103a;
        try {
            ECParameterSpec params = eCPublicKey2.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            if (!params.getCurve().equals(params2.getCurve()) || !params.getGenerator().equals(params2.getGenerator()) || !params.getOrder().equals(params2.getOrder()) || params.getCofactor() != params2.getCofactor()) {
                throw new GeneralSecurityException("invalid public key spec");
            }
            byte[] bArrA = anz.a(eCPrivateKey, eCPublicKey2.getW());
            EllipticCurve curve = eCPublicKey.getParams().getCurve();
            ECPoint w = eCPublicKey.getW();
            anz.a(w, curve);
            int iA = anz.a(curve);
            int i2 = 1;
            switch (aocVar) {
                case UNCOMPRESSED:
                    int i3 = (iA * 2) + 1;
                    bArr3 = new byte[i3];
                    byte[] byteArray = w.getAffineX().toByteArray();
                    byte[] byteArray2 = w.getAffineY().toByteArray();
                    System.arraycopy(byteArray2, 0, bArr3, i3 - byteArray2.length, byteArray2.length);
                    System.arraycopy(byteArray, 0, bArr3, (iA + 1) - byteArray.length, byteArray.length);
                    bArr3[0] = 4;
                    break;
                case DO_NOT_USE_CRUNCHY_UNCOMPRESSED:
                    int i4 = iA * 2;
                    bArr3 = new byte[i4];
                    byte[] byteArray3 = w.getAffineX().toByteArray();
                    if (byteArray3.length > iA) {
                        byteArray3 = Arrays.copyOfRange(byteArray3, byteArray3.length - iA, byteArray3.length);
                    }
                    byte[] byteArray4 = w.getAffineY().toByteArray();
                    if (byteArray4.length > iA) {
                        byteArray4 = Arrays.copyOfRange(byteArray4, byteArray4.length - iA, byteArray4.length);
                    }
                    System.arraycopy(byteArray4, 0, bArr3, i4 - byteArray4.length, byteArray4.length);
                    System.arraycopy(byteArray3, 0, bArr3, iA - byteArray3.length, byteArray3.length);
                    break;
                case COMPRESSED:
                    int i5 = iA + 1;
                    byte[] bArr4 = new byte[i5];
                    byte[] byteArray5 = w.getAffineX().toByteArray();
                    System.arraycopy(byteArray5, 0, bArr4, i5 - byteArray5.length, byteArray5.length);
                    bArr4[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
                    bArr3 = bArr4;
                    break;
                default:
                    String strValueOf = String.valueOf(aocVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 15);
                    sb.append("invalid format:");
                    sb.append(strValueOf);
                    throw new GeneralSecurityException(sb.toString());
            }
            byte[] bArrA2 = anp.a(bArr3, bArrA);
            Mac macA = aoe.f2117b.a(str);
            if (i > macA.getMacLength() * 255) {
                throw new GeneralSecurityException("size too large");
            }
            if (bArr == null || bArr.length == 0) {
                macA.init(new SecretKeySpec(new byte[macA.getMacLength()], str));
            } else {
                macA.init(new SecretKeySpec(bArr, str));
            }
            byte[] bArrDoFinal = macA.doFinal(bArrA2);
            byte[] bArr5 = new byte[i];
            macA.init(new SecretKeySpec(bArrDoFinal, str));
            byte[] bArrDoFinal2 = new byte[0];
            int length = 0;
            while (true) {
                macA.update(bArrDoFinal2);
                macA.update(bArr2);
                macA.update((byte) i2);
                bArrDoFinal2 = macA.doFinal();
                if (bArrDoFinal2.length + length < i) {
                    System.arraycopy(bArrDoFinal2, 0, bArr5, length, bArrDoFinal2.length);
                    length += bArrDoFinal2.length;
                    i2++;
                } else {
                    System.arraycopy(bArrDoFinal2, 0, bArr5, length, i - length);
                    return new any(bArr3, bArr5);
                }
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new GeneralSecurityException(e.toString());
        }
    }
}
