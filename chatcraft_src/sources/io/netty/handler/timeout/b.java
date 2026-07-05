package io.netty.handler.timeout;

import io.netty.util.a.j;

/* compiled from: IdleStateEvent.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f4591a = new b(a.READER_IDLE, true);

    /* renamed from: b, reason: collision with root package name */
    public static final b f4592b = new b(a.READER_IDLE, false);
    public static final b c = new b(a.WRITER_IDLE, true);
    public static final b d = new b(a.WRITER_IDLE, false);
    public static final b e = new b(a.ALL_IDLE, true);
    public static final b f = new b(a.ALL_IDLE, false);
    private final a g;
    private final boolean h;

    protected b(a aVar, boolean z) {
        this.g = (a) j.a(aVar, "state");
        this.h = z;
    }

    public a a() {
        return this.g;
    }
}
