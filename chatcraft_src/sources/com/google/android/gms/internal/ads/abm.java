package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@qj
/* loaded from: classes.dex */
final class abm {

    /* renamed from: a, reason: collision with root package name */
    private final Object f1811a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final List<Runnable> f1812b = new ArrayList();
    private boolean c = false;

    public final void a(final Runnable runnable, final Executor executor) {
        synchronized (this.f1811a) {
            if (this.c) {
                executor.execute(runnable);
            } else {
                this.f1812b.add(new Runnable(executor, runnable) { // from class: com.google.android.gms.internal.ads.abn

                    /* renamed from: a, reason: collision with root package name */
                    private final Executor f1813a;

                    /* renamed from: b, reason: collision with root package name */
                    private final Runnable f1814b;

                    {
                        this.f1813a = executor;
                        this.f1814b = runnable;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1813a.execute(this.f1814b);
                    }
                });
            }
        }
    }

    public final void a() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f1811a) {
            if (this.c) {
                return;
            }
            arrayList.addAll(this.f1812b);
            this.f1812b.clear();
            this.c = true;
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                ((Runnable) obj).run();
            }
        }
    }
}
