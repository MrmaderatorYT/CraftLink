package org.adw.library.widgets.discreteseekbar.a.a;

import android.os.Build;

/* compiled from: AnimatorCompat.java */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: AnimatorCompat.java */
    /* renamed from: org.adw.library.widgets.discreteseekbar.a.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0127a {
        void a(float f);
    }

    public abstract void a();

    public abstract void a(int i);

    public abstract boolean b();

    public abstract void c();

    a() {
    }

    public static final a a(float f, float f2, InterfaceC0127a interfaceC0127a) {
        if (Build.VERSION.SDK_INT >= 11) {
            return new org.adw.library.widgets.discreteseekbar.a.a.b(f, f2, interfaceC0127a);
        }
        return new b(f, f2, interfaceC0127a);
    }

    /* compiled from: AnimatorCompat.java */
    private static class b extends a {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0127a f5274a;

        /* renamed from: b, reason: collision with root package name */
        private final float f5275b;

        @Override // org.adw.library.widgets.discreteseekbar.a.a.a
        public void a() {
        }

        @Override // org.adw.library.widgets.discreteseekbar.a.a.a
        public void a(int i) {
        }

        @Override // org.adw.library.widgets.discreteseekbar.a.a.a
        public boolean b() {
            return false;
        }

        public b(float f, float f2, InterfaceC0127a interfaceC0127a) {
            this.f5274a = interfaceC0127a;
            this.f5275b = f2;
        }

        @Override // org.adw.library.widgets.discreteseekbar.a.a.a
        public void c() {
            this.f5274a.a(this.f5275b);
        }
    }
}
