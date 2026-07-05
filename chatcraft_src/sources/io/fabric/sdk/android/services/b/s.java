package io.fabric.sdk.android.services.b;

import android.content.Context;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: InstallerPackageNameProvider.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private final io.fabric.sdk.android.services.a.d<String> f4233a = new io.fabric.sdk.android.services.a.d<String>() { // from class: io.fabric.sdk.android.services.b.s.1
        @Override // io.fabric.sdk.android.services.a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(Context context) {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? BuildConfig.FLAVOR : installerPackageName;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private final io.fabric.sdk.android.services.a.b<String> f4234b = new io.fabric.sdk.android.services.a.b<>();

    public String a(Context context) {
        try {
            String strA = this.f4234b.a(context, this.f4233a);
            if (BuildConfig.FLAVOR.equals(strA)) {
                return null;
            }
            return strA;
        } catch (Exception e) {
            io.fabric.sdk.android.c.g().e("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
