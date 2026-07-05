package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.t;
import javax.annotation.concurrent.GuardedBy;

@Deprecated
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1691a = new Object();

    /* renamed from: b, reason: collision with root package name */
    @GuardedBy("sLock")
    private static a f1692b;
    private final String c;
    private final Status d;
    private final boolean e;
    private final boolean f;

    a(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(g.a.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            z = resources.getInteger(identifier) != 0;
            this.f = !z;
        } else {
            this.f = false;
        }
        this.e = z;
        String strA = t.a(context);
        strA = strA == null ? new j(context).a("google_app_id") : strA;
        if (TextUtils.isEmpty(strA)) {
            this.d = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.c = null;
        } else {
            this.c = strA;
            this.d = Status.f1688a;
        }
    }

    public static Status a(Context context) {
        Status status;
        i.a(context, "Context must not be null.");
        synchronized (f1691a) {
            if (f1692b == null) {
                f1692b = new a(context);
            }
            status = f1692b.d;
        }
        return status;
    }

    public static String a() {
        return a("getGoogleAppId").c;
    }

    private static a a(String str) {
        a aVar;
        synchronized (f1691a) {
            if (f1692b == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
            aVar = f1692b;
        }
        return aVar;
    }
}
