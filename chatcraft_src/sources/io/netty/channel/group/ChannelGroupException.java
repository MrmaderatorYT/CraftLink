package io.netty.channel.group;

import io.netty.channel.ChannelException;
import io.netty.channel.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class ChannelGroupException extends ChannelException implements Iterable<Map.Entry<d, Throwable>> {

    /* renamed from: a, reason: collision with root package name */
    private final Collection<Map.Entry<d, Throwable>> f4551a;

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<d, Throwable>> iterator() {
        return this.f4551a.iterator();
    }
}
