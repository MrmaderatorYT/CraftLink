package androidx.lifecycle;

import android.util.Log;
import androidx.lifecycle.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: LifecycleRegistry.java */
/* loaded from: classes.dex */
public class h extends e {
    private final WeakReference<g> c;

    /* renamed from: a, reason: collision with root package name */
    private androidx.a.a.b.a<f, a> f916a = new androidx.a.a.b.a<>();
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<e.b> g = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private e.b f917b = e.b.INITIALIZED;

    public h(g gVar) {
        this.c = new WeakReference<>(gVar);
    }

    public void a(e.b bVar) {
        b(bVar);
    }

    public void a(e.a aVar) {
        b(b(aVar));
    }

    private void b(e.b bVar) {
        if (this.f917b == bVar) {
            return;
        }
        this.f917b = bVar;
        if (this.e || this.d != 0) {
            this.f = true;
            return;
        }
        this.e = true;
        d();
        this.e = false;
    }

    private boolean b() {
        if (this.f916a.a() == 0) {
            return true;
        }
        e.b bVar = this.f916a.d().getValue().f920a;
        e.b bVar2 = this.f916a.e().getValue().f920a;
        return bVar == bVar2 && this.f917b == bVar2;
    }

    private e.b c(f fVar) {
        Map.Entry<f, a> entryD = this.f916a.d(fVar);
        return a(a(this.f917b, entryD != null ? entryD.getValue().f920a : null), this.g.isEmpty() ? null : this.g.get(this.g.size() - 1));
    }

    @Override // androidx.lifecycle.e
    public void a(f fVar) {
        g gVar;
        a aVar = new a(fVar, this.f917b == e.b.DESTROYED ? e.b.DESTROYED : e.b.INITIALIZED);
        if (this.f916a.a(fVar, aVar) == null && (gVar = this.c.get()) != null) {
            boolean z = this.d != 0 || this.e;
            e.b bVarC = c(fVar);
            this.d++;
            while (aVar.f920a.compareTo(bVarC) < 0 && this.f916a.c(fVar)) {
                c(aVar.f920a);
                aVar.a(gVar, e(aVar.f920a));
                c();
                bVarC = c(fVar);
            }
            if (!z) {
                d();
            }
            this.d--;
        }
    }

    private void c() {
        this.g.remove(this.g.size() - 1);
    }

    private void c(e.b bVar) {
        this.g.add(bVar);
    }

    @Override // androidx.lifecycle.e
    public void b(f fVar) {
        this.f916a.b(fVar);
    }

    @Override // androidx.lifecycle.e
    public e.b a() {
        return this.f917b;
    }

    static e.b b(e.a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return e.b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return e.b.STARTED;
            case ON_RESUME:
                return e.b.RESUMED;
            case ON_DESTROY:
                return e.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private static e.a d(e.b bVar) {
        switch (bVar) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return e.a.ON_DESTROY;
            case STARTED:
                return e.a.ON_STOP;
            case RESUMED:
                return e.a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    private static e.a e(e.b bVar) {
        switch (bVar) {
            case INITIALIZED:
            case DESTROYED:
                return e.a.ON_CREATE;
            case CREATED:
                return e.a.ON_START;
            case STARTED:
                return e.a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(g gVar) {
        androidx.a.a.b.b<f, a>.d dVarC = this.f916a.c();
        while (dVarC.hasNext() && !this.f) {
            Map.Entry next = dVarC.next();
            a aVar = (a) next.getValue();
            while (aVar.f920a.compareTo(this.f917b) < 0 && !this.f && this.f916a.c(next.getKey())) {
                c(aVar.f920a);
                aVar.a(gVar, e(aVar.f920a));
                c();
            }
        }
    }

    private void b(g gVar) {
        Iterator<Map.Entry<f, a>> itB = this.f916a.b();
        while (itB.hasNext() && !this.f) {
            Map.Entry<f, a> next = itB.next();
            a value = next.getValue();
            while (value.f920a.compareTo(this.f917b) > 0 && !this.f && this.f916a.c(next.getKey())) {
                e.a aVarD = d(value.f920a);
                c(b(aVarD));
                value.a(gVar, aVarD);
                c();
            }
        }
    }

    private void d() {
        g gVar = this.c.get();
        if (gVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!b()) {
            this.f = false;
            if (this.f917b.compareTo(this.f916a.d().getValue().f920a) < 0) {
                b(gVar);
            }
            Map.Entry<f, a> entryE = this.f916a.e();
            if (!this.f && entryE != null && this.f917b.compareTo(entryE.getValue().f920a) > 0) {
                a(gVar);
            }
        }
        this.f = false;
    }

    static e.b a(e.b bVar, e.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    /* compiled from: LifecycleRegistry.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        e.b f920a;

        /* renamed from: b, reason: collision with root package name */
        d f921b;

        a(f fVar, e.b bVar) {
            this.f921b = j.a(fVar);
            this.f920a = bVar;
        }

        void a(g gVar, e.a aVar) {
            e.b bVarB = h.b(aVar);
            this.f920a = h.a(this.f920a, bVarB);
            this.f921b.a(gVar, aVar);
            this.f920a = bVarB;
        }
    }
}
