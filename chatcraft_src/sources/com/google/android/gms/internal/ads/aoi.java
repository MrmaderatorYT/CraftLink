package com.google.android.gms.internal.ads;

import java.security.KeyFactory;
import java.security.Provider;

/* loaded from: classes.dex */
public final class aoi implements aof<KeyFactory> {
    @Override // com.google.android.gms.internal.ads.aof
    public final /* synthetic */ KeyFactory a(String str, Provider provider) {
        if (provider == null) {
            return KeyFactory.getInstance(str);
        }
        return KeyFactory.getInstance(str, provider);
    }
}
