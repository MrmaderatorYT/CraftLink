package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

@qj
/* loaded from: classes.dex */
public final class wm {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.common.util.c f3547a;

    /* renamed from: b, reason: collision with root package name */
    private final wy f3548b;
    private final String e;
    private final String f;
    private final Object d = new Object();

    @GuardedBy("mLock")
    private long g = -1;

    @GuardedBy("mLock")
    private long h = -1;

    @GuardedBy("mLock")
    private boolean i = false;

    @GuardedBy("mLock")
    private long j = -1;

    @GuardedBy("mLock")
    private long k = 0;

    @GuardedBy("mLock")
    private long l = -1;

    @GuardedBy("mLock")
    private long m = -1;

    @GuardedBy("mLock")
    private final LinkedList<wn> c = new LinkedList<>();

    wm(com.google.android.gms.common.util.c cVar, wy wyVar, String str, String str2) {
        this.f3547a = cVar;
        this.f3548b = wyVar;
        this.e = str;
        this.f = str2;
    }

    public final void a(bqj bqjVar) {
        synchronized (this.d) {
            this.l = this.f3547a.b();
            this.f3548b.a(bqjVar, this.l);
        }
    }

    public final void a(long j) {
        synchronized (this.d) {
            this.m = j;
            if (this.m != -1) {
                this.f3548b.a(this);
            }
        }
    }

    public final void b(long j) {
        synchronized (this.d) {
            if (this.m != -1) {
                this.g = j;
                this.f3548b.a(this);
            }
        }
    }

    public final void a() {
        synchronized (this.d) {
            if (this.m != -1 && this.h == -1) {
                this.h = this.f3547a.b();
                this.f3548b.a(this);
            }
            this.f3548b.b();
        }
    }

    public final void b() {
        synchronized (this.d) {
            if (this.m != -1) {
                wn wnVar = new wn(this);
                wnVar.c();
                this.c.add(wnVar);
                this.k++;
                this.f3548b.a();
                this.f3548b.a(this);
            }
        }
    }

    public final void c() {
        synchronized (this.d) {
            if (this.m != -1 && !this.c.isEmpty()) {
                wn last = this.c.getLast();
                if (last.a() == -1) {
                    last.b();
                    this.f3548b.a(this);
                }
            }
        }
    }

    public final void a(boolean z) {
        synchronized (this.d) {
            if (this.m != -1) {
                this.j = this.f3547a.b();
                if (!z) {
                    this.h = this.j;
                    this.f3548b.a(this);
                }
            }
        }
    }

    public final void b(boolean z) {
        synchronized (this.d) {
            if (this.m != -1) {
                this.i = z;
                this.f3548b.a(this);
            }
        }
    }

    public final Bundle d() {
        Bundle bundle;
        synchronized (this.d) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.e);
            bundle.putString("slotid", this.f);
            bundle.putBoolean("ismediation", this.i);
            bundle.putLong("treq", this.l);
            bundle.putLong("tresponse", this.m);
            bundle.putLong("timp", this.h);
            bundle.putLong("tload", this.j);
            bundle.putLong("pcc", this.k);
            bundle.putLong("tfetch", this.g);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<wn> it = this.c.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().d());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final String e() {
        return this.e;
    }
}
