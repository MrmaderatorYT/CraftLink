package com.google.android.gms.internal.ads;

import java.security.Provider;
import javax.crypto.KeyAgreement;

/* loaded from: classes.dex */
public final class aoh implements aof<KeyAgreement> {
    @Override // com.google.android.gms.internal.ads.aof
    public final /* synthetic */ KeyAgreement a(String str, Provider provider) {
        if (provider == null) {
            return KeyAgreement.getInstance(str);
        }
        return KeyAgreement.getInstance(str, provider);
    }
}
