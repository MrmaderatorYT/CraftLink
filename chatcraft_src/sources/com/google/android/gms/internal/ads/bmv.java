package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class bmv {

    /* renamed from: a, reason: collision with root package name */
    private final int f2851a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2852b;
    private final int c;
    private final bnj d;
    private final bns e;
    private int m;
    private final Object f = new Object();
    private ArrayList<String> g = new ArrayList<>();
    private ArrayList<String> h = new ArrayList<>();
    private ArrayList<bnh> i = new ArrayList<>();
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private String n = BuildConfig.FLAVOR;
    private String o = BuildConfig.FLAVOR;
    private String p = BuildConfig.FLAVOR;

    public bmv(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f2851a = i;
        this.f2852b = i2;
        this.c = i3;
        this.d = new bnj(i4);
        this.e = new bns(i5, i6, i7);
    }

    public final boolean a() {
        boolean z;
        synchronized (this.f) {
            z = this.l == 0;
        }
        return z;
    }

    public final String b() {
        return this.n;
    }

    public final String c() {
        return this.o;
    }

    public final String d() {
        return this.p;
    }

    public final void e() {
        synchronized (this.f) {
            this.m -= 100;
        }
    }

    public final void f() {
        synchronized (this.f) {
            this.l--;
        }
    }

    public final void g() {
        synchronized (this.f) {
            this.l++;
        }
    }

    public final void a(String str, boolean z, float f, float f2, float f3, float f4) {
        c(str, z, f, f2, f3, f4);
        synchronized (this.f) {
            if (this.l < 0) {
                xe.b("ActivityContent: negative number of WebViews.");
            }
            h();
        }
    }

    public final void b(String str, boolean z, float f, float f2, float f3, float f4) {
        c(str, z, f, f2, f3, f4);
    }

    private final void c(String str, boolean z, float f, float f2, float f3, float f4) {
        if (str == null || str.length() < this.c) {
            return;
        }
        synchronized (this.f) {
            this.g.add(str);
            this.j += str.length();
            if (z) {
                this.h.add(str);
                this.i.add(new bnh(f, f2, f3, f4, this.h.size() - 1));
            }
        }
    }

    public final void h() {
        synchronized (this.f) {
            int i = (this.j * this.f2851a) + (this.k * this.f2852b);
            if (i > this.m) {
                this.m = i;
                if (!com.google.android.gms.ads.internal.ax.i().k().b()) {
                    this.n = this.d.a(this.g);
                    this.o = this.d.a(this.h);
                }
                if (!com.google.android.gms.ads.internal.ax.i().k().d()) {
                    this.p = this.e.a(this.h, this.i);
                }
            }
        }
    }

    public final int i() {
        return this.m;
    }

    public final void a(int i) {
        this.k = i;
    }

    private static String a(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayList2.get(i2);
            i2++;
            sb.append(str);
            sb.append(' ');
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String string = sb.toString();
        return string.length() < 100 ? string : string.substring(0, 100);
    }

    public final String toString() {
        int i = this.k;
        int i2 = this.m;
        int i3 = this.j;
        String strA = a(this.g, 100);
        String strA2 = a(this.h, 100);
        String str = this.n;
        String str2 = this.o;
        String str3 = this.p;
        StringBuilder sb = new StringBuilder(String.valueOf(strA).length() + 165 + String.valueOf(strA2).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(strA);
        sb.append("\n viewableText");
        sb.append(strA2);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    final int j() {
        return this.j;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bmv)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        bmv bmvVar = (bmv) obj;
        return bmvVar.n != null && bmvVar.n.equals(this.n);
    }

    public final int hashCode() {
        return this.n.hashCode();
    }
}
