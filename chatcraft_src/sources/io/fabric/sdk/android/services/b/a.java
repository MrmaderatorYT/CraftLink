package io.fabric.sdk.android.services.b;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: AbstractSpiCall.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f4200b = Pattern.compile("http(s?)://[^\\/]+", 2);

    /* renamed from: a, reason: collision with root package name */
    protected final io.fabric.sdk.android.h f4201a;
    private final String c;
    private final io.fabric.sdk.android.services.network.d d;
    private final io.fabric.sdk.android.services.network.c e;
    private final String f;

    public a(io.fabric.sdk.android.h hVar, String str, String str2, io.fabric.sdk.android.services.network.d dVar, io.fabric.sdk.android.services.network.c cVar) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (dVar == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
        this.f4201a = hVar;
        this.f = str;
        this.c = a(str2);
        this.d = dVar;
        this.e = cVar;
    }

    protected String a() {
        return this.c;
    }

    protected HttpRequest b() {
        return a(Collections.emptyMap());
    }

    protected HttpRequest a(Map<String, String> map) {
        return this.d.a(this.e, a(), map).a(false).a(10000).a("User-Agent", "Crashlytics Android SDK/" + this.f4201a.a()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    private String a(String str) {
        return !i.d(this.f) ? f4200b.matcher(str).replaceFirst(this.f) : str;
    }
}
