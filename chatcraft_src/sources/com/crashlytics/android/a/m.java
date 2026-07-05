package com.crashlytics.android.a;

import android.content.Context;
import com.crashlytics.android.a.ab;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: EnabledSessionAnalyticsManagerStrategy.java */
/* loaded from: classes.dex */
class m implements aa {

    /* renamed from: a, reason: collision with root package name */
    final ac f1277a;

    /* renamed from: b, reason: collision with root package name */
    io.fabric.sdk.android.services.c.f f1278b;
    private final io.fabric.sdk.android.h j;
    private final io.fabric.sdk.android.services.network.d k;
    private final Context l;
    private final x m;
    private final ScheduledExecutorService n;
    private final p p;
    private final AtomicReference<ScheduledFuture<?>> o = new AtomicReference<>();
    io.fabric.sdk.android.services.b.g c = new io.fabric.sdk.android.services.b.g();
    n d = new s();
    boolean e = true;
    boolean f = true;
    volatile int g = -1;
    boolean h = false;
    boolean i = false;

    public m(io.fabric.sdk.android.h hVar, Context context, ScheduledExecutorService scheduledExecutorService, x xVar, io.fabric.sdk.android.services.network.d dVar, ac acVar, p pVar) {
        this.j = hVar;
        this.l = context;
        this.n = scheduledExecutorService;
        this.m = xVar;
        this.k = dVar;
        this.f1277a = acVar;
        this.p = pVar;
    }

    @Override // com.crashlytics.android.a.aa
    public void a(io.fabric.sdk.android.services.e.b bVar, String str) {
        this.f1278b = i.a(new y(this.j, str, bVar.f4293a, this.k, this.c.a(this.l)));
        this.m.a(bVar);
        this.h = bVar.f;
        this.i = bVar.g;
        io.fabric.sdk.android.k kVarG = io.fabric.sdk.android.c.g();
        StringBuilder sb = new StringBuilder();
        sb.append("Firebase analytics forwarding ");
        sb.append(this.h ? "enabled" : "disabled");
        kVarG.a("Answers", sb.toString());
        io.fabric.sdk.android.k kVarG2 = io.fabric.sdk.android.c.g();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Firebase analytics including purchase events ");
        sb2.append(this.i ? "enabled" : "disabled");
        kVarG2.a("Answers", sb2.toString());
        this.e = bVar.h;
        io.fabric.sdk.android.k kVarG3 = io.fabric.sdk.android.c.g();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Custom event tracking ");
        sb3.append(this.e ? "enabled" : "disabled");
        kVarG3.a("Answers", sb3.toString());
        this.f = bVar.i;
        io.fabric.sdk.android.k kVarG4 = io.fabric.sdk.android.c.g();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Predefined event tracking ");
        sb4.append(this.f ? "enabled" : "disabled");
        kVarG4.a("Answers", sb4.toString());
        if (bVar.k > 1) {
            io.fabric.sdk.android.c.g().a("Answers", "Event sampling enabled");
            this.d = new w(bVar.k);
        }
        this.g = bVar.f4294b;
        a(0L, this.g);
    }

    @Override // com.crashlytics.android.a.aa
    public void a(ab.a aVar) {
        ab abVarA = aVar.a(this.f1277a);
        if (!this.e && ab.b.CUSTOM.equals(abVarA.c)) {
            io.fabric.sdk.android.c.g().a("Answers", "Custom events tracking disabled - skipping event: " + abVarA);
            return;
        }
        if (!this.f && ab.b.PREDEFINED.equals(abVarA.c)) {
            io.fabric.sdk.android.c.g().a("Answers", "Predefined events tracking disabled - skipping event: " + abVarA);
            return;
        }
        if (this.d.a(abVarA)) {
            io.fabric.sdk.android.c.g().a("Answers", "Skipping filtered event: " + abVarA);
            return;
        }
        try {
            this.m.a((x) abVarA);
        } catch (IOException e) {
            io.fabric.sdk.android.c.g().e("Answers", "Failed to write event: " + abVarA, e);
        }
        e();
        boolean z = ab.b.CUSTOM.equals(abVarA.c) || ab.b.PREDEFINED.equals(abVarA.c);
        boolean zEquals = "purchase".equals(abVarA.g);
        if (this.h && z) {
            if (!zEquals || this.i) {
                try {
                    this.p.a(abVarA);
                } catch (Exception e2) {
                    io.fabric.sdk.android.c.g().e("Answers", "Failed to map event to Firebase: " + abVarA, e2);
                }
            }
        }
    }

    public void e() {
        if (this.g != -1) {
            a(this.g, this.g);
        }
    }

    @Override // com.crashlytics.android.a.aa
    public void a() {
        if (this.f1278b == null) {
            io.fabric.sdk.android.services.b.i.a(this.l, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        io.fabric.sdk.android.services.b.i.a(this.l, "Sending all files");
        List<File> listE = this.m.e();
        int size = 0;
        while (listE.size() > 0) {
            try {
                io.fabric.sdk.android.services.b.i.a(this.l, String.format(Locale.US, "attempt to send batch of %d files", Integer.valueOf(listE.size())));
                boolean zA = this.f1278b.a(listE);
                if (zA) {
                    size += listE.size();
                    this.m.a(listE);
                }
                if (!zA) {
                    break;
                } else {
                    listE = this.m.e();
                }
            } catch (Exception e) {
                io.fabric.sdk.android.services.b.i.a(this.l, "Failed to send batch of analytics files to server: " + e.getMessage(), e);
            }
        }
        if (size == 0) {
            this.m.g();
        }
    }

    @Override // io.fabric.sdk.android.services.c.e
    public void d() {
        if (this.o.get() != null) {
            io.fabric.sdk.android.services.b.i.a(this.l, "Cancelling time-based rollover because no events are currently being generated.");
            this.o.get().cancel(false);
            this.o.set(null);
        }
    }

    @Override // com.crashlytics.android.a.aa
    public void b() {
        this.m.f();
    }

    @Override // io.fabric.sdk.android.services.c.e
    public boolean c() {
        try {
            return this.m.d();
        } catch (IOException e) {
            io.fabric.sdk.android.services.b.i.a(this.l, "Failed to roll file over.", e);
            return false;
        }
    }

    void a(long j, long j2) {
        if (this.o.get() == null) {
            io.fabric.sdk.android.services.c.i iVar = new io.fabric.sdk.android.services.c.i(this.l, this);
            io.fabric.sdk.android.services.b.i.a(this.l, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.o.set(this.n.scheduleAtFixedRate(iVar, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                io.fabric.sdk.android.services.b.i.a(this.l, "Failed to schedule time based file roll over", e);
            }
        }
    }
}
