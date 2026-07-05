package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aof;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes.dex */
public final class aoe<T_WRAPPER extends aof<T_ENGINE>, T_ENGINE> {

    /* renamed from: a, reason: collision with root package name */
    public static final aoe<aog, Cipher> f2116a;

    /* renamed from: b, reason: collision with root package name */
    public static final aoe<aok, Mac> f2117b;
    public static final aoe<aoh, KeyAgreement> c;
    public static final aoe<aoj, KeyPairGenerator> d;
    public static final aoe<aoi, KeyFactory> e;
    private static final Logger f = Logger.getLogger(aoe.class.getName());
    private static final List<Provider> g;
    private static final aoe<aom, Signature> h;
    private static final aoe<aol, MessageDigest> i;
    private T_WRAPPER j;
    private List<Provider> k = g;
    private boolean l = true;

    private aoe(T_WRAPPER t_wrapper) {
        this.j = t_wrapper;
    }

    public final T_ENGINE a(String str) throws GeneralSecurityException {
        for (Provider provider : this.k) {
            if (a(str, provider)) {
                return (T_ENGINE) this.j.a(str, provider);
            }
        }
        if (this.l) {
            return (T_ENGINE) this.j.a(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.");
    }

    private final boolean a(String str, Provider provider) {
        try {
            this.j.a(str, provider);
            return true;
        } catch (Exception e2) {
            aoy.a(e2);
            return false;
        }
    }

    static {
        if (aow.a()) {
            String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 2; i2++) {
                String str = strArr[i2];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    f.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", str));
                }
            }
            g = arrayList;
        } else {
            g = new ArrayList();
        }
        f2116a = new aoe<>(new aog());
        f2117b = new aoe<>(new aok());
        h = new aoe<>(new aom());
        i = new aoe<>(new aol());
        c = new aoe<>(new aoh());
        d = new aoe<>(new aoj());
        e = new aoe<>(new aoi());
    }
}
