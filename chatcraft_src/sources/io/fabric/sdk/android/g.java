package io.fabric.sdk.android;

import io.fabric.sdk.android.services.b.w;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

/* compiled from: InitializationTask.java */
/* loaded from: classes.dex */
class g<Result> extends io.fabric.sdk.android.services.concurrency.f<Void, Void, Result> {

    /* renamed from: a, reason: collision with root package name */
    final h<Result> f4193a;

    public g(h<Result> hVar) {
        this.f4193a = hVar;
    }

    @Override // io.fabric.sdk.android.services.concurrency.a
    protected void a() {
        super.a();
        w wVarA = a("onPreExecute");
        try {
            try {
                boolean zB_ = this.f4193a.b_();
                wVarA.b();
                if (zB_) {
                    return;
                }
            } catch (UnmetDependencyException e) {
                throw e;
            } catch (Exception e2) {
                c.g().e("Fabric", "Failure onPreExecute()", e2);
                wVarA.b();
            }
            a(true);
        } catch (Throwable th) {
            wVarA.b();
            a(true);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.services.concurrency.a
    public Result a(Void... voidArr) {
        w wVarA = a("doInBackground");
        Result resultF = !e() ? this.f4193a.f() : null;
        wVarA.b();
        return resultF;
    }

    @Override // io.fabric.sdk.android.services.concurrency.a
    protected void a(Result result) {
        this.f4193a.a((h<Result>) result);
        this.f4193a.h.a((f<Result>) result);
    }

    @Override // io.fabric.sdk.android.services.concurrency.a
    protected void b(Result result) {
        this.f4193a.b((h<Result>) result);
        this.f4193a.h.a(new InitializationException(this.f4193a.b() + " Initialization was cancelled"));
    }

    @Override // io.fabric.sdk.android.services.concurrency.f, io.fabric.sdk.android.services.concurrency.i
    public io.fabric.sdk.android.services.concurrency.e b() {
        return io.fabric.sdk.android.services.concurrency.e.HIGH;
    }

    private w a(String str) {
        w wVar = new w(this.f4193a.b() + "." + str, "KitInitialization");
        wVar.a();
        return wVar;
    }
}
