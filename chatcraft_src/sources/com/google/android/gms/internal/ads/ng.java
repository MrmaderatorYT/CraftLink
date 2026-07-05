package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Map;
import org.json.JSONException;

@qj
/* loaded from: classes.dex */
public final class ng extends nh implements com.google.android.gms.ads.internal.gmsg.ac<afu> {

    /* renamed from: a, reason: collision with root package name */
    private final afu f3299a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f3300b;
    private final WindowManager c;
    private final bue d;
    private DisplayMetrics e;
    private float f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    public ng(afu afuVar, Context context, bue bueVar) {
        super(afuVar);
        this.g = -1;
        this.h = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.f3299a = afuVar;
        this.f3300b = context;
        this.d = bueVar;
        this.c = (WindowManager) context.getSystemService("window");
    }

    public final void a(int i, int i2) {
        int i3 = this.f3300b instanceof Activity ? com.google.android.gms.ads.internal.ax.e().c((Activity) this.f3300b)[0] : 0;
        if (this.f3299a.u() == null || !this.f3299a.u().e()) {
            bra.a();
            this.l = aac.b(this.f3300b, this.f3299a.getWidth());
            bra.a();
            this.m = aac.b(this.f3300b, this.f3299a.getHeight());
        }
        b(i, i2 - i3, this.l, this.m);
        this.f3299a.w().a(i, i2);
    }

    @Override // com.google.android.gms.ads.internal.gmsg.ac
    public final /* synthetic */ void zza(afu afuVar, Map map) throws JSONException {
        this.e = new DisplayMetrics();
        Display defaultDisplay = this.c.getDefaultDisplay();
        defaultDisplay.getMetrics(this.e);
        this.f = this.e.density;
        this.i = defaultDisplay.getRotation();
        bra.a();
        this.g = aac.b(this.e, this.e.widthPixels);
        bra.a();
        this.h = aac.b(this.e, this.e.heightPixels);
        Activity activityD = this.f3299a.d();
        if (activityD == null || activityD.getWindow() == null) {
            this.j = this.g;
            this.k = this.h;
        } else {
            com.google.android.gms.ads.internal.ax.e();
            int[] iArrA = xn.a(activityD);
            bra.a();
            this.j = aac.b(this.e, iArrA[0]);
            bra.a();
            this.k = aac.b(this.e, iArrA[1]);
        }
        if (this.f3299a.u().e()) {
            this.l = this.g;
            this.m = this.h;
        } else {
            this.f3299a.measure(0, 0);
        }
        a(this.g, this.h, this.j, this.k, this.f, this.i);
        this.f3299a.a("onDeviceFeaturesReceived", new nd(new nf().b(this.d.a()).a(this.d.b()).c(this.d.d()).d(this.d.c()).e(true)).a());
        int[] iArr = new int[2];
        this.f3299a.getLocationOnScreen(iArr);
        bra.a();
        int iB = aac.b(this.f3300b, iArr[0]);
        bra.a();
        a(iB, aac.b(this.f3300b, iArr[1]));
        if (xe.a(2)) {
            xe.d("Dispatching Ready Event.");
        }
        b(this.f3299a.k().f1790a);
    }
}
