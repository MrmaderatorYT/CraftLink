package mattecarra.usavsursschat.McClient;

import android.graphics.Bitmap;
import android.text.SpannableString;
import mattecarra.usavsursschat.i.e;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: ServerStatus.java */
/* loaded from: classes.dex */
public class b {
    public SpannableString e;

    /* renamed from: a, reason: collision with root package name */
    public long f4856a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f4857b = 0;
    public int c = 0;
    public Bitmap d = null;
    public int f = e.a();
    public String g = e.a(this.f);

    public long a() {
        return this.f4856a;
    }

    public int b() {
        return this.f4857b;
    }

    public int c() {
        return this.c;
    }

    public Bitmap d() {
        return this.d;
    }

    public SpannableString e() {
        return this.e == null ? new SpannableString(BuildConfig.FLAVOR) : this.e;
    }

    public int f() {
        return this.f;
    }
}
