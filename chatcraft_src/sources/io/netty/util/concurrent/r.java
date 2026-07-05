package io.netty.util.concurrent;

import io.netty.util.concurrent.p;
import java.util.EventListener;

/* compiled from: GenericFutureListener.java */
/* loaded from: classes.dex */
public interface r<F extends p<?>> extends EventListener {
    void operationComplete(F f);
}
