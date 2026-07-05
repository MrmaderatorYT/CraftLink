package com.crashlytics.android;

import com.crashlytics.android.c.l;
import io.fabric.sdk.android.c;
import io.fabric.sdk.android.h;
import io.fabric.sdk.android.i;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* compiled from: Crashlytics.java */
/* loaded from: classes.dex */
public class a extends h<Void> implements i {

    /* renamed from: a, reason: collision with root package name */
    public final com.crashlytics.android.a.b f1238a;

    /* renamed from: b, reason: collision with root package name */
    public final com.crashlytics.android.b.a f1239b;
    public final l c;
    public final Collection<? extends h> d;

    @Override // io.fabric.sdk.android.h
    public String a() {
        return "2.9.6.28";
    }

    @Override // io.fabric.sdk.android.h
    public String b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.h
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Void f() {
        return null;
    }

    public a() {
        this(new com.crashlytics.android.a.b(), new com.crashlytics.android.b.a(), new l());
    }

    a(com.crashlytics.android.a.b bVar, com.crashlytics.android.b.a aVar, l lVar) {
        this.f1238a = bVar;
        this.f1239b = aVar;
        this.c = lVar;
        this.d = Collections.unmodifiableCollection(Arrays.asList(bVar, aVar, lVar));
    }

    @Override // io.fabric.sdk.android.i
    public Collection<? extends h> c() {
        return this.d;
    }

    public static a e() {
        return (a) c.a(a.class);
    }

    public static void a(Throwable th) {
        g();
        e().c.a(th);
    }

    private static void g() {
        if (e() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }
}
