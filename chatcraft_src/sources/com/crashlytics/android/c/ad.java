package com.crashlytics.android.c;

/* compiled from: MiddleOutFallbackStrategy.java */
/* loaded from: classes.dex */
class ad implements au {

    /* renamed from: a, reason: collision with root package name */
    private final int f1301a;

    /* renamed from: b, reason: collision with root package name */
    private final au[] f1302b;
    private final ae c;

    public ad(int i, au... auVarArr) {
        this.f1301a = i;
        this.f1302b = auVarArr;
        this.c = new ae(i);
    }

    @Override // com.crashlytics.android.c.au
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f1301a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArrA = stackTraceElementArr;
        for (au auVar : this.f1302b) {
            if (stackTraceElementArrA.length <= this.f1301a) {
                break;
            }
            stackTraceElementArrA = auVar.a(stackTraceElementArr);
        }
        return stackTraceElementArrA.length > this.f1301a ? this.c.a(stackTraceElementArrA) : stackTraceElementArrA;
    }
}
