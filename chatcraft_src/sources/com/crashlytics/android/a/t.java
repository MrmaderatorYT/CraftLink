package com.crashlytics.android.a;

import com.crashlytics.android.a.t;

/* compiled from: PredefinedEvent.java */
/* loaded from: classes.dex */
public abstract class t<T extends t> extends d<T> {
    final c c;

    abstract String a();

    public String toString() {
        return "{type:\"" + a() + "\", predefinedAttributes:" + this.c + ", customAttributes:" + this.f1254b + "}";
    }
}
