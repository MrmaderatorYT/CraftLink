package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class ais implements b.a, b.InterfaceC0066b {

    /* renamed from: a, reason: collision with root package name */
    private ait f2007a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2008b;
    private final String c;
    private final LinkedBlockingQueue<akp> d;
    private final HandlerThread e = new HandlerThread("GassClient");

    public ais(Context context, String str, String str2) {
        this.f2008b = str;
        this.c = str2;
        this.e.start();
        this.f2007a = new ait(context, this.e.getLooper(), this, this);
        this.d = new LinkedBlockingQueue<>();
        this.f2007a.e();
    }

    public final akp b(int i) throws InterruptedException {
        akp akpVarPoll;
        try {
            akpVarPoll = this.d.poll(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            akpVarPoll = null;
        }
        return akpVarPoll == null ? c() : akpVarPoll;
    }

    private final aiy a() {
        try {
            return this.f2007a.t();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void a(int i) throws InterruptedException {
        try {
            this.d.put(c());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void a(Bundle bundle) {
        aiy aiyVarA = a();
        try {
            if (aiyVarA != null) {
                try {
                    try {
                        this.d.put(aiyVarA.a(new aiu(this.f2008b, this.c)).a());
                    } catch (InterruptedException unused) {
                    }
                } catch (Throwable unused2) {
                    this.d.put(c());
                }
            }
        } finally {
            b();
            this.e.quit();
        }
    }

    @Override // com.google.android.gms.common.internal.b.InterfaceC0066b
    public final void a(com.google.android.gms.common.b bVar) throws InterruptedException {
        try {
            this.d.put(c());
        } catch (InterruptedException unused) {
        }
    }

    private final void b() {
        if (this.f2007a != null) {
            if (this.f2007a.f() || this.f2007a.g()) {
                this.f2007a.h();
            }
        }
    }

    private static akp c() {
        akp akpVar = new akp();
        akpVar.k = 32768L;
        return akpVar;
    }
}
