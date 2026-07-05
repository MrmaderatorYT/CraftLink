package io.netty.channel.a;

import io.netty.channel.aj;
import io.netty.channel.ak;
import io.netty.channel.aq;
import io.netty.channel.au;
import io.netty.util.concurrent.aa;
import io.netty.util.concurrent.ab;
import java.nio.channels.spi.SelectorProvider;
import java.util.concurrent.Executor;

/* compiled from: NioEventLoopGroup.java */
/* loaded from: classes.dex */
public class e extends aq {
    public e() {
        this(0);
    }

    public e(int i) {
        this(i, (Executor) null);
    }

    public e(int i, Executor executor) {
        this(i, executor, SelectorProvider.provider());
    }

    public e(int i, Executor executor, SelectorProvider selectorProvider) {
        this(i, executor, selectorProvider, aj.f4481a);
    }

    public e(int i, Executor executor, SelectorProvider selectorProvider, au auVar) {
        super(i, executor, selectorProvider, auVar, ab.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.aq, io.netty.util.concurrent.u
    /* renamed from: a */
    public ak b(Executor executor, Object... objArr) {
        return new d(this, executor, (SelectorProvider) objArr[0], ((au) objArr[1]).a(), (aa) objArr[2]);
    }
}
