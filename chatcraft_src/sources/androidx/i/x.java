package androidx.i;

import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ViewGroupUtils.java */
/* loaded from: classes.dex */
class x {
    static w a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new v(viewGroup);
        }
        return u.a(viewGroup);
    }

    static void a(ViewGroup viewGroup, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 18) {
            z.a(viewGroup, z);
        } else {
            y.a(viewGroup, z);
        }
    }
}
