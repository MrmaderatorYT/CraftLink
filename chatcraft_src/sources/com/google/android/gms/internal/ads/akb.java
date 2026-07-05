package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amm;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class akb implements ajh<aja> {
    akb() {
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
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
            ane aneVarA = ane.a(apoVar);
            if (!(aneVarA instanceof ane)) {
                throw new GeneralSecurityException("expected KmsEnvelopeAeadKey proto");
            }
            ane aneVar = aneVarA;
            aox.a(aneVar.a(), 0);
            String strA = aneVar.b().a();
            return new aka(aneVar.b().b(), ajk.a(strA).b(strA));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized KmSEnvelopeAeadKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(apo apoVar) throws GeneralSecurityException {
        try {
            return b(ang.a(apoVar));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized KmsEnvelopeAeadKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof ang)) {
            throw new GeneralSecurityException("expected KmsEnvelopeAeadKeyFormat proto");
        }
        return (aqy) ane.c().a((ang) asfVar).a(0).f();
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final amm c(apo apoVar) {
        return (amm) ((aqy) amm.d().a("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey").a(((ane) b(apoVar)).h()).a(amm.b.REMOTE).f());
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final /* synthetic */ aja a(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof ane)) {
            throw new GeneralSecurityException("expected KmsEnvelopeAeadKey proto");
        }
        ane aneVar = (ane) asfVar;
        aox.a(aneVar.a(), 0);
        String strA = aneVar.b().a();
        return new aka(aneVar.b().b(), ajk.a(strA).b(strA));
    }
}
