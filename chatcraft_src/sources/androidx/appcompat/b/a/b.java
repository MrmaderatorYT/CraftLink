package androidx.appcompat.b.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;

/* compiled from: DrawableContainer.java */
/* loaded from: classes.dex */
class b extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    private AbstractC0024b f178a;

    /* renamed from: b, reason: collision with root package name */
    private Rect f179b;
    private Drawable c;
    private Drawable d;
    private boolean f;
    private boolean i;
    private Runnable j;
    private long k;
    private long l;
    private a m;
    private int e = 255;
    private int g = -1;
    private int h = -1;

    b() {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.c != null) {
            this.c.draw(canvas);
        }
        if (this.d != null) {
            this.d.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f178a.getChangingConfigurations();
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(23)
    private boolean a() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect rectE = this.f178a.e();
        if (rectE != null) {
            rect.set(rectE);
            padding = (rectE.right | ((rectE.left | rectE.top) | rectE.bottom)) != 0;
        } else if (this.c != null) {
            padding = this.c.getPadding(rect);
        } else {
            padding = super.getPadding(rect);
        }
        if (a()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.c != null) {
            this.c.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f && this.e == i) {
            return;
        }
        this.f = true;
        this.e = i;
        if (this.c != null) {
            if (this.k == 0) {
                this.c.setAlpha(i);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        if (this.f178a.z != z) {
            this.f178a.z = z;
            if (this.c != null) {
                this.c.setDither(this.f178a.z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f178a.G = true;
        if (this.f178a.F != colorFilter) {
            this.f178a.F = colorFilter;
            if (this.c != null) {
                this.c.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f178a.J = true;
        if (this.f178a.H != colorStateList) {
            this.f178a.H = colorStateList;
            androidx.core.graphics.drawable.a.a(this.c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f178a.K = true;
        if (this.f178a.I != mode) {
            this.f178a.I = mode;
            androidx.core.graphics.drawable.a.a(this.c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.d != null) {
            this.d.setBounds(rect);
        }
        if (this.c != null) {
            this.c.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f178a.m();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f178a.E != z) {
            this.f178a.E = z;
            if (this.c != null) {
                androidx.core.graphics.drawable.a.a(this.c, this.f178a.E);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f178a.E;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        if (this.d != null) {
            this.d.jumpToCurrentState();
            this.d = null;
            this.h = -1;
            z = true;
        } else {
            z = false;
        }
        if (this.c != null) {
            this.c.jumpToCurrentState();
            if (this.f) {
                this.c.setAlpha(this.e);
            }
        }
        if (this.l != 0) {
            this.l = 0L;
            z = true;
        }
        if (this.k != 0) {
            this.k = 0L;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f179b == null) {
            this.f179b = new Rect(i, i2, i3, i4);
        } else {
            this.f179b.set(i, i2, i3, i4);
        }
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        if (this.f179b != null) {
            rect.set(this.f179b);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.d != null) {
            return this.d.setState(iArr);
        }
        if (this.c != null) {
            return this.c.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (this.d != null) {
            return this.d.setLevel(i);
        }
        if (this.c != null) {
            return this.c.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.f178a.d(i, d());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f178a.f()) {
            return this.f178a.g();
        }
        if (this.c != null) {
            return this.c.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f178a.f()) {
            return this.f178a.h();
        }
        if (this.c != null) {
            return this.c.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f178a.f()) {
            return this.f178a.i();
        }
        if (this.c != null) {
            return this.c.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f178a.f()) {
            return this.f178a.j();
        }
        if (this.c != null) {
            return this.c.getMinimumHeight();
        }
        return 0;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.f178a != null) {
            this.f178a.b();
        }
        if (drawable != this.c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.d != null) {
            this.d.setVisible(z, z2);
        }
        if (this.c != null) {
            this.c.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.c == null || !this.c.isVisible()) {
            return -2;
        }
        return this.f178a.l();
    }

    int d() {
        return this.g;
    }

    boolean a(int i) {
        if (i == this.g) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f178a.D > 0) {
            if (this.d != null) {
                this.d.setVisible(false, false);
            }
            if (this.c != null) {
                this.d = this.c;
                this.h = this.g;
                this.l = this.f178a.D + jUptimeMillis;
            } else {
                this.d = null;
                this.h = -1;
                this.l = 0L;
            }
        } else if (this.c != null) {
            this.c.setVisible(false, false);
        }
        if (i >= 0 && i < this.f178a.j) {
            Drawable drawableB = this.f178a.b(i);
            this.c = drawableB;
            this.g = i;
            if (drawableB != null) {
                if (this.f178a.C > 0) {
                    this.k = jUptimeMillis + this.f178a.C;
                }
                a(drawableB);
            }
        } else {
            this.c = null;
            this.g = -1;
        }
        if (this.k != 0 || this.l != 0) {
            if (this.j == null) {
                this.j = new Runnable() { // from class: androidx.appcompat.b.a.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a(true);
                        b.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(this.j);
            }
            a(true);
        }
        invalidateSelf();
        return true;
    }

    private void a(Drawable drawable) {
        if (this.m == null) {
            this.m = new a();
        }
        drawable.setCallback(this.m.a(drawable.getCallback()));
        try {
            if (this.f178a.C <= 0 && this.f) {
                drawable.setAlpha(this.e);
            }
            if (this.f178a.G) {
                drawable.setColorFilter(this.f178a.F);
            } else {
                if (this.f178a.J) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f178a.H);
                }
                if (this.f178a.K) {
                    androidx.core.graphics.drawable.a.a(drawable, this.f178a.I);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f178a.z);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f178a.E);
            }
            Rect rect = this.f179b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.m.a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(boolean r13) {
        /*
            r12 = this;
            r0 = 1
            r12.f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r12.c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L40
            long r9 = r12.k
            int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r3 == 0) goto L42
            long r9 = r12.k
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 > 0) goto L26
            android.graphics.drawable.Drawable r3 = r12.c
            int r9 = r12.e
            r3.setAlpha(r9)
            r12.k = r7
            goto L42
        L26:
            long r9 = r12.k
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r3 = (int) r9
            androidx.appcompat.b.a.b$b r9 = r12.f178a
            int r9 = r9.C
            int r3 = r3 / r9
            android.graphics.drawable.Drawable r9 = r12.c
            int r3 = 255 - r3
            int r10 = r12.e
            int r3 = r3 * r10
            int r3 = r3 / 255
            r9.setAlpha(r3)
            r3 = 1
            goto L43
        L40:
            r12.k = r7
        L42:
            r3 = 0
        L43:
            android.graphics.drawable.Drawable r9 = r12.d
            if (r9 == 0) goto L78
            long r9 = r12.l
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L7a
            long r9 = r12.l
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L61
            android.graphics.drawable.Drawable r0 = r12.d
            r0.setVisible(r6, r6)
            r0 = 0
            r12.d = r0
            r0 = -1
            r12.h = r0
            r12.l = r7
            goto L7a
        L61:
            long r6 = r12.l
            long r6 = r6 - r1
            long r6 = r6 * r4
            int r3 = (int) r6
            androidx.appcompat.b.a.b$b r4 = r12.f178a
            int r4 = r4.D
            int r3 = r3 / r4
            android.graphics.drawable.Drawable r4 = r12.d
            int r5 = r12.e
            int r3 = r3 * r5
            int r3 = r3 / 255
            r4.setAlpha(r3)
            goto L7b
        L78:
            r12.l = r7
        L7a:
            r0 = r3
        L7b:
            if (r13 == 0) goto L87
            if (r0 == 0) goto L87
            java.lang.Runnable r13 = r12.j
            r3 = 16
            long r1 = r1 + r3
            r12.scheduleSelf(r13, r1)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.b.a.b.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.c;
    }

    final void a(Resources resources) {
        this.f178a.a(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f178a.a(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f178a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f178a.n()) {
            return null;
        }
        this.f178a.f = getChangingConfigurations();
        return this.f178a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.i && super.mutate() == this) {
            AbstractC0024b abstractC0024bC = c();
            abstractC0024bC.a();
            a(abstractC0024bC);
            this.i = true;
        }
        return this;
    }

    AbstractC0024b c() {
        return this.f178a;
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: androidx.appcompat.b.a.b$b, reason: collision with other inner class name */
    static abstract class AbstractC0024b extends Drawable.ConstantState {
        boolean A;
        int B;
        int C;
        int D;
        boolean E;
        ColorFilter F;
        boolean G;
        ColorStateList H;
        PorterDuff.Mode I;
        boolean J;
        boolean K;
        final b c;
        Resources d;
        int e;
        int f;
        int g;
        SparseArray<Drawable.ConstantState> h;
        Drawable[] i;
        int j;
        boolean k;
        boolean l;
        Rect m;
        boolean n;
        boolean o;
        int p;
        int q;
        int r;
        int s;
        boolean t;
        int u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        boolean z;

        AbstractC0024b(AbstractC0024b abstractC0024b, b bVar, Resources resources) {
            Resources resources2;
            this.e = 160;
            this.k = false;
            this.n = false;
            this.z = true;
            this.C = 0;
            this.D = 0;
            this.c = bVar;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = abstractC0024b != null ? abstractC0024b.d : null;
            }
            this.d = resources2;
            this.e = b.a(resources, abstractC0024b != null ? abstractC0024b.e : 0);
            if (abstractC0024b != null) {
                this.f = abstractC0024b.f;
                this.g = abstractC0024b.g;
                this.x = true;
                this.y = true;
                this.k = abstractC0024b.k;
                this.n = abstractC0024b.n;
                this.z = abstractC0024b.z;
                this.A = abstractC0024b.A;
                this.B = abstractC0024b.B;
                this.C = abstractC0024b.C;
                this.D = abstractC0024b.D;
                this.E = abstractC0024b.E;
                this.F = abstractC0024b.F;
                this.G = abstractC0024b.G;
                this.H = abstractC0024b.H;
                this.I = abstractC0024b.I;
                this.J = abstractC0024b.J;
                this.K = abstractC0024b.K;
                if (abstractC0024b.e == this.e) {
                    if (abstractC0024b.l) {
                        this.m = new Rect(abstractC0024b.m);
                        this.l = true;
                    }
                    if (abstractC0024b.o) {
                        this.p = abstractC0024b.p;
                        this.q = abstractC0024b.q;
                        this.r = abstractC0024b.r;
                        this.s = abstractC0024b.s;
                        this.o = true;
                    }
                }
                if (abstractC0024b.t) {
                    this.u = abstractC0024b.u;
                    this.t = true;
                }
                if (abstractC0024b.v) {
                    this.w = abstractC0024b.w;
                    this.v = true;
                }
                Drawable[] drawableArr = abstractC0024b.i;
                this.i = new Drawable[drawableArr.length];
                this.j = abstractC0024b.j;
                SparseArray<Drawable.ConstantState> sparseArray = abstractC0024b.h;
                if (sparseArray != null) {
                    this.h = sparseArray.clone();
                } else {
                    this.h = new SparseArray<>(this.j);
                }
                int i = this.j;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null) {
                        Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.h.put(i2, constantState);
                        } else {
                            this.i[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.i = new Drawable[10];
            this.j = 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f | this.g;
        }

        public final int a(Drawable drawable) {
            int i = this.j;
            if (i >= this.i.length) {
                e(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.c);
            this.i[i] = drawable;
            this.j++;
            this.g = drawable.getChangingConfigurations() | this.g;
            b();
            this.m = null;
            this.l = false;
            this.o = false;
            this.x = false;
            return i;
        }

        void b() {
            this.t = false;
            this.v = false;
        }

        final int c() {
            return this.i.length;
        }

        private void o() {
            if (this.h != null) {
                int size = this.h.size();
                for (int i = 0; i < size; i++) {
                    this.i[this.h.keyAt(i)] = b(this.h.valueAt(i).newDrawable(this.d));
                }
                this.h = null;
            }
        }

        private Drawable b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.B);
            }
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.c);
            return drawableMutate;
        }

        public final int d() {
            return this.j;
        }

        public final Drawable b(int i) {
            int iIndexOfKey;
            Drawable drawable = this.i[i];
            if (drawable != null) {
                return drawable;
            }
            if (this.h == null || (iIndexOfKey = this.h.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable drawableB = b(this.h.valueAt(iIndexOfKey).newDrawable(this.d));
            this.i[i] = drawableB;
            this.h.removeAt(iIndexOfKey);
            if (this.h.size() == 0) {
                this.h = null;
            }
            return drawableB;
        }

        final boolean d(int i, int i2) {
            int i3 = this.j;
            Drawable[] drawableArr = this.i;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.B = i;
            return z;
        }

        final void a(Resources resources) {
            if (resources != null) {
                this.d = resources;
                int iA = b.a(resources, this.e);
                int i = this.e;
                this.e = iA;
                if (i != iA) {
                    this.o = false;
                    this.l = false;
                }
            }
        }

        final void a(Resources.Theme theme) {
            if (theme != null) {
                o();
                int i = this.j;
                Drawable[] drawableArr = this.i;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.g |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                a(theme.getResources());
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.j;
            Drawable[] drawableArr = this.i;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    if (drawable.canApplyTheme()) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.h.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                }
            }
            return false;
        }

        void a() {
            int i = this.j;
            Drawable[] drawableArr = this.i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null) {
                    drawableArr[i2].mutate();
                }
            }
            this.A = true;
        }

        public final void a(boolean z) {
            this.k = z;
        }

        public final Rect e() {
            if (this.k) {
                return null;
            }
            if (this.m != null || this.l) {
                return this.m;
            }
            o();
            Rect rect = new Rect();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            Rect rect2 = null;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect)) {
                    if (rect2 == null) {
                        rect2 = new Rect(0, 0, 0, 0);
                    }
                    if (rect.left > rect2.left) {
                        rect2.left = rect.left;
                    }
                    if (rect.top > rect2.top) {
                        rect2.top = rect.top;
                    }
                    if (rect.right > rect2.right) {
                        rect2.right = rect.right;
                    }
                    if (rect.bottom > rect2.bottom) {
                        rect2.bottom = rect.bottom;
                    }
                }
            }
            this.l = true;
            this.m = rect2;
            return rect2;
        }

        public final void b(boolean z) {
            this.n = z;
        }

        public final boolean f() {
            return this.n;
        }

        public final int g() {
            if (!this.o) {
                k();
            }
            return this.p;
        }

        public final int h() {
            if (!this.o) {
                k();
            }
            return this.q;
        }

        public final int i() {
            if (!this.o) {
                k();
            }
            return this.r;
        }

        public final int j() {
            if (!this.o) {
                k();
            }
            return this.s;
        }

        protected void k() {
            this.o = true;
            o();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            this.q = -1;
            this.p = -1;
            this.s = 0;
            this.r = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.p) {
                    this.p = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.q) {
                    this.q = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.r) {
                    this.r = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.s) {
                    this.s = minimumHeight;
                }
            }
        }

        public final void c(int i) {
            this.C = i;
        }

        public final void d(int i) {
            this.D = i;
        }

        public final int l() {
            if (this.t) {
                return this.u;
            }
            o();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.u = opacity;
            this.t = true;
            return opacity;
        }

        public final boolean m() {
            if (this.v) {
                return this.w;
            }
            o();
            int i = this.j;
            Drawable[] drawableArr = this.i;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                }
                if (drawableArr[i2].isStateful()) {
                    z = true;
                    break;
                }
                i2++;
            }
            this.w = z;
            this.v = true;
            return z;
        }

        public void e(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.i, 0, drawableArr, 0, i);
            this.i = drawableArr;
        }

        public synchronized boolean n() {
            if (this.x) {
                return this.y;
            }
            o();
            this.x = true;
            int i = this.j;
            Drawable[] drawableArr = this.i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.y = false;
                    return false;
                }
            }
            this.y = true;
            return true;
        }
    }

    protected void a(AbstractC0024b abstractC0024b) {
        this.f178a = abstractC0024b;
        if (this.g >= 0) {
            this.c = abstractC0024b.b(this.g);
            if (this.c != null) {
                a(this.c);
            }
        }
        this.h = -1;
        this.d = null;
    }

    /* compiled from: DrawableContainer.java */
    static class a implements Drawable.Callback {

        /* renamed from: a, reason: collision with root package name */
        private Drawable.Callback f181a;

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        a() {
        }

        public a a(Drawable.Callback callback) {
            this.f181a = callback;
            return this;
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f181a;
            this.f181a = null;
            return callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (this.f181a != null) {
                this.f181a.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (this.f181a != null) {
                this.f181a.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static int a(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }
}
