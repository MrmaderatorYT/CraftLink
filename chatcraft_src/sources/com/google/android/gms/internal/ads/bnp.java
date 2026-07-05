package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;
import me.zhanghai.android.materialprogressbar.BuildConfig;

@qj
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class bnp {
    public static void a(String[] strArr, int i, int i2, PriorityQueue<bnq> priorityQueue) throws UnsupportedEncodingException {
        if (strArr.length < i2) {
            a(i, b(strArr, 0, strArr.length), a(strArr, 0, strArr.length), strArr.length, priorityQueue);
            return;
        }
        long jB = b(strArr, 0, i2);
        a(i, jB, a(strArr, 0, i2), i2, priorityQueue);
        long jA = a(16785407L, i2 - 1);
        for (int i3 = 1; i3 < (strArr.length - i2) + 1; i3++) {
            jB = ((((((jB + 1073807359) - ((((bnm.a(strArr[i3 - 1]) + 2147483647L) % 1073807359) * jA) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((bnm.a(strArr[(i3 + i2) - 1]) + 2147483647L) % 1073807359)) % 1073807359;
            a(i, jB, a(strArr, i3, i2), strArr.length, priorityQueue);
        }
    }

    private static void a(int i, long j, String str, int i2, PriorityQueue<bnq> priorityQueue) {
        bnq bnqVar = new bnq(j, str, i2);
        if ((priorityQueue.size() != i || (priorityQueue.peek().c <= bnqVar.c && priorityQueue.peek().f2880a <= bnqVar.f2880a)) && !priorityQueue.contains(bnqVar)) {
            priorityQueue.add(bnqVar);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    private static String a(String[] strArr, int i, int i2) {
        int i3 = i2 + i;
        if (strArr.length < i3) {
            xe.c("Unable to construct shingle");
            return BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i4 = i3 - 1;
            if (i < i4) {
                sb.append(strArr[i]);
                sb.append(' ');
                i++;
            } else {
                sb.append(strArr[i4]);
                return sb.toString();
            }
        }
    }

    private static long b(String[] strArr, int i, int i2) {
        long jA = (bnm.a(strArr[0]) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            jA = (((jA * 16785407) % 1073807359) + ((bnm.a(strArr[i3]) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return jA;
    }

    private static long a(long j, int i) {
        if (i == 0) {
            return 1L;
        }
        if (i == 1) {
            return j;
        }
        if (i % 2 == 0) {
            return a((j * j) % 1073807359, i / 2) % 1073807359;
        }
        return (j * (a((j * j) % 1073807359, i / 2) % 1073807359)) % 1073807359;
    }
}
