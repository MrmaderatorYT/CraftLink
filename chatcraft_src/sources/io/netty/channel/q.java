package io.netty.channel;

/* compiled from: ChannelMetadata.java */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4552a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4553b;

    public q(boolean z) {
        this(z, 1);
    }

    public q(boolean z, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("defaultMaxMessagesPerRead: " + i + " (expected > 0)");
        }
        this.f4552a = z;
        this.f4553b = i;
    }

    public boolean a() {
        return this.f4552a;
    }

    public int b() {
        return this.f4553b;
    }
}
