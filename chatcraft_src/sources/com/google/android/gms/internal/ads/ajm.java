package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amm;
import com.google.android.gms.internal.ads.amw;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class ajm {
    @Deprecated
    public static final aji a(byte[] bArr) throws GeneralSecurityException {
        try {
            amw amwVarA = amw.a(bArr);
            for (amw.b bVar : amwVarA.b()) {
                if (bVar.b().c() == amm.b.UNKNOWN_KEYMATERIAL || bVar.b().c() == amm.b.SYMMETRIC || bVar.b().c() == amm.b.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return aji.a(amwVarA);
        } catch (zzbrl unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
