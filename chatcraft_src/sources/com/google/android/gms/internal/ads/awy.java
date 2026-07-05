package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* loaded from: classes.dex */
public class awy {

    /* renamed from: b, reason: collision with root package name */
    protected volatile Boolean f2358b;
    private axt c;
    private static final ConditionVariable d = new ConditionVariable();

    /* renamed from: a, reason: collision with root package name */
    protected static volatile box f2357a = null;
    private static volatile Random e = null;

    public awy(axt axtVar) {
        this.c = axtVar;
        axtVar.c().execute(new awz(this));
    }

    public final void a(int i, int i2, long j) {
        try {
            d.block();
            if (!this.f2358b.booleanValue() || f2357a == null) {
                return;
            }
            agn agnVar = new agn();
            agnVar.f1970a = this.c.f2387a.getPackageName();
            agnVar.f1971b = Long.valueOf(j);
            bpb bpbVarA = f2357a.a(aus.a(agnVar));
            bpbVarA.a(i2);
            bpbVarA.b(i);
            bpbVarA.a();
        } catch (Exception unused) {
        }
    }

    public static int a() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ThreadLocalRandom.current().nextInt();
            }
            return c().nextInt();
        } catch (RuntimeException unused) {
            return c().nextInt();
        }
    }

    private static Random c() {
        if (e == null) {
            synchronized (awy.class) {
                if (e == null) {
                    e = new Random();
                }
            }
        }
        return e;
    }
}
