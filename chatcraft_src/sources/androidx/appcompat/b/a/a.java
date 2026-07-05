package androidx.appcompat.b.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.a;
import androidx.appcompat.b.a.b;
import androidx.appcompat.b.a.d;
import androidx.b.h;
import androidx.core.a.a.g;
import androidx.j.a.a.i;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatedStateListDrawableCompat.java */
/* loaded from: classes.dex */
public class a extends androidx.appcompat.b.a.d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f168a = "a";

    /* renamed from: b, reason: collision with root package name */
    private b f169b;
    private f c;
    private int d;
    private int e;
    private boolean f;

    @Override // androidx.appcompat.b.a.d, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.b.a.d, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public a() {
        this(null, null);
    }

    a(b bVar, Resources resources) {
        super(null);
        this.d = -1;
        this.e = -1;
        a(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static a a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        a aVar = new a();
        aVar.b(context, resources, xmlPullParser, attributeSet, theme);
        return aVar;
    }

    @Override // androidx.appcompat.b.a.d
    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        TypedArray typedArrayA = g.a(resources, theme, attributeSet, a.j.AnimatedStateListDrawableCompat);
        setVisible(typedArrayA.getBoolean(a.j.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(typedArrayA);
        a(resources);
        typedArrayA.recycle();
        c(context, resources, xmlPullParser, attributeSet, theme);
        e();
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.c != null && (visible || z2)) {
            if (z) {
                this.c.a();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (this.c != null) {
            this.c.b();
            this.c = null;
            a(this.d);
            this.d = -1;
            this.e = -1;
        }
    }

    @Override // androidx.appcompat.b.a.d, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int iA = this.f169b.a(iArr);
        boolean z = iA != d() && (b(iA) || a(iA));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    private boolean b(int i) {
        int iD;
        int iA;
        f c0023a;
        f fVar = this.c;
        if (fVar != null) {
            if (i == this.d) {
                return true;
            }
            if (i == this.e && fVar.c()) {
                fVar.d();
                this.d = this.e;
                this.e = i;
                return true;
            }
            iD = this.d;
            fVar.b();
        } else {
            iD = d();
        }
        this.c = null;
        this.e = -1;
        this.d = -1;
        b bVar = this.f169b;
        int iA2 = bVar.a(iD);
        int iA3 = bVar.a(i);
        if (iA3 == 0 || iA2 == 0 || (iA = bVar.a(iA2, iA3)) < 0) {
            return false;
        }
        boolean zC = bVar.c(iA2, iA3);
        a(iA);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            c0023a = new d((AnimationDrawable) current, bVar.b(iA2, iA3), zC);
        } else if (current instanceof androidx.j.a.a.c) {
            c0023a = new c((androidx.j.a.a.c) current);
        } else {
            if (!(current instanceof Animatable)) {
                return false;
            }
            c0023a = new C0023a((Animatable) current);
        }
        c0023a.a();
        this.c = c0023a;
        this.e = iD;
        this.d = i;
        return true;
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    private static abstract class f {
        public abstract void a();

        public abstract void b();

        public boolean c() {
            return false;
        }

        public void d() {
        }

        private f() {
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: androidx.appcompat.b.a.a$a, reason: collision with other inner class name */
    private static class C0023a extends f {

        /* renamed from: a, reason: collision with root package name */
        private final Animatable f170a;

        C0023a(Animatable animatable) {
            super();
            this.f170a = animatable;
        }

        @Override // androidx.appcompat.b.a.a.f
        public void a() {
            this.f170a.start();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void b() {
            this.f170a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    private static class d extends f {

        /* renamed from: a, reason: collision with root package name */
        private final ObjectAnimator f174a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f175b;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                objectAnimatorOfInt.setAutoCancel(true);
            }
            objectAnimatorOfInt.setDuration(eVar.a());
            objectAnimatorOfInt.setInterpolator(eVar);
            this.f175b = z2;
            this.f174a = objectAnimatorOfInt;
        }

        @Override // androidx.appcompat.b.a.a.f
        public boolean c() {
            return this.f175b;
        }

        @Override // androidx.appcompat.b.a.a.f
        public void a() {
            this.f174a.start();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void d() {
            this.f174a.reverse();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void b() {
            this.f174a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    private static class c extends f {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.j.a.a.c f173a;

        c(androidx.j.a.a.c cVar) {
            super();
            this.f173a = cVar;
        }

        @Override // androidx.appcompat.b.a.a.f
        public void a() {
            this.f173a.start();
        }

        @Override // androidx.appcompat.b.a.a.f
        public void b() {
            this.f173a.stop();
        }
    }

    private void a(TypedArray typedArray) {
        b bVar = this.f169b;
        if (Build.VERSION.SDK_INT >= 21) {
            bVar.f |= typedArray.getChangingConfigurations();
        }
        bVar.a(typedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_variablePadding, bVar.k));
        bVar.b(typedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_constantSize, bVar.n));
        bVar.c(typedArray.getInt(a.j.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.C));
        bVar.d(typedArray.getInt(a.j.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.D));
        setDither(typedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_dither, bVar.z));
    }

    private void e() {
        onStateChange(getState());
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    e(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    d(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private int d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        TypedArray typedArrayA = g.a(resources, theme, attributeSet, a.j.AnimatedStateListDrawableTransition);
        int resourceId = typedArrayA.getResourceId(a.j.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = typedArrayA.getResourceId(a.j.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = typedArrayA.getResourceId(a.j.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawableB = resourceId3 > 0 ? androidx.appcompat.a.a.a.b(context, resourceId3) : null;
        boolean z = typedArrayA.getBoolean(a.j.AnimatedStateListDrawableTransition_android_reversible, false);
        typedArrayA.recycle();
        if (drawableB == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (xmlPullParser.getName().equals("animated-vector")) {
                drawableB = androidx.j.a.a.c.a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawableB = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableB = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableB == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId == -1 || resourceId2 == -1) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
        return this.f169b.a(resourceId, resourceId2, drawableB, z);
    }

    private int e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayA = g.a(resources, theme, attributeSet, a.j.AnimatedStateListDrawableItem);
        int resourceId = typedArrayA.getResourceId(a.j.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = typedArrayA.getResourceId(a.j.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawableB = resourceId2 > 0 ? androidx.appcompat.a.a.a.b(context, resourceId2) : null;
        typedArrayA.recycle();
        int[] iArrA = a(attributeSet);
        if (drawableB == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (xmlPullParser.getName().equals("vector")) {
                drawableB = i.a(resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawableB = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableB = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableB == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        return this.f169b.a(iArrA, drawableB, resourceId);
    }

    @Override // androidx.appcompat.b.a.d, androidx.appcompat.b.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f && super.mutate() == this) {
            this.f169b.a();
            this.f = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.b.a.d, androidx.appcompat.b.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b c() {
        return new b(this.f169b, this, null);
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    static class b extends d.a {

        /* renamed from: a, reason: collision with root package name */
        androidx.b.d<Long> f171a;

        /* renamed from: b, reason: collision with root package name */
        h<Integer> f172b;

        private static long f(int i, int i2) {
            return i2 | (i << 32);
        }

        b(b bVar, a aVar, Resources resources) {
            super(bVar, aVar, resources);
            if (bVar != null) {
                this.f171a = bVar.f171a;
                this.f172b = bVar.f172b;
            } else {
                this.f171a = new androidx.b.d<>();
                this.f172b = new h<>();
            }
        }

        @Override // androidx.appcompat.b.a.d.a, androidx.appcompat.b.a.b.AbstractC0024b
        void a() {
            this.f171a = this.f171a.clone();
            this.f172b = this.f172b.clone();
        }

        int a(int i, int i2, Drawable drawable, boolean z) {
            int iA = super.a(drawable);
            long jF = f(i, i2);
            long j = z ? 8589934592L : 0L;
            long j2 = iA;
            this.f171a.c(jF, Long.valueOf(j2 | j));
            if (z) {
                this.f171a.c(f(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return iA;
        }

        int a(int[] iArr, Drawable drawable, int i) {
            int iA = super.a(iArr, drawable);
            this.f172b.b(iA, Integer.valueOf(i));
            return iA;
        }

        int a(int[] iArr) {
            int iB = super.b(iArr);
            return iB >= 0 ? iB : super.b(StateSet.WILD_CARD);
        }

        int a(int i) {
            if (i < 0) {
                return 0;
            }
            return this.f172b.a(i, 0).intValue();
        }

        int a(int i, int i2) {
            return (int) this.f171a.a(f(i, i2), -1L).longValue();
        }

        boolean b(int i, int i2) {
            return (this.f171a.a(f(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        boolean c(int i, int i2) {
            return (this.f171a.a(f(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // androidx.appcompat.b.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // androidx.appcompat.b.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    @Override // androidx.appcompat.b.a.d, androidx.appcompat.b.a.b
    protected void a(b.AbstractC0024b abstractC0024b) {
        super.a(abstractC0024b);
        if (abstractC0024b instanceof b) {
            this.f169b = (b) abstractC0024b;
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    private static class e implements TimeInterpolator {

        /* renamed from: a, reason: collision with root package name */
        private int[] f176a;

        /* renamed from: b, reason: collision with root package name */
        private int f177b;
        private int c;

        e(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f177b = numberOfFrames;
            if (this.f176a == null || this.f176a.length < numberOfFrames) {
                this.f176a = new int[numberOfFrames];
            }
            int[] iArr = this.f176a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr[i2] = duration;
                i += duration;
            }
            this.c = i;
            return i;
        }

        int a() {
            return this.c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.c) + 0.5f);
            int i2 = this.f177b;
            int[] iArr = this.f176a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.c : 0.0f);
        }
    }
}
