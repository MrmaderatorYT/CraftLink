package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.c.a;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;

@qj
/* loaded from: classes.dex */
public final class mt extends nh {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f3277a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f3278b;
    private String c;
    private long d;
    private long e;
    private String f;
    private String g;

    public mt(afu afuVar, Map<String, String> map) {
        super(afuVar, "createCalendarEvent");
        this.f3277a = map;
        this.f3278b = afuVar.d();
        this.c = d("description");
        this.f = d("summary");
        this.d = e("start_ticks");
        this.e = e("end_ticks");
        this.g = d("location");
    }

    private final String d(String str) {
        return TextUtils.isEmpty(this.f3277a.get(str)) ? BuildConfig.FLAVOR : this.f3277a.get(str);
    }

    private final long e(String str) {
        String str2 = this.f3277a.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public final void a() throws JSONException {
        if (this.f3278b == null) {
            a("Activity context is not available.");
            return;
        }
        com.google.android.gms.ads.internal.ax.e();
        if (!xn.f(this.f3278b).d()) {
            a("This feature is not available on the device.");
            return;
        }
        com.google.android.gms.ads.internal.ax.e();
        AlertDialog.Builder builderE = xn.e(this.f3278b);
        Resources resourcesG = com.google.android.gms.ads.internal.ax.i().g();
        builderE.setTitle(resourcesG != null ? resourcesG.getString(a.C0065a.s5) : "Create calendar event");
        builderE.setMessage(resourcesG != null ? resourcesG.getString(a.C0065a.s6) : "Allow Ad to create a calendar event?");
        builderE.setPositiveButton(resourcesG != null ? resourcesG.getString(a.C0065a.s3) : "Accept", new mu(this));
        builderE.setNegativeButton(resourcesG != null ? resourcesG.getString(a.C0065a.s4) : "Decline", new mv(this));
        builderE.create().show();
    }

    @TargetApi(14)
    final Intent b() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.c);
        data.putExtra("eventLocation", this.g);
        data.putExtra("description", this.f);
        if (this.d > -1) {
            data.putExtra("beginTime", this.d);
        }
        if (this.e > -1) {
            data.putExtra("endTime", this.e);
        }
        data.setFlags(268435456);
        return data;
    }
}
