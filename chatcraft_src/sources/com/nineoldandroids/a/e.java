package com.nineoldandroids.a;

import android.view.animation.Interpolator;

/* compiled from: Keyframe.java */
/* loaded from: classes.dex */
public abstract class e implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    float f4068a;

    /* renamed from: b, reason: collision with root package name */
    Class f4069b;
    private Interpolator d = null;
    boolean c = false;

    public abstract void a(Object obj);

    public abstract Object b();

    @Override // 
    public abstract e e();

    public static e a(float f, int i) {
        return new a(f, i);
    }

    public static e a(float f) {
        return new a(f);
    }

    public boolean a() {
        return this.c;
    }

    public float c() {
        return this.f4068a;
    }

    public Interpolator d() {
        return this.d;
    }

    public void a(Interpolator interpolator) {
        this.d = interpolator;
    }

    /* compiled from: Keyframe.java */
    static class a extends e {
        int d;

        a(float f, int i) {
            this.f4068a = f;
            this.d = i;
            this.f4069b = Integer.TYPE;
            this.c = true;
        }

        a(float f) {
            this.f4068a = f;
            this.f4069b = Integer.TYPE;
        }

        public int f() {
            return this.d;
        }

        @Override // com.nineoldandroids.a.e
        public Object b() {
            return Integer.valueOf(this.d);
        }

        @Override // com.nineoldandroids.a.e
        public void a(Object obj) {
            if (obj == null || obj.getClass() != Integer.class) {
                return;
            }
            this.d = ((Integer) obj).intValue();
            this.c = true;
        }

        @Override // com.nineoldandroids.a.e
        /* renamed from: g, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a e() {
            a aVar = new a(c(), this.d);
            aVar.a(d());
            return aVar;
        }
    }
}
