package com.crashlytics.android.c;

import android.app.ActivityManager;
import io.fabric.sdk.android.services.b.r;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: SessionProtobufHelper.java */
/* loaded from: classes.dex */
class ar {

    /* renamed from: a, reason: collision with root package name */
    private static final d f1325a = d.a("0");

    /* renamed from: b, reason: collision with root package name */
    private static final d f1326b = d.a("Unity");

    public static void a(g gVar, String str, String str2, long j) {
        gVar.a(1, d.a(str2));
        gVar.a(2, d.a(str));
        gVar.a(3, j);
    }

    public static void a(g gVar, String str, String str2, String str3, String str4, String str5, int i, String str6) {
        d dVarA = d.a(str);
        d dVarA2 = d.a(str2);
        d dVarA3 = d.a(str3);
        d dVarA4 = d.a(str4);
        d dVarA5 = d.a(str5);
        d dVarA6 = str6 != null ? d.a(str6) : null;
        gVar.g(7, 2);
        gVar.k(a(dVarA, dVarA2, dVarA3, dVarA4, dVarA5, i, dVarA6));
        gVar.a(1, dVarA);
        gVar.a(2, dVarA3);
        gVar.a(3, dVarA4);
        gVar.g(5, 2);
        gVar.k(a(dVarA2));
        gVar.a(1, dVarA2);
        gVar.a(6, dVarA5);
        if (dVarA6 != null) {
            gVar.a(8, f1326b);
            gVar.a(9, dVarA6);
        }
        gVar.b(10, i);
    }

    public static void a(g gVar, String str, String str2, boolean z) {
        d dVarA = d.a(str);
        d dVarA2 = d.a(str2);
        gVar.g(8, 2);
        gVar.k(a(dVarA, dVarA2, z));
        gVar.b(1, 3);
        gVar.a(2, dVarA);
        gVar.a(3, dVarA2);
        gVar.a(4, z);
    }

    public static void a(g gVar, int i, String str, int i2, long j, long j2, boolean z, Map<r.a, String> map, int i3, String str2, String str3) {
        d dVarA = a(str);
        d dVarA2 = a(str3);
        d dVarA3 = a(str2);
        gVar.g(9, 2);
        gVar.k(a(i, dVarA, i2, j, j2, z, map, i3, dVarA3, dVarA2));
        gVar.b(3, i);
        gVar.a(4, dVarA);
        gVar.a(5, i2);
        gVar.a(6, j);
        gVar.a(7, j2);
        gVar.a(10, z);
        for (Map.Entry<r.a, String> entry : map.entrySet()) {
            gVar.g(11, 2);
            gVar.k(a(entry.getKey(), entry.getValue()));
            gVar.b(1, entry.getKey().h);
            gVar.a(2, d.a(entry.getValue()));
        }
        gVar.a(12, i3);
        if (dVarA3 != null) {
            gVar.a(13, dVarA3);
        }
        if (dVarA2 != null) {
            gVar.a(14, dVarA2);
        }
    }

    public static void a(g gVar, String str, String str2, String str3) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        d dVarA = d.a(str);
        d dVarA2 = a(str2);
        d dVarA3 = a(str3);
        int iB = g.b(1, dVarA) + 0;
        if (str2 != null) {
            iB += g.b(2, dVarA2);
        }
        if (str3 != null) {
            iB += g.b(3, dVarA3);
        }
        gVar.g(6, 2);
        gVar.k(iB);
        gVar.a(1, dVarA);
        if (str2 != null) {
            gVar.a(2, dVarA2);
        }
        if (str3 != null) {
            gVar.a(3, dVarA3);
        }
    }

    public static void a(g gVar, long j, String str, av avVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, Map<String, String> map, aa aaVar, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i, String str2, String str3, Float f, int i2, boolean z, long j2, long j3) {
        d dVarA = d.a(str2);
        d dVarA2 = str3 == null ? null : d.a(str3.replace("-", BuildConfig.FLAVOR));
        d dVarA3 = aaVar.a();
        if (dVarA3 == null) {
            io.fabric.sdk.android.c.g().a("CrashlyticsCore", "No log data to include with this event.");
        }
        aaVar.c();
        gVar.g(10, 2);
        gVar.k(a(j, str, avVar, thread, stackTraceElementArr, threadArr, list, 8, map, runningAppProcessInfo, i, dVarA, dVarA2, f, i2, z, j2, j3, dVarA3));
        gVar.a(1, j);
        gVar.a(2, d.a(str));
        a(gVar, avVar, thread, stackTraceElementArr, threadArr, list, 8, dVarA, dVarA2, map, runningAppProcessInfo, i);
        a(gVar, f, i2, z, i, j2, j3);
        a(gVar, dVarA3);
    }

    private static void a(g gVar, av avVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, d dVar, d dVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) throws IOException {
        gVar.g(3, 2);
        gVar.k(a(avVar, thread, stackTraceElementArr, threadArr, list, i, dVar, dVar2, map, runningAppProcessInfo, i2));
        a(gVar, avVar, thread, stackTraceElementArr, threadArr, list, i, dVar, dVar2);
        if (map != null && !map.isEmpty()) {
            a(gVar, map);
        }
        if (runningAppProcessInfo != null) {
            gVar.a(3, runningAppProcessInfo.importance != 100);
        }
        gVar.a(4, i2);
    }

    private static void a(g gVar, av avVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, d dVar, d dVar2) throws IOException {
        gVar.g(1, 2);
        gVar.k(a(avVar, thread, stackTraceElementArr, threadArr, list, i, dVar, dVar2));
        a(gVar, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            a(gVar, threadArr[i2], list.get(i2), 0, false);
        }
        a(gVar, avVar, 1, i, 2);
        gVar.g(3, 2);
        gVar.k(a());
        gVar.a(1, f1325a);
        gVar.a(2, f1325a);
        gVar.a(3, 0L);
        gVar.g(4, 2);
        gVar.k(a(dVar, dVar2));
        gVar.a(1, 0L);
        gVar.a(2, 0L);
        gVar.a(3, dVar);
        if (dVar2 != null) {
            gVar.a(4, dVar2);
        }
    }

    private static void a(g gVar, Map<String, String> map) throws IOException {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            gVar.g(2, 2);
            gVar.k(a(entry.getKey(), entry.getValue()));
            gVar.a(1, d.a(entry.getKey()));
            String value = entry.getValue();
            if (value == null) {
                value = BuildConfig.FLAVOR;
            }
            gVar.a(2, d.a(value));
        }
    }

    private static void a(g gVar, av avVar, int i, int i2, int i3) throws IOException {
        gVar.g(i3, 2);
        gVar.k(a(avVar, 1, i2));
        gVar.a(1, d.a(avVar.f1330b));
        String str = avVar.f1329a;
        if (str != null) {
            gVar.a(3, d.a(str));
        }
        int i4 = 0;
        for (StackTraceElement stackTraceElement : avVar.c) {
            a(gVar, 4, stackTraceElement, true);
        }
        av avVar2 = avVar.d;
        if (avVar2 != null) {
            if (i < i2) {
                a(gVar, avVar2, i + 1, i2, 6);
                return;
            }
            while (avVar2 != null) {
                avVar2 = avVar2.d;
                i4++;
            }
            gVar.a(7, i4);
        }
    }

    private static void a(g gVar, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) throws IOException {
        gVar.g(1, 2);
        gVar.k(a(thread, stackTraceElementArr, i, z));
        gVar.a(1, d.a(thread.getName()));
        gVar.a(2, i);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            a(gVar, 3, stackTraceElement, z);
        }
    }

    private static void a(g gVar, int i, StackTraceElement stackTraceElement, boolean z) throws IOException {
        gVar.g(i, 2);
        gVar.k(a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            gVar.a(1, Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            gVar.a(1, 0L);
        }
        gVar.a(2, d.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            gVar.a(3, d.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            gVar.a(4, stackTraceElement.getLineNumber());
        }
        gVar.a(5, z ? 4 : 0);
    }

    private static void a(g gVar, Float f, int i, boolean z, int i2, long j, long j2) throws IOException {
        gVar.g(5, 2);
        gVar.k(a(f, i, z, i2, j, j2));
        if (f != null) {
            gVar.a(1, f.floatValue());
        }
        gVar.c(2, i);
        gVar.a(3, z);
        gVar.a(4, i2);
        gVar.a(5, j);
        gVar.a(6, j2);
    }

    private static void a(g gVar, d dVar) throws IOException {
        if (dVar != null) {
            gVar.g(6, 2);
            gVar.k(b(dVar));
            gVar.a(1, dVar);
        }
    }

    private static int a(d dVar, d dVar2, d dVar3, d dVar4, d dVar5, int i, d dVar6) {
        int iB = g.b(1, dVar) + 0 + g.b(2, dVar3) + g.b(3, dVar4);
        int iA = a(dVar2);
        int iJ = iB + g.j(5) + g.l(iA) + iA + g.b(6, dVar5);
        if (dVar6 != null) {
            iJ = iJ + g.b(8, f1326b) + g.b(9, dVar6);
        }
        return iJ + g.e(10, i);
    }

    private static int a(d dVar) {
        return g.b(1, dVar) + 0;
    }

    private static int a(d dVar, d dVar2, boolean z) {
        return g.e(1, 3) + 0 + g.b(2, dVar) + g.b(3, dVar2) + g.b(4, z);
    }

    private static int a(r.a aVar, String str) {
        return g.e(1, aVar.h) + g.b(2, d.a(str));
    }

    private static int a(int i, d dVar, int i2, long j, long j2, boolean z, Map<r.a, String> map, int i3, d dVar2, d dVar3) {
        int iE = g.e(3, i) + 0 + (dVar == null ? 0 : g.b(4, dVar)) + g.d(5, i2) + g.b(6, j) + g.b(7, j2) + g.b(10, z);
        if (map != null) {
            for (Map.Entry<r.a, String> entry : map.entrySet()) {
                int iA = a(entry.getKey(), entry.getValue());
                iE += g.j(11) + g.l(iA) + iA;
            }
        }
        return iE + g.d(12, i3) + (dVar2 == null ? 0 : g.b(13, dVar2)) + (dVar3 != null ? g.b(14, dVar3) : 0);
    }

    private static int a(d dVar, d dVar2) {
        int iB = g.b(1, 0L) + 0 + g.b(2, 0L) + g.b(3, dVar);
        return dVar2 != null ? iB + g.b(4, dVar2) : iB;
    }

    private static int a(long j, String str, av avVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, d dVar, d dVar2, Float f, int i3, boolean z, long j2, long j3, d dVar3) {
        int iB = g.b(1, j) + 0 + g.b(2, d.a(str));
        int iA = a(avVar, thread, stackTraceElementArr, threadArr, list, i, dVar, dVar2, map, runningAppProcessInfo, i2);
        int iJ = iB + g.j(3) + g.l(iA) + iA;
        int iA2 = a(f, i3, z, i2, j2, j3);
        int iJ2 = iJ + g.j(5) + g.l(iA2) + iA2;
        if (dVar3 == null) {
            return iJ2;
        }
        int iB2 = b(dVar3);
        return iJ2 + g.j(6) + g.l(iB2) + iB2;
    }

    private static int a(av avVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, d dVar, d dVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int iA = a(avVar, thread, stackTraceElementArr, threadArr, list, i, dVar, dVar2);
        int iJ = g.j(1) + g.l(iA) + iA + 0;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                int iA2 = a(entry.getKey(), entry.getValue());
                iJ += g.j(2) + g.l(iA2) + iA2;
            }
        }
        if (runningAppProcessInfo != null) {
            iJ += g.b(3, runningAppProcessInfo.importance != 100);
        }
        return iJ + g.d(4, i2);
    }

    private static int a(av avVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, d dVar, d dVar2) {
        int iA = a(thread, stackTraceElementArr, 4, true);
        int iJ = g.j(1) + g.l(iA) + iA + 0;
        int length = threadArr.length;
        int iJ2 = iJ;
        for (int i2 = 0; i2 < length; i2++) {
            int iA2 = a(threadArr[i2], list.get(i2), 0, false);
            iJ2 += g.j(1) + g.l(iA2) + iA2;
        }
        int iA3 = a(avVar, 1, i);
        int iJ3 = iJ2 + g.j(2) + g.l(iA3) + iA3;
        int iA4 = a();
        int iJ4 = iJ3 + g.j(3) + g.l(iA4) + iA4;
        int iA5 = a(dVar, dVar2);
        return iJ4 + g.j(3) + g.l(iA5) + iA5;
    }

    private static int a(String str, String str2) {
        int iB = g.b(1, d.a(str));
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        return iB + g.b(2, d.a(str2));
    }

    private static int a(Float f, int i, boolean z, int i2, long j, long j2) {
        return (f != null ? 0 + g.b(1, f.floatValue()) : 0) + g.f(2, i) + g.b(3, z) + g.d(4, i2) + g.b(5, j) + g.b(6, j2);
    }

    private static int b(d dVar) {
        return g.b(1, dVar);
    }

    private static int a(av avVar, int i, int i2) {
        int i3 = 0;
        int iB = g.b(1, d.a(avVar.f1330b)) + 0;
        String str = avVar.f1329a;
        if (str != null) {
            iB += g.b(3, d.a(str));
        }
        int iJ = iB;
        for (StackTraceElement stackTraceElement : avVar.c) {
            int iA = a(stackTraceElement, true);
            iJ += g.j(4) + g.l(iA) + iA;
        }
        av avVar2 = avVar.d;
        if (avVar2 == null) {
            return iJ;
        }
        if (i < i2) {
            int iA2 = a(avVar2, i + 1, i2);
            return iJ + g.j(6) + g.l(iA2) + iA2;
        }
        while (avVar2 != null) {
            avVar2 = avVar2.d;
            i3++;
        }
        return iJ + g.d(7, i3);
    }

    private static int a() {
        return g.b(1, f1325a) + 0 + g.b(2, f1325a) + g.b(3, 0L);
    }

    private static int a(StackTraceElement stackTraceElement, boolean z) {
        int iB;
        if (stackTraceElement.isNativeMethod()) {
            iB = g.b(1, Math.max(stackTraceElement.getLineNumber(), 0)) + 0;
        } else {
            iB = g.b(1, 0L) + 0;
        }
        int iB2 = iB + g.b(2, d.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            iB2 += g.b(3, d.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            iB2 += g.b(4, stackTraceElement.getLineNumber());
        }
        return iB2 + g.d(5, z ? 2 : 0);
    }

    private static int a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int iB = g.b(1, d.a(thread.getName())) + g.d(2, i);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            int iA = a(stackTraceElement, z);
            iB += g.j(3) + g.l(iA) + iA;
        }
        return iB;
    }

    private static d a(String str) {
        if (str == null) {
            return null;
        }
        return d.a(str);
    }
}
