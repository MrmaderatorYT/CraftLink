package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amm;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class ajv implements ajh<aoo> {
    ajv() {
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final int b() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.ajh
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final anm a(apo apoVar) throws GeneralSecurityException {
        try {
            akv akvVarA = akv.a(apoVar);
            if (!(akvVarA instanceof akv)) {
                throw new GeneralSecurityException("expected AesCtrKey proto");
            }
            akv akvVar = akvVarA;
            aox.a(akvVar.a(), 0);
            aox.a(akvVar.c().a());
            a(akvVar.b());
            return new anm(akvVar.c().b(), akvVar.b().a());
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized AesCtrKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(apo apoVar) throws GeneralSecurityException {
        try {
            return b(akx.a(apoVar));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized AesCtrKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof akx)) {
            throw new GeneralSecurityException("expected AesCtrKeyFormat proto");
        }
        akx akxVar = (akx) asfVar;
        aox.a(akxVar.b());
        a(akxVar.a());
        return (aqy) akv.d().a(akxVar.a()).a(apo.a(aor.a(akxVar.b()))).a(0).f();
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final amm c(apo apoVar) {
        return (amm) ((aqy) amm.d().a("type.googleapis.com/google.crypto.tink.AesCtrKey").a(((akv) b(apoVar)).h()).a(amm.b.SYMMETRIC).f());
    }

    private static void a(akz akzVar) throws GeneralSecurityException {
        if (akzVar.a() < 12 || akzVar.a() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final /* synthetic */ aoo a(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof akv)) {
            throw new GeneralSecurityException("expected AesCtrKey proto");
        }
        akv akvVar = (akv) asfVar;
        aox.a(akvVar.a(), 0);
        aox.a(akvVar.c().a());
        a(akvVar.b());
        return new anm(akvVar.c().b(), akvVar.b().a());
    }
}
