package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
final class akj {
    public static void a(alu aluVar) throws GeneralSecurityException {
        anz.a(a(aluVar.a().a()));
        a(aluVar.a().b());
        if (aluVar.c() == aln.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        ajq.a(aluVar.b().a());
    }

    public static String a(ame ameVar) throws NoSuchAlgorithmException {
        switch (akk.f2033a[ameVar.ordinal()]) {
            case 1:
                return "HmacSha1";
            case 2:
                return "HmacSha256";
            case 3:
                return "HmacSha512";
            default:
                String strValueOf = String.valueOf(ameVar);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 27);
                sb.append("hash unsupported for HMAC: ");
                sb.append(strValueOf);
                throw new NoSuchAlgorithmException(sb.toString());
        }
    }

    public static aob a(amc amcVar) throws GeneralSecurityException {
        switch (akk.f2034b[amcVar.ordinal()]) {
            case 1:
                return aob.NIST_P256;
            case 2:
                return aob.NIST_P384;
            case 3:
                return aob.NIST_P521;
            default:
                String strValueOf = String.valueOf(amcVar);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 20);
                sb.append("unknown curve type: ");
                sb.append(strValueOf);
                throw new GeneralSecurityException(sb.toString());
        }
    }

    public static aoc a(aln alnVar) throws GeneralSecurityException {
        switch (akk.c[alnVar.ordinal()]) {
            case 1:
                return aoc.UNCOMPRESSED;
            case 2:
                return aoc.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
            case 3:
                return aoc.COMPRESSED;
            default:
                String strValueOf = String.valueOf(alnVar);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 22);
                sb.append("unknown point format: ");
                sb.append(strValueOf);
                throw new GeneralSecurityException(sb.toString());
        }
    }
}
