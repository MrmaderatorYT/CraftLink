package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: AdapterListUpdateCallback.java */
/* loaded from: classes.dex */
public final class b implements j {

    /* renamed from: a, reason: collision with root package name */
    private final RecyclerView.a f1073a;

    public b(RecyclerView.a aVar) {
        this.f1073a = aVar;
    }

    @Override // androidx.recyclerview.widget.j
    public void a(int i, int i2) {
        this.f1073a.b(i, i2);
    }

    @Override // androidx.recyclerview.widget.j
    public void b(int i, int i2) {
        this.f1073a.c(i, i2);
    }

    @Override // androidx.recyclerview.widget.j
    public void c(int i, int i2) {
        this.f1073a.a(i, i2);
    }

    @Override // androidx.recyclerview.widget.j
    public void a(int i, int i2, Object obj) {
        this.f1073a.a(i, i2, obj);
    }
}
