package io.netty.channel;

/* compiled from: DefaultChannelHandlerContext.java */
/* loaded from: classes.dex */
final class ac extends b {
    private final j e;

    ac(ae aeVar, io.netty.util.concurrent.j jVar, String str, j jVar2) {
        super(aeVar, jVar, str, a(jVar2), b(jVar2));
        if (jVar2 == null) {
            throw new NullPointerException("handler");
        }
        this.e = jVar2;
    }

    @Override // io.netty.channel.l
    public j v() {
        return this.e;
    }

    private static boolean a(j jVar) {
        return jVar instanceof n;
    }

    private static boolean b(j jVar) {
        return jVar instanceof t;
    }
}
