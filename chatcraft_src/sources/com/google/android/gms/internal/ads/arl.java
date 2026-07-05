package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public class arl {

    /* renamed from: a, reason: collision with root package name */
    private static final aqk f2205a = aqk.a();

    /* renamed from: b, reason: collision with root package name */
    private apo f2206b;
    private volatile asf c;
    private volatile apo d;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof arl)) {
            return false;
        }
        arl arlVar = (arl) obj;
        asf asfVar = this.c;
        asf asfVar2 = arlVar.c;
        if (asfVar == null && asfVar2 == null) {
            return c().equals(arlVar.c());
        }
        if (asfVar != null && asfVar2 != null) {
            return asfVar.equals(asfVar2);
        }
        if (asfVar != null) {
            return asfVar.equals(arlVar.b(asfVar.q()));
        }
        return b(asfVar2.q()).equals(asfVar2);
    }

    private final asf b(asf asfVar) {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    try {
                        this.c = asfVar;
                        this.d = apo.f2149a;
                    } catch (zzbrl unused) {
                        this.c = asfVar;
                        this.d = apo.f2149a;
                    }
                }
            }
        }
        return this.c;
    }

    public final asf a(asf asfVar) {
        asf asfVar2 = this.c;
        this.f2206b = null;
        this.d = null;
        this.c = asfVar;
        return asfVar2;
    }

    public final int b() {
        if (this.d != null) {
            return this.d.a();
        }
        if (this.c != null) {
            return this.c.l();
        }
        return 0;
    }

    public final apo c() {
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d != null) {
                return this.d;
            }
            if (this.c == null) {
                this.d = apo.f2149a;
            } else {
                this.d = this.c.h();
            }
            return this.d;
        }
    }
}
