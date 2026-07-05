package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

@TargetApi(17)
/* loaded from: classes.dex */
public final class bkm extends Surface {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f2767a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f2768b;
    private final boolean c;
    private final bko d;
    private boolean e;

    public static synchronized boolean a(Context context) {
        if (!f2768b) {
            if (bkg.f2760a >= 17) {
                boolean z = false;
                String strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                if (strEglQueryString != null && strEglQueryString.contains("EGL_EXT_protected_content")) {
                    if (!(bkg.f2760a == 24 && (bkg.d.startsWith("SM-G950") || bkg.d.startsWith("SM-G955")) && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
                        z = true;
                    }
                }
                f2767a = z;
            }
            f2768b = true;
        }
        return f2767a;
    }

    public static bkm a(Context context, boolean z) {
        if (bkg.f2760a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
        bjq.b(!z || a(context));
        return new bko().a(z);
    }

    private bkm(bko bkoVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.d = bkoVar;
        this.c = z;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.d) {
            if (!this.e) {
                this.d.a();
                this.e = true;
            }
        }
    }
}
