package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.ank;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class akq {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final ank f2040a = (ank) ((aqy) ank.b().a("TINK_MAC_1_0_0").a(ajc.a("TinkMac", "Mac", "HmacKey", 0, true)).f());

    @Deprecated
    private static final ank c = (ank) ((aqy) ank.b().a((ank.a) f2040a).a("TINK_MAC_1_1_0").f());

    /* renamed from: b, reason: collision with root package name */
    public static final ank f2041b = (ank) ((aqy) ank.b().a((ank.a) f2040a).a("TINK_MAC").f());

    public static void a() throws GeneralSecurityException {
        ajq.a("TinkMac", new ako());
        ajc.a(f2041b);
    }

    static {
        try {
            a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
