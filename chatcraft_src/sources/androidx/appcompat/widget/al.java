package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.af;

/* compiled from: ScrollingTabContainerView.java */
/* loaded from: classes.dex */
public class al extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final Interpolator j = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    Runnable f350a;

    /* renamed from: b, reason: collision with root package name */
    af f351b;
    int c;
    int d;
    private b e;
    private Spinner f;
    private boolean g;
    private int h;
    private int i;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f351b.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.c = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.c = View.MeasureSpec.getSize(i) / 2;
            }
            this.c = Math.min(this.c, this.d);
        } else {
            this.c = -1;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (!z && this.g) {
            this.f351b.measure(0, iMakeMeasureSpec);
            if (this.f351b.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                b();
            } else {
                c();
            }
        } else {
            c();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.i);
    }

    private boolean a() {
        return this.f != null && this.f.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.g = z;
    }

    private void b() {
        if (a()) {
            return;
        }
        if (this.f == null) {
            this.f = d();
        }
        removeView(this.f351b);
        addView(this.f, new ViewGroup.LayoutParams(-2, -1));
        if (this.f.getAdapter() == null) {
            this.f.setAdapter((SpinnerAdapter) new a());
        }
        if (this.f350a != null) {
            removeCallbacks(this.f350a);
            this.f350a = null;
        }
        this.f.setSelection(this.i);
    }

    private boolean c() {
        if (!a()) {
            return false;
        }
        removeView(this.f);
        addView(this.f351b, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f.getSelectedItemPosition());
        return false;
    }

    public void setTabSelected(int i) {
        this.i = i;
        int childCount = this.f351b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f351b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        if (this.f == null || i < 0) {
            return;
        }
        this.f.setSelection(i);
    }

    public void setContentHeight(int i) {
        this.h = i;
        requestLayout();
    }

    private Spinner d() {
        v vVar = new v(getContext(), null, a.C0018a.actionDropDownStyle);
        vVar.setLayoutParams(new af.a(-2, -1));
        vVar.setOnItemSelectedListener(this);
        return vVar;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.a aVarA = androidx.appcompat.view.a.a(getContext());
        setContentHeight(aVarA.e());
        this.d = aVarA.g();
    }

    public void a(int i) {
        final View childAt = this.f351b.getChildAt(i);
        if (this.f350a != null) {
            removeCallbacks(this.f350a);
        }
        this.f350a = new Runnable() { // from class: androidx.appcompat.widget.al.1
            @Override // java.lang.Runnable
            public void run() {
                al.this.smoothScrollTo(childAt.getLeft() - ((al.this.getWidth() - childAt.getWidth()) / 2), 0);
                al.this.f350a = null;
            }
        };
        post(this.f350a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f350a != null) {
            post(this.f350a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f350a != null) {
            removeCallbacks(this.f350a);
        }
    }

    c a(a.c cVar, boolean z) {
        c cVar2 = new c(getContext(), cVar, z);
        if (z) {
            cVar2.setBackgroundDrawable(null);
            cVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.h));
        } else {
            cVar2.setFocusable(true);
            if (this.e == null) {
                this.e = new b();
            }
            cVar2.setOnClickListener(this.e);
        }
        return cVar2;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j2) {
        ((c) view).b().d();
    }

    /* compiled from: ScrollingTabContainerView.java */
    private class c extends LinearLayout {

        /* renamed from: b, reason: collision with root package name */
        private final int[] f357b;
        private a.c c;
        private TextView d;
        private ImageView e;
        private View f;

        public c(Context context, a.c cVar, boolean z) {
            super(context, null, a.C0018a.actionBarTabStyle);
            this.f357b = new int[]{R.attr.background};
            this.c = cVar;
            as asVarA = as.a(context, null, this.f357b, a.C0018a.actionBarTabStyle, 0);
            if (asVarA.g(0)) {
                setBackgroundDrawable(asVarA.a(0));
            }
            asVarA.a();
            if (z) {
                setGravity(8388627);
            }
            a();
        }

        public void a(a.c cVar) {
            this.c = cVar;
            a();
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(a.c.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(a.c.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (al.this.c <= 0 || getMeasuredWidth() <= al.this.c) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(al.this.c, 1073741824), i2);
        }

        public void a() {
            a.c cVar = this.c;
            View viewC = cVar.c();
            if (viewC != null) {
                ViewParent parent = viewC.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewC);
                    }
                    addView(viewC);
                }
                this.f = viewC;
                if (this.d != null) {
                    this.d.setVisibility(8);
                }
                if (this.e != null) {
                    this.e.setVisibility(8);
                    this.e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f != null) {
                removeView(this.f);
                this.f = null;
            }
            Drawable drawableA = cVar.a();
            CharSequence charSequenceB = cVar.b();
            if (drawableA != null) {
                if (this.e == null) {
                    o oVar = new o(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    oVar.setLayoutParams(layoutParams);
                    addView(oVar, 0);
                    this.e = oVar;
                }
                this.e.setImageDrawable(drawableA);
                this.e.setVisibility(0);
            } else if (this.e != null) {
                this.e.setVisibility(8);
                this.e.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(charSequenceB);
            if (z) {
                if (this.d == null) {
                    x xVar = new x(getContext(), null, a.C0018a.actionBarTabTextStyle);
                    xVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    xVar.setLayoutParams(layoutParams2);
                    addView(xVar);
                    this.d = xVar;
                }
                this.d.setText(charSequenceB);
                this.d.setVisibility(0);
            } else if (this.d != null) {
                this.d.setVisibility(8);
                this.d.setText((CharSequence) null);
            }
            if (this.e != null) {
                this.e.setContentDescription(cVar.e());
            }
            au.a(this, z ? null : cVar.e());
        }

        public a.c b() {
            return this.c;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    private class a extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return al.this.f351b.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((c) al.this.f351b.getChildAt(i)).b();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return al.this.a((a.c) getItem(i), true);
            }
            ((c) view).a((a.c) getItem(i));
            return view;
        }
    }

    /* compiled from: ScrollingTabContainerView.java */
    private class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((c) view).b().d();
            int childCount = al.this.f351b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = al.this.f351b.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }
}
