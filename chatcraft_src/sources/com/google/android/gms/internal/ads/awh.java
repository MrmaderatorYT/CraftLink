package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
final class awh implements Runnable {
    private awh() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MessageDigest unused = avu.c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused2) {
        } finally {
            avu.f2327a.countDown();
        }
    }
}
