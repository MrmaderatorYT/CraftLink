package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.e;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements d {

    /* renamed from: a, reason: collision with root package name */
    private final Object f905a;

    /* renamed from: b, reason: collision with root package name */
    private final a.C0052a f906b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f905a = obj;
        this.f906b = a.f908a.b(this.f905a.getClass());
    }

    @Override // androidx.lifecycle.d
    public void a(g gVar, e.a aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f906b.a(gVar, aVar, this.f905a);
    }
}
