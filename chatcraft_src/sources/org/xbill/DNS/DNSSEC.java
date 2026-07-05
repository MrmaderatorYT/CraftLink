package org.xbill.DNS;

import java.math.BigInteger;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

/* loaded from: classes.dex */
public class DNSSEC {

    /* renamed from: a, reason: collision with root package name */
    private static final a f5295a = new a(32, "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFD97", "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFD94", "A6", "1", "8D91E471E0989CDA27DF505A453F2B7635294F2DDF23E3B122ACC99C9E9F1E14", "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF6C611070995AD10045841B09B761B893");

    /* renamed from: b, reason: collision with root package name */
    private static final a f5296b = new a(32, "FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF", "FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC", "5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B", "6B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C296", "4FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5", "FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551");
    private static final a c = new a(48, "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF", "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC", "B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF", "AA87CA22BE8B05378EB1C71EF320AD746E1D3B628BA79B9859F741E082542A385502F25DBF55296C3A545E3872760AB7", "3617DE4A96262C6F5D9E98BF9292DC29F8F41DBD289A147CE9DA3113B5F0B8C00A60B1CE1D7E819D7A431D7C90EA0E5F", "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973");

    public static class KeyMismatchException extends DNSSECException {
    }

    public static class MalformedKeyException extends DNSSECException {
    }

    public static class SignatureExpiredException extends DNSSECException {
    }

    public static class SignatureNotYetValidException extends DNSSECException {
    }

    public static class UnsupportedAlgorithmException extends DNSSECException {
    }

    public static class DNSSECException extends Exception {
        DNSSECException(String str) {
            super(str);
        }
    }

    public static class SignatureVerificationException extends DNSSECException {
        SignatureVerificationException() {
            super("signature verification failed");
        }
    }

    public static class IncompatibleKeyException extends IllegalArgumentException {
        IncompatibleKeyException() {
            super("incompatible keys");
        }
    }

    public static class NoSignatureException extends DNSSECException {
        NoSignatureException() {
            super("no signature found");
        }
    }

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        int f5297a;

        /* renamed from: b, reason: collision with root package name */
        public BigInteger f5298b;
        public BigInteger c;
        public BigInteger d;
        public BigInteger e;
        public BigInteger f;
        public BigInteger g;
        EllipticCurve h;
        ECParameterSpec i;

        a(int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.f5297a = i;
            this.f5298b = new BigInteger(str, 16);
            this.c = new BigInteger(str2, 16);
            this.d = new BigInteger(str3, 16);
            this.e = new BigInteger(str4, 16);
            this.f = new BigInteger(str5, 16);
            this.g = new BigInteger(str6, 16);
            this.h = new EllipticCurve(new ECFieldFp(this.f5298b), this.c, this.d);
            this.i = new ECParameterSpec(this.h, new ECPoint(this.e, this.f), this.g, 1);
        }
    }
}
