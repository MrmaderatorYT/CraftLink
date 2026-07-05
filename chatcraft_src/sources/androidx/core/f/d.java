package androidx.core.f;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public final class d {

    /* compiled from: Pools.java */
    public interface a<T> {
        T a();

        boolean a(T t);
    }

    /* compiled from: Pools.java */
    public static class b<T> implements a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Object[] f612a;

        /* renamed from: b, reason: collision with root package name */
        private int f613b;

        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f612a = new Object[i];
        }

        @Override // androidx.core.f.d.a
        public T a() {
            if (this.f613b <= 0) {
                return null;
            }
            int i = this.f613b - 1;
            T t = (T) this.f612a[i];
            this.f612a[i] = null;
            this.f613b--;
            return t;
        }

        @Override // androidx.core.f.d.a
        public boolean a(T t) {
            if (b(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            if (this.f613b >= this.f612a.length) {
                return false;
            }
            this.f612a[this.f613b] = t;
            this.f613b++;
            return true;
        }

        private boolean b(T t) {
            for (int i = 0; i < this.f613b; i++) {
                if (this.f612a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: Pools.java */
    public static class c<T> extends b<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f614a;

        public c(int i) {
            super(i);
            this.f614a = new Object();
        }

        @Override // androidx.core.f.d.b, androidx.core.f.d.a
        public T a() {
            T t;
            synchronized (this.f614a) {
                t = (T) super.a();
            }
            return t;
        }

        @Override // androidx.core.f.d.b, androidx.core.f.d.a
        public boolean a(T t) {
            boolean zA;
            synchronized (this.f614a) {
                zA = super.a(t);
            }
            return zA;
        }
    }
}
