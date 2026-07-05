package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: RealCall.java */
/* loaded from: classes.dex */
final class x implements e {

    /* renamed from: a, reason: collision with root package name */
    final v f5256a;

    /* renamed from: b, reason: collision with root package name */
    final okhttp3.internal.b.j f5257b;
    final y c;
    final boolean d;
    private p e;
    private boolean f;

    private x(v vVar, y yVar, boolean z) {
        this.f5256a = vVar;
        this.c = yVar;
        this.d = z;
        this.f5257b = new okhttp3.internal.b.j(vVar, z);
    }

    static x a(v vVar, y yVar, boolean z) {
        x xVar = new x(vVar, yVar, z);
        xVar.e = vVar.z().a(xVar);
        return xVar;
    }

    @Override // okhttp3.e
    public aa a() {
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f = true;
        }
        g();
        this.e.a(this);
        try {
            try {
                this.f5256a.u().a(this);
                aa aaVarF = f();
                if (aaVarF != null) {
                    return aaVarF;
                }
                throw new IOException("Canceled");
            } catch (IOException e) {
                this.e.a(this, e);
                throw e;
            }
        } finally {
            this.f5256a.u().b(this);
        }
    }

    private void g() {
        this.f5257b.a(okhttp3.internal.e.f.c().a("response.body().close()"));
    }

    public boolean b() {
        return this.f5257b.a();
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public x clone() {
        return a(this.f5256a, this.c, this.d);
    }

    /* compiled from: RealCall.java */
    final class a extends okhttp3.internal.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f5258a;
        private final f c;

        String a() {
            return this.f5258a.c.a().f();
        }

        x b() {
            return this.f5258a;
        }

        @Override // okhttp3.internal.b
        protected void c() {
            IOException e;
            aa aaVarF;
            boolean z = true;
            try {
                try {
                    aaVarF = this.f5258a.f();
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
                try {
                    if (this.f5258a.f5257b.a()) {
                        this.c.a(this.f5258a, new IOException("Canceled"));
                    } else {
                        this.c.a(this.f5258a, aaVarF);
                    }
                } catch (IOException e3) {
                    e = e3;
                    if (!z) {
                        this.f5258a.e.a(this.f5258a, e);
                        this.c.a(this.f5258a, e);
                    } else {
                        okhttp3.internal.e.f.c().a(4, "Callback failure for " + this.f5258a.d(), e);
                    }
                }
            } finally {
                this.f5258a.f5256a.u().a(this);
            }
        }
    }

    String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(b() ? "canceled " : BuildConfig.FLAVOR);
        sb.append(this.d ? "web socket" : "call");
        sb.append(" to ");
        sb.append(e());
        return sb.toString();
    }

    String e() {
        return this.c.a().m();
    }

    aa f() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f5256a.x());
        arrayList.add(this.f5257b);
        arrayList.add(new okhttp3.internal.b.a(this.f5256a.g()));
        arrayList.add(new okhttp3.internal.a.a(this.f5256a.i()));
        arrayList.add(new okhttp3.internal.connection.a(this.f5256a));
        if (!this.d) {
            arrayList.addAll(this.f5256a.y());
        }
        arrayList.add(new okhttp3.internal.b.b(this.d));
        return new okhttp3.internal.b.g(arrayList, null, null, null, 0, this.c, this, this.e, this.f5256a.a(), this.f5256a.b(), this.f5256a.c()).a(this.c);
    }
}
