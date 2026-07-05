package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import java.util.concurrent.Callable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class l implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context f;

    /* renamed from: a, reason: collision with root package name */
    private final Object f3233a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ConditionVariable f3234b = new ConditionVariable();
    private volatile boolean c = false;
    private volatile boolean d = false;
    private SharedPreferences e = null;
    private JSONObject g = new JSONObject();

    public final void a(Context context) {
        if (this.c) {
            return;
        }
        synchronized (this.f3233a) {
            if (this.c) {
                return;
            }
            if (!this.d) {
                this.d = true;
            }
            this.f = context.getApplicationContext() == null ? context : context.getApplicationContext();
            try {
                Context contextA = com.google.android.gms.common.e.a(context);
                if (contextA == null && context != null && (contextA = context.getApplicationContext()) == null) {
                    contextA = context;
                }
                if (contextA == null) {
                    return;
                }
                bra.c();
                this.e = contextA.getSharedPreferences("google_ads_flags", 0);
                if (this.e != null) {
                    this.e.registerOnSharedPreferenceChangeListener(this);
                }
                b();
                this.c = true;
            } finally {
                this.d = false;
                this.f3234b.open();
            }
        }
    }

    public final <T> T a(d<T> dVar) {
        if (!this.f3234b.block(5000L)) {
            synchronized (this.f3233a) {
                if (!this.d) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.c || this.e == null) {
            synchronized (this.f3233a) {
                if (this.c && this.e != null) {
                }
                return dVar.b();
            }
        }
        if (dVar.c() == 1 && this.g.has(dVar.a())) {
            return dVar.a(this.g);
        }
        return (T) zt.a(this.f, new n(this, dVar));
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            b();
        }
    }

    private final void b() {
        if (this.e == null) {
            return;
        }
        try {
            this.g = new JSONObject((String) zt.a(this.f, new Callable(this) { // from class: com.google.android.gms.internal.ads.m

                /* renamed from: a, reason: collision with root package name */
                private final l f3261a;

                {
                    this.f3261a = this;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f3261a.a();
                }
            }));
        } catch (JSONException unused) {
        }
    }

    final /* synthetic */ String a() {
        return this.e.getString("flag_configuration", "{}");
    }
}
