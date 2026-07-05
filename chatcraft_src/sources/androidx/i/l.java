package androidx.i;

import android.view.View;
import android.view.ViewGroup;
import androidx.i.j;

/* compiled from: Scene.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f845a;

    /* renamed from: b, reason: collision with root package name */
    private Runnable f846b;

    public void a() {
        if (a(this.f845a) != this || this.f846b == null) {
            return;
        }
        this.f846b.run();
    }

    static void a(View view, l lVar) {
        view.setTag(j.a.transition_current_scene, lVar);
    }

    static l a(View view) {
        return (l) view.getTag(j.a.transition_current_scene);
    }
}
