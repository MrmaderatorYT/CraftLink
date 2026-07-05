package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class am implements awf {

    /* renamed from: a, reason: collision with root package name */
    private androidx.browser.a.e f2063a;

    /* renamed from: b, reason: collision with root package name */
    private androidx.browser.a.b f2064b;
    private androidx.browser.a.d c;
    private an d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (listQueryIntentActivities != null && resolveInfoResolveActivity != null) {
            for (int i = 0; i < listQueryIntentActivities.size(); i++) {
                if (resolveInfoResolveActivity.activityInfo.name.equals(listQueryIntentActivities.get(i).activityInfo.name)) {
                    return resolveInfoResolveActivity.activityInfo.packageName.equals(awd.a(context));
                }
            }
        }
        return false;
    }

    public final void a(Activity activity) {
        if (this.c == null) {
            return;
        }
        activity.unbindService(this.c);
        this.f2064b = null;
        this.f2063a = null;
        this.c = null;
    }

    public final void a(an anVar) {
        this.d = anVar;
    }

    public final void b(Activity activity) {
        String strA;
        if (this.f2064b == null && (strA = awd.a(activity)) != null) {
            this.c = new awe(this);
            androidx.browser.a.b.a(activity, strA, this.c);
        }
    }

    public final boolean a(Uri uri, Bundle bundle, List<Bundle> list) {
        if (this.f2064b == null) {
            return false;
        }
        if (this.f2064b == null) {
            this.f2063a = null;
        } else if (this.f2063a == null) {
            this.f2063a = this.f2064b.a((androidx.browser.a.a) null);
        }
        androidx.browser.a.e eVar = this.f2063a;
        if (eVar == null) {
            return false;
        }
        return eVar.a(uri, null, null);
    }

    @Override // com.google.android.gms.internal.ads.awf
    public final void a(androidx.browser.a.b bVar) {
        this.f2064b = bVar;
        this.f2064b.a(0L);
        if (this.d != null) {
            this.d.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.awf
    public final void a() {
        this.f2064b = null;
        this.f2063a = null;
        if (this.d != null) {
            this.d.b();
        }
    }
}
