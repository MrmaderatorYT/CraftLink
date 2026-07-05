package androidx.core.e;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;
import me.zhanghai.android.materialprogressbar.BuildConfig;

/* compiled from: TextUtilsCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Locale f609a = new Locale(BuildConfig.FLAVOR, BuildConfig.FLAVOR);

    public static int a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(f609a)) {
            return 0;
        }
        String strA = a.a(locale);
        if (strA == null) {
            return b(locale);
        }
        return (strA.equalsIgnoreCase("Arab") || strA.equalsIgnoreCase("Hebr")) ? 1 : 0;
    }

    private static int b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 1:
            case 2:
                return 1;
            default:
                return 0;
        }
    }
}
