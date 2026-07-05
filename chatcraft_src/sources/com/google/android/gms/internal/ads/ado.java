package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;

@qj
@TargetApi(14)
/* loaded from: classes.dex */
public final class ado implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final AudioManager f1872a;

    /* renamed from: b, reason: collision with root package name */
    private final adp f1873b;
    private boolean c;
    private boolean d;
    private boolean e;
    private float f = 1.0f;

    public ado(Context context, adp adpVar) {
        this.f1872a = (AudioManager) context.getSystemService("audio");
        this.f1873b = adpVar;
    }

    public final void a(boolean z) {
        this.e = z;
        d();
    }

    public final void a(float f) {
        this.f = f;
        d();
    }

    public final float a() {
        float f = this.e ? 0.0f : this.f;
        if (this.c) {
            return f;
        }
        return 0.0f;
    }

    public final void b() {
        this.d = true;
        d();
    }

    public final void c() {
        this.d = false;
        d();
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        this.c = i > 0;
        this.f1873b.e();
    }

    private final void d() {
        boolean z = this.d && !this.e && this.f > 0.0f;
        if (z && !this.c) {
            if (this.f1872a != null && !this.c) {
                this.c = this.f1872a.requestAudioFocus(this, 3, 2) == 1;
            }
            this.f1873b.e();
            return;
        }
        if (z || !this.c) {
            return;
        }
        if (this.f1872a != null && this.c) {
            this.c = this.f1872a.abandonAudioFocus(this) == 0;
        }
        this.f1873b.e();
    }
}
