package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONObject;

@qj
/* loaded from: classes.dex */
public final class jd {

    /* renamed from: b, reason: collision with root package name */
    private static final Charset f3192b = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public static final jb<JSONObject> f3191a = new jf();
    private static final iz<InputStream> c = je.f3193a;

    static final /* synthetic */ InputStream a(JSONObject jSONObject) {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(f3192b));
    }
}
