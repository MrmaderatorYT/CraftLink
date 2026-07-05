package com.squareup.a;

import java.util.Map;
import java.util.Set;

/* compiled from: HandlerFinder.java */
/* loaded from: classes.dex */
interface f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f4095a = new f() { // from class: com.squareup.a.f.1
        @Override // com.squareup.a.f
        public Map<Class<?>, e> a(Object obj) {
            return a.a(obj);
        }

        @Override // com.squareup.a.f
        public Map<Class<?>, Set<d>> b(Object obj) {
            return a.b(obj);
        }
    };

    Map<Class<?>, e> a(Object obj);

    Map<Class<?>, Set<d>> b(Object obj);
}
