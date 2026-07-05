package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* loaded from: classes.dex */
final class lw {

    /* renamed from: a, reason: collision with root package name */
    long f3259a;

    /* renamed from: b, reason: collision with root package name */
    final String f3260b;
    final String c;
    final long d;
    final long e;
    final long f;
    final long g;
    final List<bfd> h;

    private lw(String str, String str2, long j, long j2, long j3, long j4, List<bfd> list) {
        this.f3260b = str;
        this.c = BuildConfig.FLAVOR.equals(str2) ? null : str2;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = j4;
        this.h = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    lw(String str, awj awjVar) {
        List list;
        String str2 = awjVar.f2344b;
        long j = awjVar.c;
        long j2 = awjVar.d;
        long j3 = awjVar.e;
        long j4 = awjVar.f;
        if (awjVar.h != null) {
            list = awjVar.h;
        } else {
            Map<String, String> map = awjVar.g;
            List arrayList = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new bfd(entry.getKey(), entry.getValue()));
            }
            list = arrayList;
        }
        this(str, str2, j, j2, j3, j4, list);
        this.f3259a = awjVar.f2343a.length;
    }

    static lw a(mw mwVar) throws IOException {
        if (le.a((InputStream) mwVar) != 538247942) {
            throw new IOException();
        }
        return new lw(le.a(mwVar), le.a(mwVar), le.b((InputStream) mwVar), le.b((InputStream) mwVar), le.b((InputStream) mwVar), le.b((InputStream) mwVar), le.b(mwVar));
    }

    final boolean a(OutputStream outputStream) throws IOException {
        try {
            le.a(outputStream, 538247942);
            le.a(outputStream, this.f3260b);
            le.a(outputStream, this.c == null ? BuildConfig.FLAVOR : this.c);
            le.a(outputStream, this.d);
            le.a(outputStream, this.e);
            le.a(outputStream, this.f);
            le.a(outputStream, this.g);
            List<bfd> list = this.h;
            if (list != null) {
                le.a(outputStream, list.size());
                for (bfd bfdVar : list) {
                    le.a(outputStream, bfdVar.a());
                    le.a(outputStream, bfdVar.b());
                }
            } else {
                le.a(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            eb.b("%s", e.toString());
            return false;
        }
    }
}
