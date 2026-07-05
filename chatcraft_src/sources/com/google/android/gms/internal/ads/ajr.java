package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amm;
import com.google.android.gms.internal.ads.amw;
import com.google.android.gms.internal.ads.amy;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class ajr {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f2023a = Charset.forName("UTF-8");

    public static amy a(amw amwVar) {
        amy.a aVarA = amy.a().a(amwVar.a());
        for (amw.b bVar : amwVar.b()) {
            aVarA.a((amy.b) ((aqy) amy.b.a().a(bVar.b().a()).a(bVar.c()).a(bVar.e()).a(bVar.d()).f()));
        }
        return (amy) ((aqy) aVarA.f());
    }

    public static void b(amw amwVar) throws GeneralSecurityException {
        if (amwVar.c() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        int iA = amwVar.a();
        boolean z = false;
        boolean z2 = true;
        for (amw.b bVar : amwVar.b()) {
            if (!bVar.a()) {
                throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(bVar.d())));
            }
            if (bVar.e() == ani.UNKNOWN_PREFIX) {
                throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(bVar.d())));
            }
            if (bVar.c() == amp.UNKNOWN_STATUS) {
                throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(bVar.d())));
            }
            if (bVar.c() == amp.ENABLED && bVar.d() == iA) {
                if (z) {
                    throw new GeneralSecurityException("keyset contains multiple primary keys");
                }
                z = true;
            }
            if (bVar.b().c() != amm.b.ASYMMETRIC_PUBLIC) {
                z2 = false;
            }
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
