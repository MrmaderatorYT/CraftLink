package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class ajk {

    /* renamed from: a, reason: collision with root package name */
    private static final CopyOnWriteArrayList<ajj> f2016a = new CopyOnWriteArrayList<>();

    public static ajj a(String str) throws GeneralSecurityException {
        Iterator<ajj> it = f2016a.iterator();
        while (it.hasNext()) {
            ajj next = it.next();
            if (next.a(str)) {
                return next;
            }
        }
        String strValueOf = String.valueOf(str);
        throw new GeneralSecurityException(strValueOf.length() != 0 ? "No KMS client does support: ".concat(strValueOf) : new String("No KMS client does support: "));
    }
}
