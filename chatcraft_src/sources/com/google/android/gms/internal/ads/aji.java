package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class aji {

    /* renamed from: a, reason: collision with root package name */
    private amw f2015a;

    private aji(amw amwVar) {
        this.f2015a = amwVar;
    }

    static final aji a(amw amwVar) throws GeneralSecurityException {
        if (amwVar == null || amwVar.c() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return new aji(amwVar);
    }

    final amw a() {
        return this.f2015a;
    }

    public final String toString() {
        return ajr.a(this.f2015a).toString();
    }
}
