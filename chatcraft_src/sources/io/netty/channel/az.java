package io.netty.channel;

/* compiled from: ThreadPerChannelEventLoop.java */
/* loaded from: classes.dex */
public class az extends ax {

    /* renamed from: b, reason: collision with root package name */
    private final ba f4488b;
    private d g;

    public az(ba baVar) {
        super(baVar, baVar.f4528a, true);
        this.f4488b = baVar;
    }

    @Override // io.netty.channel.ax, io.netty.channel.al
    public h a(z zVar) {
        return super.a(zVar).b(new i() { // from class: io.netty.channel.az.1
            @Override // io.netty.util.concurrent.r
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void operationComplete(h hVar) {
                if (hVar.l()) {
                    az.this.g = hVar.e();
                } else {
                    az.this.g();
                }
            }
        });
    }

    @Override // io.netty.util.concurrent.ae
    protected void f() {
        while (true) {
            Runnable runnableS = s();
            if (runnableS != null) {
                runnableS.run();
                u();
            }
            d dVar = this.g;
            if (D_()) {
                if (dVar != null) {
                    dVar.n().b(dVar.n().i());
                }
                if (v()) {
                    return;
                }
            } else if (dVar != null && !dVar.i()) {
                t();
                g();
            }
        }
    }

    protected void g() {
        this.g = null;
        this.f4488b.f4529b.remove(this);
        this.f4488b.c.add(this);
    }
}
