package com.google.android.gms.internal.ads;

import java.security.KeyPairGenerator;
import java.security.Provider;

/* loaded from: classes.dex */
public final class aoj implements aof<KeyPairGenerator> {
    @Override // com.google.android.gms.internal.ads.aof
    public final /* synthetic */ KeyPairGenerator a(String str, Provider provider) {
        if (provider == null) {
            return KeyPairGenerator.getInstance(str);
        }
        return KeyPairGenerator.getInstance(str, provider);
    }
}
