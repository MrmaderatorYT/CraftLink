package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.ank;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class ajt {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final ank f2024a = (ank) ((aqy) ank.b().a((ank.a) akq.f2040a).a(ajc.a("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).a(ajc.a("TinkAead", "Aead", "AesEaxKey", 0, true)).a(ajc.a("TinkAead", "Aead", "AesGcmKey", 0, true)).a(ajc.a("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).a(ajc.a("TinkAead", "Aead", "KmsAeadKey", 0, true)).a(ajc.a("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).a("TINK_AEAD_1_0_0").f());

    @Deprecated
    private static final ank c = (ank) ((aqy) ank.b().a((ank.a) f2024a).a("TINK_AEAD_1_1_0").f());

    /* renamed from: b, reason: collision with root package name */
    public static final ank f2025b = (ank) ((aqy) ank.b().a((ank.a) akq.f2041b).a(ajc.a("TinkAead", "Aead", "AesCtrHmacAeadKey", 0, true)).a(ajc.a("TinkAead", "Aead", "AesEaxKey", 0, true)).a(ajc.a("TinkAead", "Aead", "AesGcmKey", 0, true)).a(ajc.a("TinkAead", "Aead", "ChaCha20Poly1305Key", 0, true)).a(ajc.a("TinkAead", "Aead", "KmsAeadKey", 0, true)).a(ajc.a("TinkAead", "Aead", "KmsEnvelopeAeadKey", 0, true)).a("TINK_AEAD").f());

    public static void a() throws GeneralSecurityException {
        akq.a();
        ajq.a("TinkAead", new ajs());
        ajc.a(f2025b);
    }

    static {
        try {
            a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
