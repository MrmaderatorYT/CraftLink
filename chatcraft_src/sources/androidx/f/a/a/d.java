package androidx.f.a.a;

import android.view.animation.Interpolator;

/* compiled from: LookupTableInterpolator.java */
/* loaded from: classes.dex */
abstract class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f705a;

    /* renamed from: b, reason: collision with root package name */
    private final float f706b;

    protected d(float[] fArr) {
        this.f705a = fArr;
        this.f706b = 1.0f / (this.f705a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int iMin = Math.min((int) ((this.f705a.length - 1) * f), this.f705a.length - 2);
        return this.f705a[iMin] + (((f - (iMin * this.f706b)) / this.f706b) * (this.f705a[iMin + 1] - this.f705a[iMin]));
    }
}
