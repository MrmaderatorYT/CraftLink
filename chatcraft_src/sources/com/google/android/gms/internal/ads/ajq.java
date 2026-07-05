package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.amw;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class ajq {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f2021a = Logger.getLogger(ajq.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentMap<String, ajh> f2022b = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> c = new ConcurrentHashMap();
    private static final ConcurrentMap<String, ajb> d = new ConcurrentHashMap();

    public static synchronized <P> void a(String str, ajb<P> ajbVar) {
        if (d.containsKey(str.toLowerCase())) {
            if (!ajbVar.getClass().equals(d.get(str.toLowerCase()).getClass())) {
                Logger logger = f2021a;
                Level level = Level.WARNING;
                String strValueOf = String.valueOf(str);
                logger.logp(level, "com.google.crypto.tink.Registry", "addCatalogue", strValueOf.length() != 0 ? "Attempted overwrite of a catalogueName catalogue for name ".concat(strValueOf) : new String("Attempted overwrite of a catalogueName catalogue for name "));
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 47);
                sb.append("catalogue for name ");
                sb.append(str);
                sb.append(" has been already registered");
                throw new GeneralSecurityException(sb.toString());
            }
        }
        d.put(str.toLowerCase(), ajbVar);
    }

    public static <P> ajb<P> a(String str) throws GeneralSecurityException {
        if (str == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        ajb<P> ajbVar = d.get(str.toLowerCase());
        if (ajbVar != null) {
            return ajbVar;
        }
        String strConcat = String.format("no catalogue found for %s. ", str);
        if (str.toLowerCase().startsWith("tinkaead")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call AeadConfig.register().");
        }
        if (str.toLowerCase().startsWith("tinkdeterministicaead")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call DeterministicAeadConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkstreamingaead")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call StreamingAeadConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkhybriddecrypt") || str.toLowerCase().startsWith("tinkhybridencrypt")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call HybridConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkmac")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call MacConfig.register().");
        } else if (str.toLowerCase().startsWith("tinkpublickeysign") || str.toLowerCase().startsWith("tinkpublickeyverify")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call SignatureConfig.register().");
        } else if (str.toLowerCase().startsWith("tink")) {
            strConcat = String.valueOf(strConcat).concat("Maybe call TinkConfig.register().");
        }
        throw new GeneralSecurityException(strConcat);
    }

    public static synchronized <P> void a(ajh<P> ajhVar) {
        a((ajh) ajhVar, true);
    }

    public static synchronized <P> void a(ajh<P> ajhVar, boolean z) {
        if (ajhVar == null) {
            throw new IllegalArgumentException("key manager must be non-null.");
        }
        String strA = ajhVar.a();
        if (f2022b.containsKey(strA)) {
            ajh ajhVarB = b(strA);
            boolean zBooleanValue = c.get(strA).booleanValue();
            if (!ajhVar.getClass().equals(ajhVarB.getClass()) || (!zBooleanValue && z)) {
                Logger logger = f2021a;
                Level level = Level.WARNING;
                String strValueOf = String.valueOf(strA);
                logger.logp(level, "com.google.crypto.tink.Registry", "registerKeyManager", strValueOf.length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat(strValueOf) : new String("Attempted overwrite of a registered key manager for key type "));
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", strA, ajhVarB.getClass().getName(), ajhVar.getClass().getName()));
            }
        }
        f2022b.put(strA, ajhVar);
        c.put(strA, Boolean.valueOf(z));
    }

    private static <P> ajh<P> b(String str) throws GeneralSecurityException {
        ajh<P> ajhVar = f2022b.get(str);
        if (ajhVar != null) {
            return ajhVar;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
        sb.append("No key manager found for key type: ");
        sb.append(str);
        sb.append(".  Check the configuration of the registry.");
        throw new GeneralSecurityException(sb.toString());
    }

    public static synchronized <P> amm a(ams amsVar) {
        ajh ajhVarB;
        ajhVarB = b(amsVar.a());
        if (!c.get(amsVar.a()).booleanValue()) {
            String strValueOf = String.valueOf(amsVar.a());
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(strValueOf) : new String("newKey-operation not permitted for key type "));
        }
        return ajhVarB.c(amsVar.b());
    }

    public static synchronized <P> asf b(ams amsVar) {
        ajh ajhVarB;
        ajhVarB = b(amsVar.a());
        if (!c.get(amsVar.a()).booleanValue()) {
            String strValueOf = String.valueOf(amsVar.a());
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(strValueOf) : new String("newKey-operation not permitted for key type "));
        }
        return ajhVarB.b(amsVar.b());
    }

    public static synchronized <P> asf a(String str, asf asfVar) {
        ajh ajhVarB;
        ajhVarB = b(str);
        if (!c.get(str).booleanValue()) {
            String strValueOf = String.valueOf(str);
            throw new GeneralSecurityException(strValueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(strValueOf) : new String("newKey-operation not permitted for key type "));
        }
        return ajhVarB.b(asfVar);
    }

    public static <P> P b(String str, asf asfVar) {
        return (P) b(str).a(asfVar);
    }

    private static <P> P a(String str, apo apoVar) {
        return (P) b(str).a(apoVar);
    }

    public static <P> P a(String str, byte[] bArr) {
        return (P) a(str, apo.a(bArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <P> ajn<P> a(aji ajiVar, ajh<P> ajhVar) throws GeneralSecurityException {
        ajr.b(ajiVar.a());
        ajn<P> ajnVar = (ajn<P>) new ajn();
        for (amw.b bVar : ajiVar.a().b()) {
            if (bVar.c() == amp.ENABLED) {
                ajp ajpVarA = ajnVar.a(a(bVar.b().a(), bVar.b().b()), bVar);
                if (bVar.d() == ajiVar.a().a()) {
                    ajnVar.a(ajpVarA);
                }
            }
        }
        return ajnVar;
    }
}
