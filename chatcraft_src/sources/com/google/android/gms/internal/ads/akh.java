package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class akh {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f2031a = Logger.getLogger(akh.class.getName());

    public static ajg a(aji ajiVar) throws GeneralSecurityException {
        ajn ajnVarA = ajq.a(ajiVar, (ajh) null);
        Iterator it = ajnVarA.b().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((Collection) it.next()).iterator();
            while (it2.hasNext()) {
                if (!(((ajp) it2.next()).a() instanceof ajg)) {
                    throw new GeneralSecurityException("invalid HybridEncrypt key material");
                }
            }
        }
        return new aki(ajnVarA);
    }
}
