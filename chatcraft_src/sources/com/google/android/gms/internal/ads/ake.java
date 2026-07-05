package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.ank;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class ake {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final ank f2029a = (ank) ((aqy) ank.b().a((ank.a) ajt.f2024a).a(ajc.a("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).a(ajc.a("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).a("TINK_HYBRID_1_0_0").f());

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    private static final ank f2030b = (ank) ((aqy) ank.b().a((ank.a) f2029a).a("TINK_HYBRID_1_1_0").f());
    private static final ank c = (ank) ((aqy) ank.b().a((ank.a) ajt.f2025b).a(ajc.a("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey", 0, true)).a(ajc.a("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey", 0, true)).a("TINK_HYBRID").f());

    static {
        try {
            ajt.a();
            ajq.a("TinkHybridEncrypt", new akg());
            ajq.a("TinkHybridDecrypt", new akf());
            ajc.a(c);
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
