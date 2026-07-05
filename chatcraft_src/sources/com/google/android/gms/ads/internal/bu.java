package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.qj;
import com.google.android.gms.internal.ads.ro;
import com.google.android.gms.internal.ads.vv;
import com.google.android.gms.internal.ads.xn;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class bu {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1567a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f1568b;
    private vv c;
    private ro d;

    public bu(Context context, vv vvVar, ro roVar) {
        this.f1567a = context;
        this.c = vvVar;
        this.d = roVar;
        if (this.d == null) {
            this.d = new ro();
        }
    }

    private final boolean c() {
        return (this.c != null && this.c.a().f) || this.d.f3429a;
    }

    public final void a() {
        this.f1568b = true;
    }

    public final boolean b() {
        return !c() || this.f1568b;
    }

    public final void a(String str) {
        if (c()) {
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            if (this.c != null) {
                this.c.a(str, null, 3);
                return;
            }
            if (!this.d.f3429a || this.d.f3430b == null) {
                return;
            }
            for (String str2 : this.d.f3430b) {
                if (!TextUtils.isEmpty(str2)) {
                    String strReplace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    ax.e();
                    xn.a(this.f1567a, BuildConfig.FLAVOR, strReplace);
                }
            }
        }
    }
}
