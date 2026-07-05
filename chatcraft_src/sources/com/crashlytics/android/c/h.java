package com.crashlytics.android.c;

/* compiled from: CompositeCreateReportSpiCall.java */
/* loaded from: classes.dex */
class h implements t {

    /* renamed from: a, reason: collision with root package name */
    private final v f1346a;

    /* renamed from: b, reason: collision with root package name */
    private final af f1347b;

    public h(v vVar, af afVar) {
        this.f1346a = vVar;
        this.f1347b = afVar;
    }

    @Override // com.crashlytics.android.c.t
    public boolean a(s sVar) throws Throwable {
        switch (sVar.f1426b.g()) {
            case JAVA:
                this.f1346a.a(sVar);
                break;
            case NATIVE:
                this.f1347b.a(sVar);
                break;
        }
        return true;
    }
}
