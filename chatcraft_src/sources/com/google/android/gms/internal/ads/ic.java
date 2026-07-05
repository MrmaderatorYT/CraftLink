package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ic implements bge {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f3157a = eb.f3057a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    private final py f3158b;
    private final hb c;
    private final jc d;

    @Deprecated
    public ic(py pyVar) {
        this(pyVar, new jc(4096));
    }

    @Deprecated
    private ic(py pyVar, jc jcVar) {
        this.f3158b = pyVar;
        this.c = new ga(pyVar);
        this.d = jcVar;
    }

    public ic(hb hbVar) {
        this(hbVar, new jc(4096));
    }

    private ic(hb hbVar, jc jcVar) {
        this.c = hbVar;
        this.f3158b = hbVar;
        this.d = jcVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0196, code lost:
    
        throw new java.io.IOException();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x021a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013f A[Catch: IOException -> 0x0199, MalformedURLException -> 0x0220, SocketTimeoutException -> 0x0241, TRY_LEAVE, TryCatch #0 {IOException -> 0x0199, blocks: (B:56:0x012f, B:72:0x017e, B:60:0x013f, B:67:0x015b), top: B:125:0x012f }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01af  */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.String] */
    @Override // com.google.android.gms.internal.ads.bge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.internal.ads.bje a(com.google.android.gms.internal.ads.blc<?> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ic.a(com.google.android.gms.internal.ads.blc):com.google.android.gms.internal.ads.bje");
    }

    private static void a(String str, blc<?> blcVar, zzae zzaeVar) throws zzae {
        ab abVarK = blcVar.k();
        int iJ = blcVar.j();
        try {
            abVarK.a(zzaeVar);
            blcVar.b(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iJ)));
        } catch (zzae e) {
            blcVar.b(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(iJ)));
            throw e;
        }
    }

    private final byte[] a(InputStream inputStream, int i) throws Throwable {
        uc ucVar = new uc(this.d, i);
        byte[] bArr = null;
        try {
            if (inputStream == null) {
                throw new zzac();
            }
            byte[] bArrA = this.d.a(1024);
            while (true) {
                try {
                    int i2 = inputStream.read(bArrA);
                    if (i2 == -1) {
                        break;
                    }
                    ucVar.write(bArrA, 0, i2);
                } catch (Throwable th) {
                    th = th;
                    bArr = bArrA;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            eb.a("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    this.d.a(bArr);
                    ucVar.close();
                    throw th;
                }
            }
            byte[] byteArray = ucVar.toByteArray();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    eb.a("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.d.a(bArrA);
            ucVar.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
