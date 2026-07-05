package org.xbill.DNS;

/* compiled from: ResolveThread.java */
/* loaded from: classes.dex */
class bu extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private au f5358a;

    /* renamed from: b, reason: collision with root package name */
    private Object f5359b;
    private bx c;
    private bv d;

    public bu(bv bvVar, au auVar, Object obj, bx bxVar) {
        this.d = bvVar;
        this.f5358a = auVar;
        this.f5359b = obj;
        this.c = bxVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.c.a(this.f5359b, this.d.a(this.f5358a));
        } catch (Exception e) {
            this.c.a(this.f5359b, e);
        }
    }
}
