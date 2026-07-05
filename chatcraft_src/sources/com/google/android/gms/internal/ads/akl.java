package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.akv;
import com.google.android.gms.internal.ads.alh;
import com.google.android.gms.internal.ads.amg;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
final class akl implements ant {

    /* renamed from: a, reason: collision with root package name */
    private final String f2035a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2036b;
    private alh c;
    private akr d;
    private int e;

    akl(ams amsVar) throws GeneralSecurityException {
        this.f2035a = amsVar.a();
        if (this.f2035a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                alj aljVarA = alj.a(amsVar.b());
                this.c = (alh) ajq.b(amsVar);
                this.f2036b = aljVarA.a();
                return;
            } catch (zzbrl e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        }
        if (!this.f2035a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            String strValueOf = String.valueOf(this.f2035a);
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(strValueOf) : new String("unsupported AEAD DEM key type: "));
        }
        try {
            akt aktVarA = akt.a(amsVar.b());
            this.d = (akr) ajq.b(amsVar);
            this.e = aktVarA.a().b();
            this.f2036b = this.e + aktVarA.b().b();
        } catch (zzbrl e2) {
            throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.ant
    public final int a() {
        return this.f2036b;
    }

    @Override // com.google.android.gms.internal.ads.ant
    public final aja a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.f2036b) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.f2035a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            return (aja) ajq.b(this.f2035a, (alh) ((aqy) alh.c().a((alh.a) this.c).a(apo.a(bArr, 0, this.f2036b)).f()));
        }
        if (this.f2035a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, this.e);
            byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, this.e, this.f2036b);
            akv akvVar = (akv) ((aqy) akv.d().a((akv.a) this.d.b()).a(apo.a(bArrCopyOfRange)).f());
            return (aja) ajq.b(this.f2035a, (akr) ((aqy) akr.d().a(this.d.a()).a(akvVar).a((amg) ((aqy) amg.d().a((amg.a) this.d.c()).a(apo.a(bArrCopyOfRange2)).f())).f()));
        }
        throw new GeneralSecurityException("unknown DEM key type");
    }
}
