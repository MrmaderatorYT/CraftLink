package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.eb;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class blc<T> implements Comparable<blc<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final eb.a f2793a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2794b;
    private final String c;
    private final int d;
    private final Object e;
    private bsh f;
    private Integer g;
    private bpg h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private ab m;
    private awj n;
    private bne o;

    public blc(int i, String str, bsh bshVar) {
        Uri uri;
        String host;
        this.f2793a = eb.a.f3059a ? new eb.a() : null;
        this.e = new Object();
        this.i = true;
        int iHashCode = 0;
        this.j = false;
        this.k = false;
        this.l = false;
        this.n = null;
        this.f2794b = i;
        this.c = str;
        this.f = bshVar;
        this.m = new bbe();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.d = iHashCode;
    }

    protected abstract brg<T> a(bje bjeVar);

    protected abstract void a(T t);

    public byte[] a() {
        return null;
    }

    public final int c() {
        return this.f2794b;
    }

    public final int d() {
        return this.d;
    }

    public final void b(String str) {
        if (eb.a.f3059a) {
            this.f2793a.a(str, Thread.currentThread().getId());
        }
    }

    final void c(String str) {
        if (this.h != null) {
            this.h.b(this);
        }
        if (eb.a.f3059a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new bmd(this, str, id));
            } else {
                this.f2793a.a(str, id);
                this.f2793a.a(toString());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final blc<?> a(bpg bpgVar) {
        this.h = bpgVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final blc<?> a(int i) {
        this.g = Integer.valueOf(i);
        return this;
    }

    public final String e() {
        return this.c;
    }

    public final String f() {
        String str = this.c;
        int i = this.f2794b;
        if (i == 0 || i == -1) {
            return str;
        }
        String string = Integer.toString(i);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(str).length());
        sb.append(string);
        sb.append('-');
        sb.append(str);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final blc<?> a(awj awjVar) {
        this.n = awjVar;
        return this;
    }

    public final awj g() {
        return this.n;
    }

    public final boolean h() {
        synchronized (this.e) {
        }
        return false;
    }

    public Map<String, String> b() {
        return Collections.emptyMap();
    }

    public final boolean i() {
        return this.i;
    }

    public final int j() {
        return this.m.a();
    }

    public final ab k() {
        return this.m;
    }

    public final void l() {
        synchronized (this.e) {
            this.k = true;
        }
    }

    public final boolean m() {
        boolean z;
        synchronized (this.e) {
            z = this.k;
        }
        return z;
    }

    public final void a(zzae zzaeVar) {
        bsh bshVar;
        synchronized (this.e) {
            bshVar = this.f;
        }
        if (bshVar != null) {
            bshVar.a(zzaeVar);
        }
    }

    final void a(bne bneVar) {
        synchronized (this.e) {
            this.o = bneVar;
        }
    }

    final void a(brg<?> brgVar) {
        bne bneVar;
        synchronized (this.e) {
            bneVar = this.o;
        }
        if (bneVar != null) {
            bneVar.a(this, brgVar);
        }
    }

    final void n() {
        bne bneVar;
        synchronized (this.e) {
            bneVar = this.o;
        }
        if (bneVar != null) {
            bneVar.a(this);
        }
    }

    public String toString() {
        String strValueOf = String.valueOf(Integer.toHexString(this.d));
        String strConcat = strValueOf.length() != 0 ? "0x".concat(strValueOf) : new String("0x");
        h();
        String str = this.c;
        String strValueOf2 = String.valueOf(bof.NORMAL);
        String strValueOf3 = String.valueOf(this.g);
        StringBuilder sb = new StringBuilder(String.valueOf("[ ] ").length() + 3 + String.valueOf(str).length() + String.valueOf(strConcat).length() + String.valueOf(strValueOf2).length() + String.valueOf(strValueOf3).length());
        sb.append("[ ] ");
        sb.append(str);
        sb.append(" ");
        sb.append(strConcat);
        sb.append(" ");
        sb.append(strValueOf2);
        sb.append(" ");
        sb.append(strValueOf3);
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        blc blcVar = (blc) obj;
        bof bofVar = bof.NORMAL;
        bof bofVar2 = bof.NORMAL;
        return bofVar == bofVar2 ? this.g.intValue() - blcVar.g.intValue() : bofVar2.ordinal() - bofVar.ordinal();
    }
}
