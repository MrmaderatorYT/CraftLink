package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.a;
import java.util.ArrayList;

/* compiled from: NotificationCompat.java */
/* loaded from: classes.dex */
public class g {

    /* compiled from: NotificationCompat.java */
    public static abstract class c {
        public void a(Bundle bundle) {
        }

        public void a(f fVar) {
        }

        public RemoteViews b(f fVar) {
            return null;
        }

        public RemoteViews c(f fVar) {
            return null;
        }

        public RemoteViews d(f fVar) {
            return null;
        }
    }

    /* compiled from: NotificationCompat.java */
    public static class b {
        String A;
        Bundle B;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        String I;
        String K;
        long L;

        @Deprecated
        public ArrayList<String> O;

        /* renamed from: a, reason: collision with root package name */
        public Context f549a;
        CharSequence d;
        CharSequence e;
        PendingIntent f;
        PendingIntent g;
        RemoteViews h;
        Bitmap i;
        CharSequence j;
        int k;
        int l;
        boolean n;
        c o;
        CharSequence p;
        CharSequence[] q;
        int r;
        int s;
        boolean t;
        String u;
        boolean v;
        String w;
        boolean y;
        boolean z;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<a> f550b = new ArrayList<>();
        ArrayList<a> c = new ArrayList<>();
        boolean m = true;
        boolean x = false;
        int C = 0;
        int D = 0;
        int J = 0;
        int M = 0;
        Notification N = new Notification();

        public b(Context context, String str) {
            this.f549a = context;
            this.I = str;
            this.N.when = System.currentTimeMillis();
            this.N.audioStreamType = -1;
            this.l = 0;
            this.O = new ArrayList<>();
        }

        public b a(int i) {
            this.N.icon = i;
            return this;
        }

        public b a(CharSequence charSequence) {
            this.d = c(charSequence);
            return this;
        }

        public b b(CharSequence charSequence) {
            this.e = c(charSequence);
            return this;
        }

        public b a(Bitmap bitmap) {
            this.i = b(bitmap);
            return this;
        }

        private Bitmap b(Bitmap bitmap) throws Resources.NotFoundException {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f549a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(a.b.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(a.b.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double d = dimensionPixelSize;
            double dMax = Math.max(1, bitmap.getWidth());
            Double.isNaN(d);
            Double.isNaN(dMax);
            double d2 = d / dMax;
            double d3 = dimensionPixelSize2;
            double dMax2 = Math.max(1, bitmap.getHeight());
            Double.isNaN(d3);
            Double.isNaN(dMax2);
            double dMin = Math.min(d2, d3 / dMax2);
            double width = bitmap.getWidth();
            Double.isNaN(width);
            int iCeil = (int) Math.ceil(width * dMin);
            double height = bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, iCeil, (int) Math.ceil(height * dMin), true);
        }

        public b a(boolean z) {
            a(2, z);
            return this;
        }

        public b b(boolean z) {
            a(16, z);
            return this;
        }

        private void a(int i, boolean z) {
            if (z) {
                Notification notification = this.N;
                notification.flags = i | notification.flags;
            } else {
                Notification notification2 = this.N;
                notification2.flags = (i ^ (-1)) & notification2.flags;
            }
        }

        public Bundle a() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public b a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f550b.add(new a(i, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new h(this).a();
        }

        protected static CharSequence c(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }
    }

    /* compiled from: NotificationCompat.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Bundle f547a;

        /* renamed from: b, reason: collision with root package name */
        boolean f548b;
        public int c;
        public CharSequence d;
        public PendingIntent e;
        private final k[] f;
        private final k[] g;
        private boolean h;
        private final int i;

        public a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true);
        }

        a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, k[] kVarArr, k[] kVarArr2, boolean z, int i2, boolean z2) {
            this.f548b = true;
            this.c = i;
            this.d = b.c(charSequence);
            this.e = pendingIntent;
            this.f547a = bundle == null ? new Bundle() : bundle;
            this.f = kVarArr;
            this.g = kVarArr2;
            this.h = z;
            this.i = i2;
            this.f548b = z2;
        }

        public int a() {
            return this.c;
        }

        public CharSequence b() {
            return this.d;
        }

        public PendingIntent c() {
            return this.e;
        }

        public Bundle d() {
            return this.f547a;
        }

        public boolean e() {
            return this.h;
        }

        public k[] f() {
            return this.f;
        }

        public int g() {
            return this.i;
        }

        public k[] h() {
            return this.g;
        }

        public boolean i() {
            return this.f548b;
        }
    }

    public static Bundle a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return i.a(notification);
        }
        return null;
    }
}
