package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* loaded from: classes.dex */
final class bop extends PushbackInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ bom f2909a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bop(bom bomVar, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.f2909a = bomVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f2909a.f2903a.a();
        super.close();
    }
}
