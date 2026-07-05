package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class azb {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2411a = "azb";

    /* renamed from: b, reason: collision with root package name */
    private final axt f2412b;
    private final String c;
    private final String d;
    private final Class<?>[] g;
    private final int e = 2;
    private volatile Method f = null;
    private CountDownLatch h = new CountDownLatch(1);

    public azb(axt axtVar, String str, String str2, Class<?>... clsArr) {
        this.f2412b = axtVar;
        this.c = str;
        this.d = str2;
        this.g = clsArr;
        this.f2412b.c().submit(new azc(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        try {
            Class clsLoadClass = this.f2412b.d().loadClass(a(this.f2412b.f(), this.c));
            if (clsLoadClass == null) {
                return;
            }
            this.f = clsLoadClass.getMethod(a(this.f2412b.f(), this.d), this.g);
            if (this.f == null) {
            }
        } catch (zzcx unused) {
        } catch (UnsupportedEncodingException unused2) {
        } catch (ClassNotFoundException unused3) {
        } catch (NoSuchMethodException unused4) {
        } catch (NullPointerException unused5) {
        } finally {
            this.h.countDown();
        }
    }

    private final String a(byte[] bArr, String str) {
        return new String(this.f2412b.e().a(bArr, str), "UTF-8");
    }

    public final Method a() {
        if (this.f != null) {
            return this.f;
        }
        try {
            if (this.h.await(2L, TimeUnit.SECONDS)) {
                return this.f;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
