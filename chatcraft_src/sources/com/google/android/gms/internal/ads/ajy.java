package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amm;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class ajy implements ajh<aja> {
    ajy() {
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
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
            all allVarA = all.a(apoVar);
            if (!(allVarA instanceof all)) {
                throw new GeneralSecurityException("expected ChaCha20Poly1305Key proto");
            }
            all allVar = allVarA;
            aox.a(allVar.a(), 0);
            if (allVar.b().a() == 32) {
                return new anr(allVar.b().b());
            }
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        } catch (zzbrl e) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305 key", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(apo apoVar) {
        return c();
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(asf asfVar) {
        return c();
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final amm c(apo apoVar) {
        return (amm) ((aqy) amm.d().a("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key").a(c().h()).a(amm.b.SYMMETRIC).f());
    }

    private static all c() {
        return (all) ((aqy) all.c().a(0).a(apo.a(aor.a(32))).f());
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final /* synthetic */ aja a(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof all)) {
            throw new GeneralSecurityException("expected ChaCha20Poly1305Key proto");
        }
        all allVar = (all) asfVar;
        aox.a(allVar.a(), 0);
        if (allVar.b().a() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
        return new anr(allVar.b().b());
    }
}
