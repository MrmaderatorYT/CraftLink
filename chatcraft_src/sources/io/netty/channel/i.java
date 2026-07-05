package io.netty.channel;

/* compiled from: ChannelFutureListener.java */
/* loaded from: classes.dex */
public interface i extends io.netty.util.concurrent.r<h> {
    public static final i f = new i() { // from class: io.netty.channel.i.1
        @Override // io.netty.util.concurrent.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(h hVar) {
            hVar.e().j();
        }
    };
    public static final i g = new i() { // from class: io.netty.channel.i.2
        @Override // io.netty.util.concurrent.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(h hVar) {
            if (hVar.l()) {
                return;
            }
            hVar.e().j();
        }
    };
    public static final i h = new i() { // from class: io.netty.channel.i.3
        @Override // io.netty.util.concurrent.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(h hVar) {
            if (hVar.l()) {
                return;
            }
            hVar.e().d().a(hVar.k());
        }
    };
}
