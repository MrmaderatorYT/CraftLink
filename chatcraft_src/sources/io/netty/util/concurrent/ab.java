package io.netty.util.concurrent;

import java.util.concurrent.RejectedExecutionException;

/* compiled from: RejectedExecutionHandlers.java */
/* loaded from: classes.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    private static final aa f4716a = new aa() { // from class: io.netty.util.concurrent.ab.1
        @Override // io.netty.util.concurrent.aa
        public void a(Runnable runnable, ae aeVar) {
            throw new RejectedExecutionException();
        }
    };

    public static aa a() {
        return f4716a;
    }
}
