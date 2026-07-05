package io.fabric.sdk.android.services.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: AdvertisingInfoProvider.java */
/* loaded from: classes.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4204a;

    /* renamed from: b, reason: collision with root package name */
    private final io.fabric.sdk.android.services.d.c f4205b;

    public c(Context context) {
        this.f4204a = context.getApplicationContext();
        this.f4205b = new io.fabric.sdk.android.services.d.d(context, "TwitterAdvertisingInfoPreferences");
    }

    public b a() {
        b bVarB = b();
        if (c(bVarB)) {
            io.fabric.sdk.android.c.g().a("Fabric", "Using AdvertisingInfo from Preference Store");
            a(bVarB);
            return bVarB;
        }
        b bVarE = e();
        b(bVarE);
        return bVarE;
    }

    private void a(final b bVar) {
        new Thread(new h() { // from class: io.fabric.sdk.android.services.b.c.1
            @Override // io.fabric.sdk.android.services.b.h
            public void a() {
                b bVarE = c.this.e();
                if (bVar.equals(bVarE)) {
                    return;
                }
                io.fabric.sdk.android.c.g().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                c.this.b(bVarE);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public void b(b bVar) {
        if (c(bVar)) {
            this.f4205b.a(this.f4205b.b().putString("advertising_id", bVar.f4202a).putBoolean("limit_ad_tracking_enabled", bVar.f4203b));
        } else {
            this.f4205b.a(this.f4205b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    protected b b() {
        return new b(this.f4205b.a().getString("advertising_id", BuildConfig.FLAVOR), this.f4205b.a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public f c() {
        return new d(this.f4204a);
    }

    public f d() {
        return new e(this.f4204a);
    }

    private boolean c(b bVar) {
        return (bVar == null || TextUtils.isEmpty(bVar.f4202a)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b e() {
        b bVarA = c().a();
        if (!c(bVarA)) {
            bVarA = d().a();
            if (!c(bVarA)) {
                io.fabric.sdk.android.c.g().a("Fabric", "AdvertisingInfo not present");
            } else {
                io.fabric.sdk.android.c.g().a("Fabric", "Using AdvertisingInfo from Service Provider");
            }
        } else {
            io.fabric.sdk.android.c.g().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        }
        return bVarA;
    }
}
