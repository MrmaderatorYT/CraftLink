package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PreferenceRecyclerViewAccessibilityDelegate.java */
/* loaded from: classes.dex */
public class k extends androidx.recyclerview.widget.m {

    /* renamed from: a, reason: collision with root package name */
    final RecyclerView f997a;

    /* renamed from: b, reason: collision with root package name */
    final androidx.core.g.a f998b;
    final androidx.core.g.a c;

    public k(RecyclerView recyclerView) {
        super(recyclerView);
        this.f998b = super.b();
        this.c = new androidx.core.g.a() { // from class: androidx.preference.k.1
            @Override // androidx.core.g.a
            public void a(View view, androidx.core.g.a.c cVar) {
                Preference preferenceA;
                k.this.f998b.a(view, cVar);
                int iF = k.this.f997a.f(view);
                RecyclerView.a adapter = k.this.f997a.getAdapter();
                if ((adapter instanceof h) && (preferenceA = ((h) adapter).a(iF)) != null) {
                    preferenceA.a(cVar);
                }
            }

            @Override // androidx.core.g.a
            public boolean a(View view, int i, Bundle bundle) {
                return k.this.f998b.a(view, i, bundle);
            }
        };
        this.f997a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.m
    public androidx.core.g.a b() {
        return this.c;
    }
}
