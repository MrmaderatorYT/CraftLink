package me.relex.circleindicator;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public class CircleIndicator extends a {
    private ViewPager k;
    private final ViewPager.f l;
    private final DataSetObserver m;

    @Override // me.relex.circleindicator.a
    public /* bridge */ /* synthetic */ void a(b bVar) {
        super.a(bVar);
    }

    public CircleIndicator(Context context) {
        super(context);
        this.l = new ViewPager.f() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.f
            public void a(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.f
            public void b(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.f
            public void a(int i) {
                if (CircleIndicator.this.k.getAdapter() == null || CircleIndicator.this.k.getAdapter().b() <= 0) {
                    return;
                }
                CircleIndicator.this.a(i);
                CircleIndicator.this.j = i;
            }
        };
        this.m = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator.this.k == null) {
                    return;
                }
                androidx.viewpager.widget.a adapter = CircleIndicator.this.k.getAdapter();
                int iB = adapter != null ? adapter.b() : 0;
                if (iB == CircleIndicator.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator.this.j < iB) {
                    CircleIndicator.this.j = CircleIndicator.this.k.getCurrentItem();
                } else {
                    CircleIndicator.this.j = -1;
                }
                CircleIndicator.this.a();
            }
        };
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new ViewPager.f() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.f
            public void a(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.f
            public void b(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.f
            public void a(int i) {
                if (CircleIndicator.this.k.getAdapter() == null || CircleIndicator.this.k.getAdapter().b() <= 0) {
                    return;
                }
                CircleIndicator.this.a(i);
                CircleIndicator.this.j = i;
            }
        };
        this.m = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator.this.k == null) {
                    return;
                }
                androidx.viewpager.widget.a adapter = CircleIndicator.this.k.getAdapter();
                int iB = adapter != null ? adapter.b() : 0;
                if (iB == CircleIndicator.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator.this.j < iB) {
                    CircleIndicator.this.j = CircleIndicator.this.k.getCurrentItem();
                } else {
                    CircleIndicator.this.j = -1;
                }
                CircleIndicator.this.a();
            }
        };
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new ViewPager.f() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.f
            public void a(int i2, float f, int i22) {
            }

            @Override // androidx.viewpager.widget.ViewPager.f
            public void b(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.f
            public void a(int i2) {
                if (CircleIndicator.this.k.getAdapter() == null || CircleIndicator.this.k.getAdapter().b() <= 0) {
                    return;
                }
                CircleIndicator.this.a(i2);
                CircleIndicator.this.j = i2;
            }
        };
        this.m = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator.this.k == null) {
                    return;
                }
                androidx.viewpager.widget.a adapter = CircleIndicator.this.k.getAdapter();
                int iB = adapter != null ? adapter.b() : 0;
                if (iB == CircleIndicator.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator.this.j < iB) {
                    CircleIndicator.this.j = CircleIndicator.this.k.getCurrentItem();
                } else {
                    CircleIndicator.this.j = -1;
                }
                CircleIndicator.this.a();
            }
        };
    }

    @TargetApi(21)
    public CircleIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.l = new ViewPager.f() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.f
            public void a(int i22, float f, int i222) {
            }

            @Override // androidx.viewpager.widget.ViewPager.f
            public void b(int i22) {
            }

            @Override // androidx.viewpager.widget.ViewPager.f
            public void a(int i22) {
                if (CircleIndicator.this.k.getAdapter() == null || CircleIndicator.this.k.getAdapter().b() <= 0) {
                    return;
                }
                CircleIndicator.this.a(i22);
                CircleIndicator.this.j = i22;
            }
        };
        this.m = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator.this.k == null) {
                    return;
                }
                androidx.viewpager.widget.a adapter = CircleIndicator.this.k.getAdapter();
                int iB = adapter != null ? adapter.b() : 0;
                if (iB == CircleIndicator.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator.this.j < iB) {
                    CircleIndicator.this.j = CircleIndicator.this.k.getCurrentItem();
                } else {
                    CircleIndicator.this.j = -1;
                }
                CircleIndicator.this.a();
            }
        };
    }

    public void setViewPager(ViewPager viewPager) {
        this.k = viewPager;
        if (this.k == null || this.k.getAdapter() == null) {
            return;
        }
        this.j = -1;
        a();
        this.k.b(this.l);
        this.k.a(this.l);
        this.l.a(this.k.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int iB;
        removeAllViews();
        androidx.viewpager.widget.a adapter = this.k.getAdapter();
        if (adapter == null || (iB = adapter.b()) <= 0) {
            return;
        }
        a(iB, this.k.getCurrentItem());
    }

    public DataSetObserver getDataSetObserver() {
        return this.m;
    }

    @Deprecated
    public void setOnPageChangeListener(ViewPager.f fVar) {
        if (this.k == null) {
            throw new NullPointerException("can not find Viewpager , setViewPager first");
        }
        this.k.b(fVar);
        this.k.a(fVar);
    }
}
