package com.crashlytics.android.a;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

/* compiled from: SessionEvent.java */
/* loaded from: classes.dex */
final class ab {

    /* renamed from: a, reason: collision with root package name */
    public final ac f1241a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1242b;
    public final b c;
    public final Map<String, String> d;
    public final String e;
    public final Map<String, Object> f;
    public final String g;
    public final Map<String, Object> h;
    private String i;

    /* compiled from: SessionEvent.java */
    enum b {
        START,
        RESUME,
        PAUSE,
        STOP,
        CRASH,
        INSTALL,
        CUSTOM,
        PREDEFINED
    }

    public static a a(b bVar, Activity activity) {
        return new a(bVar).a(Collections.singletonMap("activity", activity.getClass().getName()));
    }

    public static a a(long j) {
        return new a(b.INSTALL).a(Collections.singletonMap("installedAt", String.valueOf(j)));
    }

    public static a a(String str) {
        return new a(b.CRASH).a(Collections.singletonMap("sessionId", str));
    }

    public static a a(String str, String str2) {
        return a(str).b(Collections.singletonMap("exceptionName", str2));
    }

    private ab(ac acVar, long j, b bVar, Map<String, String> map, String str, Map<String, Object> map2, String str2, Map<String, Object> map3) {
        this.f1241a = acVar;
        this.f1242b = j;
        this.c = bVar;
        this.d = map;
        this.e = str;
        this.f = map2;
        this.g = str2;
        this.h = map3;
    }

    /* compiled from: SessionEvent.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final b f1243a;

        /* renamed from: b, reason: collision with root package name */
        final long f1244b = System.currentTimeMillis();
        Map<String, String> c = null;
        String d = null;
        Map<String, Object> e = null;
        String f = null;
        Map<String, Object> g = null;

        public a(b bVar) {
            this.f1243a = bVar;
        }

        public a a(Map<String, String> map) {
            this.c = map;
            return this;
        }

        public a b(Map<String, Object> map) {
            this.e = map;
            return this;
        }

        public ab a(ac acVar) {
            return new ab(acVar, this.f1244b, this.f1243a, this.c, this.d, this.e, this.f, this.g);
        }
    }

    public String toString() {
        if (this.i == null) {
            this.i = "[" + getClass().getSimpleName() + ": timestamp=" + this.f1242b + ", type=" + this.c + ", details=" + this.d + ", customType=" + this.e + ", customAttributes=" + this.f + ", predefinedType=" + this.g + ", predefinedAttributes=" + this.h + ", metadata=[" + this.f1241a + "]]";
        }
        return this.i;
    }
}
