package androidx.i;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* compiled from: RectEvaluator.java */
/* loaded from: classes.dex */
class k implements TypeEvaluator<Rect> {

    /* renamed from: a, reason: collision with root package name */
    private Rect f844a;

    k() {
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i = rect.left + ((int) ((rect2.left - rect.left) * f));
        int i2 = rect.top + ((int) ((rect2.top - rect.top) * f));
        int i3 = rect.right + ((int) ((rect2.right - rect.right) * f));
        int i4 = rect.bottom + ((int) ((rect2.bottom - rect.bottom) * f));
        if (this.f844a == null) {
            return new Rect(i, i2, i3, i4);
        }
        this.f844a.set(i, i2, i3, i4);
        return this.f844a;
    }
}
