package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amm;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class ajx implements ajh<aja> {
    ajx() {
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final int b() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.ajh
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final aja a(apo apoVar) throws GeneralSecurityException {
        try {
            alh alhVarA = alh.a(apoVar);
            if (!(alhVarA instanceof alh)) {
                throw new GeneralSecurityException("expected AesGcmKey proto");
            }
            alh alhVar = alhVarA;
            aox.a(alhVar.a(), 0);
            aox.a(alhVar.b().a());
            return new ano(alhVar.b().b());
        } catch (zzbrl unused) {
            throw new GeneralSecurityException("expected AesGcmKey proto");
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(apo apoVar) throws GeneralSecurityException {
        try {
            return b(alj.a(apoVar));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized AesGcmKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof alj)) {
            throw new GeneralSecurityException("expected AesGcmKeyFormat proto");
        }
        alj aljVar = (alj) asfVar;
        aox.a(aljVar.a());
        return (aqy) alh.c().a(apo.a(aor.a(aljVar.a()))).a(0).f();
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final amm c(apo apoVar) {
        return (amm) ((aqy) amm.d().a("type.googleapis.com/google.crypto.tink.AesGcmKey").a(((alh) b(apoVar)).h()).a(amm.b.SYMMETRIC).f());
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final /* synthetic */ aja a(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof alh)) {
            throw new GeneralSecurityException("expected AesGcmKey proto");
        }
        alh alhVar = (alh) asfVar;
        aox.a(alhVar.a(), 0);
        aox.a(alhVar.b().a());
        return new ano(alhVar.b().b());
    }
}
