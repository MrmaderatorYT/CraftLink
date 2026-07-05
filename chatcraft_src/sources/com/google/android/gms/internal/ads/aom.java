package com.google.android.gms.internal.ads;

import java.security.Provider;
import java.security.Signature;

/* loaded from: classes.dex */
public final class aom implements aof<Signature> {
    @Override // com.google.android.gms.internal.ads.aof
    public final /* synthetic */ Signature a(String str, Provider provider) {
        if (provider == null) {
            return Signature.getInstance(str);
        }
        return Signature.getInstance(str, provider);
    }
}
