package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AppCompatDrawableManager.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    private static j f413b;
    private WeakHashMap<Context, androidx.b.h<ColorStateList>> j;
    private androidx.b.a<String, d> k;
    private androidx.b.h<String> l;
    private final WeakHashMap<Context, androidx.b.d<WeakReference<Drawable.ConstantState>>> m = new WeakHashMap<>(0);
    private TypedValue n;
    private boolean o;

    /* renamed from: a, reason: collision with root package name */
    private static final PorterDuff.Mode f412a = PorterDuff.Mode.SRC_IN;
    private static final c c = new c(6);
    private static final int[] d = {a.e.abc_textfield_search_default_mtrl_alpha, a.e.abc_textfield_default_mtrl_alpha, a.e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] e = {a.e.abc_ic_commit_search_api_mtrl_alpha, a.e.abc_seekbar_tick_mark_material, a.e.abc_ic_menu_share_mtrl_alpha, a.e.abc_ic_menu_copy_mtrl_am_alpha, a.e.abc_ic_menu_cut_mtrl_alpha, a.e.abc_ic_menu_selectall_mtrl_alpha, a.e.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] f = {a.e.abc_textfield_activated_mtrl_alpha, a.e.abc_textfield_search_activated_mtrl_alpha, a.e.abc_cab_background_top_mtrl_alpha, a.e.abc_text_cursor_material, a.e.abc_text_select_handle_left_mtrl_dark, a.e.abc_text_select_handle_middle_mtrl_dark, a.e.abc_text_select_handle_right_mtrl_dark, a.e.abc_text_select_handle_left_mtrl_light, a.e.abc_text_select_handle_middle_mtrl_light, a.e.abc_text_select_handle_right_mtrl_light};
    private static final int[] g = {a.e.abc_popup_background_mtrl_mult, a.e.abc_cab_background_internal_bg, a.e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] h = {a.e.abc_tab_indicator_material, a.e.abc_textfield_search_material};
    private static final int[] i = {a.e.abc_btn_check_material, a.e.abc_btn_radio_material};

    /* compiled from: AppCompatDrawableManager.java */
    private interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public static synchronized j a() {
        if (f413b == null) {
            f413b = new j();
            a(f413b);
        }
        return f413b;
    }

    private static void a(j jVar) {
        if (Build.VERSION.SDK_INT < 24) {
            jVar.a("vector", new e());
            jVar.a("animated-vector", new b());
            jVar.a("animated-selector", new a());
        }
    }

    public synchronized Drawable a(Context context, int i2) {
        return a(context, i2, false);
    }

    synchronized Drawable a(Context context, int i2, boolean z) {
        Drawable drawableD;
        f(context);
        drawableD = d(context, i2);
        if (drawableD == null) {
            drawableD = c(context, i2);
        }
        if (drawableD == null) {
            drawableD = androidx.core.a.a.a(context, i2);
        }
        if (drawableD != null) {
            drawableD = a(context, i2, z, drawableD);
        }
        if (drawableD != null) {
            ab.b(drawableD);
        }
        return drawableD;
    }

    public synchronized void a(Context context) {
        androidx.b.d<WeakReference<Drawable.ConstantState>> dVar = this.m.get(context);
        if (dVar != null) {
            dVar.c();
        }
    }

    private static long a(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable c(Context context, int i2) throws Resources.NotFoundException {
        if (this.n == null) {
            this.n = new TypedValue();
        }
        TypedValue typedValue = this.n;
        context.getResources().getValue(i2, typedValue, true);
        long jA = a(typedValue);
        Drawable drawableA = a(context, jA);
        if (drawableA != null) {
            return drawableA;
        }
        if (i2 == a.e.abc_cab_background_top_material) {
            drawableA = new LayerDrawable(new Drawable[]{a(context, a.e.abc_cab_background_internal_bg), a(context, a.e.abc_cab_background_top_mtrl_alpha)});
        }
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, jA, drawableA);
        }
        return drawableA;
    }

    private Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList colorStateListB = b(context, i2);
        if (colorStateListB != null) {
            if (ab.c(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable drawableG = androidx.core.graphics.drawable.a.g(drawable);
            androidx.core.graphics.drawable.a.a(drawableG, colorStateListB);
            PorterDuff.Mode modeA = a(i2);
            if (modeA == null) {
                return drawableG;
            }
            androidx.core.graphics.drawable.a.a(drawableG, modeA);
            return drawableG;
        }
        if (i2 == a.e.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(R.id.background), an.a(context, a.C0018a.colorControlNormal), f412a);
            a(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), an.a(context, a.C0018a.colorControlNormal), f412a);
            a(layerDrawable.findDrawableByLayerId(R.id.progress), an.a(context, a.C0018a.colorControlActivated), f412a);
            return drawable;
        }
        if (i2 == a.e.abc_ratingbar_material || i2 == a.e.abc_ratingbar_indicator_material || i2 == a.e.abc_ratingbar_small_material) {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            a(layerDrawable2.findDrawableByLayerId(R.id.background), an.c(context, a.C0018a.colorControlNormal), f412a);
            a(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), an.a(context, a.C0018a.colorControlActivated), f412a);
            a(layerDrawable2.findDrawableByLayerId(R.id.progress), an.a(context, a.C0018a.colorControlActivated), f412a);
            return drawable;
        }
        if (a(context, i2, drawable) || !z) {
            return drawable;
        }
        return null;
    }

    private Drawable d(Context context, int i2) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        if (this.k == null || this.k.isEmpty()) {
            return null;
        }
        if (this.l != null) {
            String strA = this.l.a(i2);
            if ("appcompat_skip_skip".equals(strA) || (strA != null && this.k.get(strA) == null)) {
                return null;
            }
        } else {
            this.l = new androidx.b.h<>();
        }
        if (this.n == null) {
            this.n = new TypedValue();
        }
        TypedValue typedValue = this.n;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long jA = a(typedValue);
        Drawable drawableA = a(context, jA);
        if (drawableA != null) {
            return drawableA;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.l.c(i2, name);
                d dVar = this.k.get(name);
                if (dVar != null) {
                    drawableA = dVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableA != null) {
                    drawableA.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, jA, drawableA);
                }
            } catch (Exception e2) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", e2);
            }
        }
        if (drawableA == null) {
            this.l.c(i2, "appcompat_skip_skip");
        }
        return drawableA;
    }

    private synchronized Drawable a(Context context, long j) {
        androidx.b.d<WeakReference<Drawable.ConstantState>> dVar = this.m.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceA = dVar.a(j);
        if (weakReferenceA != null) {
            Drawable.ConstantState constantState = weakReferenceA.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.b(j);
        }
        return null;
    }

    private synchronized boolean a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        androidx.b.d<WeakReference<Drawable.ConstantState>> dVar = this.m.get(context);
        if (dVar == null) {
            dVar = new androidx.b.d<>();
            this.m.put(context, dVar);
        }
        dVar.b(j, new WeakReference<>(constantState));
        return true;
    }

    synchronized Drawable a(Context context, ax axVar, int i2) {
        Drawable drawableD = d(context, i2);
        if (drawableD == null) {
            drawableD = axVar.a(i2);
        }
        if (drawableD == null) {
            return null;
        }
        return a(context, i2, false, drawableD);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static boolean a(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
        /*
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.j.f412a
            int[] r1 = androidx.appcompat.widget.j.d
            boolean r1 = a(r1, r7)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L15
            int r2 = androidx.appcompat.a.C0018a.colorControlNormal
        L12:
            r7 = 1
            r1 = -1
            goto L44
        L15:
            int[] r1 = androidx.appcompat.widget.j.f
            boolean r1 = a(r1, r7)
            if (r1 == 0) goto L20
            int r2 = androidx.appcompat.a.C0018a.colorControlActivated
            goto L12
        L20:
            int[] r1 = androidx.appcompat.widget.j.g
            boolean r1 = a(r1, r7)
            if (r1 == 0) goto L2b
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L12
        L2b:
            int r1 = androidx.appcompat.a.e.abc_list_divider_mtrl_alpha
            if (r7 != r1) goto L3c
            r2 = 16842800(0x1010030, float:2.3693693E-38)
            r7 = 1109603123(0x42233333, float:40.8)
            int r7 = java.lang.Math.round(r7)
            r1 = r7
            r7 = 1
            goto L44
        L3c:
            int r1 = androidx.appcompat.a.e.abc_dialog_material_background
            if (r7 != r1) goto L41
            goto L12
        L41:
            r7 = 0
            r1 = -1
            r2 = 0
        L44:
            if (r7 == 0) goto L61
            boolean r7 = androidx.appcompat.widget.ab.c(r8)
            if (r7 == 0) goto L50
            android.graphics.drawable.Drawable r8 = r8.mutate()
        L50:
            int r6 = androidx.appcompat.widget.an.a(r6, r2)
            android.graphics.PorterDuffColorFilter r6 = a(r6, r0)
            r8.setColorFilter(r6)
            if (r1 == r3) goto L60
            r8.setAlpha(r1)
        L60:
            return r5
        L61:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    private void a(String str, d dVar) {
        if (this.k == null) {
            this.k = new androidx.b.a<>();
        }
        this.k.put(str, dVar);
    }

    private static boolean a(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    static PorterDuff.Mode a(int i2) {
        if (i2 == a.e.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    synchronized ColorStateList b(Context context, int i2) {
        ColorStateList colorStateListE;
        colorStateListE = e(context, i2);
        if (colorStateListE == null) {
            if (i2 == a.e.abc_edit_text_material) {
                colorStateListE = androidx.appcompat.a.a.a.a(context, a.c.abc_tint_edittext);
            } else if (i2 == a.e.abc_switch_track_mtrl_alpha) {
                colorStateListE = androidx.appcompat.a.a.a.a(context, a.c.abc_tint_switch_track);
            } else if (i2 == a.e.abc_switch_thumb_material) {
                colorStateListE = e(context);
            } else if (i2 == a.e.abc_btn_default_mtrl_shape) {
                colorStateListE = b(context);
            } else if (i2 == a.e.abc_btn_borderless_material) {
                colorStateListE = c(context);
            } else if (i2 == a.e.abc_btn_colored_material) {
                colorStateListE = d(context);
            } else if (i2 == a.e.abc_spinner_mtrl_am_alpha || i2 == a.e.abc_spinner_textfield_background_material) {
                colorStateListE = androidx.appcompat.a.a.a.a(context, a.c.abc_tint_spinner);
            } else if (a(e, i2)) {
                colorStateListE = an.b(context, a.C0018a.colorControlNormal);
            } else if (a(h, i2)) {
                colorStateListE = androidx.appcompat.a.a.a.a(context, a.c.abc_tint_default);
            } else if (a(i, i2)) {
                colorStateListE = androidx.appcompat.a.a.a.a(context, a.c.abc_tint_btn_checkable);
            } else if (i2 == a.e.abc_seekbar_thumb_material) {
                colorStateListE = androidx.appcompat.a.a.a.a(context, a.c.abc_tint_seek_thumb);
            }
            if (colorStateListE != null) {
                a(context, i2, colorStateListE);
            }
        }
        return colorStateListE;
    }

    private ColorStateList e(Context context, int i2) {
        androidx.b.h<ColorStateList> hVar;
        if (this.j == null || (hVar = this.j.get(context)) == null) {
            return null;
        }
        return hVar.a(i2);
    }

    private void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.j == null) {
            this.j = new WeakHashMap<>();
        }
        androidx.b.h<ColorStateList> hVar = this.j.get(context);
        if (hVar == null) {
            hVar = new androidx.b.h<>();
            this.j.put(context, hVar);
        }
        hVar.c(i2, colorStateList);
    }

    private ColorStateList b(Context context) {
        return f(context, an.a(context, a.C0018a.colorButtonNormal));
    }

    private ColorStateList c(Context context) {
        return f(context, 0);
    }

    private ColorStateList d(Context context) {
        return f(context, an.a(context, a.C0018a.colorAccent));
    }

    private ColorStateList f(Context context, int i2) {
        int iA = an.a(context, a.C0018a.colorControlHighlight);
        return new ColorStateList(new int[][]{an.f360a, an.d, an.f361b, an.h}, new int[]{an.c(context, a.C0018a.colorButtonNormal), androidx.core.graphics.a.a(iA, i2), androidx.core.graphics.a.a(iA, i2), i2});
    }

    private ColorStateList e(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListB = an.b(context, a.C0018a.colorSwitchThumbNormal);
        if (colorStateListB != null && colorStateListB.isStateful()) {
            iArr[0] = an.f360a;
            iArr2[0] = colorStateListB.getColorForState(iArr[0], 0);
            iArr[1] = an.e;
            iArr2[1] = an.a(context, a.C0018a.colorControlActivated);
            iArr[2] = an.h;
            iArr2[2] = colorStateListB.getDefaultColor();
        } else {
            iArr[0] = an.f360a;
            iArr2[0] = an.c(context, a.C0018a.colorSwitchThumbNormal);
            iArr[1] = an.e;
            iArr2[1] = an.a(context, a.C0018a.colorControlActivated);
            iArr[2] = an.h;
            iArr2[2] = an.a(context, a.C0018a.colorSwitchThumbNormal);
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* compiled from: AppCompatDrawableManager.java */
    private static class c extends androidx.b.e<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return a((c) Integer.valueOf(b(i, mode)));
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return a((c) Integer.valueOf(b(i, mode)), (Integer) porterDuffColorFilter);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    static void a(Drawable drawable, aq aqVar, int[] iArr) {
        if (ab.c(drawable) && drawable.mutate() != drawable) {
            Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (aqVar.d || aqVar.c) {
            drawable.setColorFilter(a(aqVar.d ? aqVar.f364a : null, aqVar.c ? aqVar.f365b : f412a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterA;
        porterDuffColorFilterA = c.a(i2, mode);
        if (porterDuffColorFilterA == null) {
            porterDuffColorFilterA = new PorterDuffColorFilter(i2, mode);
            c.a(i2, mode, porterDuffColorFilterA);
        }
        return porterDuffColorFilterA;
    }

    private static void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (ab.c(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f412a;
        }
        drawable.setColorFilter(a(i2, mode));
    }

    private void f(Context context) {
        if (this.o) {
            return;
        }
        this.o = true;
        Drawable drawableA = a(context, a.e.abc_vector_test);
        if (drawableA == null || !a(drawableA)) {
            this.o = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof androidx.j.a.a.i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* compiled from: AppCompatDrawableManager.java */
    private static class e implements d {
        e() {
        }

        @Override // androidx.appcompat.widget.j.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.j.a.a.i.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* compiled from: AppCompatDrawableManager.java */
    private static class b implements d {
        b() {
        }

        @Override // androidx.appcompat.widget.j.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.j.a.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* compiled from: AppCompatDrawableManager.java */
    static class a implements d {
        a() {
        }

        @Override // androidx.appcompat.widget.j.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.appcompat.b.a.a.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }
}
