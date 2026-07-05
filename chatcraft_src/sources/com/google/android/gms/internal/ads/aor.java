package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* loaded from: classes.dex */
public final class aor {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<SecureRandom> f2121a = new aos();

    /* JADX INFO: Access modifiers changed from: private */
    public static SecureRandom b() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] a(int i) {
        byte[] bArr = new byte[i];
        f2121a.get().nextBytes(bArr);
        return bArr;
    }
}
