package io.fabric.sdk.android.services.b;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

/* compiled from: FirebaseInfo.java */
/* loaded from: classes.dex */
public class q {
    String a(Context context) {
        int iA = i.a(context, "google_app_id", "string");
        if (iA == 0) {
            return null;
        }
        io.fabric.sdk.android.c.g().a("Fabric", "Generating Crashlytics ApiKey from google_app_id in Strings");
        return a(context.getResources().getString(iA));
    }

    String a(String str) {
        return i.b(str).substring(0, 40);
    }

    public boolean b(Context context) {
        if (i.a(context, "com.crashlytics.useFirebaseAppId", false)) {
            return true;
        }
        return e(context) && !c(context);
    }

    boolean c(Context context) {
        if (TextUtils.isEmpty(new g().c(context))) {
            return !TextUtils.isEmpty(new g().d(context));
        }
        return true;
    }

    public boolean d(Context context) throws Resources.NotFoundException {
        int iA = i.a(context, "io.fabric.auto_initialize", "bool");
        if (iA == 0) {
            return false;
        }
        boolean z = context.getResources().getBoolean(iA);
        if (z) {
            io.fabric.sdk.android.c.g().a("Fabric", "Found Fabric auto-initialization flag for joint Firebase/Fabric customers");
        }
        return z;
    }

    boolean e(Context context) {
        if (i.a(context, "google_app_id", "string") == 0) {
            return false;
        }
        return !TextUtils.isEmpty(context.getResources().getString(r0));
    }

    public boolean f(Context context) {
        o oVarA = p.a(context);
        if (oVarA == null) {
            return true;
        }
        return oVarA.a();
    }
}
