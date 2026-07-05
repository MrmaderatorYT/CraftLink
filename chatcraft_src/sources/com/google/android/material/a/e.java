package com.google.android.material.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

/* compiled from: DrawableAlphaProperty.java */
/* loaded from: classes.dex */
public class e extends Property<Drawable, Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final Property<Drawable, Integer> f3709a = new e();

    /* renamed from: b, reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f3710b;

    private e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f3710b = new WeakHashMap<>();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.f3710b.containsKey(drawable)) {
            return this.f3710b.get(drawable);
        }
        return 255;
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(Drawable drawable, Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.f3710b.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
