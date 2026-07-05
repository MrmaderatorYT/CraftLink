package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: PagerAdapter.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final DataSetObservable f1154a = new DataSetObservable();

    /* renamed from: b, reason: collision with root package name */
    private DataSetObserver f1155b;

    public int a(Object obj) {
        return -1;
    }

    public Parcelable a() {
        return null;
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Deprecated
    public void a(View view) {
    }

    public abstract boolean a(View view, Object obj);

    public float b(int i) {
        return 1.0f;
    }

    public abstract int b();

    @Deprecated
    public void b(View view) {
    }

    @Deprecated
    public void b(View view, int i, Object obj) {
    }

    public void a(ViewGroup viewGroup) {
        a((View) viewGroup);
    }

    public Object a(ViewGroup viewGroup, int i) {
        return a((View) viewGroup, i);
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        a((View) viewGroup, i, obj);
    }

    public void b(ViewGroup viewGroup, int i, Object obj) {
        b((View) viewGroup, i, obj);
    }

    public void b(ViewGroup viewGroup) {
        b((View) viewGroup);
    }

    @Deprecated
    public Object a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void c() {
        synchronized (this) {
            if (this.f1155b != null) {
                this.f1155b.onChanged();
            }
        }
        this.f1154a.notifyChanged();
    }

    public void a(DataSetObserver dataSetObserver) {
        this.f1154a.registerObserver(dataSetObserver);
    }

    void b(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f1155b = dataSetObserver;
        }
    }
}
