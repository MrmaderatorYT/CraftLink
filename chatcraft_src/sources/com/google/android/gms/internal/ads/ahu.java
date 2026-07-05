package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Collections;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class ahu {

    /* renamed from: a, reason: collision with root package name */
    public final String f1995a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f1996b;
    public final Map<String, String> c;
    private final String d;

    @TargetApi(21)
    public ahu(WebResourceRequest webResourceRequest) {
        this(webResourceRequest.getUrl().toString(), webResourceRequest.getUrl(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
    }

    public ahu(String str) {
        this(str, Uri.parse(str), null, null);
    }

    private ahu(String str, Uri uri, @Nullable String str2, @Nullable Map<String, String> map) {
        this.f1995a = str;
        this.f1996b = uri;
        this.d = str2 == null ? "GET" : str2;
        this.c = map == null ? Collections.emptyMap() : map;
    }
}
