package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amm;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;

/* loaded from: classes.dex */
final class akc implements ajh<ajf> {
    akc() {
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final int b() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.ajh
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final ajf a(apo apoVar) throws GeneralSecurityException {
        try {
            alw alwVarA = alw.a(apoVar);
            if (!(alwVarA instanceof alw)) {
                throw new GeneralSecurityException("expected EciesAeadHkdfPrivateKey proto");
            }
            alw alwVar = alwVarA;
            aox.a(alwVar.a(), 0);
            akj.a(alwVar.b().b());
            alu aluVarB = alwVar.b().b();
            ama amaVarA = aluVarB.a();
            aob aobVarA = akj.a(amaVarA.a());
            byte[] bArrB = alwVar.c().b();
            return new anu((ECPrivateKey) aoe.e.a("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, bArrB), anz.a(aobVarA))), amaVarA.c().b(), akj.a(amaVarA.b()), akj.a(aluVarB.c()), new akl(aluVarB.b().a()));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPrivateKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(apo apoVar) throws GeneralSecurityException {
        try {
            return b(als.a(apoVar));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("invalid EciesAeadHkdf key format", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof als)) {
            throw new GeneralSecurityException("expected EciesAeadHkdfKeyFormat proto");
        }
        als alsVar = (als) asfVar;
        akj.a(alsVar.a());
        KeyPair keyPairA = anz.a(anz.a(akj.a(alsVar.a().a().a())));
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairA.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairA.getPrivate();
        ECPoint w = eCPublicKey.getW();
        return (aqy) alw.d().a(0).a((aly) ((aqy) aly.e().a(0).a(alsVar.a()).a(apo.a(w.getAffineX().toByteArray())).b(apo.a(w.getAffineY().toByteArray())).f())).a(apo.a(eCPrivateKey.getS().toByteArray())).f();
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final amm c(apo apoVar) {
        return (amm) ((aqy) amm.d().a("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").a(((alw) b(apoVar)).h()).a(amm.b.ASYMMETRIC_PRIVATE).f());
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final /* synthetic */ ajf a(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof alw)) {
            throw new GeneralSecurityException("expected EciesAeadHkdfPrivateKey proto");
        }
        alw alwVar = (alw) asfVar;
        aox.a(alwVar.a(), 0);
        akj.a(alwVar.b().b());
        alu aluVarB = alwVar.b().b();
        ama amaVarA = aluVarB.a();
        aob aobVarA = akj.a(amaVarA.a());
        byte[] bArrB = alwVar.c().b();
        return new anu((ECPrivateKey) aoe.e.a("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, bArrB), anz.a(aobVarA))), amaVarA.c().b(), akj.a(amaVarA.b()), akj.a(aluVarB.c()), new akl(aluVarB.b().a()));
    }
}
