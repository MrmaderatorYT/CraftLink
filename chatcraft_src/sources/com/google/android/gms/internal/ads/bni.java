package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class bni {

    /* renamed from: b, reason: collision with root package name */
    private static MessageDigest f2873b;

    /* renamed from: a, reason: collision with root package name */
    protected Object f2874a = new Object();

    abstract byte[] a(String str);

    protected final MessageDigest a() {
        synchronized (this.f2874a) {
            if (f2873b != null) {
                return f2873b;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    f2873b = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return f2873b;
        }
    }
}
