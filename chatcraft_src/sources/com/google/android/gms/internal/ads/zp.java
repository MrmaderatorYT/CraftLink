package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@qj
/* loaded from: classes.dex */
public final class zp {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, Bitmap> f3638a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f3639b = new AtomicInteger(0);

    public final int a(Bitmap bitmap) {
        if (bitmap == null) {
            xe.b("Bitmap is null. Skipping putting into the Memory Map.");
            return -1;
        }
        int andIncrement = this.f3639b.getAndIncrement();
        this.f3638a.put(Integer.valueOf(andIncrement), bitmap);
        return andIncrement;
    }

    public final Bitmap a(Integer num) {
        return this.f3638a.get(num);
    }

    public final void b(Integer num) {
        this.f3638a.remove(num);
    }
}
