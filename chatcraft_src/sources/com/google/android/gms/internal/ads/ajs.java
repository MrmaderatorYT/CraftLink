package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class ajs implements ajb<aja> {
    @Override // com.google.android.gms.internal.ads.ajb
    public final ajh<aja> a(String str, String str2, int i) throws GeneralSecurityException {
        ajh<aja> ajuVar;
        String lowerCase = str2.toLowerCase();
        if (((lowerCase.hashCode() == 2989895 && lowerCase.equals("aead")) ? (char) 0 : (char) 65535) != 0) {
            throw new GeneralSecurityException(String.format("No support for primitive '%s'.", str2));
        }
        switch (str) {
            case "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey":
                ajuVar = new aju();
                break;
            case "type.googleapis.com/google.crypto.tink.AesEaxKey":
                ajuVar = new ajw();
                break;
            case "type.googleapis.com/google.crypto.tink.AesGcmKey":
                ajuVar = new ajx();
                break;
            case "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key":
                ajuVar = new ajy();
                break;
            case "type.googleapis.com/google.crypto.tink.KmsAeadKey":
                ajuVar = new ajz();
                break;
            case "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey":
                ajuVar = new akb();
                break;
            default:
                throw new GeneralSecurityException(String.format("No support for primitive 'Aead' with key type '%s'.", str));
        }
        if (ajuVar.b() >= i) {
            return ajuVar;
        }
        throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", str, Integer.valueOf(i)));
    }
}
