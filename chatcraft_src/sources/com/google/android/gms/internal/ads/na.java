package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.c.a;
import java.util.Map;
import org.json.JSONException;

@qj
/* loaded from: classes.dex */
public final class na extends nh {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f3290a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f3291b;

    public na(afu afuVar, Map<String, String> map) {
        super(afuVar, "storePicture");
        this.f3290a = map;
        this.f3291b = afuVar.d();
    }

    public final void a() throws JSONException {
        if (this.f3291b == null) {
            a("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.ax.e();
        if (!xn.f(this.f3291b).c()) {
            a("Feature is not supported by the device.");
            return;
        }
        String str = this.f3290a.get("iurl");
        if (TextUtils.isEmpty(str)) {
            a("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            String strValueOf = String.valueOf(str);
            a(strValueOf.length() != 0 ? "Invalid image url: ".concat(strValueOf) : new String("Invalid image url: "));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        com.google.android.gms.ads.internal.ax.e();
        if (!xn.c(lastPathSegment)) {
            String strValueOf2 = String.valueOf(lastPathSegment);
            a(strValueOf2.length() != 0 ? "Image type not recognized: ".concat(strValueOf2) : new String("Image type not recognized: "));
            return;
        }
        Resources resourcesG = com.google.android.gms.ads.internal.ax.i().g();
        com.google.android.gms.ads.internal.ax.e();
        AlertDialog.Builder builderE = xn.e(this.f3291b);
        builderE.setTitle(resourcesG != null ? resourcesG.getString(a.C0065a.s1) : "Save image");
        builderE.setMessage(resourcesG != null ? resourcesG.getString(a.C0065a.s2) : "Allow Ad to store image in Picture gallery?");
        builderE.setPositiveButton(resourcesG != null ? resourcesG.getString(a.C0065a.s3) : "Accept", new nb(this, str, lastPathSegment));
        builderE.setNegativeButton(resourcesG != null ? resourcesG.getString(a.C0065a.s4) : "Decline", new nc(this));
        builderE.create().show();
    }
}
