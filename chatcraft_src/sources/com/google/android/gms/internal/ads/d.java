package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public abstract class d<T> {

    /* renamed from: a, reason: collision with root package name */
    private final int f3051a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3052b;
    private final T c;

    private d(int i, String str, T t) {
        this.f3051a = i;
        this.f3052b = str;
        this.c = t;
        bra.d().a(this);
    }

    protected abstract T a(SharedPreferences sharedPreferences);

    protected abstract T a(JSONObject jSONObject);

    public abstract void a(SharedPreferences.Editor editor, T t);

    public final String a() {
        return this.f3052b;
    }

    public final T b() {
        return this.c;
    }

    public static d<Boolean> a(int i, String str, Boolean bool) {
        return new e(i, str, bool);
    }

    public static d<Integer> a(int i, String str, int i2) {
        return new f(i, str, Integer.valueOf(i2));
    }

    public static d<Long> a(int i, String str, long j) {
        return new g(i, str, Long.valueOf(j));
    }

    public static d<Float> a(int i, String str, float f) {
        return new h(i, str, Float.valueOf(f));
    }

    public static d<String> a(int i, String str, String str2) {
        return new i(i, str, str2);
    }

    public static d<String> a(int i, String str) {
        d<String> dVarA = a(i, str, (String) null);
        bra.d().b(dVarA);
        return dVarA;
    }

    public static d<String> b(int i, String str) {
        d<String> dVarA = a(i, str, (String) null);
        bra.d().c(dVarA);
        return dVarA;
    }

    public final int c() {
        return this.f3051a;
    }

    /* synthetic */ d(int i, String str, Object obj, e eVar) {
        this(i, str, obj);
    }
}
