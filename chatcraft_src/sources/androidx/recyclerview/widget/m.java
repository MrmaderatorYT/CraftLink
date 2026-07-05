package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: RecyclerViewAccessibilityDelegate.java */
/* loaded from: classes.dex */
public class m extends androidx.core.g.a {
    final RecyclerView d;
    final androidx.core.g.a e = new a(this);

    public m(RecyclerView recyclerView) {
        this.d = recyclerView;
    }

    boolean c() {
        return this.d.w();
    }

    @Override // androidx.core.g.a
    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (c() || this.d.getLayoutManager() == null) {
            return false;
        }
        return this.d.getLayoutManager().a(i, bundle);
    }

    @Override // androidx.core.g.a
    public void a(View view, androidx.core.g.a.c cVar) {
        super.a(view, cVar);
        cVar.a((CharSequence) RecyclerView.class.getName());
        if (c() || this.d.getLayoutManager() == null) {
            return;
        }
        this.d.getLayoutManager().a(cVar);
    }

    @Override // androidx.core.g.a
    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (!(view instanceof RecyclerView) || c()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().a(accessibilityEvent);
        }
    }

    public androidx.core.g.a b() {
        return this.e;
    }

    /* compiled from: RecyclerViewAccessibilityDelegate.java */
    public static class a extends androidx.core.g.a {

        /* renamed from: a, reason: collision with root package name */
        final m f1129a;

        public a(m mVar) {
            this.f1129a = mVar;
        }

        @Override // androidx.core.g.a
        public void a(View view, androidx.core.g.a.c cVar) {
            super.a(view, cVar);
            if (this.f1129a.c() || this.f1129a.d.getLayoutManager() == null) {
                return;
            }
            this.f1129a.d.getLayoutManager().a(view, cVar);
        }

        @Override // androidx.core.g.a
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (this.f1129a.c() || this.f1129a.d.getLayoutManager() == null) {
                return false;
            }
            return this.f1129a.d.getLayoutManager().a(view, i, bundle);
        }
    }
}
