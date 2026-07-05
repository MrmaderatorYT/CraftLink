package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class arw implements ase {

    /* renamed from: a, reason: collision with root package name */
    private ase[] f2218a;

    arw(ase... aseVarArr) {
        this.f2218a = aseVarArr;
    }

    @Override // com.google.android.gms.internal.ads.ase
    public final boolean a(Class<?> cls) {
        for (ase aseVar : this.f2218a) {
            if (aseVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.ase
    public final asd b(Class<?> cls) {
        for (ase aseVar : this.f2218a) {
            if (aseVar.a(cls)) {
                return aseVar.b(cls);
            }
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(strValueOf.length() != 0 ? "No factory is available for message type: ".concat(strValueOf) : new String("No factory is available for message type: "));
    }
}
