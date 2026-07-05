package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class b extends com.google.android.gms.common.internal.safeparcel.a {

    /* renamed from: b, reason: collision with root package name */
    private final int f1694b;
    private final int c;
    private final PendingIntent d;
    private final String e;

    /* renamed from: a, reason: collision with root package name */
    public static final b f1693a = new b(0);
    public static final Parcelable.Creator<b> CREATOR = new h();

    b(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f1694b = i;
        this.c = i2;
        this.d = pendingIntent;
        this.e = str;
    }

    public b(int i) {
        this(i, null, null);
    }

    public b(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public b(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    public final boolean a() {
        return this.c == 0;
    }

    public final int b() {
        return this.c;
    }

    public final PendingIntent c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    static String a(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.c == bVar.c && com.google.android.gms.common.internal.h.a(this.d, bVar.d) && com.google.android.gms.common.internal.h.a(this.e, bVar.e);
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.h.a(Integer.valueOf(this.c), this.d, this.e);
    }

    public final String toString() {
        return com.google.android.gms.common.internal.h.a(this).a("statusCode", a(this.c)).a("resolution", this.d).a("message", this.e).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f1694b);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, b());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, (Parcelable) c(), i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, d(), false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, iA);
    }
}
