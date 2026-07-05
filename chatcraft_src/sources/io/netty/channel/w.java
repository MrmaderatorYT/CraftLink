package io.netty.channel;

import java.util.Map;

/* compiled from: ChannelPipeline.java */
/* loaded from: classes.dex */
public interface w extends v, Iterable<Map.Entry<String, j>> {
    j a(String str);

    w a();

    w a(j jVar);

    w a(String str, j jVar);

    w a(String str, String str2, j jVar);

    w a(Throwable th);

    w a(j... jVarArr);

    j b(String str);

    j b(String str, String str2, j jVar);

    l b(j jVar);

    w b();

    w b(Object obj);

    w b(String str, j jVar);

    w c();

    w c(Object obj);

    w d();
}
