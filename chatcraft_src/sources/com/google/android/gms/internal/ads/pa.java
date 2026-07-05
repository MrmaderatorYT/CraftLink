package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import java.io.InputStream;

/* loaded from: classes.dex */
final class pa implements zf<at> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f3340a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ double f3341b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ ot e;

    pa(ot otVar, boolean z, double d, boolean z2, String str) {
        this.e = otVar;
        this.f3340a = z;
        this.f3341b = d;
        this.c = z2;
        this.d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zf
    @TargetApi(19)
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final at a(InputStream inputStream) {
        Bitmap bitmapDecodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (this.f3341b * 160.0d);
        if (!this.c) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
        } catch (Exception e) {
            xe.b("Error grabbing image.", e);
            bitmapDecodeStream = null;
        }
        if (bitmapDecodeStream == null) {
            this.e.a(2, this.f3340a);
            return null;
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis();
        if (com.google.android.gms.common.util.j.f() && xe.a()) {
            int width = bitmapDecodeStream.getWidth();
            int height = bitmapDecodeStream.getHeight();
            int allocationByteCount = bitmapDecodeStream.getAllocationByteCount();
            long j = jUptimeMillis2 - jUptimeMillis;
            boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
            StringBuilder sb = new StringBuilder(108);
            sb.append("Decoded image w: ");
            sb.append(width);
            sb.append(" h:");
            sb.append(height);
            sb.append(" bytes: ");
            sb.append(allocationByteCount);
            sb.append(" time: ");
            sb.append(j);
            sb.append(" on ui thread: ");
            sb.append(z);
            xe.a(sb.toString());
        }
        return new at(new BitmapDrawable(Resources.getSystem(), bitmapDecodeStream), Uri.parse(this.d), this.f3341b);
    }

    @Override // com.google.android.gms.internal.ads.zf
    public final /* synthetic */ at a() {
        this.e.a(2, this.f3340a);
        return null;
    }
}
