package com.crashlytics.android.c;

/* compiled from: MiddleOutStrategy.java */
/* loaded from: classes.dex */
class ae implements au {

    /* renamed from: a, reason: collision with root package name */
    private final int f1303a;

    public ae(int i) {
        this.f1303a = i;
    }

    @Override // com.crashlytics.android.c.au
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f1303a) {
            return stackTraceElementArr;
        }
        int i = this.f1303a / 2;
        int i2 = this.f1303a - i;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[this.f1303a];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i2);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i, stackTraceElementArr2, i2, i);
        return stackTraceElementArr2;
    }
}
