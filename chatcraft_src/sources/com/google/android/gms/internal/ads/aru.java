package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.aqy;

/* loaded from: classes.dex */
final class aru implements asy {

    /* renamed from: b, reason: collision with root package name */
    private static final ase f2216b = new arv();

    /* renamed from: a, reason: collision with root package name */
    private final ase f2217a;

    public aru() {
        this(new arw(aqx.a(), a()));
    }

    private aru(ase aseVar) {
        this.f2217a = (ase) ara.a(aseVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.ads.asy
    public final <T> asx<T> a(Class<T> cls) {
        asz.a((Class<?>) cls);
        asd asdVarB = this.f2217a.b(cls);
        if (asdVarB.b()) {
            if (aqy.class.isAssignableFrom(cls)) {
                return asl.a(asz.c(), aqn.a(), asdVarB.c());
            }
            return asl.a(asz.a(), aqn.b(), asdVarB.c());
        }
        if (aqy.class.isAssignableFrom(cls)) {
            if (a(asdVarB)) {
                return asj.a(cls, asdVarB, asp.b(), aro.b(), asz.c(), aqn.a(), asc.b());
            }
            return asj.a(cls, asdVarB, asp.b(), aro.b(), asz.c(), (aql<?>) null, asc.b());
        }
        if (a(asdVarB)) {
            return asj.a(cls, asdVarB, asp.a(), aro.a(), asz.a(), aqn.b(), asc.a());
        }
        return asj.a(cls, asdVarB, asp.a(), aro.a(), asz.b(), (aql<?>) null, asc.a());
    }

    private static boolean a(asd asdVar) {
        return asdVar.a() == aqy.e.h;
    }

    private static ase a() {
        try {
            return (ase) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f2216b;
        }
    }
}
