package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.Provider;

/* loaded from: classes.dex */
public final class aol implements aof<MessageDigest> {
    @Override // com.google.android.gms.internal.ads.aof
    public final /* synthetic */ MessageDigest a(String str, Provider provider) {
        if (provider == null) {
            return MessageDigest.getInstance(str);
        }
        return MessageDigest.getInstance(str, provider);
    }
}
