package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.a;

/* compiled from: LinearLayoutCompat.java */
/* loaded from: classes.dex */
public class af extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    private boolean f333a;

    /* renamed from: b, reason: collision with root package name */
    private int f334b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    int a(View view) {
        return 0;
    }

    int a(View view, int i) {
        return 0;
    }

    int b(View view) {
        return 0;
    }

    int d(int i) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public af(Context context) {
        this(context, null);
    }

    public af(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public af(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f333a = true;
        this.f334b = -1;
        this.c = 0;
        this.e = 8388659;
        as asVarA = as.a(context, attributeSet, a.j.LinearLayoutCompat, i, 0);
        int iA = asVarA.a(a.j.LinearLayoutCompat_android_orientation, -1);
        if (iA >= 0) {
            setOrientation(iA);
        }
        int iA2 = asVarA.a(a.j.LinearLayoutCompat_android_gravity, -1);
        if (iA2 >= 0) {
            setGravity(iA2);
        }
        boolean zA = asVarA.a(a.j.LinearLayoutCompat_android_baselineAligned, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.g = asVarA.a(a.j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f334b = asVarA.a(a.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = asVarA.a(a.j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(asVarA.a(a.j.LinearLayoutCompat_divider));
        this.n = asVarA.a(a.j.LinearLayoutCompat_showDividers, 0);
        this.o = asVarA.e(a.j.LinearLayoutCompat_dividerPadding, 0);
        asVarA.a();
    }

    public void setShowDividers(int i) {
        if (i != this.n) {
            requestLayout();
        }
        this.n = i;
    }

    public int getShowDividers() {
        return this.n;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.k) {
            return;
        }
        this.k = drawable;
        if (drawable != null) {
            this.l = drawable.getIntrinsicWidth();
            this.m = drawable.getIntrinsicHeight();
        } else {
            this.l = 0;
            this.m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.o = i;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.k == null) {
            return;
        }
        if (this.d == 1) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    void a(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View viewB = b(i);
            if (viewB != null && viewB.getVisibility() != 8 && c(i)) {
                a(canvas, (viewB.getTop() - ((a) viewB.getLayoutParams()).topMargin) - this.m);
            }
        }
        if (c(virtualChildCount)) {
            View viewB2 = b(virtualChildCount - 1);
            if (viewB2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.m;
            } else {
                bottom = viewB2.getBottom() + ((a) viewB2.getLayoutParams()).bottomMargin;
            }
            a(canvas, bottom);
        }
    }

    void b(Canvas canvas) {
        int right;
        int left;
        int virtualChildCount = getVirtualChildCount();
        boolean zA = ay.a(this);
        for (int i = 0; i < virtualChildCount; i++) {
            View viewB = b(i);
            if (viewB != null && viewB.getVisibility() != 8 && c(i)) {
                a aVar = (a) viewB.getLayoutParams();
                if (zA) {
                    left = viewB.getRight() + aVar.rightMargin;
                } else {
                    left = (viewB.getLeft() - aVar.leftMargin) - this.l;
                }
                b(canvas, left);
            }
        }
        if (c(virtualChildCount)) {
            View viewB2 = b(virtualChildCount - 1);
            if (viewB2 != null) {
                a aVar2 = (a) viewB2.getLayoutParams();
                if (zA) {
                    right = (viewB2.getLeft() - aVar2.leftMargin) - this.l;
                } else {
                    right = viewB2.getRight() + aVar2.rightMargin;
                }
            } else if (zA) {
                right = getPaddingLeft();
            } else {
                right = (getWidth() - getPaddingRight()) - this.l;
            }
            b(canvas, right);
        }
    }

    void a(Canvas canvas, int i) {
        this.k.setBounds(getPaddingLeft() + this.o, i, (getWidth() - getPaddingRight()) - this.o, this.m + i);
        this.k.draw(canvas);
    }

    void b(Canvas canvas, int i) {
        this.k.setBounds(i, getPaddingTop() + this.o, this.l + i, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.f333a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f334b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f334b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f334b);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f334b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.c;
        if (this.d == 1 && (i = this.e & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f;
            }
        }
        return bottom + ((a) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f334b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f334b = i;
    }

    View b(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.d == 1) {
            a(i, i2);
        } else {
            b(i, i2);
        }
    }

    protected boolean c(int i) {
        if (i == 0) {
            return (this.n & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.n & 4) != 0;
        }
        if ((this.n & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0342  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(int r41, int r42) {
        /*
            Method dump skipped, instructions count: 932
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.af.a(int, int):void");
    }

    private void c(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View viewB = b(i3);
            if (viewB.getVisibility() != 8) {
                a aVar = (a) viewB.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = viewB.getMeasuredHeight();
                    measureChildWithMargins(viewB, iMakeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:201:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void b(int r45, int r46) {
        /*
            Method dump skipped, instructions count: 1310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.af.b(int, int):void");
    }

    private void d(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View viewB = b(i3);
            if (viewB.getVisibility() != 8) {
                a aVar = (a) viewB.getLayoutParams();
                if (aVar.height == -1) {
                    int i4 = aVar.width;
                    aVar.width = viewB.getMeasuredWidth();
                    measureChildWithMargins(viewB, i2, 0, iMakeMeasureSpec, 0);
                    aVar.width = i4;
                }
            }
        }
    }

    void a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.d == 1) {
            a(i, i2, i3, i4);
        } else {
            b(i, i2, i3, i4);
        }
    }

    void a(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int paddingLeft = getPaddingLeft();
        int i6 = i3 - i;
        int paddingRight = i6 - getPaddingRight();
        int paddingRight2 = (i6 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i7 = this.e & 112;
        int i8 = this.e & 8388615;
        if (i7 == 16) {
            paddingTop = (((i4 - i2) - this.f) / 2) + getPaddingTop();
        } else if (i7 == 80) {
            paddingTop = ((getPaddingTop() + i4) - i2) - this.f;
        } else {
            paddingTop = getPaddingTop();
        }
        int iA = 0;
        while (iA < virtualChildCount) {
            View viewB = b(iA);
            if (viewB == null) {
                paddingTop += d(iA);
            } else if (viewB.getVisibility() != 8) {
                int measuredWidth = viewB.getMeasuredWidth();
                int measuredHeight = viewB.getMeasuredHeight();
                a aVar = (a) viewB.getLayoutParams();
                int i9 = aVar.h;
                if (i9 < 0) {
                    i9 = i8;
                }
                int iA2 = androidx.core.g.c.a(i9, androidx.core.g.q.f(this)) & 7;
                if (iA2 == 1) {
                    i5 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + aVar.leftMargin) - aVar.rightMargin;
                } else if (iA2 == 5) {
                    i5 = (paddingRight - measuredWidth) - aVar.rightMargin;
                } else {
                    i5 = aVar.leftMargin + paddingLeft;
                }
                int i10 = i5;
                if (c(iA)) {
                    paddingTop += this.m;
                }
                int i11 = paddingTop + aVar.topMargin;
                a(viewB, i10, i11 + a(viewB), measuredWidth, measuredHeight);
                int iB = i11 + measuredHeight + aVar.bottomMargin + b(viewB);
                iA += a(viewB, iA);
                paddingTop = iB;
            }
            iA++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void b(int r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.af.b(int, int, int, int):void");
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    public void setOrientation(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.d;
    }

    public void setGravity(int i) {
        if (this.e != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.e = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.e;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((8388615 & this.e) != i2) {
            this.e = i2 | (this.e & (-8388616));
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.e & 112) != i2) {
            this.e = i2 | (this.e & (-113));
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        if (this.d == 0) {
            return new a(-2, -2);
        }
        if (this.d == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(af.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(af.class.getName());
    }

    /* compiled from: LinearLayoutCompat.java */
    public static class a extends ViewGroup.MarginLayoutParams {
        public float g;
        public int h;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.LinearLayoutCompat_Layout);
            this.g = typedArrayObtainStyledAttributes.getFloat(a.j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.h = typedArrayObtainStyledAttributes.getInt(a.j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public a(int i, int i2) {
            super(i, i2);
            this.h = -1;
            this.g = 0.0f;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.h = -1;
        }
    }
}
