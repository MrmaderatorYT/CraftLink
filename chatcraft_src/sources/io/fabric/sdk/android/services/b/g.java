package io.fabric.sdk.android.services.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: ApiKey.java */
/* loaded from: classes.dex */
public class g {
    protected String a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    public String a(Context context) {
        String strC = c(context);
        if (TextUtils.isEmpty(strC)) {
            strC = d(context);
        }
        if (TextUtils.isEmpty(strC)) {
            strC = b(context);
        }
        if (TextUtils.isEmpty(strC)) {
            e(context);
        }
        return strC;
    }

    protected String b(Context context) {
        return new q().a(context);
    }

    protected String c(Context context) {
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString("io.fabric.ApiKey");
            try {
                if ("@string/twitter_consumer_secret".equals(string)) {
                    io.fabric.sdk.android.c.g().a("Fabric", "Ignoring bad default value for Fabric ApiKey set by FirebaseUI-Auth");
                } else {
                    str = string;
                }
                if (str != null) {
                    return str;
                }
                io.fabric.sdk.android.c.g().a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                return bundle.getString("com.crashlytics.ApiKey");
            } catch (Exception e) {
                e = e;
                str = string;
                io.fabric.sdk.android.c.g().a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
                return str;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    protected String d(Context context) {
        int iA = i.a(context, "io.fabric.ApiKey", "string");
        if (iA == 0) {
            io.fabric.sdk.android.c.g().a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            iA = i.a(context, "com.crashlytics.ApiKey", "string");
        }
        if (iA != 0) {
            return context.getResources().getString(iA);
        }
        return null;
    }

    protected void e(Context context) {
        if (io.fabric.sdk.android.c.h() || i.i(context)) {
            throw new IllegalArgumentException(a());
        }
        io.fabric.sdk.android.c.g().e("Fabric", a());
    }
}
