package androidx.lifecycle;

/* compiled from: ViewModelProvider.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private final a f926a;

    /* renamed from: b, reason: collision with root package name */
    private final r f927b;

    /* compiled from: ViewModelProvider.java */
    public interface a {
        <T extends p> T a(Class<T> cls);
    }

    public q(r rVar, a aVar) {
        this.f926a = aVar;
        this.f927b = rVar;
    }

    public <T extends p> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public <T extends p> T a(String str, Class<T> cls) {
        T t = (T) this.f927b.a(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.f926a.a(cls);
        this.f927b.a(str, t2);
        return t2;
    }
}
