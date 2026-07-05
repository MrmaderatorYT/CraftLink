package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzha extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private final int f3671a;

    public zzha(int i) {
        StringBuilder sb = new StringBuilder(36);
        sb.append("AudioTrack write failed: ");
        sb.append(i);
        super(sb.toString());
        this.f3671a = i;
    }
}
