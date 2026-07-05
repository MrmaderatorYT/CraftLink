package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.a;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f317a;

    /* renamed from: b, reason: collision with root package name */
    private int f318b;
    private WeakReference<View> c;
    private LayoutInflater d;
    private a e;

    public interface a {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f317a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ViewStubCompat, i, 0);
        this.f318b = typedArrayObtainStyledAttributes.getResourceId(a.j.ViewStubCompat_android_inflatedId, -1);
        this.f317a = typedArrayObtainStyledAttributes.getResourceId(a.j.ViewStubCompat_android_layout, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(a.j.ViewStubCompat_android_id, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.f318b;
    }

    public void setInflatedId(int i) {
        this.f318b = i;
    }

    public int getLayoutResource() {
        return this.f317a;
    }

    public void setLayoutResource(int i) {
        this.f317a = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.d = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.d;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.c != null) {
            View view = this.c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            a();
        }
    }

    public View a() {
        LayoutInflater layoutInflaterFrom;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            if (this.f317a != 0) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (this.d != null) {
                    layoutInflaterFrom = this.d;
                } else {
                    layoutInflaterFrom = LayoutInflater.from(getContext());
                }
                View viewInflate = layoutInflaterFrom.inflate(this.f317a, viewGroup, false);
                if (this.f318b != -1) {
                    viewInflate.setId(this.f318b);
                }
                int iIndexOfChild = viewGroup.indexOfChild(this);
                viewGroup.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
                } else {
                    viewGroup.addView(viewInflate, iIndexOfChild);
                }
                this.c = new WeakReference<>(viewInflate);
                if (this.e != null) {
                    this.e.a(this, viewInflate);
                }
                return viewInflate;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    public void setOnInflateListener(a aVar) {
        this.e = aVar;
    }
}
