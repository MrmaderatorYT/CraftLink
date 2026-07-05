package io.netty.channel.b;

import io.netty.channel.ba;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: OioEventLoopGroup.java */
/* loaded from: classes.dex */
public class d extends ba {
    public d() {
        this(0);
    }

    public d(int i) {
        this(i, Executors.defaultThreadFactory());
    }

    public d(int i, ThreadFactory threadFactory) {
        super(i, threadFactory, new Object[0]);
    }
}
