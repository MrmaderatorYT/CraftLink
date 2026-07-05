package com.google.android.gms.common.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.j;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1697a;

    public b(Context context) {
        this.f1697a = context;
    }

    public ApplicationInfo a(String str, int i) {
        return this.f1697a.getPackageManager().getApplicationInfo(str, i);
    }

    public PackageInfo b(String str, int i) {
        return this.f1697a.getPackageManager().getPackageInfo(str, i);
    }

    public int a(String str) {
        return this.f1697a.checkCallingOrSelfPermission(str);
    }

    public int a(String str, String str2) {
        return this.f1697a.getPackageManager().checkPermission(str, str2);
    }

    public boolean a() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return a.a(this.f1697a);
        }
        if (!j.k() || (nameForUid = this.f1697a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f1697a.getPackageManager().isInstantApp(nameForUid);
    }
}
