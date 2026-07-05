package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amu;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class ajc {
    public static amu a(String str, String str2, String str3, int i, boolean z) {
        amu.a aVarA = amu.f().a(str2);
        String strValueOf = String.valueOf(str3);
        return (amu) ((aqy) aVarA.b(strValueOf.length() != 0 ? "type.googleapis.com/google.crypto.tink.".concat(strValueOf) : new String("type.googleapis.com/google.crypto.tink.")).a(0).a(true).c(str).f());
    }

    public static void a(ank ankVar) throws GeneralSecurityException {
        for (amu amuVar : ankVar.a()) {
            if (amuVar.b().isEmpty()) {
                throw new GeneralSecurityException("Missing type_url.");
            }
            if (amuVar.a().isEmpty()) {
                throw new GeneralSecurityException("Missing primitive_name.");
            }
            if (amuVar.e().isEmpty()) {
                throw new GeneralSecurityException("Missing catalogue_name.");
            }
            ajq.a(ajq.a(amuVar.e()).a(amuVar.b(), amuVar.a(), amuVar.c()), amuVar.d());
        }
    }
}
