package androidx.core.g;

import android.os.Build;
import android.view.ViewGroup;
import androidx.core.a;

/* compiled from: ViewGroupCompat.java */
/* loaded from: classes.dex */
public final class s {
    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(a.c.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && q.n(viewGroup) == null) ? false : true;
    }
}
