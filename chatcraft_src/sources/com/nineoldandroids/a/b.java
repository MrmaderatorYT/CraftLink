package com.nineoldandroids.a;

/* compiled from: FloatEvaluator.java */
/* loaded from: classes.dex */
public class b implements j<Number> {
    @Override // com.nineoldandroids.a.j
    public Float a(float f, Number number, Number number2) {
        float fFloatValue = number.floatValue();
        return Float.valueOf(fFloatValue + (f * (number2.floatValue() - fFloatValue)));
    }
}
