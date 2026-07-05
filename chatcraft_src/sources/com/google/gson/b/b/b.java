package com.google.gson.b.b;

import com.google.gson.b.e;
import java.lang.reflect.AccessibleObject;

/* compiled from: ReflectionAccessor.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f3964a;

    public abstract void a(AccessibleObject accessibleObject);

    static {
        f3964a = e.a() < 9 ? new a() : new c();
    }

    public static b a() {
        return f3964a;
    }
}
