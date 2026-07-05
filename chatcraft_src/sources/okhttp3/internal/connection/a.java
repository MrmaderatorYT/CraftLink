package okhttp3.internal.connection;

import okhttp3.aa;
import okhttp3.internal.b.g;
import okhttp3.t;
import okhttp3.v;
import okhttp3.y;

/* compiled from: ConnectInterceptor.java */
/* loaded from: classes.dex */
public final class a implements t {

    /* renamed from: a, reason: collision with root package name */
    public final v f5134a;

    public a(v vVar) {
        this.f5134a = vVar;
    }

    @Override // okhttp3.t
    public aa a(t.a aVar) {
        g gVar = (g) aVar;
        y yVarA = gVar.a();
        f fVarF = gVar.f();
        return gVar.a(yVarA, fVarF, fVarF.a(this.f5134a, aVar, !yVarA.b().equals("GET")), fVarF.c());
    }
}
