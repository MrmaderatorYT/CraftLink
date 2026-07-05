package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amm;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
final class akm implements ajh<ajl> {
    akm() {
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final String a() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final int b() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.ajh
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final ajl a(apo apoVar) throws GeneralSecurityException {
        aop aopVar;
        try {
            amg amgVarA = amg.a(apoVar);
            if (!(amgVarA instanceof amg)) {
                throw new GeneralSecurityException("expected HmacKey proto");
            }
            amg amgVar = amgVarA;
            aox.a(amgVar.a(), 0);
            if (amgVar.c().a() < 16) {
                throw new GeneralSecurityException("key too short");
            }
            a(amgVar.b());
            ame ameVarA = amgVar.b().a();
            SecretKeySpec secretKeySpec = new SecretKeySpec(amgVar.c().b(), "HMAC");
            int iB = amgVar.b().b();
            switch (ameVarA) {
                case SHA1:
                    aopVar = new aop("HMACSHA1", secretKeySpec, iB);
                    break;
                case SHA256:
                    aopVar = new aop("HMACSHA256", secretKeySpec, iB);
                    break;
                case SHA512:
                    aopVar = new aop("HMACSHA512", secretKeySpec, iB);
                    break;
                default:
                    throw new GeneralSecurityException("unknown hash");
            }
            return aopVar;
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized HmacKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(apo apoVar) throws GeneralSecurityException {
        try {
            return b(ami.a(apoVar));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized HmacKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final asf b(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof ami)) {
            throw new GeneralSecurityException("expected HmacKeyFormat proto");
        }
        ami amiVar = (ami) asfVar;
        if (amiVar.b() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        a(amiVar.a());
        return (aqy) amg.d().a(0).a(amiVar.a()).a(apo.a(aor.a(amiVar.b()))).f();
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final amm c(apo apoVar) {
        return (amm) ((aqy) amm.d().a("type.googleapis.com/google.crypto.tink.HmacKey").a(((amg) b(apoVar)).h()).a(amm.b.SYMMETRIC).f());
    }

    private static void a(amk amkVar) throws GeneralSecurityException {
        if (amkVar.b() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        switch (amkVar.a()) {
            case SHA1:
                if (amkVar.b() > 20) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case SHA256:
                if (amkVar.b() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case SHA512:
                if (amkVar.b() > 64) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            default:
                throw new GeneralSecurityException("unknown hash type");
        }
    }

    @Override // com.google.android.gms.internal.ads.ajh
    public final /* synthetic */ ajl a(asf asfVar) throws GeneralSecurityException {
        if (!(asfVar instanceof amg)) {
            throw new GeneralSecurityException("expected HmacKey proto");
        }
        amg amgVar = (amg) asfVar;
        aox.a(amgVar.a(), 0);
        if (amgVar.c().a() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        a(amgVar.b());
        ame ameVarA = amgVar.b().a();
        SecretKeySpec secretKeySpec = new SecretKeySpec(amgVar.c().b(), "HMAC");
        int iB = amgVar.b().b();
        switch (ameVarA) {
            case SHA1:
                return new aop("HMACSHA1", secretKeySpec, iB);
            case SHA256:
                return new aop("HMACSHA256", secretKeySpec, iB);
            case SHA512:
                return new aop("HMACSHA512", secretKeySpec, iB);
            default:
                throw new GeneralSecurityException("unknown hash");
        }
    }
}
