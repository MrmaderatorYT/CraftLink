package androidx.lifecycle;

import androidx.lifecycle.e;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements d {

    /* renamed from: a, reason: collision with root package name */
    private final b f898a;

    FullLifecycleObserverAdapter(b bVar) {
        this.f898a = bVar;
    }

    @Override // androidx.lifecycle.d
    public void a(g gVar, e.a aVar) {
        switch (aVar) {
            case ON_CREATE:
                this.f898a.a(gVar);
                return;
            case ON_START:
                this.f898a.b(gVar);
                return;
            case ON_RESUME:
                this.f898a.c(gVar);
                return;
            case ON_PAUSE:
                this.f898a.d(gVar);
                return;
            case ON_STOP:
                this.f898a.e(gVar);
                return;
            case ON_DESTROY:
                this.f898a.f(gVar);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
