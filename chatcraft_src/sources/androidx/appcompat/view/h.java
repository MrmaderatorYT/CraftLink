package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.g.u;
import androidx.core.g.v;
import androidx.core.g.w;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: b, reason: collision with root package name */
    v f204b;
    private Interpolator d;
    private boolean e;
    private long c = -1;
    private final w f = new w() { // from class: androidx.appcompat.view.h.1

        /* renamed from: b, reason: collision with root package name */
        private boolean f206b = false;
        private int c = 0;

        @Override // androidx.core.g.w, androidx.core.g.v
        public void a(View view) {
            if (this.f206b) {
                return;
            }
            this.f206b = true;
            if (h.this.f204b != null) {
                h.this.f204b.a(null);
            }
        }

        void a() {
            this.c = 0;
            this.f206b = false;
            h.this.b();
        }

        @Override // androidx.core.g.w, androidx.core.g.v
        public void b(View view) {
            int i = this.c + 1;
            this.c = i;
            if (i == h.this.f203a.size()) {
                if (h.this.f204b != null) {
                    h.this.f204b.b(null);
                }
                a();
            }
        }
    };

    /* renamed from: a, reason: collision with root package name */
    final ArrayList<u> f203a = new ArrayList<>();

    public h a(u uVar) {
        if (!this.e) {
            this.f203a.add(uVar);
        }
        return this;
    }

    public h a(u uVar, u uVar2) {
        this.f203a.add(uVar);
        uVar2.b(uVar.a());
        this.f203a.add(uVar2);
        return this;
    }

    public void a() {
        if (this.e) {
            return;
        }
        Iterator<u> it = this.f203a.iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (this.c >= 0) {
                next.a(this.c);
            }
            if (this.d != null) {
                next.a(this.d);
            }
            if (this.f204b != null) {
                next.a(this.f);
            }
            next.c();
        }
        this.e = true;
    }

    void b() {
        this.e = false;
    }

    public void c() {
        if (this.e) {
            Iterator<u> it = this.f203a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.e = false;
        }
    }

    public h a(long j) {
        if (!this.e) {
            this.c = j;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.e) {
            this.d = interpolator;
        }
        return this;
    }

    public h a(v vVar) {
        if (!this.e) {
            this.f204b = vVar;
        }
        return this;
    }
}
