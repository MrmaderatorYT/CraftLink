package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

/* compiled from: ActivityCompat.java */
/* loaded from: classes.dex */
public class a extends androidx.core.a.a {

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC0035a f542a;

    /* compiled from: ActivityCompat.java */
    /* renamed from: androidx.core.app.a$a, reason: collision with other inner class name */
    public interface InterfaceC0035a {
        boolean a(Activity activity, int i, int i2, Intent intent);
    }

    public static InterfaceC0035a a() {
        return f542a;
    }

    public static void a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }
}
