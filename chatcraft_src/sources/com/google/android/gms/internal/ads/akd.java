package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class akd implements ajh<ajg> {
    akd() {
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final int b() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.ajh
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final ajg a(apo apoVar) throws GeneralSecurityException {
        try {
            aly alyVarA = aly.a(apoVar);
            if (!(alyVarA instanceof aly)) {
                throw new GeneralSecurityException("expected EciesAeadHkdfPublicKey proto");
            }
            aly alyVar = alyVarA;
            aox.a(alyVar.a(), 0);
            akj.a(alyVar.b());
            alu aluVarB = alyVar.b();
            ama amaVarA = aluVarB.a();
            return new anv(anz.a(akj.a(amaVarA.a()), alyVar.c().b(), alyVar.d().b()), amaVarA.c().b(), akj.a(amaVarA.b()), akj.a(aluVarB.c()), new akl(aluVarB.b().a()));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPublicKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(apo apoVar) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(asf asfVar) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final amm c(apo apoVar) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final /* synthetic */ ajg a(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof aly)) {
            throw new GeneralSecurityException("expected EciesAeadHkdfPublicKey proto");
        }
        aly alyVar = (aly) asfVar;
        aox.a(alyVar.a(), 0);
        akj.a(alyVar.b());
        alu aluVarB = alyVar.b();
        ama amaVarA = aluVarB.a();
        return new anv(anz.a(akj.a(amaVarA.a()), alyVar.c().b(), alyVar.d().b()), amaVarA.c().b(), akj.a(amaVarA.b()), akj.a(aluVarB.c()), new akl(aluVarB.b().a()));
    }
}
