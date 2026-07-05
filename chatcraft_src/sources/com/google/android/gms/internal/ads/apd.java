package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

/* loaded from: classes.dex */
final class apd extends aoz {
    apd() {
    }

    @Override // com.google.android.gms.internal.ads.aoz
    public final void a(Throwable th) {
        th.printStackTrace();
    }

    @Override // com.google.android.gms.internal.ads.aoz
    public final void a(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
    }
}
