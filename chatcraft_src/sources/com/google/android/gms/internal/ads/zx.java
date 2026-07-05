package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
final class zx implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f3648a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Context f3649b;

    zx(zv zvVar, Context context, Context context2) {
        this.f3648a = context;
        this.f3649b = context2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.f3648a != null) {
            xe.a("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.f3648a.getSharedPreferences("admob_user_agent", 0);
        } else {
            xe.a("Attempting to read user agent from local cache.");
            sharedPreferences = this.f3649b.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(string)) {
            xe.a("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.f3649b);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                xe.a("Persisting user agent.");
            }
        }
        return string;
    }
}
