package androidx.core.g.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* compiled from: PathInterpolatorApi14.java */
/* loaded from: classes.dex */
class a implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f628a;

    /* renamed from: b, reason: collision with root package name */
    private final float[] f629b;

    a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.f628a = new float[i];
        this.f629b = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((i2 * length) / (i - 1), fArr, null);
            this.f628a[i2] = fArr[0];
            this.f629b[i2] = fArr[1];
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f628a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f628a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.f628a[length] - this.f628a[i];
        if (f2 == 0.0f) {
            return this.f629b[i];
        }
        float f3 = (f - this.f628a[i]) / f2;
        float f4 = this.f629b[i];
        return f4 + (f3 * (this.f629b[length] - f4));
    }
}
