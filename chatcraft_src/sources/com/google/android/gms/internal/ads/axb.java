package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public abstract class axb implements axa {

    /* renamed from: a, reason: collision with root package name */
    protected static volatile axt f2361a;

    /* renamed from: b, reason: collision with root package name */
    protected MotionEvent f2362b;
    protected double k;
    protected float l;
    protected float m;
    protected float n;
    protected float o;
    protected DisplayMetrics q;
    private double r;
    private double s;
    protected LinkedList<MotionEvent> c = new LinkedList<>();
    protected long d = 0;
    protected long e = 0;
    protected long f = 0;
    protected long g = 0;
    protected long h = 0;
    protected long i = 0;
    protected long j = 0;
    private boolean t = false;
    protected boolean p = false;

    protected axb(Context context) {
        try {
            if (((Boolean) bra.e().a(o.bn)).booleanValue()) {
                avu.a();
            } else {
                axy.a(f2361a);
            }
            this.q = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    protected abstract long a(StackTraceElement[] stackTraceElementArr);

    protected abstract akp a(Context context, View view, Activity activity);

    protected abstract akp a(Context context, aho ahoVar);

    @Override // com.google.android.gms.internal.ads.axa
    public void a(View view) {
    }

    protected abstract axz b(MotionEvent motionEvent);

    @Override // com.google.android.gms.internal.ads.axa
    public final String a(Context context) {
        if (aya.a()) {
            if (((Boolean) bra.e().a(o.bp)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return a(context, null, false, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.axa
    public final String a(Context context, String str, View view) {
        return a(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.axa
    public final String a(Context context, String str, View view, Activity activity) {
        return a(context, str, true, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.axa
    public final void a(MotionEvent motionEvent) {
        boolean z = false;
        if (this.t) {
            this.g = 0L;
            this.f = 0L;
            this.e = 0L;
            this.d = 0L;
            this.h = 0L;
            this.j = 0L;
            this.i = 0L;
            Iterator<MotionEvent> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.c.clear();
            this.f2362b = null;
            this.t = false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.k = 0.0d;
                this.r = motionEvent.getRawX();
                this.s = motionEvent.getRawY();
                break;
            case 1:
            case 2:
                double rawX = motionEvent.getRawX();
                double rawY = motionEvent.getRawY();
                double d = this.r;
                Double.isNaN(rawX);
                double d2 = rawX - d;
                double d3 = this.s;
                Double.isNaN(rawY);
                double d4 = rawY - d3;
                this.k += Math.sqrt((d2 * d2) + (d4 * d4));
                this.r = rawX;
                this.s = rawY;
                break;
        }
        try {
            switch (motionEvent.getAction()) {
                case 0:
                    this.l = motionEvent.getX();
                    this.m = motionEvent.getY();
                    this.n = motionEvent.getRawX();
                    this.o = motionEvent.getRawY();
                    this.d++;
                    break;
                case 1:
                    this.f2362b = MotionEvent.obtain(motionEvent);
                    this.c.add(this.f2362b);
                    if (this.c.size() > 6) {
                        this.c.remove().recycle();
                    }
                    this.f++;
                    this.h = a(new Throwable().getStackTrace());
                    break;
                case 2:
                    this.e += motionEvent.getHistorySize() + 1;
                    axz axzVarB = b(motionEvent);
                    if ((axzVarB == null || axzVarB.d == null || axzVarB.g == null) ? false : true) {
                        this.i += axzVarB.d.longValue() + axzVarB.g.longValue();
                    }
                    if (this.q != null && axzVarB != null && axzVarB.e != null && axzVarB.h != null) {
                        z = true;
                    }
                    if (z) {
                        this.j += axzVarB.e.longValue() + axzVarB.h.longValue();
                        break;
                    }
                    break;
                case 3:
                    this.g++;
                    break;
            }
        } catch (zzdi unused) {
        }
        this.p = true;
    }

    @Override // com.google.android.gms.internal.ads.axa
    public final void a(int i, int i2, int i3) {
        if (this.f2362b != null) {
            this.f2362b.recycle();
        }
        if (this.q != null) {
            this.f2362b = MotionEvent.obtain(0L, i3, 1, this.q.density * i, this.q.density * i2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.f2362b = null;
        }
        this.p = false;
    }

    private final String a(Context context, String str, boolean z, View view, Activity activity, byte[] bArr) {
        akp akpVarA;
        try {
            if (z) {
                akpVarA = a(context, view, activity);
                this.t = true;
            } else {
                akpVarA = a(context, null);
            }
            if (akpVarA != null && akpVarA.d() != 0) {
                return avu.a(akpVarA, str);
            }
            return Integer.toString(5);
        } catch (UnsupportedEncodingException | GeneralSecurityException unused) {
            return Integer.toString(7);
        } catch (Throwable unused2) {
            return Integer.toString(3);
        }
    }
}
