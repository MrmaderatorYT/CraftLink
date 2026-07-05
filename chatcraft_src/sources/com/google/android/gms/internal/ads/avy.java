package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class avy extends awb {

    /* renamed from: a, reason: collision with root package name */
    private Logger f2330a;

    public avy(String str) {
        this.f2330a = Logger.getLogger(str);
    }

    @Override // com.google.android.gms.internal.ads.awb
    public final void a(String str) {
        this.f2330a.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", str);
    }
}
