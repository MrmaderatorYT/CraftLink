package com.nineoldandroids.a;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ObjectAnimator.java */
/* loaded from: classes.dex */
public final class g extends k {
    private static final Map<String, com.nineoldandroids.util.c> h = new HashMap();
    private Object i;
    private String j;
    private com.nineoldandroids.util.c k;

    static {
        h.put("alpha", h.f4072a);
        h.put("pivotX", h.f4073b);
        h.put("pivotY", h.c);
        h.put("translationX", h.d);
        h.put("translationY", h.e);
        h.put("rotation", h.f);
        h.put("rotationX", h.g);
        h.put("rotationY", h.h);
        h.put("scaleX", h.i);
        h.put("scaleY", h.j);
        h.put("scrollX", h.k);
        h.put("scrollY", h.l);
        h.put("x", h.m);
        h.put("y", h.n);
    }

    public void a(com.nineoldandroids.util.c cVar) {
        if (this.f != null) {
            i iVar = this.f[0];
            String strC = iVar.c();
            iVar.a(cVar);
            this.g.remove(strC);
            this.g.put(this.j, iVar);
        }
        if (this.k != null) {
            this.j = cVar.a();
        }
        this.k = cVar;
        this.e = false;
    }

    public g() {
    }

    private <T> g(T t, com.nineoldandroids.util.c<T, ?> cVar) {
        this.i = t;
        a(cVar);
    }

    public static <T> g a(T t, com.nineoldandroids.util.c<T, Integer> cVar, int... iArr) {
        g gVar = new g(t, cVar);
        gVar.a(iArr);
        return gVar;
    }

    @Override // com.nineoldandroids.a.k
    public void a(int... iArr) {
        if (this.f == null || this.f.length == 0) {
            if (this.k != null) {
                a(i.a((com.nineoldandroids.util.c<?, Integer>) this.k, iArr));
                return;
            } else {
                a(i.a(this.j, iArr));
                return;
            }
        }
        super.a(iArr);
    }

    @Override // com.nineoldandroids.a.k, com.nineoldandroids.a.a
    public void a() {
        super.a();
    }

    @Override // com.nineoldandroids.a.k
    void c() {
        if (this.e) {
            return;
        }
        if (this.k == null && com.nineoldandroids.b.a.a.f4077a && (this.i instanceof View) && h.containsKey(this.j)) {
            a(h.get(this.j));
        }
        int length = this.f.length;
        for (int i = 0; i < length; i++) {
            this.f[i].a(this.i);
        }
        super.c();
    }

    @Override // com.nineoldandroids.a.k
    void a(float f) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.a(f);
        int length = this.f.length;
        for (int i = 0; i < length; i++) {
            this.f[i].b(this.i);
        }
    }

    @Override // com.nineoldandroids.a.k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public g clone() {
        return (g) super.clone();
    }

    @Override // com.nineoldandroids.a.k
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.i;
        if (this.f != null) {
            for (int i = 0; i < this.f.length; i++) {
                str = str + "\n    " + this.f[i].toString();
            }
        }
        return str;
    }
}
