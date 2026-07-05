package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzgx extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private final int f3670a;

    public zzgx(int i, int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder(82);
        sb.append("AudioTrack init failed: ");
        sb.append(i);
        sb.append(", Config(");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        sb.append(")");
        super(sb.toString());
        this.f3670a = i;
    }
}
