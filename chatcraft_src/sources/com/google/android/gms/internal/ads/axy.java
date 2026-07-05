package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class axy {

    /* renamed from: a, reason: collision with root package name */
    static ajg f2394a;

    static boolean a(axt axtVar) {
        Method methodA;
        if (f2394a != null) {
            return true;
        }
        String str = (String) bra.e().a(o.bm);
        if (str == null || str.length() == 0) {
            str = null;
            if (axtVar != null && (methodA = axtVar.a("phpjyfBMe8u7C5auGMsy22WXoT6iMDb5qqttOP4sXOBlc73QdE1wdYLJ++PsHndY", "86B2wkBiSbEIJu45HO/BQ/RpWXZRq9YpFeIER87ao7I=")) != null) {
                str = (String) methodA.invoke(null, new Object[0]);
            }
            if (str == null) {
                return false;
            }
        }
        try {
            try {
                aji ajiVarA = ajm.a(atu.a(str, true));
                ajc.a(ake.f2029a);
                f2394a = akh.a(ajiVarA);
                return f2394a != null;
            } catch (GeneralSecurityException unused) {
                return false;
            }
        } catch (IllegalArgumentException unused2) {
            return false;
        }
    }
}
