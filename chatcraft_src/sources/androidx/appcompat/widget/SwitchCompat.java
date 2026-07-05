package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.a;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private final TextPaint H;
    private ColorStateList I;
    private Layout J;
    private Layout K;
    private TransformationMethod L;
    private final Rect M;

    /* renamed from: a, reason: collision with root package name */
    float f305a;

    /* renamed from: b, reason: collision with root package name */
    ObjectAnimator f306b;
    private Drawable d;
    private ColorStateList e;
    private PorterDuff.Mode f;
    private boolean g;
    private boolean h;
    private Drawable i;
    private ColorStateList j;
    private PorterDuff.Mode k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private CharSequence r;
    private CharSequence s;
    private boolean t;
    private int u;
    private int v;
    private float w;
    private float x;
    private VelocityTracker y;
    private int z;
    private static final Property<SwitchCompat, Float> c = new Property<SwitchCompat, Float>(Float.class, "thumbPos") { // from class: androidx.appcompat.widget.SwitchCompat.1
        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f305a);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f) {
            switchCompat.setThumbPosition(f.floatValue());
        }
    };
    private static final int[] N = {R.attr.state_checked};

    private static float a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0018a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = false;
        this.j = null;
        this.k = null;
        this.l = false;
        this.m = false;
        this.y = VelocityTracker.obtain();
        this.M = new Rect();
        this.H = new TextPaint(1);
        Resources resources = getResources();
        this.H.density = resources.getDisplayMetrics().density;
        as asVarA = as.a(context, attributeSet, a.j.SwitchCompat, i, 0);
        this.d = asVarA.a(a.j.SwitchCompat_android_thumb);
        if (this.d != null) {
            this.d.setCallback(this);
        }
        this.i = asVarA.a(a.j.SwitchCompat_track);
        if (this.i != null) {
            this.i.setCallback(this);
        }
        this.r = asVarA.c(a.j.SwitchCompat_android_textOn);
        this.s = asVarA.c(a.j.SwitchCompat_android_textOff);
        this.t = asVarA.a(a.j.SwitchCompat_showText, true);
        this.n = asVarA.e(a.j.SwitchCompat_thumbTextPadding, 0);
        this.o = asVarA.e(a.j.SwitchCompat_switchMinWidth, 0);
        this.p = asVarA.e(a.j.SwitchCompat_switchPadding, 0);
        this.q = asVarA.a(a.j.SwitchCompat_splitTrack, false);
        ColorStateList colorStateListE = asVarA.e(a.j.SwitchCompat_thumbTint);
        if (colorStateListE != null) {
            this.e = colorStateListE;
            this.g = true;
        }
        PorterDuff.Mode modeA = ab.a(asVarA.a(a.j.SwitchCompat_thumbTintMode, -1), null);
        if (this.f != modeA) {
            this.f = modeA;
            this.h = true;
        }
        if (this.g || this.h) {
            b();
        }
        ColorStateList colorStateListE2 = asVarA.e(a.j.SwitchCompat_trackTint);
        if (colorStateListE2 != null) {
            this.j = colorStateListE2;
            this.l = true;
        }
        PorterDuff.Mode modeA2 = ab.a(asVarA.a(a.j.SwitchCompat_trackTintMode, -1), null);
        if (this.k != modeA2) {
            this.k = modeA2;
            this.m = true;
        }
        if (this.l || this.m) {
            a();
        }
        int iG = asVarA.g(a.j.SwitchCompat_switchTextAppearance, 0);
        if (iG != 0) {
            a(context, iG);
        }
        asVarA.a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.v = viewConfiguration.getScaledTouchSlop();
        this.z = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void a(Context context, int i) {
        as asVarA = as.a(context, i, a.j.TextAppearance);
        ColorStateList colorStateListE = asVarA.e(a.j.TextAppearance_android_textColor);
        if (colorStateListE != null) {
            this.I = colorStateListE;
        } else {
            this.I = getTextColors();
        }
        int iE = asVarA.e(a.j.TextAppearance_android_textSize, 0);
        if (iE != 0) {
            float f = iE;
            if (f != this.H.getTextSize()) {
                this.H.setTextSize(f);
                requestLayout();
            }
        }
        a(asVarA.a(a.j.TextAppearance_android_typeface, -1), asVarA.a(a.j.TextAppearance_android_textStyle, -1));
        if (asVarA.a(a.j.TextAppearance_textAllCaps, false)) {
            this.L = new androidx.appcompat.c.a(getContext());
        } else {
            this.L = null;
        }
        asVarA.a();
    }

    private void a(int i, int i2) {
        Typeface typeface;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
            default:
                typeface = null;
                break;
        }
        a(typeface, i2);
    }

    public void a(Typeface typeface, int i) {
        Typeface typefaceCreate;
        if (i > 0) {
            if (typeface == null) {
                typefaceCreate = Typeface.defaultFromStyle(i);
            } else {
                typefaceCreate = Typeface.create(typeface, i);
            }
            setSwitchTypeface(typefaceCreate);
            int style = ((typefaceCreate != null ? typefaceCreate.getStyle() : 0) ^ (-1)) & i;
            this.H.setFakeBoldText((style & 1) != 0);
            this.H.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.H.setFakeBoldText(false);
        this.H.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.H.getTypeface() == null || this.H.getTypeface().equals(typeface)) && (this.H.getTypeface() != null || typeface == null)) {
            return;
        }
        this.H.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setSwitchPadding(int i) {
        this.p = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.p;
    }

    public void setSwitchMinWidth(int i) {
        this.o = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.o;
    }

    public void setThumbTextPadding(int i) {
        this.n = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.n;
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.i != null) {
            this.i.setCallback(null);
        }
        this.i = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public Drawable getTrackDrawable() {
        return this.i;
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.l = true;
        a();
    }

    public ColorStateList getTrackTintList() {
        return this.j;
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.m = true;
        a();
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.k;
    }

    private void a() {
        if (this.i != null) {
            if (this.l || this.m) {
                this.i = this.i.mutate();
                if (this.l) {
                    androidx.core.graphics.drawable.a.a(this.i, this.j);
                }
                if (this.m) {
                    androidx.core.graphics.drawable.a.a(this.i, this.k);
                }
                if (this.i.isStateful()) {
                    this.i.setState(getDrawableState());
                }
            }
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.d != null) {
            this.d.setCallback(null);
        }
        this.d = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public Drawable getThumbDrawable() {
        return this.d;
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.e = colorStateList;
        this.g = true;
        b();
    }

    public ColorStateList getThumbTintList() {
        return this.e;
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f = mode;
        this.h = true;
        b();
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f;
    }

    private void b() {
        if (this.d != null) {
            if (this.g || this.h) {
                this.d = this.d.mutate();
                if (this.g) {
                    androidx.core.graphics.drawable.a.a(this.d, this.e);
                }
                if (this.h) {
                    androidx.core.graphics.drawable.a.a(this.d, this.f);
                }
                if (this.d.isStateful()) {
                    this.d.setState(getDrawableState());
                }
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.q = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.q;
    }

    public CharSequence getTextOn() {
        return this.r;
    }

    public void setTextOn(CharSequence charSequence) {
        this.r = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.s;
    }

    public void setTextOff(CharSequence charSequence) {
        this.s = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.t != z) {
            this.t = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.t;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.t) {
            if (this.J == null) {
                this.J = a(this.r);
            }
            if (this.K == null) {
                this.K = a(this.s);
            }
        }
        Rect rect = this.M;
        int intrinsicHeight2 = 0;
        if (this.d != null) {
            this.d.getPadding(rect);
            intrinsicWidth = (this.d.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.d.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.C = Math.max(this.t ? Math.max(this.J.getWidth(), this.K.getWidth()) + (this.n * 2) : 0, intrinsicWidth);
        if (this.i != null) {
            this.i.getPadding(rect);
            intrinsicHeight2 = this.i.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        if (this.d != null) {
            Rect rectA = ab.a(this.d);
            iMax = Math.max(iMax, rectA.left);
            iMax2 = Math.max(iMax2, rectA.right);
        }
        int iMax3 = Math.max(this.o, (this.C * 2) + iMax + iMax2);
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.A = iMax3;
        this.B = iMax4;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.r : this.s;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    private Layout a(CharSequence charSequence) {
        if (this.L != null) {
            charSequence = this.L.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        return new StaticLayout(charSequence2, this.H, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, this.H)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean a(float f, float f2) {
        if (this.d == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.d.getPadding(this.M);
        int i = this.E - this.v;
        int i2 = (this.D + thumbOffset) - this.v;
        return f > ((float) i2) && f < ((float) ((((this.C + i2) + this.M.left) + this.M.right) + this.v)) && f2 > ((float) i) && f2 < ((float) (this.G + this.v));
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.y.addMovement(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (isEnabled() && a(x, y)) {
                    this.u = 1;
                    this.w = x;
                    this.x = y;
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.u == 2) {
                    b(motionEvent);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.u = 0;
                this.y.clear();
                break;
            case 2:
                switch (this.u) {
                    case 1:
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x2 - this.w) > this.v || Math.abs(y2 - this.x) > this.v) {
                            this.u = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.w = x2;
                            this.x = y2;
                            return true;
                        }
                        break;
                    case 2:
                        float x3 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f = x3 - this.w;
                        float f2 = thumbScrollRange != 0 ? f / thumbScrollRange : f > 0.0f ? 1.0f : -1.0f;
                        if (ay.a(this)) {
                            f2 = -f2;
                        }
                        float fA = a(this.f305a + f2, 0.0f, 1.0f);
                        if (fA != this.f305a) {
                            this.w = x3;
                            setThumbPosition(fA);
                        }
                        return true;
                }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void a(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private void b(MotionEvent motionEvent) {
        boolean targetCheckedState;
        this.u = 0;
        boolean z = true;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z2) {
            this.y.computeCurrentVelocity(1000);
            float xVelocity = this.y.getXVelocity();
            if (Math.abs(xVelocity) > this.z) {
                if (!ay.a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z = false;
                }
                targetCheckedState = z;
            } else {
                targetCheckedState = getTargetCheckedState();
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        a(motionEvent);
    }

    private void a(boolean z) {
        this.f306b = ObjectAnimator.ofFloat(this, c, z ? 1.0f : 0.0f);
        this.f306b.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.f306b.setAutoCancel(true);
        }
        this.f306b.start();
    }

    private void c() {
        if (this.f306b != null) {
            this.f306b.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        return this.f305a > 0.5f;
    }

    void setThumbPosition(float f) {
        this.f305a = f;
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (getWindowToken() != null && androidx.core.g.q.x(this)) {
            a(zIsChecked);
        } else {
            c();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int iMax;
        int width;
        int paddingLeft;
        int paddingTop;
        int height;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        if (this.d != null) {
            Rect rect = this.M;
            if (this.i != null) {
                this.i.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectA = ab.a(this.d);
            int iMax2 = Math.max(0, rectA.left - rect.left);
            iMax = Math.max(0, rectA.right - rect.right);
            i5 = iMax2;
        } else {
            iMax = 0;
        }
        if (ay.a(this)) {
            paddingLeft = getPaddingLeft() + i5;
            width = ((this.A + paddingLeft) - i5) - iMax;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax;
            paddingLeft = (width - this.A) + i5 + iMax;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.B / 2);
            height = this.B + paddingTop;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.B + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.B;
        }
        this.D = paddingLeft;
        this.E = paddingTop;
        this.G = height;
        this.F = width;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Rect rectA;
        int i;
        int i2;
        Rect rect = this.M;
        int i3 = this.D;
        int i4 = this.E;
        int i5 = this.F;
        int i6 = this.G;
        int thumbOffset = getThumbOffset() + i3;
        if (this.d != null) {
            rectA = ab.a(this.d);
        } else {
            rectA = ab.f323a;
        }
        if (this.i != null) {
            this.i.getPadding(rect);
            thumbOffset += rect.left;
            if (rectA != null) {
                if (rectA.left > rect.left) {
                    i3 += rectA.left - rect.left;
                }
                i = rectA.top > rect.top ? (rectA.top - rect.top) + i4 : i4;
                if (rectA.right > rect.right) {
                    i5 -= rectA.right - rect.right;
                }
                if (rectA.bottom > rect.bottom) {
                    i2 = i6 - (rectA.bottom - rect.bottom);
                }
                this.i.setBounds(i3, i, i5, i2);
            } else {
                i = i4;
            }
            i2 = i6;
            this.i.setBounds(i3, i, i5, i2);
        }
        if (this.d != null) {
            this.d.getPadding(rect);
            int i7 = thumbOffset - rect.left;
            int i8 = thumbOffset + this.C + rect.right;
            this.d.setBounds(i7, i4, i8, i6);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.a(background, i7, i4, i8, i6);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int width;
        super.onDraw(canvas);
        Rect rect = this.M;
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.E;
        int i2 = this.G;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.d;
        if (drawable != null) {
            if (this.q && drawable2 != null) {
                Rect rectA = ab.a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectA.left;
                rect.right -= rectA.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            } else {
                drawable.draw(canvas);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.J : this.K;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            if (this.I != null) {
                this.H.setColor(this.I.getColorForState(drawableState, 0));
            }
            this.H.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i3 + i4) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!ay.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.p : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ay.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.p : compoundPaddingRight;
    }

    private int getThumbOffset() {
        float f;
        if (ay.a(this)) {
            f = 1.0f - this.f305a;
        } else {
            f = this.f305a;
        }
        return (int) ((f * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Rect rectA;
        if (this.i == null) {
            return 0;
        }
        Rect rect = this.M;
        this.i.getPadding(rect);
        if (this.d != null) {
            rectA = ab.a(this.d);
        } else {
            rectA = ab.f323a;
        }
        return ((((this.A - this.C) - rect.left) - rect.right) - rectA.left) - rectA.right;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, N);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.d;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.d != null) {
            androidx.core.graphics.drawable.a.a(this.d, f, f2);
        }
        if (this.i != null) {
            androidx.core.graphics.drawable.a.a(this.i, f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.d || drawable == this.i;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.d != null) {
            this.d.jumpToCurrentState();
        }
        if (this.i != null) {
            this.i.jumpToCurrentState();
        }
        if (this.f306b == null || !this.f306b.isStarted()) {
            return;
        }
        this.f306b.end();
        this.f306b = null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.r : this.s;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(text)) {
            accessibilityNodeInfo.setText(charSequence);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(' ');
        sb.append(charSequence);
        accessibilityNodeInfo.setText(sb);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.a(this, callback));
    }
}
