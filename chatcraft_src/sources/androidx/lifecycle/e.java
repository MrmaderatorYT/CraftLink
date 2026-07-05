package androidx.lifecycle;

/* compiled from: Lifecycle.java */
/* loaded from: classes.dex */
public abstract class e {

    /* compiled from: Lifecycle.java */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    public abstract b a();

    public abstract void a(f fVar);

    public abstract void b(f fVar);

    /* compiled from: Lifecycle.java */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean a(b bVar) {
            return compareTo(bVar) >= 0;
        }
    }
}
