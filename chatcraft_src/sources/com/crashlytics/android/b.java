package com.crashlytics.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.crashlytics.android.CrashlyticsInitProvider;

/* compiled from: ManifestEnabledCheckStrategy.java */
/* loaded from: classes.dex */
class b implements CrashlyticsInitProvider.a {
    b() {
    }

    @Override // com.crashlytics.android.CrashlyticsInitProvider.a
    public boolean a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                return bundle.getBoolean("firebase_crashlytics_collection_enabled", true);
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }
}
