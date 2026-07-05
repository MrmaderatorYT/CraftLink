package com.google.android.gms.internal.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import javax.annotation.Nonnull;

@qj
/* loaded from: classes.dex */
public final class btm extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(@Nonnull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        String str;
        Bundle bundleA = a(context);
        Boolean bool = null;
        if (bundleA != null) {
            try {
                str = (String) bundleA.get("com.google.android.gms.ads.APPLICATION_ID");
            } catch (ClassCastException unused) {
                aan.c("The com.google.android.gms.ads.APPLICATION_ID metadata must have a String value");
                str = null;
            }
            try {
                bool = (Boolean) bundleA.get("com.google.android.gms.ads.AD_MANAGER_APP");
            } catch (ClassCastException unused2) {
                aan.c("The com.google.android.gms.ads.AD_MANAGER_APP metadata must have a boolean value");
            }
        } else {
            str = null;
        }
        if ((bool == null || !bool.booleanValue()) && str == null) {
            throw new IllegalStateException("\n\n******************************************************************************\n* The Google Mobile Ads SDK was initialized incorrectly. AdMob publishers    *\n* should follow the instructions here: https://goo.gl/fQ2neu to add a valid  *\n* App ID inside the AndroidManifest. Google Ad Manager publishers should     *\n* follow instructions here: https://goo.gl/h17b6x.                           *\n******************************************************************************\n\n");
        }
        if (str != null) {
            if (!str.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$")) {
                throw new IllegalStateException("\n\n******************************************************************************\n* Invalid application ID. Follow instructions here: https://goo.gl/fQ2neu to *\n* find your app ID.                                                          *\n******************************************************************************\n\n");
            }
            String strValueOf = String.valueOf(str);
            aan.b(strValueOf.length() != 0 ? "Publisher provided Google AdMob App ID in manifest: ".concat(strValueOf) : new String("Publisher provided Google AdMob App ID in manifest: "));
            Bundle bundle = new Bundle();
            bundle.putBoolean("measurementEnabled", false);
            jp.a(context, str, bundle);
        }
        super.attachInfo(context, providerInfo);
    }

    private static Bundle a(Context context) {
        try {
            return com.google.android.gms.common.b.c.a(context).a(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            aan.b("Failed to load metadata: Package name not found", e);
            return null;
        } catch (NullPointerException e2) {
            aan.b("Failed to load metadata: Null pointer exception", e2);
            return null;
        }
    }
}
