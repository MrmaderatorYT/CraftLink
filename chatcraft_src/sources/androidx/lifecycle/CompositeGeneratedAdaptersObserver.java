package androidx.lifecycle;

import androidx.lifecycle.e;

/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements d {

    /* renamed from: a, reason: collision with root package name */
    private final c[] f897a;

    CompositeGeneratedAdaptersObserver(c[] cVarArr) {
        this.f897a = cVarArr;
    }

    @Override // androidx.lifecycle.d
    public void a(g gVar, e.a aVar) {
        k kVar = new k();
        for (c cVar : this.f897a) {
            cVar.a(gVar, aVar, false, kVar);
        }
        for (c cVar2 : this.f897a) {
            cVar2.a(gVar, aVar, true, kVar);
        }
    }
}
