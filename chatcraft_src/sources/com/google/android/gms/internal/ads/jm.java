package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class jm implements com.google.android.gms.ads.internal.gmsg.g {

    /* renamed from: a, reason: collision with root package name */
    private final il f3202a;

    /* renamed from: b, reason: collision with root package name */
    private final abv f3203b;
    private final /* synthetic */ jj c;

    public jm(jj jjVar, il ilVar, abv abvVar) {
        this.c = jjVar;
        this.f3202a = ilVar;
        this.f3203b = abvVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.g
    public final void a(JSONObject jSONObject) {
        try {
            try {
                this.f3203b.b(this.c.f3196a.a(jSONObject));
                this.f3202a.a();
            } catch (IllegalStateException unused) {
                this.f3202a.a();
            } catch (JSONException e) {
                this.f3203b.b(e);
                this.f3202a.a();
            }
        } catch (Throwable th) {
            this.f3202a.a();
            throw th;
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.g
    public final void a(@Nullable String str) {
        try {
            if (str == null) {
                this.f3203b.a(new zzaju());
            } else {
                this.f3203b.a(new zzaju(str));
            }
            this.f3202a.a();
        } catch (IllegalStateException unused) {
            this.f3202a.a();
        } catch (Throwable th) {
            this.f3202a.a();
            throw th;
        }
    }
}
