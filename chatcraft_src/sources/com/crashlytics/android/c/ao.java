package com.crashlytics.android.c;

import java.io.File;
import java.util.Map;

/* compiled from: Report.java */
/* loaded from: classes.dex */
interface ao {

    /* compiled from: Report.java */
    public enum a {
        JAVA,
        NATIVE
    }

    String a();

    String b();

    File c();

    File[] d();

    Map<String, String> e();

    void f();

    a g();
}
