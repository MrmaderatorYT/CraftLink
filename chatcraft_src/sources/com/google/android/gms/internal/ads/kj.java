package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import java.util.Map;

@qj
/* loaded from: classes.dex */
public final class kj extends kl {

    /* renamed from: b, reason: collision with root package name */
    private static final mi f3231b = new mi();

    /* renamed from: a, reason: collision with root package name */
    private Map<Class<? extends Object>, Object> f3232a;

    @Override // com.google.android.gms.internal.ads.kk
    public final kn a(String str) {
        return d(str);
    }

    @Override // com.google.android.gms.internal.ads.kk
    public final boolean b(String str) {
        try {
            return com.google.android.gms.ads.mediation.customevent.a.class.isAssignableFrom(Class.forName(str, false, kj.class.getClassLoader()));
        } catch (Throwable unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 80);
            sb.append("Could not load custom event implementation class: ");
            sb.append(str);
            sb.append(", assuming old implementation.");
            aan.e(sb.toString());
            return false;
        }
    }

    public final void a(Map<Class<? extends Object>, Object> map) {
        this.f3232a = map;
    }

    private final <NetworkExtrasT extends com.google.ads.mediation.e, ServerParametersT extends MediationServerParameters> kn d(String str) {
        try {
            Class<?> cls = Class.forName(str, false, kj.class.getClassLoader());
            if (com.google.ads.mediation.b.class.isAssignableFrom(cls)) {
                com.google.ads.mediation.b bVar = (com.google.ads.mediation.b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                return new ln(bVar, (com.google.ads.mediation.e) this.f3232a.get(bVar.getAdditionalParametersType()));
            }
            if (com.google.android.gms.ads.mediation.b.class.isAssignableFrom(cls)) {
                return new li((com.google.android.gms.ads.mediation.b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 64);
            sb.append("Could not instantiate mediation adapter: ");
            sb.append(str);
            sb.append(" (not a valid adapter).");
            aan.e(sb.toString());
            throw new RemoteException();
        } catch (Throwable unused) {
            return e(str);
        }
    }

    private final kn e(String str) throws RemoteException {
        try {
            aan.b("Reflection failed, retrying using direct instantiation");
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 43);
            sb.append("Could not instantiate mediation adapter: ");
            sb.append(str);
            sb.append(". ");
            aan.c(sb.toString(), th);
        }
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
            return new li(new AdMobAdapter());
        }
        if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
            return new li(new AdUrlAdapter());
        }
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            return new li(new CustomEventAdapter());
        }
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            com.google.ads.mediation.customevent.CustomEventAdapter customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
            return new ln(customEventAdapter, (com.google.android.gms.ads.mediation.customevent.c) this.f3232a.get(customEventAdapter.getAdditionalParametersType()));
        }
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.kk
    public final md c(String str) {
        return mi.a(str);
    }
}
