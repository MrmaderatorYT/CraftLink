package com.google.android.gms.internal.ads;

import me.zhanghai.android.materialprogressbar.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public class nh {

    /* renamed from: a, reason: collision with root package name */
    private final afu f3301a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3302b;

    public nh(afu afuVar) {
        this(afuVar, BuildConfig.FLAVOR);
    }

    public nh(afu afuVar, String str) {
        this.f3301a = afuVar;
        this.f3302b = str;
    }

    public final void a(String str) throws JSONException {
        try {
            this.f3301a.a("onError", new JSONObject().put("message", str).put("action", this.f3302b));
        } catch (JSONException e) {
            xe.b("Error occurred while dispatching error event.", e);
        }
    }

    public final void b(String str) throws JSONException {
        try {
            this.f3301a.a("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            xe.b("Error occured while dispatching ready Event.", e);
        }
    }

    public final void a(int i, int i2, int i3, int i4) throws JSONException {
        try {
            this.f3301a.a("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            xe.b("Error occured while dispatching size change.", e);
        }
    }

    public final void b(int i, int i2, int i3, int i4) throws JSONException {
        try {
            this.f3301a.a("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            xe.b("Error occured while dispatching default position.", e);
        }
    }

    public final void c(String str) throws JSONException {
        try {
            this.f3301a.a("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            xe.b("Error occured while dispatching state change.", e);
        }
    }

    public final void a(int i, int i2, int i3, int i4, float f, int i5) throws JSONException {
        try {
            this.f3301a.a("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f).put("rotation", i5));
        } catch (JSONException e) {
            xe.b("Error occured while obtaining screen information.", e);
        }
    }
}
