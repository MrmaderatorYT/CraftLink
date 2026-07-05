package com.google.android.material.c;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.c.c;

/* compiled from: CircularRevealWidget.java */
/* loaded from: classes.dex */
public interface d extends c.a {
    void a();

    void b();

    int getCircularRevealScrimColor();

    C0083d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(C0083d c0083d);

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: com.google.android.material.c.d$d, reason: collision with other inner class name */
    public static class C0083d {

        /* renamed from: a, reason: collision with root package name */
        public float f3777a;

        /* renamed from: b, reason: collision with root package name */
        public float f3778b;
        public float c;

        private C0083d() {
        }

        public C0083d(float f, float f2, float f3) {
            this.f3777a = f;
            this.f3778b = f2;
            this.c = f3;
        }

        public C0083d(C0083d c0083d) {
            this(c0083d.f3777a, c0083d.f3778b, c0083d.c);
        }

        public void a(float f, float f2, float f3) {
            this.f3777a = f;
            this.f3778b = f2;
            this.c = f3;
        }

        public void a(C0083d c0083d) {
            a(c0083d.f3777a, c0083d.f3778b, c0083d.c);
        }

        public boolean a() {
            return this.c == Float.MAX_VALUE;
        }
    }

    /* compiled from: CircularRevealWidget.java */
    public static class b extends Property<d, C0083d> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<d, C0083d> f3775a = new b("circularReveal");

        private b(String str) {
            super(C0083d.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0083d get(d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, C0083d c0083d) {
            dVar.setRevealInfo(c0083d);
        }
    }

    /* compiled from: CircularRevealWidget.java */
    public static class a implements TypeEvaluator<C0083d> {

        /* renamed from: a, reason: collision with root package name */
        public static final TypeEvaluator<C0083d> f3773a = new a();

        /* renamed from: b, reason: collision with root package name */
        private final C0083d f3774b = new C0083d();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0083d evaluate(float f, C0083d c0083d, C0083d c0083d2) {
            this.f3774b.a(com.google.android.material.e.a.a(c0083d.f3777a, c0083d2.f3777a, f), com.google.android.material.e.a.a(c0083d.f3778b, c0083d2.f3778b, f), com.google.android.material.e.a.a(c0083d.c, c0083d2.c, f));
            return this.f3774b;
        }
    }

    /* compiled from: CircularRevealWidget.java */
    public static class c extends Property<d, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<d, Integer> f3776a = new c("circularRevealScrimColor");

        private c(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }
}
