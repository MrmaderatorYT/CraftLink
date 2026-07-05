package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public abstract class awb {
    public abstract void a(String str);

    public static awb a(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new avw(cls.getSimpleName()) : new avy(cls.getSimpleName());
    }
}
