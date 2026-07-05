package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.ac;

/* compiled from: RouteDatabase.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Set<ac> f5139a = new LinkedHashSet();

    public synchronized void a(ac acVar) {
        this.f5139a.add(acVar);
    }

    public synchronized void b(ac acVar) {
        this.f5139a.remove(acVar);
    }

    public synchronized boolean c(ac acVar) {
        return this.f5139a.contains(acVar);
    }
}
