package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.a.a.f;

/* compiled from: TintTypedArray.java */
/* loaded from: classes.dex */
public class as {

    /* renamed from: a, reason: collision with root package name */
    private final Context f367a;

    /* renamed from: b, reason: collision with root package name */
    private final TypedArray f368b;
    private TypedValue c;

    public static as a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new as(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static as a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new as(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static as a(Context context, int i, int[] iArr) {
        return new as(context, context.obtainStyledAttributes(i, iArr));
    }

    private as(Context context, TypedArray typedArray) {
        this.f367a = context;
        this.f368b = typedArray;
    }

    public Drawable a(int i) {
        int resourceId;
        if (this.f368b.hasValue(i) && (resourceId = this.f368b.getResourceId(i, 0)) != 0) {
            return androidx.appcompat.a.a.a.b(this.f367a, resourceId);
        }
        return this.f368b.getDrawable(i);
    }

    public Drawable b(int i) {
        int resourceId;
        if (!this.f368b.hasValue(i) || (resourceId = this.f368b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return j.a().a(this.f367a, resourceId, true);
    }

    public Typeface a(int i, int i2, f.a aVar) {
        int resourceId = this.f368b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return androidx.core.a.a.f.a(this.f367a, resourceId, this.c, i2, aVar);
    }

    public CharSequence c(int i) {
        return this.f368b.getText(i);
    }

    public String d(int i) {
        return this.f368b.getString(i);
    }

    public boolean a(int i, boolean z) {
        return this.f368b.getBoolean(i, z);
    }

    public int a(int i, int i2) {
        return this.f368b.getInt(i, i2);
    }

    public float a(int i, float f) {
        return this.f368b.getFloat(i, f);
    }

    public int b(int i, int i2) {
        return this.f368b.getColor(i, i2);
    }

    public ColorStateList e(int i) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.f368b.hasValue(i) || (resourceId = this.f368b.getResourceId(i, 0)) == 0 || (colorStateListA = androidx.appcompat.a.a.a.a(this.f367a, resourceId)) == null) ? this.f368b.getColorStateList(i) : colorStateListA;
    }

    public int c(int i, int i2) {
        return this.f368b.getInteger(i, i2);
    }

    public float b(int i, float f) {
        return this.f368b.getDimension(i, f);
    }

    public int d(int i, int i2) {
        return this.f368b.getDimensionPixelOffset(i, i2);
    }

    public int e(int i, int i2) {
        return this.f368b.getDimensionPixelSize(i, i2);
    }

    public int f(int i, int i2) {
        return this.f368b.getLayoutDimension(i, i2);
    }

    public int g(int i, int i2) {
        return this.f368b.getResourceId(i, i2);
    }

    public CharSequence[] f(int i) {
        return this.f368b.getTextArray(i);
    }

    public boolean g(int i) {
        return this.f368b.hasValue(i);
    }

    public void a() {
        this.f368b.recycle();
    }
}
