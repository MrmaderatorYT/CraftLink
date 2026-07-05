package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.btk;
import com.google.android.gms.internal.ads.btn;

/* loaded from: classes.dex */
public class h {
    public static void a(Context context, String str) {
        a(context, str, null);
    }

    @Deprecated
    public static void a(Context context, String str, a aVar) {
        btk.a().a(context, str, aVar == null ? null : aVar.a());
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final btn f1491a;

        final btn a() {
            return this.f1491a;
        }
    }
}
