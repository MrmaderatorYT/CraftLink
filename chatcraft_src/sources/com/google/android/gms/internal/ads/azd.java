package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public abstract class azd implements Callable {

    /* renamed from: a, reason: collision with root package name */
    protected final axt f2414a;

    /* renamed from: b, reason: collision with root package name */
    protected final akp f2415b;
    protected Method c;
    private final String d = getClass().getSimpleName();
    private final String e;
    private final String f;
    private final int g;
    private final int h;

    public azd(axt axtVar, String str, String str2, akp akpVar, int i, int i2) {
        this.f2414a = axtVar;
        this.e = str;
        this.f = str2;
        this.f2415b = akpVar;
        this.g = i;
        this.h = i2;
    }

    protected abstract void a();

    @Override // java.util.concurrent.Callable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void call() {
        long jNanoTime;
        try {
            jNanoTime = System.nanoTime();
            this.c = this.f2414a.a(this.e, this.f);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        if (this.c == null) {
            return null;
        }
        a();
        awy awyVarH = this.f2414a.h();
        if (awyVarH != null && this.g != Integer.MIN_VALUE) {
            awyVarH.a(this.h, this.g, (System.nanoTime() - jNanoTime) / 1000);
        }
        return null;
    }
}
