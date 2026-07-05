package io.netty.channel.a;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* compiled from: NioTask.java */
/* loaded from: classes.dex */
public interface f<C extends SelectableChannel> {
    void a(C c, Throwable th);

    void a(C c, SelectionKey selectionKey);
}
