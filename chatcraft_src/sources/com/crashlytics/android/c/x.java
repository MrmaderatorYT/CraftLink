package com.crashlytics.android.c;

import android.content.Context;

/* compiled from: DialogStringResolver.java */
/* loaded from: classes.dex */
class x {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1433a;

    /* renamed from: b, reason: collision with root package name */
    private final io.fabric.sdk.android.services.e.o f1434b;

    public x(Context context, io.fabric.sdk.android.services.e.o oVar) {
        this.f1433a = context;
        this.f1434b = oVar;
    }

    public String a() {
        return a("com.crashlytics.CrashSubmissionPromptTitle", this.f1434b.f4310a);
    }

    public String b() {
        return a("com.crashlytics.CrashSubmissionPromptMessage", this.f1434b.f4311b);
    }

    public String c() {
        return a("com.crashlytics.CrashSubmissionSendTitle", this.f1434b.c);
    }

    public String d() {
        return a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.f1434b.g);
    }

    public String e() {
        return a("com.crashlytics.CrashSubmissionCancelTitle", this.f1434b.e);
    }

    private String a(String str, String str2) {
        return b(io.fabric.sdk.android.services.b.i.b(this.f1433a, str), str2);
    }

    private String b(String str, String str2) {
        return a(str) ? str2 : str;
    }

    private boolean a(String str) {
        return str == null || str.length() == 0;
    }
}
