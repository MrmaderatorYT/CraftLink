package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amm;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class ajz implements ajh<aja> {
    ajz() {
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final int b() {
        return 0;
    }

    private static aja d(apo apoVar) throws GeneralSecurityException {
        try {
            return c(ana.a(apoVar));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected KmsAeadKey proto", e);
        }
    }

    private static aja c(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof ana)) {
            throw new GeneralSecurityException("expected KmsAeadKey proto");
        }
        ana anaVar = (ana) asfVar;
        aox.a(anaVar.a(), 0);
        String strA = anaVar.b().a();
        return ajk.a(strA).b(strA);
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(apo apoVar) throws GeneralSecurityException {
        try {
            return b(anc.a(apoVar));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized KmsAeadKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof anc)) {
            throw new GeneralSecurityException("expected KmsAeadKeyFormat proto");
        }
        return (aqy) ana.c().a((anc) asfVar).a(0).f();
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final amm c(apo apoVar) {
        return (amm) ((aqy) amm.d().a("type.googleapis.com/google.crypto.tink.KmsAeadKey").a(((ana) b(apoVar)).h()).a(amm.b.REMOTE).f());
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final /* synthetic */ aja a(asf asfVar) {
        return c(asfVar);
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final /* synthetic */ aja a(apo apoVar) {
        return d(apoVar);
    }
}
