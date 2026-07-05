package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amm;
import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* loaded from: classes.dex */
class aju implements ajh<aja> {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f2026a = Logger.getLogger(aju.class.getName());

    aju() {
        ajq.a(new ajv());
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
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
            akr akrVarA = akr.a(apoVar);
            if (!(akrVarA instanceof akr)) {
                throw new GeneralSecurityException("expected AesCtrHmacAeadKey proto");
            }
            akr akrVar = akrVarA;
            aox.a(akrVar.a(), 0);
            return new aod((aoo) ajq.b("type.googleapis.com/google.crypto.tink.AesCtrKey", akrVar.b()), (ajl) ajq.b("type.googleapis.com/google.crypto.tink.HmacKey", akrVar.c()), akrVar.c().b().b());
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(apo apoVar) throws GeneralSecurityException {
        try {
            return b(akt.a(apoVar));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof akt)) {
            throw new GeneralSecurityException("expected AesCtrHmacAeadKeyFormat proto");
        }
        akt aktVar = (akt) asfVar;
        akv akvVar = (akv) ajq.a("type.googleapis.com/google.crypto.tink.AesCtrKey", aktVar.a());
        return (aqy) akr.d().a(akvVar).a((amg) ajq.a("type.googleapis.com/google.crypto.tink.HmacKey", aktVar.b())).a(0).f();
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final amm c(apo apoVar) {
        return (amm) ((aqy) amm.d().a("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey").a(((akr) b(apoVar)).h()).a(amm.b.SYMMETRIC).f());
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final /* synthetic */ aja a(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof akr)) {
            throw new GeneralSecurityException("expected AesCtrHmacAeadKey proto");
        }
        akr akrVar = (akr) asfVar;
        aox.a(akrVar.a(), 0);
        return new aod((aoo) ajq.b("type.googleapis.com/google.crypto.tink.AesCtrKey", akrVar.b()), (ajl) ajq.b("type.googleapis.com/google.crypto.tink.HmacKey", akrVar.c()), akrVar.c().b().b());
    }
}
