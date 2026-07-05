package io.fabric.sdk.android.services.concurrency;

/* compiled from: Priority.java */
/* loaded from: classes.dex */
public enum e {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    static <Y> int a(i iVar, Y y) {
        e eVarB;
        if (y instanceof i) {
            eVarB = ((i) y).b();
        } else {
            eVarB = NORMAL;
        }
        return eVarB.ordinal() - iVar.b().ordinal();
    }
}
