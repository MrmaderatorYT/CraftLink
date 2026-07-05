package androidx.lifecycle;

import androidx.lifecycle.e;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: b, reason: collision with root package name */
    static final Object f900b = new Object();
    private boolean h;
    private boolean i;

    /* renamed from: a, reason: collision with root package name */
    final Object f901a = new Object();
    private androidx.a.a.b.b<m<? super T>, LiveData<T>.a> e = new androidx.a.a.b.b<>();
    int c = 0;
    private volatile Object f = f900b;
    volatile Object d = f900b;
    private int g = -1;
    private final Runnable j = new Runnable() { // from class: androidx.lifecycle.LiveData.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f901a) {
                obj = LiveData.this.d;
                LiveData.this.d = LiveData.f900b;
            }
            LiveData.this.a((LiveData) obj);
        }
    };

    protected void b() {
    }

    protected void c() {
    }

    private void b(LiveData<T>.a aVar) {
        if (aVar.d) {
            if (!aVar.a()) {
                aVar.a(false);
            } else {
                if (aVar.e >= this.g) {
                    return;
                }
                aVar.e = this.g;
                aVar.c.a((Object) this.f);
            }
        }
    }

    void a(LiveData<T>.a aVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (aVar != null) {
                b(aVar);
                aVar = null;
            } else {
                androidx.a.a.b.b<m<? super T>, LiveData<T>.a>.d dVarC = this.e.c();
                while (dVarC.hasNext()) {
                    b((a) dVarC.next().getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public void a(g gVar, m<? super T> mVar) {
        a("observe");
        if (gVar.g().a() == e.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(gVar, mVar);
        LiveData<T>.a aVarA = this.e.a(mVar, lifecycleBoundObserver);
        if (aVarA != null && !aVarA.a(gVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (aVarA != null) {
            return;
        }
        gVar.g().a(lifecycleBoundObserver);
    }

    public void a(m<? super T> mVar) {
        a("removeObserver");
        LiveData<T>.a aVarB = this.e.b(mVar);
        if (aVarB == null) {
            return;
        }
        aVarB.b();
        aVarB.a(false);
    }

    protected void a(T t) {
        a("setValue");
        this.g++;
        this.f = t;
        a((a) null);
    }

    public T a() {
        T t = (T) this.f;
        if (t != f900b) {
            return t;
        }
        return null;
    }

    public boolean d() {
        return this.c > 0;
    }

    class LifecycleBoundObserver extends LiveData<T>.a implements d {

        /* renamed from: a, reason: collision with root package name */
        final g f903a;

        LifecycleBoundObserver(g gVar, m<? super T> mVar) {
            super(mVar);
            this.f903a = gVar;
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean a() {
            return this.f903a.g().a().a(e.b.STARTED);
        }

        @Override // androidx.lifecycle.d
        public void a(g gVar, e.a aVar) {
            if (this.f903a.g().a() == e.b.DESTROYED) {
                LiveData.this.a((m) this.c);
            } else {
                a(a());
            }
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean a(g gVar) {
            return this.f903a == gVar;
        }

        @Override // androidx.lifecycle.LiveData.a
        void b() {
            this.f903a.g().b(this);
        }
    }

    private abstract class a {
        final m<? super T> c;
        boolean d;
        int e = -1;

        abstract boolean a();

        boolean a(g gVar) {
            return false;
        }

        void b() {
        }

        a(m<? super T> mVar) {
            this.c = mVar;
        }

        void a(boolean z) {
            if (z == this.d) {
                return;
            }
            this.d = z;
            boolean z2 = LiveData.this.c == 0;
            LiveData.this.c += this.d ? 1 : -1;
            if (z2 && this.d) {
                LiveData.this.b();
            }
            if (LiveData.this.c == 0 && !this.d) {
                LiveData.this.c();
            }
            if (this.d) {
                LiveData.this.a(this);
            }
        }
    }

    private static void a(String str) {
        if (androidx.a.a.a.a.a().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }
}
