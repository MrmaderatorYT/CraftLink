package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amm;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class ajw implements ajh<aja> {
    ajw() {
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
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
            alb albVarA = alb.a(apoVar);
            if (!(albVarA instanceof alb)) {
                throw new GeneralSecurityException("expected AesEaxKey proto");
            }
            alb albVar = albVarA;
            aox.a(albVar.a(), 0);
            aox.a(albVar.c().a());
            if (albVar.b().a() != 12 && albVar.b().a() != 16) {
                throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
            }
            return new ann(albVar.c().b(), albVar.b().a());
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized AesEaxKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(apo apoVar) throws GeneralSecurityException {
        try {
            return b(ald.a(apoVar));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized AesEaxKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof ald)) {
            throw new GeneralSecurityException("expected AesEaxKeyFormat proto");
        }
        ald aldVar = (ald) asfVar;
        aox.a(aldVar.b());
        if (aldVar.a().a() != 12 && aldVar.a().a() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
        return (aqy) alb.d().a(apo.a(aor.a(aldVar.b()))).a(aldVar.a()).a(0).f();
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final amm c(apo apoVar) {
        return (amm) ((aqy) amm.d().a("type.googleapis.com/google.crypto.tink.AesEaxKey").a(((alb) b(apoVar)).h()).a(amm.b.SYMMETRIC).f());
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final /* synthetic */ aja a(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof alb)) {
            throw new GeneralSecurityException("expected AesEaxKey proto");
        }
        alb albVar = (alb) asfVar;
        aox.a(albVar.a(), 0);
        aox.a(albVar.c().a());
        if (albVar.b().a() != 12 && albVar.b().a() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
        return new ann(albVar.c().b(), albVar.b().a());
    }
}
