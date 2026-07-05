package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.util.List;

/* loaded from: classes.dex */
final class apc extends aoz {

    /* renamed from: a, reason: collision with root package name */
    private final apa f2138a = new apa();

    apc() {
    }

    @Override // com.google.android.gms.internal.ads.aoz
    public final void a(Throwable th) {
        th.printStackTrace();
        List<Throwable> listA = this.f2138a.a(th, false);
        if (listA == null) {
            return;
        }
        synchronized (listA) {
            for (Throwable th2 : listA) {
                System.err.print("Suppressed: ");
                th2.printStackTrace();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.aoz
    public final void a(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
        List<Throwable> listA = this.f2138a.a(th, false);
        if (listA == null) {
            return;
        }
        synchronized (listA) {
            for (Throwable th2 : listA) {
                printWriter.print("Suppressed: ");
                th2.printStackTrace(printWriter);
            }
        }
    }
}
