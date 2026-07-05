package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
final class vn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Bitmap f3524a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ vk f3525b;

    vn(vk vkVar, Bitmap bitmap) {
        this.f3525b = vkVar;
        this.f3524a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f3524a.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        synchronized (this.f3525b.l) {
            this.f3525b.c.g = new avm();
            this.f3525b.c.g.c = byteArrayOutputStream.toByteArray();
            this.f3525b.c.g.f2317b = "image/png";
            this.f3525b.c.g.f2316a = 1;
        }
    }
}
