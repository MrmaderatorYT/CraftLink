package com.google.android.gms.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.m;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final m f1462a;

    public static a a(Context context, String str, String str2, String str3, Bundle bundle) {
        return m.a(context, str, str2, str3, bundle).a();
    }

    public a(m mVar) {
        this.f1462a = mVar;
    }

    public void a(String str, String str2, Bundle bundle) {
        this.f1462a.a(str, str2, bundle);
    }

    public void a(String str, String str2, Object obj) {
        this.f1462a.a(str, str2, obj, true);
    }

    public Map<String, Object> a(String str, String str2, boolean z) {
        return this.f1462a.a(str, str2, z);
    }

    public void a(Bundle bundle) {
        this.f1462a.a(bundle);
    }

    public void b(String str, String str2, Bundle bundle) {
        this.f1462a.b(str, str2, bundle);
    }

    public List<Bundle> a(String str, String str2) {
        return this.f1462a.a(str, str2);
    }

    public String a() {
        return this.f1462a.e();
    }

    public String b() {
        return this.f1462a.f();
    }

    public String c() {
        return this.f1462a.c();
    }

    public String d() {
        return this.f1462a.b();
    }

    public long e() {
        return this.f1462a.d();
    }

    public void a(String str) {
        this.f1462a.a(str);
    }

    public void b(String str) {
        this.f1462a.b(str);
    }

    public Bundle b(Bundle bundle) {
        return this.f1462a.a(bundle, true);
    }

    public void c(Bundle bundle) {
        this.f1462a.a(bundle, false);
    }

    public int c(String str) {
        return this.f1462a.c(str);
    }

    public void a(Activity activity, String str, String str2) {
        this.f1462a.a(activity, str, str2);
    }

    public String f() {
        return this.f1462a.g();
    }
}
