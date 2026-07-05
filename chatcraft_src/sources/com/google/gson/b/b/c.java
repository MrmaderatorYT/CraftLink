package com.google.gson.b.b;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: UnsafeReflectionAccessor.java */
/* loaded from: classes.dex */
final class c extends b {

    /* renamed from: a, reason: collision with root package name */
    private static Class f3967a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f3968b = b();
    private final Field c = c();

    c() {
    }

    @Override // com.google.gson.b.b.b
    public void a(AccessibleObject accessibleObject) throws SecurityException {
        if (b(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
        }
    }

    boolean b(AccessibleObject accessibleObject) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f3968b != null && this.c != null) {
            try {
                f3967a.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f3968b, accessibleObject, Long.valueOf(((Long) f3967a.getMethod("objectFieldOffset", Field.class).invoke(this.f3968b, this.c)).longValue()), true);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static Object b() throws NoSuchFieldException {
        try {
            f3967a = Class.forName("sun.misc.Unsafe");
            Field declaredField = f3967a.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Field c() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }
}
