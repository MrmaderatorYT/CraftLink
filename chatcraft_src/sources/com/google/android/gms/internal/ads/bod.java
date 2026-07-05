package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
/* loaded from: classes.dex */
public final class bod extends com.google.android.gms.common.internal.safeparcel.a {
    public static final Parcelable.Creator<bod> CREATOR = new boe();

    /* renamed from: a, reason: collision with root package name */
    public final String f2896a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2897b;
    public long c;
    private final long d;
    private final String e;
    private final String f;
    private final String g;
    private final Bundle h;

    public static bod a(String str) {
        return a(Uri.parse(str));
    }

    public static bod a(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                xe.e(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean zEquals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long j = queryParameter2 == null ? 0L : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            for (String str3 : com.google.android.gms.ads.internal.ax.g().a(uri)) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new bod(queryParameter, j, host, str, str2, bundle, zEquals, 0L);
        } catch (NullPointerException | NumberFormatException e) {
            xe.c("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    bod(String str, long j, String str2, String str3, String str4, Bundle bundle, boolean z, long j2) {
        this.f2896a = str;
        this.d = j;
        this.e = str2 == null ? BuildConfig.FLAVOR : str2;
        this.f = str3 == null ? BuildConfig.FLAVOR : str3;
        this.g = str4 == null ? BuildConfig.FLAVOR : str4;
        this.h = bundle == null ? new Bundle() : bundle;
        this.f2897b = z;
        this.c = j2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f2896a, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, this.d);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, this.e, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, this.f, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, this.g, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 7, this.h, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, this.f2897b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, this.c);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
