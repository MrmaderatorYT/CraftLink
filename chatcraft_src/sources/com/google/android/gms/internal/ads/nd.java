package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class nd {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f3295a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f3296b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    private nd(nf nfVar) {
        this.f3295a = nfVar.f3297a;
        this.f3296b = nfVar.f3298b;
        this.c = nfVar.c;
        this.d = nfVar.d;
        this.e = nfVar.e;
    }

    public final JSONObject a() {
        try {
            return new JSONObject().put("sms", this.f3295a).put("tel", this.f3296b).put("calendar", this.c).put("storePicture", this.d).put("inlineVideo", this.e);
        } catch (JSONException e) {
            xe.b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
