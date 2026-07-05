package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

@qj
/* loaded from: classes.dex */
public class bqr {

    /* renamed from: a, reason: collision with root package name */
    private final bqg f2979a;

    /* renamed from: b, reason: collision with root package name */
    private final bqf f2980b;
    private final bto c;
    private final ec d;
    private final ui e;
    private final vj f;
    private final nl g;
    private final ed h;

    public bqr(bqg bqgVar, bqf bqfVar, bto btoVar, ec ecVar, ui uiVar, vj vjVar, nl nlVar, ed edVar) {
        this.f2979a = bqgVar;
        this.f2980b = bqfVar;
        this.c = btoVar;
        this.d = ecVar;
        this.e = uiVar;
        this.f = vjVar;
        this.g = nlVar;
        this.h = edVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        bra.a().a(context, bra.g().f1790a, "gmob-apps", bundle, true);
    }

    public final brn a(Context context, String str, kk kkVar) {
        return new bqw(this, context, str, kkVar).a(context, false);
    }

    public final nm a(Activity activity) {
        bqt bqtVar = new bqt(this, activity);
        Intent intent = activity.getIntent();
        boolean booleanExtra = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            aan.c("useClientJar flag not found in activity intent extras.");
        } else {
            booleanExtra = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return bqtVar.a(activity, booleanExtra);
    }
}
