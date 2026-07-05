package com.afollestad.materialdialogs.internal;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.afollestad.materialdialogs.e;

/* compiled from: ThemeSingleton.java */
/* loaded from: classes.dex */
public class d {
    private static d w;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1236a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f1237b = 0;
    public int c = 0;
    public ColorStateList d = null;
    public ColorStateList e = null;
    public ColorStateList f = null;
    public int g = 0;
    public int h = 0;
    public Drawable i = null;
    public int j = 0;
    public int k = 0;
    public ColorStateList l = null;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public e r = e.START;
    public e s = e.START;
    public e t = e.END;
    public e u = e.START;
    public e v = e.START;

    public static d a(boolean z) {
        if (w == null && z) {
            w = new d();
        }
        return w;
    }

    public static d a() {
        return a(true);
    }
}
