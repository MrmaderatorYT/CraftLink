package io.fabric.sdk.android.services.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import io.fabric.sdk.android.h;

/* compiled from: PreferenceStoreImpl.java */
/* loaded from: classes.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f4291a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4292b;
    private final Context c;

    public d(Context context, String str) {
        if (context == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.c = context;
        this.f4292b = str;
        this.f4291a = this.c.getSharedPreferences(this.f4292b, 0);
    }

    @Deprecated
    public d(h hVar) {
        this(hVar.r(), hVar.getClass().getName());
    }

    @Override // io.fabric.sdk.android.services.d.c
    public SharedPreferences a() {
        return this.f4291a;
    }

    @Override // io.fabric.sdk.android.services.d.c
    public SharedPreferences.Editor b() {
        return this.f4291a.edit();
    }

    @Override // io.fabric.sdk.android.services.d.c
    @TargetApi(9)
    public boolean a(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT >= 9) {
            editor.apply();
            return true;
        }
        return editor.commit();
    }
}
