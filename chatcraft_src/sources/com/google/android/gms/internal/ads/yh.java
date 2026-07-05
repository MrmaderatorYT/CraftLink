package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

@qj
/* loaded from: classes.dex */
public final class yh {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3598a = false;

    /* renamed from: b, reason: collision with root package name */
    private float f3599b = 1.0f;

    public final synchronized void a(float f) {
        this.f3599b = f;
    }

    public final synchronized float a() {
        if (!c()) {
            return 1.0f;
        }
        return this.f3599b;
    }

    public final synchronized void a(boolean z) {
        this.f3598a = z;
    }

    public final synchronized boolean b() {
        return this.f3598a;
    }

    private final synchronized boolean c() {
        return this.f3599b >= 0.0f;
    }

    public static float a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return streamVolume / streamMaxVolume;
    }
}
