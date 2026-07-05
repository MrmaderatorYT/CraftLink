package io.netty.b;

import java.nio.ByteOrder;

/* compiled from: Unpooled.java */
/* loaded from: classes.dex */
public final class af {
    static final /* synthetic */ boolean d = !af.class.desiredAssertionStatus();
    private static final j e = ag.f4374b;

    /* renamed from: a, reason: collision with root package name */
    public static final ByteOrder f4372a = ByteOrder.BIG_ENDIAN;

    /* renamed from: b, reason: collision with root package name */
    public static final ByteOrder f4373b = ByteOrder.LITTLE_ENDIAN;
    public static final i c = e.a(0, 0);

    static {
        if (!d && !(c instanceof o)) {
            throw new AssertionError("EMPTY_BUFFER must be an EmptyByteBuf.");
        }
    }

    public static i a(byte[] bArr) {
        if (bArr.length == 0) {
            return c;
        }
        return new ai(e, bArr, bArr.length);
    }

    private af() {
    }
}
