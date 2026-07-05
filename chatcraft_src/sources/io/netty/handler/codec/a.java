package io.netty.handler.codec;

import io.netty.b.i;
import io.netty.channel.f;
import io.netty.channel.l;
import io.netty.channel.z;
import io.netty.util.a.t;
import java.util.List;

/* compiled from: ByteToMessageCodec.java */
/* loaded from: classes.dex */
public abstract class a<I> extends f {
    private final b decoder;
    private final e<I> encoder;
    private final t outboundMsgMatcher;

    protected abstract void decode(l lVar, i iVar, List<Object> list);

    protected abstract void encode(l lVar, I i, i iVar);

    protected a() {
        this(true);
    }

    protected a(Class<? extends I> cls) {
        this(cls, true);
    }

    protected a(boolean z) {
        this.decoder = new b() { // from class: io.netty.handler.codec.a.1
            @Override // io.netty.handler.codec.b
            public void a(l lVar, i iVar, List<Object> list) {
                a.this.decode(lVar, iVar, list);
            }

            @Override // io.netty.handler.codec.b
            protected void b(l lVar, i iVar, List<Object> list) {
                a.this.decodeLast(lVar, iVar, list);
            }
        };
        d.a(this);
        this.outboundMsgMatcher = t.a(this, a.class, "I");
        this.encoder = new C0106a(z);
    }

    protected a(Class<? extends I> cls, boolean z) {
        this.decoder = new b() { // from class: io.netty.handler.codec.a.1
            @Override // io.netty.handler.codec.b
            public void a(l lVar, i iVar, List<Object> list) {
                a.this.decode(lVar, iVar, list);
            }

            @Override // io.netty.handler.codec.b
            protected void b(l lVar, i iVar, List<Object> list) {
                a.this.decodeLast(lVar, iVar, list);
            }
        };
        d.a(this);
        this.outboundMsgMatcher = t.a((Class<?>) cls);
        this.encoder = new C0106a(z);
    }

    public boolean acceptOutboundMessage(Object obj) {
        return this.outboundMsgMatcher.a(obj);
    }

    @Override // io.netty.channel.o, io.netty.channel.n
    public void channelRead(l lVar, Object obj) {
        this.decoder.channelRead(lVar, obj);
    }

    @Override // io.netty.channel.f, io.netty.channel.t
    public void write(l lVar, Object obj, z zVar) throws Throwable {
        this.encoder.write(lVar, obj, zVar);
    }

    @Override // io.netty.channel.o, io.netty.channel.n
    public void channelReadComplete(l lVar) {
        this.decoder.channelReadComplete(lVar);
    }

    @Override // io.netty.channel.o, io.netty.channel.n
    public void channelInactive(l lVar) {
        this.decoder.channelInactive(lVar);
    }

    @Override // io.netty.channel.k, io.netty.channel.j
    public void handlerAdded(l lVar) {
        try {
            this.decoder.handlerAdded(lVar);
        } finally {
            this.encoder.handlerAdded(lVar);
        }
    }

    @Override // io.netty.channel.k, io.netty.channel.j
    public void handlerRemoved(l lVar) {
        try {
            this.decoder.handlerRemoved(lVar);
        } finally {
            this.encoder.handlerRemoved(lVar);
        }
    }

    protected void decodeLast(l lVar, i iVar, List<Object> list) {
        if (iVar.e()) {
            decode(lVar, iVar, list);
        }
    }

    /* compiled from: ByteToMessageCodec.java */
    /* renamed from: io.netty.handler.codec.a$a, reason: collision with other inner class name */
    private final class C0106a extends e<I> {
        C0106a(boolean z) {
            super(z);
        }

        @Override // io.netty.handler.codec.e
        public boolean a(Object obj) {
            return a.this.acceptOutboundMessage(obj);
        }

        @Override // io.netty.handler.codec.e
        protected void a(l lVar, I i, i iVar) {
            a.this.encode(lVar, i, iVar);
        }
    }
}
