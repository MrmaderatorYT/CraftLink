package io.netty.channel;

/* compiled from: WriteBufferWaterMark.java */
/* loaded from: classes.dex */
public final class bc {

    /* renamed from: a, reason: collision with root package name */
    public static final bc f4534a = new bc(32768, 65536, false);

    /* renamed from: b, reason: collision with root package name */
    private final int f4535b;
    private final int c;

    bc(int i, int i2, boolean z) {
        if (z) {
            if (i < 0) {
                throw new IllegalArgumentException("write buffer's low water mark must be >= 0");
            }
            if (i2 < i) {
                throw new IllegalArgumentException("write buffer's high water mark cannot be less than  low water mark (" + i + "): " + i2);
            }
        }
        this.f4535b = i;
        this.c = i2;
    }

    public int a() {
        return this.f4535b;
    }

    public int b() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(55);
        sb.append("WriteBufferWaterMark(low: ");
        sb.append(this.f4535b);
        sb.append(", high: ");
        sb.append(this.c);
        sb.append(")");
        return sb.toString();
    }
}
