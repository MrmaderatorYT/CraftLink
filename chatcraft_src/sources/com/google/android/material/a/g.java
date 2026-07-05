package com.google.android.material.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* compiled from: MatrixEvaluator.java */
/* loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f3712a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f3713b = new float[9];
    private final Matrix c = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f3712a);
        matrix2.getValues(this.f3713b);
        for (int i = 0; i < 9; i++) {
            this.f3713b[i] = this.f3712a[i] + ((this.f3713b[i] - this.f3712a[i]) * f);
        }
        this.c.setValues(this.f3713b);
        return this.c;
    }
}
