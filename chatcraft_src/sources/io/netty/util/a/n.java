package io.netty.util.a;

import io.netty.util.concurrent.y;

/* compiled from: PromiseNotificationUtil.java */
/* loaded from: classes.dex */
public final class n {
    /* JADX WARN: Multi-variable type inference failed */
    public static <V> void a(y<? super V> yVar, V v, io.netty.util.a.b.c cVar) {
        if (yVar.b((y<? super V>) v) || cVar == null) {
            return;
        }
        Throwable thK = yVar.k();
        if (thK == null) {
            cVar.c("Failed to mark a promise as success because it has succeeded already: {}", yVar);
        } else {
            cVar.c("Failed to mark a promise as success because it has failed already: {}, unnotified cause:", yVar, thK);
        }
    }

    public static void a(y<?> yVar, Throwable th, io.netty.util.a.b.c cVar) {
        if (yVar.b(th) || cVar == null) {
            return;
        }
        Throwable thK = yVar.k();
        if (thK == null) {
            cVar.c("Failed to mark a promise as failure because it has succeeded already: {}", yVar, th);
        } else {
            cVar.b("Failed to mark a promise as failure because it has failed already: {}, unnotified cause: {}", yVar, s.a(thK), th);
        }
    }
}
