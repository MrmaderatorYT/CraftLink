package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class bab implements Parcelable {
    public static final Parcelable.Creator<bab> CREATOR = new bac();
    private int A;

    /* renamed from: a, reason: collision with root package name */
    public final String f2442a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2443b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final List<byte[]> g;
    public final bbt h;
    public final int i;
    public final int j;
    public final float k;
    public final int l;
    public final float m;
    public final int n;
    public final int o;
    public final int p;
    public final long q;
    public final int r;
    public final String s;
    private final bem t;
    private final int u;
    private final byte[] v;
    private final bkk w;
    private final int x;
    private final int y;
    private final int z;

    public static bab a(String str, String str2, String str3, String str4, int i, int i2, int i3, float f, List<byte[]> list, int i4) {
        return new bab(str, str2, str3, str4, i, -1, i2, i3, f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i4, null, -1, Long.MAX_VALUE, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public static bab a(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, bkk bkkVar, bbt bbtVar) {
        return new bab(str, null, str2, null, -1, i2, i3, i4, -1.0f, i5, f2, bArr, i6, bkkVar, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, bbtVar, null);
    }

    public static bab a(String str, String str2, String str3, String str4, int i, int i2, int i3, List<byte[]> list, int i4, String str5) {
        return new bab(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i2, i3, -1, -1, -1, i4, str5, -1, Long.MAX_VALUE, null, null, null);
    }

    public static bab a(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, bbt bbtVar, int i5, String str4) {
        return a(str, str2, null, -1, -1, i3, i4, -1, null, bbtVar, 0, str4);
    }

    public static bab a(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, bbt bbtVar, int i6, String str4) {
        return new bab(str, null, str2, null, -1, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, -1, -1, i6, str4, -1, Long.MAX_VALUE, list, bbtVar, null);
    }

    public static bab a(String str, String str2, String str3, String str4, int i, int i2, String str5, int i3) {
        return new bab(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str5, i3, Long.MAX_VALUE, null, null, null);
    }

    public static bab a(String str, String str2, String str3, int i, int i2, String str4, bbt bbtVar) {
        return a(str, str2, (String) null, -1, i2, str4, -1, bbtVar, Long.MAX_VALUE, (List<byte[]>) Collections.emptyList());
    }

    public static bab a(String str, String str2, String str3, int i, int i2, String str4, int i3, bbt bbtVar, long j, List<byte[]> list) {
        return new bab(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, -1, j, list, bbtVar, null);
    }

    public static bab a(String str, String str2, String str3, int i, List<byte[]> list, String str4, bbt bbtVar) {
        return new bab(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, bbtVar, null);
    }

    public static bab a(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        return new bab(str, str2, str3, str4, i, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str5, -1, Long.MAX_VALUE, null, null, null);
    }

    public static bab a(String str, String str2, long j) {
        return new bab(null, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    public static bab a(String str, String str2, String str3, int i, bbt bbtVar) {
        return new bab(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, bbtVar, null);
    }

    private bab(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, bkk bkkVar, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, bbt bbtVar, bem bemVar) {
        this.f2442a = str;
        this.d = str2;
        this.e = str3;
        this.c = str4;
        this.f2443b = i;
        this.f = i2;
        this.i = i3;
        this.j = i4;
        this.k = f;
        this.l = i5;
        this.m = f2;
        this.v = bArr;
        this.u = i6;
        this.w = bkkVar;
        this.n = i7;
        this.o = i8;
        this.p = i9;
        this.x = i10;
        this.y = i11;
        this.r = i12;
        this.s = str5;
        this.z = i13;
        this.q = j;
        this.g = list == null ? Collections.emptyList() : list;
        this.h = bbtVar;
        this.t = bemVar;
    }

    bab(Parcel parcel) {
        this.f2442a = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.c = parcel.readString();
        this.f2443b = parcel.readInt();
        this.f = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readFloat();
        this.l = parcel.readInt();
        this.m = parcel.readFloat();
        this.v = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.u = parcel.readInt();
        this.w = (bkk) parcel.readParcelable(bkk.class.getClassLoader());
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        this.p = parcel.readInt();
        this.x = parcel.readInt();
        this.y = parcel.readInt();
        this.r = parcel.readInt();
        this.s = parcel.readString();
        this.z = parcel.readInt();
        this.q = parcel.readLong();
        int i = parcel.readInt();
        this.g = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.g.add(parcel.createByteArray());
        }
        this.h = (bbt) parcel.readParcelable(bbt.class.getClassLoader());
        this.t = (bem) parcel.readParcelable(bem.class.getClassLoader());
    }

    public final bab a(int i) {
        return new bab(this.f2442a, this.d, this.e, this.c, this.f2443b, i, this.i, this.j, this.k, this.l, this.m, this.v, this.u, this.w, this.n, this.o, this.p, this.x, this.y, this.r, this.s, this.z, this.q, this.g, this.h, this.t);
    }

    public final bab a(long j) {
        return new bab(this.f2442a, this.d, this.e, this.c, this.f2443b, this.f, this.i, this.j, this.k, this.l, this.m, this.v, this.u, this.w, this.n, this.o, this.p, this.x, this.y, this.r, this.s, this.z, j, this.g, this.h, this.t);
    }

    public final bab a(bab babVar) {
        if (this == babVar) {
            return this;
        }
        return new bab(babVar.f2442a, this.d, this.e, this.c == null ? babVar.c : this.c, this.f2443b == -1 ? babVar.f2443b : this.f2443b, this.f, this.i, this.j, this.k == -1.0f ? babVar.k : this.k, this.l, this.m, this.v, this.u, this.w, this.n, this.o, this.p, this.x, this.y, this.r | babVar.r, this.s == null ? babVar.s : this.s, this.z, this.q, this.g, babVar.h != null ? babVar.h : this.h, this.t);
    }

    public final bab a(int i, int i2) {
        return new bab(this.f2442a, this.d, this.e, this.c, this.f2443b, this.f, this.i, this.j, this.k, this.l, this.m, this.v, this.u, this.w, this.n, this.o, this.p, i, i2, this.r, this.s, this.z, this.q, this.g, this.h, this.t);
    }

    public final bab a(bbt bbtVar) {
        return new bab(this.f2442a, this.d, this.e, this.c, this.f2443b, this.f, this.i, this.j, this.k, this.l, this.m, this.v, this.u, this.w, this.n, this.o, this.p, this.x, this.y, this.r, this.s, this.z, this.q, this.g, bbtVar, this.t);
    }

    public final bab a(bem bemVar) {
        return new bab(this.f2442a, this.d, this.e, this.c, this.f2443b, this.f, this.i, this.j, this.k, this.l, this.m, this.v, this.u, this.w, this.n, this.o, this.p, this.x, this.y, this.r, this.s, this.z, this.q, this.g, this.h, bemVar);
    }

    public final int a() {
        if (this.i == -1 || this.j == -1) {
            return -1;
        }
        return this.i * this.j;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat b() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.e);
        String str = this.s;
        if (str != null) {
            mediaFormat.setString("language", str);
        }
        a(mediaFormat, "max-input-size", this.f);
        a(mediaFormat, "width", this.i);
        a(mediaFormat, "height", this.j);
        float f = this.k;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        a(mediaFormat, "rotation-degrees", this.l);
        a(mediaFormat, "channel-count", this.n);
        a(mediaFormat, "sample-rate", this.o);
        a(mediaFormat, "encoder-delay", this.x);
        a(mediaFormat, "encoder-padding", this.y);
        for (int i = 0; i < this.g.size(); i++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.g.get(i)));
        }
        bkk bkkVar = this.w;
        if (bkkVar != null) {
            a(mediaFormat, "color-transfer", bkkVar.c);
            a(mediaFormat, "color-standard", bkkVar.f2765a);
            a(mediaFormat, "color-range", bkkVar.f2766b);
            byte[] bArr = bkkVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final String toString() {
        String str = this.f2442a;
        String str2 = this.d;
        String str3 = this.e;
        int i = this.f2443b;
        String str4 = this.s;
        int i2 = this.i;
        int i3 = this.j;
        float f = this.k;
        int i4 = this.n;
        int i5 = this.o;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 100 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(str4);
        sb.append(", [");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        sb.append("], [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.A == 0) {
            this.A = (((((((((((((((((((((((((this.f2442a == null ? 0 : this.f2442a.hashCode()) + 527) * 31) + (this.d == null ? 0 : this.d.hashCode())) * 31) + (this.e == null ? 0 : this.e.hashCode())) * 31) + (this.c == null ? 0 : this.c.hashCode())) * 31) + this.f2443b) * 31) + this.i) * 31) + this.j) * 31) + this.n) * 31) + this.o) * 31) + (this.s == null ? 0 : this.s.hashCode())) * 31) + this.z) * 31) + (this.h == null ? 0 : this.h.hashCode())) * 31) + (this.t != null ? this.t.hashCode() : 0);
        }
        return this.A;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bab babVar = (bab) obj;
        if (this.f2443b != babVar.f2443b || this.f != babVar.f || this.i != babVar.i || this.j != babVar.j || this.k != babVar.k || this.l != babVar.l || this.m != babVar.m || this.u != babVar.u || this.n != babVar.n || this.o != babVar.o || this.p != babVar.p || this.x != babVar.x || this.y != babVar.y || this.q != babVar.q || this.r != babVar.r || !bkg.a(this.f2442a, babVar.f2442a) || !bkg.a(this.s, babVar.s) || this.z != babVar.z || !bkg.a(this.d, babVar.d) || !bkg.a(this.e, babVar.e) || !bkg.a(this.c, babVar.c) || !bkg.a(this.h, babVar.h) || !bkg.a(this.t, babVar.t) || !bkg.a(this.w, babVar.w) || !Arrays.equals(this.v, babVar.v) || this.g.size() != babVar.g.size()) {
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            if (!Arrays.equals(this.g.get(i), babVar.g.get(i))) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2442a);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.c);
        parcel.writeInt(this.f2443b);
        parcel.writeInt(this.f);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeFloat(this.k);
        parcel.writeInt(this.l);
        parcel.writeFloat(this.m);
        parcel.writeInt(this.v != null ? 1 : 0);
        if (this.v != null) {
            parcel.writeByteArray(this.v);
        }
        parcel.writeInt(this.u);
        parcel.writeParcelable(this.w, i);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
        parcel.writeInt(this.x);
        parcel.writeInt(this.y);
        parcel.writeInt(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.z);
        parcel.writeLong(this.q);
        int size = this.g.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.g.get(i2));
        }
        parcel.writeParcelable(this.h, 0);
        parcel.writeParcelable(this.t, 0);
    }
}
