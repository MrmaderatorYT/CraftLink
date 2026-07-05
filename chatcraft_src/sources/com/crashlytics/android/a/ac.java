package com.crashlytics.android.a;

/* compiled from: SessionEventMetadata.java */
/* loaded from: classes.dex */
final class ac {

    /* renamed from: a, reason: collision with root package name */
    public final String f1247a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1248b;
    public final String c;
    public final Boolean d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    private String k;

    public ac(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f1247a = str;
        this.f1248b = str2;
        this.c = str3;
        this.d = bool;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = str9;
    }

    public String toString() {
        if (this.k == null) {
            this.k = "appBundleId=" + this.f1247a + ", executionId=" + this.f1248b + ", installationId=" + this.c + ", limitAdTrackingEnabled=" + this.d + ", betaDeviceToken=" + this.e + ", buildId=" + this.f + ", osVersion=" + this.g + ", deviceModel=" + this.h + ", appVersionCode=" + this.i + ", appVersionName=" + this.j;
        }
        return this.k;
    }
}
