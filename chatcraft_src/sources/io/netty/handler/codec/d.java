package io.netty.handler.codec;

import io.netty.channel.k;

/* compiled from: CodecUtil.java */
/* loaded from: classes.dex */
final class d {
    static void a(k kVar) {
        if (kVar.isSharable()) {
            throw new IllegalStateException("@Sharable annotation is not allowed");
        }
    }
}
