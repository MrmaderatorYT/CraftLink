package com.crashlytics.android.c;

import java.util.HashMap;

/* compiled from: RemoveRepeatsStrategy.java */
/* loaded from: classes.dex */
class an implements au {

    /* renamed from: a, reason: collision with root package name */
    private final int f1316a;

    public an() {
        this(1);
    }

    public an(int i) {
        this.f1316a = i;
    }

    @Override // com.crashlytics.android.c.au
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] stackTraceElementArrA = a(stackTraceElementArr, this.f1316a);
        return stackTraceElementArrA.length < stackTraceElementArr.length ? stackTraceElementArrA : stackTraceElementArr;
    }

    private static StackTraceElement[] a(StackTraceElement[] stackTraceElementArr, int i) {
        int i2;
        HashMap map = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i3];
            Integer num = (Integer) map.get(stackTraceElement);
            if (num == null || !a(stackTraceElementArr, num.intValue(), i3)) {
                stackTraceElementArr2[i4] = stackTraceElementArr[i3];
                i4++;
                i2 = i3;
                i5 = 1;
            } else {
                int iIntValue = i3 - num.intValue();
                if (i5 < i) {
                    System.arraycopy(stackTraceElementArr, i3, stackTraceElementArr2, i4, iIntValue);
                    i4 += iIntValue;
                    i5++;
                }
                i2 = (iIntValue - 1) + i3;
            }
            map.put(stackTraceElement, Integer.valueOf(i3));
            i3 = i2 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i4];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, stackTraceElementArr3.length);
        return stackTraceElementArr3;
    }

    private static boolean a(StackTraceElement[] stackTraceElementArr, int i, int i2) {
        int i3 = i2 - i;
        if (i2 + i3 > stackTraceElementArr.length) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!stackTraceElementArr[i + i4].equals(stackTraceElementArr[i2 + i4])) {
                return false;
            }
        }
        return true;
    }
}
