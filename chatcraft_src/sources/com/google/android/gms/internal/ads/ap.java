package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import java.lang.ref.WeakReference;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class ap implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    String f2133a;

    /* renamed from: b, reason: collision with root package name */
    Long f2134b;
    WeakReference<View> c;
    private final pn d;
    private dv e;
    private com.google.android.gms.ads.internal.gmsg.ac f;

    public ap(pn pnVar) {
        this.d = pnVar;
    }

    public final void a(dv dvVar) {
        this.e = dvVar;
        if (this.f != null) {
            this.d.b("/unconfirmedClick", this.f);
        }
        this.f = new aq(this);
        this.d.a("/unconfirmedClick", this.f);
    }

    public final dv a() {
        return this.e;
    }

    public final void b() {
        if (this.e == null || this.f2134b == null) {
            return;
        }
        c();
        try {
            this.e.a();
        } catch (RemoteException e) {
            aan.d("#007 Could not call remote method.", e);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws JSONException {
        if (this.c == null || this.c.get() != view) {
            return;
        }
        if (this.f2133a != null && this.f2134b != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f2133a);
                jSONObject.put("time_interval", com.google.android.gms.ads.internal.ax.l().a() - this.f2134b.longValue());
                jSONObject.put("messageType", "onePointFiveClick");
                this.d.a("sendMessageToNativeJs", jSONObject);
            } catch (JSONException e) {
                xe.b("Unable to dispatch sendMessageToNativeJs event", e);
            }
        }
        c();
    }

    private final void c() {
        this.f2133a = null;
        this.f2134b = null;
        if (this.c == null) {
            return;
        }
        View view = this.c.get();
        this.c = null;
        if (view == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
    }
}
