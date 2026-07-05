package com.crashlytics.android.c;

/* compiled from: TrimmedThrowableData.java */
/* loaded from: classes.dex */
class av {

    /* renamed from: a, reason: collision with root package name */
    public final String f1329a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1330b;
    public final StackTraceElement[] c;
    public final av d;

    public av(Throwable th, au auVar) {
        this.f1329a = th.getLocalizedMessage();
        this.f1330b = th.getClass().getName();
        this.c = auVar.a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.d = cause != null ? new av(cause, auVar) : null;
    }
}
